package com.mycompany.hh_dangjian.menu_study_pager.tabdetailpager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.http.VolleyError;
import com.mycompany.hh_dangjian.R;
import com.mycompany.hh_dangjian.base.BaseMenuStudyPager;
import com.mycompany.hh_dangjian.entity.PartyWorkData;
import com.mycompany.hh_dangjian.entity.StudyData;
import com.mycompany.hh_dangjian.util.CacheData;
import com.mycompany.hh_dangjian.util.StaticContent;

import java.util.List;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.menu_study_pager.tabdetailpager
 * 文件名:PartyWorkPager
 * 创建者：zhuli
 * 创建时间: 2018/1/25  16:42
 * 描述:  TODO
 */
public class PartyWorkPager extends BaseMenuStudyPager {

    public static final String CACHE_PARTYWORK_JSON_DATA = "cache_partywork_json_data";
    private StudyData.DataBean.ChildrenBean bean;
    private ListView listView;
    private PartyWorkData party_work_bean;
    private ViewHolder viewHolder;
    private List<PartyWorkData.DataBean.StudyBean> study_bean;


    public PartyWorkPager(Context context, StudyData.DataBean.ChildrenBean childrenBean) {
        super(context);
        this.bean=childrenBean;
    }

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.dangwu_pager,null);
        listView= (ListView) view.findViewById(R.id.lv_partywork);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        String url= StaticContent.HOST_IP+bean.getUrl();
        Log.e("url",url);
        String saveJson=CacheData.getString(context,CACHE_PARTYWORK_JSON_DATA);
        if (!TextUtils.isEmpty(saveJson)){
            processData(saveJson);
        }
       getDataFromNet(url);
    }

    private void getDataFromNet(String url) {
        RxVolley.get(url, new HttpCallback() {
            @Override
            public void onFailure(VolleyError error) {
                super.onFailure(error);
                Log.e("PartyWorkPager",error.toString());
            }

            @Override
            public void onSuccess(String t) {
                super.onSuccess(t);
                CacheData.putString(context,CACHE_PARTYWORK_JSON_DATA,t);
                processData(t);
            }
        });
    }

    private void processData(String t) {
        party_work_bean= parseJson(t);
        study_bean=party_work_bean.getData().getStudy();
        listView.setAdapter(new MyBaseAdapter());

    }

    private PartyWorkData parseJson(String t) {
        return new Gson().fromJson(t,PartyWorkData.class);
    }

    private class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return study_bean.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view==null){
                view=View.inflate(context,R.layout.item_partywork_pager,null);
                viewHolder=new ViewHolder();
                viewHolder.tv_title= (TextView) view.findViewById(R.id.tv_title);
                viewHolder.tv_date= (TextView) view.findViewById(R.id.tv_date);
                view.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) view.getTag();
            }
            viewHolder.tv_title.setText(study_bean.get(i).getTitle());
            viewHolder.tv_date.setText(study_bean.get(i).getDate());
            return view;
        }
    }
    static class ViewHolder{
        public TextView tv_title;
        public TextView tv_date;
    }
}
