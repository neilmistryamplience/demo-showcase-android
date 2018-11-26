package com.amplience.cms.content.rendering.android.basic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.amplience.cms.content.delivery.ContentItemService;
import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.cms.content.rendering.android.ContentView;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public abstract class BasicContentView<T extends ContentItem> extends Fragment implements ContentView<T> {

    protected T content;

    private Map<Integer, List<Fragment>> collections = Maps.newHashMap();

    private static FragmentTransaction fragmentTransaction;

    @Override
    public void setContent(T content) {
        this.content = content;
        renderContent();
    }

    public T getContent() {
        return this.content;
    }


    /**
     * Rendering
     */

    protected void renderContent() {
        if(getView() == null || getContent() == null) {
            return;
        }
        onRenderContent(getContent());
    }

    protected abstract void onRenderContent(T content);

    /**
     * Collection / stacks of content handling
     */

    protected void renderCollection(int containerViewId, List<? extends ContentItem> contentItems) {
        renderCollection(containerViewId, contentItems, null);
    }

    protected void renderCollection(int containerViewId, List<? extends ContentItem> contentItems, Function<ContentView, ContentView> adaptor) {
        renderCollection(containerViewId, contentItems, null, adaptor);
    }

    protected void renderCollection(int containerViewId, List<? extends ContentItem> contentItems, Class<? extends BasicContentView> childFragmentClass, Function<ContentView, ContentView> adaptor) {
        try {

            /**
             * TOOD: This may not be safe, but improves performance
             */
            boolean fragmentOwner = false;
            if(fragmentTransaction == null) {
                fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentOwner = true;
            }

            FragmentTransaction transaction = fragmentTransaction;

            if(collections.containsKey(containerViewId)) {
                for (Fragment fragment : collections.get(containerViewId)) {
                    transaction.remove(fragment);
                }
            }

            List<Fragment> fragments = Lists.newArrayList();

            for (ContentItem item : contentItems) {
                if (item == null) {
                    continue;
                }

                ContentView<?> fragement = childFragmentClass != null ? childFragmentClass.newInstance() : createContentFragment(item);
                if (fragement != null && fragement instanceof Fragment) {
                    if(adaptor != null) {
                        fragement = adaptor.apply(fragement);
                    }
                    ((ContentView) fragement).setContent(item);
                    fragments.add((Fragment)fragement);
                    transaction.add(containerViewId, (Fragment)fragement, null);
                }
            }

            collections.put(containerViewId, fragments);

            if(fragmentOwner) {
                transaction.addToBackStack(null);
                transaction.commit();
                fragmentTransaction = null;
            }

        }catch(IllegalAccessException ex){
        }catch(java.lang.InstantiationException ex){
        }
    }

    protected <CT extends ContentItem> ContentView<CT> createContentFragment(CT type) {
        try {
            return getContentFragment(type).newInstance();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private <CT extends ContentItem> Class<? extends ContentView<CT>> getContentFragment(CT type) {
        return (Class<? extends ContentView<CT>>)type.getClass().getAnnotation(ContentTypeFragment.class).fragment();
    }

}
