package com.mycompany.hh_dangjian.pager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.mycompany.hh_dangjian.base.BasePager;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.pager
 * 文件名:HomePager
 * 创建者：zhuli
 * 创建时间: 2018/1/24  14:11
 * 描述:  TODO
 */
public class MePager extends BasePager {
    public MePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();

        TextView textView=new TextView(context);
        textView.setText("Me");
        titlebar.setVisibility(View.GONE);
        fl_content.addView(textView);
    }
}
