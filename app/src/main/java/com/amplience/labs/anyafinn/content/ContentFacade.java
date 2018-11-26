package com.amplience.labs.anyafinn.content;

import android.content.Intent;

import com.amplience.cms.content.delivery.ContentDeliveryClient;
import com.amplience.cms.content.delivery.ContentItemService;
import com.amplience.cms.content.delivery.ContentItemServiceImpl;
import com.amplience.cms.content.delivery.serialization.ContentItemDeserializer;
import com.amplience.labs.anyafinn.content.model.accelerators.Banner;
import com.amplience.labs.anyafinn.content.model.accelerators.Card;
import com.amplience.labs.anyafinn.content.model.accelerators.CardList;
import com.amplience.labs.anyafinn.content.model.accelerators.FlexibleSlot;
import com.amplience.labs.anyafinn.content.model.accelerators.HeroSlot;
import com.amplience.labs.anyafinn.content.model.accelerators.Image;
import com.amplience.labs.anyafinn.content.model.accelerators.Slider;
import com.amplience.labs.anyafinn.content.model.accelerators.SplitBlock;
import com.amplience.labs.anyafinn.content.model.accelerators.Text;
import com.amplience.labs.anyafinn.content.model.anyafinn.Carousel;
import com.amplience.labs.anyafinn.content.model.anyafinn.Grid;
import com.amplience.labs.anyafinn.content.model.anyafinn.HeroBlock;
import com.amplience.labs.anyafinn.content.model.anyafinn.ImageBlock;
import com.amplience.labs.anyafinn.content.model.anyafinn.Page;
import com.amplience.labs.anyafinn.content.model.anyafinn.Stack;
import com.amplience.labs.anyafinn.content.model.anyafinn.TextBlock;
import com.amplience.labs.anyafinn.model.ContentSettings;
import com.google.common.collect.Maps;

import java.util.Map;

public class ContentFacade {

    private static Map<Intent, ContentFacade> INSTANCES = Maps.newHashMap();

    public static ContentFacade getOrCreate(Intent intent) {
        if(!INSTANCES.containsKey(intent)) {
            INSTANCES.put(intent, new ContentFacade(intent));
        }
        return INSTANCES.get(intent);
    }

    private final ContentSettings contentSettings;
    private final ContentDeliveryClient contentDeliveryClient;
    private final ContentItemDeserializer contentItemDeserializer;
    private final ContentItemService contentItemService;

    private ContentFacade(Intent intent) {
        contentSettings = new ContentSettings();
        contentSettings.parse(intent);

        contentDeliveryClient =
                new ContentDeliveryClient.Builder()
                        .setBaseUrl(contentSettings.getContentDeliveryUrl())
                        .setAccount(contentSettings.getContentDeliveryAccount())
                        .build();

        contentItemDeserializer =
                new ContentItemDeserializer()
                        .withContentType(ImageBlock.class)
                        .withContentType(HeroBlock.class)
                        .withContentType(TextBlock.class)
                        .withContentType(Carousel.class)
                        .withContentType(Grid.class)
                        .withContentType(Page.class)
                        .withContentType(Stack.class)
                        //accelorators
                        .withContentType(FlexibleSlot.class)
                        .withContentType(Banner.class)
                        .withContentType(Image.class)
                        .withContentType(Slider.class)
                        .withContentType(SplitBlock.class)
                        .withContentType(Text.class)
//                      .withContentType(Video.class)
                        .withContentType(HeroSlot.class)
                        .withContentType(Card.class)
                        .withContentType(CardList.class);

        contentItemService = new ContentItemServiceImpl(contentDeliveryClient, contentItemDeserializer, contentSettings.getLocale());
    }

    public ContentSettings getContentSettings() {
        return contentSettings;
    }

    public ContentDeliveryClient getContentDeliveryClient() {
        return contentDeliveryClient;
    }

    public ContentItemDeserializer getContentItemDeserializer() {
        return contentItemDeserializer;
    }

    public ContentItemService getContentItemService() {
        return contentItemService;
    }
}

