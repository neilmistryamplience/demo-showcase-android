package com.amplience.cms.content.rendering.android;


import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ContentTypeFragment {
    Class<? extends ContentView> fragment();
}
