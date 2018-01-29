package com.mycompany.hh_dangjian.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.base
 * 文件名:BaseFragment
 * 创建者：zhuli
 * 创建时间: 2018/1/23  17:33
 * 描述:  TODO
 */
public abstract class BaseFragment extends Fragment {

    public Context context;
    public View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    public abstract View initView();

    public void initData(){

    }

}
