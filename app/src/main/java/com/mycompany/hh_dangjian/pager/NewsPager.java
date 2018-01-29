package com.mycompany.hh_dangjian.pager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.http.VolleyError;
import com.mycompany.hh_dangjian.R;
import com.mycompany.hh_dangjian.base.BasePager;
import com.mycompany.hh_dangjian.entity.HomeData;
import com.mycompany.hh_dangjian.util.CacheData;
import com.mycompany.hh_dangjian.util.StaticContent;

import java.util.List;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.pager
 * 文件名:HomePager
 * 创建者：zhuli
 * 创建时间: 2018/1/24  14:11
 * 描述:  TODO
 */
public class NewsPager extends BasePager {
    public static final String CACHE_HOME_PAGE_DATA= "cache_news_page_data";
    private List<HomeData.DataBean.TopnewsBean> topnews;
    private TextView tv_title;
    private List<HomeData.DataBean.NewsBean> news;
    private ViewPager vpbanner;
    private ListView lvnews;
    private String cache="";
    private TextView tv_sequence;
    private ViewHolder viewHolder;

    public NewsPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();

        View view=View.inflate(context, R.layout.news_pager,null);
        initialize(view);
        fl_content.addView(view);
        cache= CacheData.getString(context,CACHE_HOME_PAGE_DATA);
        if (!TextUtils.isEmpty(cache)){
            parseJson(cache);
        }
        getDataFromNet();
    }


    private void initialize(View view) {
        vpbanner = (ViewPager) view.findViewById(R.id.vp_banner);
        lvnews = (ListView) view.findViewById(R.id.lv_news);
        tv_title= (TextView) view.findViewById(R.id.tv_title);
        tv_sequence= (TextView) view.findViewById(R.id.tv_sequence);
    }

    public void getDataFromNet() {
        RxVolley.get("http://192.168.1.106:8080/web_home/static/api/news/10001/list_1.json", new HttpCallback() {
            @Override
            public void onFailure(VolleyError error) {
                super.onFailure(error);
                Log.e("error",error.toString());
                Toast.makeText(context, "联网失败"+error.toString(), Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onSuccess(String t) {
                super.onSuccess(t);
                CacheData.putString(context,CACHE_HOME_PAGE_DATA,t);
                processData(t);
            }
        });
    }

    private void processData(String t) {
        HomeData data=parseJson(t);
        topnews=data.getData().getTopnews();
        news=data.getData().getNews();
        vpbanner.setAdapter(new MyPageAdapter());
        lvnews.setAdapter(new MyBaseAdapter());

    }

    private HomeData parseJson(String t) {
        return  new Gson().fromJson(t,HomeData.class);
    }

    private class MyPageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return topnews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object==view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=new ImageView(context);
            tv_title.setText(topnews.get(position).getTitle());
            int nowPosition=position;
            tv_sequence.setText(nowPosition+"/"+topnews.size());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);
            Glide.with(context).load(StaticContent.HOST_IP+topnews.get(position).getListimage()).asBitmap().error(R.drawable.load_default).into(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return news.size();
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
                view= View.inflate(context,R.layout.item_home_pager,null);
                viewHolder=new ViewHolder();
                viewHolder.iv_icon= (ImageView) view.findViewById(R.id.iv_icon);
                viewHolder.tv_title= (TextView) view.findViewById(R.id.tv_title);
                viewHolder.tv_time= (TextView) view.findViewById(R.id.tv_time);
                view.setTag(viewHolder);
            }else{
                viewHolder= (ViewHolder) view.getTag();
            }
            viewHolder.tv_title.setText(news.get(i).getTitle());
            viewHolder.tv_time.setText(news.get(i).getDate());
            Glide.with(context).load(StaticContent.HOST_IP+news.get(i).getListimage()).asBitmap().error(R.drawable.load_default).into(viewHolder.iv_icon);

            return view;
        }
    }
    static class ViewHolder{
        ImageView iv_icon;
        TextView tv_title;
        TextView tv_time;
    }
}
