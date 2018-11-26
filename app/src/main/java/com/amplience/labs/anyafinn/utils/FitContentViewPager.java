package com.amplience.labs.anyafinn.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

public class FitContentViewPager extends ViewPager {

    public FitContentViewPager(Context context) {
        super(context);
        this.setOffscreenPageLimit(10);
    }

    public FitContentViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOffscreenPageLimit(10);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View mCurrentView = getChildAt(getCurrentItem());
        if (mCurrentView == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }

        int height = 0;
        mCurrentView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        int h = mCurrentView.getMeasuredHeight();
        if (h > height) height = h;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void measureCurrentView(View currentView) {
        requestLayout();
    }

    public int measureFragment(View view) {
        if (view == null)
            return 0;

        view.measure(0, 0);
        return view.getMeasuredHeight();
    }


}
