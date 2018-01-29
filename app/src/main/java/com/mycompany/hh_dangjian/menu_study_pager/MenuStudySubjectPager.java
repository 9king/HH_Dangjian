package com.mycompany.hh_dangjian.menu_study_pager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mycompany.hh_dangjian.base.BaseMenuStudyPager;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.menu_study_pager
 * 创建者：zhuli
 * 创建时间: 2018/1/25  13:11
 * 描述:  TODO
 */
public class MenuStudySubjectPager extends BaseMenuStudyPager {
    public MenuStudySubjectPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView=new TextView(context);
        textView.setText("subject");
        textView.setTextSize(40);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
