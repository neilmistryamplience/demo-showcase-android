package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.view.accelerators.VideoFragment;

/**
 * Created by darren on 21/08/2018.
 */

@ContentType(pattern = "/video.json")
@ContentTypeFragment(fragment = VideoFragment.class)
public class Video extends ContentItem {

    private com.amplience.cms.content.delivery.model.Video video;

    public com.amplience.cms.content.delivery.model.Video getVideo() {
        return video;
    }

    public void setVideo(com.amplience.cms.content.delivery.model.Video video) {
        this.video = video;
    }

}
