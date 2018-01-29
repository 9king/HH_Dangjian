package com.mycompany.hh_dangjian.menu_study_pager;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.mycompany.hh_dangjian.MainActivity;
import com.mycompany.hh_dangjian.R;
import com.mycompany.hh_dangjian.base.BaseMenuStudyPager;
import com.mycompany.hh_dangjian.entity.StudyData;
import com.mycompany.hh_dangjian.menu_study_pager.tabdetailpager.PartyWorkPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.menu_study_pager
 * 文件名:MenuStudyKnowledgePager
 * 创建者：zhuli
 * 创建时间: 2018/1/25  13:11
 * 描述:  TODO
 */
public class MenuStudyKnowledgePager extends BaseMenuStudyPager {
    private TabLayout tabPageIndicator;
    private ViewPager viewpager;
    private List<StudyData.DataBean.ChildrenBean> childrenBean;
    private ArrayList<PartyWorkPager> partyWorkPagers;

    public MenuStudyKnowledgePager(Context context, List<StudyData.DataBean.ChildrenBean> childrenBean) {
        super(context);
        this.childrenBean= childrenBean;
    }

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.menustudy_knowledge_pager,null);
        initialize(view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        partyWorkPagers =new ArrayList<>();
        for (int i=0;i<childrenBean.size();i++){
            partyWorkPagers.add(new PartyWorkPager(context,childrenBean.get(i)));
        }
        viewpager.setAdapter(new MyViewPagerAdapter());
        tabPageIndicator.setupWithViewPager(viewpager);
        tabPageIndicator.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());
    }

    private void initialize(View view) {
        tabPageIndicator = (TabLayout) view.findViewById(R.id.tabPageIndicator);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
    }

    private class MyViewPagerAdapter extends PagerAdapter {
        @Override
        public CharSequence getPageTitle(int position) {
            return childrenBean.get(position).getTitle();
        }

        @Override
        public int getCount() {
            return partyWorkPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PartyWorkPager partyWorkPager = partyWorkPagers.get(position);
            View rootView= partyWorkPager.rootView;
            partyWorkPager.initData();
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
    private void isEnableSlidingMenu(int touchmode) {
        MainActivity mainActivity= (MainActivity) context;
        SlidingMenu slidingMenu=mainActivity.getSlidingMenu();
        slidingMenu.setTouchModeAbove(touchmode);
    }
    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position==0){
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);
            }else {
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
            }
              partyWorkPagers.get(position).initData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
