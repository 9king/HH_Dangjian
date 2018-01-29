package com.mycompany.hh_dangjian.pager;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.http.VolleyError;
import com.mycompany.hh_dangjian.base.BaseMenuStudyPager;
import com.mycompany.hh_dangjian.base.BasePager;
import com.mycompany.hh_dangjian.entity.StudyData;
import com.mycompany.hh_dangjian.menu_study_pager.MenuStudyKnowledgePager;
import com.mycompany.hh_dangjian.menu_study_pager.MenuStudySubjectPager;
import com.mycompany.hh_dangjian.menu_study_pager.MenuStudyVedioPager;
import com.mycompany.hh_dangjian.util.CacheData;
import com.mycompany.hh_dangjian.util.StaticContent;

import java.util.ArrayList;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.pager
 * 文件名:HomePager
 * 创建者：zhuli
 * 创建时间: 2018/1/24  14:11
 * 描述:  TODO
 */
public class StudyPager extends BasePager {
    public static final String STUDY_PAGER_JSON_DATA = "study_pager_json_data";
    private ArrayList<BaseMenuStudyPager> baseMenuPages;
    private StudyData.DataBean data;
    private String[] title_name=new String[]{
      "党务","专题","视频"
    };
    public StudyPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tv_title.setText("党务");

        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        //3.把子视图添加到BasePager的FrameLayout中
        fl_content.addView(textView);
        //4.绑定数据
        textView.setText("新闻中心内容");
        String cache_data= CacheData.getString(context,STUDY_PAGER_JSON_DATA);
        if (TextUtils.isEmpty(cache_data)){
            parseJson(cache_data);
        }
        getDataFromNet();
    }

    public void getDataFromNet() {
        RxVolley.get(StaticContent.STUDY_PAGE_URL, new HttpCallback() {
            @Override
            public void onFailure(VolleyError error) {
                super.onFailure(error);
                Log.e("studyPager联网失败",error.toString());
                Toast.makeText(context, error.toString()+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String t) {
                super.onSuccess(t);
                CacheData.putString(context,STUDY_PAGER_JSON_DATA,t);
                //设置适配器
                processData(t);
                Toast.makeText(context, "StudyPage联网请求成功"+t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void processData(String t) {
        StudyData bean=parseJson(t);
        data=bean.getData();
        baseMenuPages=new ArrayList<>();
        baseMenuPages.add(new MenuStudyKnowledgePager(context,data.getChildren()));
        baseMenuPages.add(new MenuStudySubjectPager(context));
        baseMenuPages.add(new MenuStudyVedioPager(context));
        switchPager(0);
    }

    private StudyData parseJson(String t) {
       return new Gson().fromJson(t,StudyData.class);
    }


    public void switchPager(int i) {
        //移除之前的内容
        tv_title.setText(title_name[i]);
        fl_content.removeAllViews();//去掉数据
        BaseMenuStudyPager pager=baseMenuPages.get(i);
        View rootView=pager.rootView;

        pager.initData();//初始化数据，添加数据
        fl_content.addView(rootView);
    }
}
