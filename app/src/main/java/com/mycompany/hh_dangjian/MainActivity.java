package com.mycompany.hh_dangjian;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.mycompany.hh_dangjian.fragment.ContentFragment;
import com.mycompany.hh_dangjian.fragment.LeftMenuFragment;
import com.mycompany.hh_dangjian.util.DensityUtil;

public class MainActivity extends SlidingFragmentActivity {

    public static final String TAG_LEFT_MENU_FRAGMENT = "tag_left_menu_fragment";
    public static final String TAG_CONTENT_FRAGMENT = "tag_content_fragment";
    private int width;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSlidingMenu();
        initFragment();
    }

    private void initFragment() {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fl_leftmenu_fragment,new LeftMenuFragment(),TAG_LEFT_MENU_FRAGMENT);
        ft.replace(R.id.fl_content_fragment,new ContentFragment(),TAG_CONTENT_FRAGMENT);
        ft.commit();
    }

    private void initSlidingMenu() {
        setBehindContentView(R.layout.leftmenu_activity);
        SlidingMenu left_menu=getSlidingMenu();
        left_menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        left_menu.setMode(SlidingMenu.LEFT);
        left_menu.setBehindOffset(DensityUtil.dip2px(this,200));
    }

    public ContentFragment getContentFragment() {
        FragmentManager fm=getSupportFragmentManager();
        return (ContentFragment) fm.findFragmentByTag(TAG_CONTENT_FRAGMENT);
    }

    public LeftMenuFragment getLeftMenuFragment() {
        FragmentManager fm=getSupportFragmentManager();
        return (LeftMenuFragment) fm.findFragmentByTag(TAG_LEFT_MENU_FRAGMENT);
    }
}
