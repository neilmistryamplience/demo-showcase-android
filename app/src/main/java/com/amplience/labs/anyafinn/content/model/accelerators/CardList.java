package com.amplience.labs.anyafinn.content.model.accelerators;


import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.model.common.ContentGrid;
import com.amplience.labs.anyafinn.content.view.accelerators.CardListFragment;
import com.amplience.labs.anyafinn.content.view.anyafinn.GridFragment;
import com.amplience.labs.anyafinn.content.view.common.StackFragment;

import java.util.List;

@ContentType(pattern = "/cardList.json")
@ContentTypeFragment(fragment = StackFragment.class)
public class CardList extends ContentItem implements ContentGrid {
    private String header;
    private boolean heroList;
    private boolean slider;
    private List<ContentItem> cards;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public boolean isHeroList() {
        return heroList;
    }

    public void setHeroList(boolean heroList) {
        this.heroList = heroList;
    }

    public boolean isSlider() {
        return slider;
    }

    public void setSlider(boolean slider) {
        this.slider = slider;
    }

    public List<ContentItem> getCards() {
        return cards;
    }

    public void setCards(List<ContentItem> cards) {
        this.cards = cards;
    }

    @Override
    public List<ContentItem> getChildren() {
        return getCards();
    }

    @Override
    public int getColumns() {
        return 1;
    }

}
