package com.mycompany.hh_dangjian.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.view
 * 文件名:DisableTouchTabLayout
 * 创建者：zhuli
 * 创建时间: 2018/1/26  11:22
 * 描述:  TODO
 */
public class DisableTouchTabLayout extends TabLayout {
    public DisableTouchTabLayout(Context context) {
        super(context);
    }

    public DisableTouchTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DisableTouchTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}
