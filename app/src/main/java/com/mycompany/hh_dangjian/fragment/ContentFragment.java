package com.mycompany.hh_dangjian.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.mycompany.hh_dangjian.MainActivity;
import com.mycompany.hh_dangjian.R;
import com.mycompany.hh_dangjian.base.BaseFragment;
import com.mycompany.hh_dangjian.base.BasePager;
import com.mycompany.hh_dangjian.pager.HomePager;
import com.mycompany.hh_dangjian.pager.MePager;
import com.mycompany.hh_dangjian.pager.NewsPager;
import com.mycompany.hh_dangjian.pager.StudyPager;
import com.mycompany.hh_dangjian.view.NoScrollViewPager;

import java.util.ArrayList;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.base
 * 文件名:ContentFragment
 * 创建者：zhuli
 * 创建时间: 2018/1/23  17:36
 * 描述:  TODO
 */
public class ContentFragment extends BaseFragment {
    private RadioGroup rgmain;
    private NoScrollViewPager viewPager;
    private ArrayList<BasePager>pages;
    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.contentfragment,null);
        initialize(view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        pages=new ArrayList<>();
        pages.add(new HomePager(context));
        pages.add(new StudyPager(context));
        pages.add(new NewsPager(context));
        pages.add(new MePager(context));

        viewPager.setAdapter(new MyPageAdapter());
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        rgmain.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rgmain.check(R.id.rb_home);
        pages.get(0).initData();
        isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
    }

    private void initialize(View view) {
        viewPager= (NoScrollViewPager) view.findViewById(R.id.viewpager);
        rgmain = (RadioGroup) view.findViewById(R.id.rg_main);


    }

    public StudyPager getStudyPager() {
        return (StudyPager) pages.get(1);
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.rb_home:
                    viewPager.setCurrentItem(0,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_study:
                    viewPager.setCurrentItem(1,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);
                    break;
                case R.id.rb_news:
                    viewPager.setCurrentItem(2,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_me:

                    viewPager.setCurrentItem(3,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
            }
        }
    }

    private void isEnableSlidingMenu(int touchmode) {
        MainActivity mainActivity= (MainActivity) context;
        SlidingMenu slidingMenu=mainActivity.getSlidingMenu();
        slidingMenu.setTouchModeAbove(touchmode);
    }

    private class MyPageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager=pages.get(position);
            View rootView=pager.rootView;
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            pages.get(position).initData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
