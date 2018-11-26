package com.amplience.labs.anyafinn.content.view.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.amplience.cms.content.rendering.android.ContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.cms.content.delivery.model.ContentItem;

public class ContainerFragment extends ButterknifeContentView<ContentItem> {

    private ContentView<?> fragement;

    public ContainerFragment() {
        super(R.layout.fragment_cms_generic);
    }

    protected void onRenderContent(ContentItem content) {
        FragmentTransaction transaction =
                getChildFragmentManager().beginTransaction();
        if(fragement != null){
            transaction.remove((Fragment)fragement);
        }
        fragement = createContentFragment(content);
        if(fragement != null) {
            ((ContentView<ContentItem>)fragement).setContent(content);
            transaction.add(R.id.container, (Fragment)fragement);
        }
        transaction.commit();
    }

}
