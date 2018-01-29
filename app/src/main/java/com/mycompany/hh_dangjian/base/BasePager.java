package com.mycompany.hh_dangjian.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mycompany.hh_dangjian.MainActivity;
import com.mycompany.hh_dangjian.R;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.base
 * 文件名:BasePager
 * 创建者：zhuli
 * 创建时间: 2018/1/24  14:02
 * 描述:  TODO
 */
public class BasePager {
    public final Context context;//MainActivity

    /**
     * 视图，代表各个不同的页面
     */
    public RelativeLayout titlebar;
    public View rootView;
    /**
     * 显示标题
     */
    public TextView tv_title;

    /**
     * 点击侧滑的
     */
    public ImageButton ib_menu;

    public FrameLayout fl_content;

    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    /**
     * 用于初始化公共部分视图，并且初始化加载子视图的FrameLayout
     * @return
     */
    private View initView() {
        //基类的页面
        View view = View.inflate(context, R.layout.base_pager,null);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        ib_menu = (ImageButton) view.findViewById(R.id.ib_menu);
        fl_content = (FrameLayout) view.findViewById(R.id.fl_content);
        titlebar= (RelativeLayout) view.findViewById(R.id.titlebar);
        ib_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.getSlidingMenu().toggle();//关<->开
            }
        });
        return view;
    }

    /**
     * 初始化数据;当孩子需要初始化数据;或者绑定数据;联网请求数据并且绑定的时候，重写该方法
     */
    public void initData(){

    }

}
