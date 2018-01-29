package com.mycompany.hh_dangjian.base;

import android.content.Context;
import android.view.View;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.base
 * 文件名:BaseMenuStudyPager
 * 创建者：zhuli
 * 创建时间: 2018/1/25  13:09
 * 描述:  TODO
 */
public abstract class BaseMenuStudyPager {
    public final Context context;
    public View rootView;

    public BaseMenuStudyPager(Context context){
        this.context = context;
        rootView = initView();
    }

    public abstract View initView() ;

    /**
     * 子页面需要绑定数据，联网请求数据等的时候，重写该方法
     */
    public void initData(){

    }
}
