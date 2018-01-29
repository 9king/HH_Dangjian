package com.mycompany.hh_dangjian.entity;

import java.util.List;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.entity
 * 文件名:HomeData
 * 创建者：zhuli
 * 创建时间: 2018/1/24  15:56
 * 描述:  TODO
 */
public class HomeData {

    /**
     * data : {"news":[{"date":"2018-01-23 ","id":200010,"listimage":"/static/images/2018/01/23/1.jpg","title":"习进平:政法工作要履行好四项主要任务","type":"news","url":"/static/html/2018/01/23/20001.html"},{"date":"2018-01-23 ","id":200011,"listimage":"/static/images/2018/01/23/1.jpg","title":"政法工作要履行好四项主要任务","type":"news","url":"/static/html/2018/01/23/20001.html"},{"date":"2018-01-23 ","id":200012,"listimage":"/static/images/2018/01/23/1.jpg","title":"习进平:政法工作要履行好四项主要任务","type":"news","url":"/static/html/2018/01/23/20001.html"}],"topnews":[{"id":20003,"listimage":"/static/images/2018/01/23/1.jpg","title":"习进平:政法工作要履行好四项主要任务","type":"news","url":"/static/html/2018/01/23/20001.html"},{"id":20004,"listimage":"/static/images/2018/01/23/2.jpg","title":"习进平:政法工作要履行好四项主要任务","type":"news","url":"/static/html/2018/01/23/20001.html"},{"id":20005,"listimage":"/static/images/2018/01/23/3.jpg","title":"习进平:政法工作要履行好四项主要任务","type":"news","url":"/static/html/2018/01/23/20001.html"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<NewsBean> news;
        private List<TopnewsBean> topnews;

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<TopnewsBean> getTopnews() {
            return topnews;
        }

        public void setTopnews(List<TopnewsBean> topnews) {
            this.topnews = topnews;
        }

        public static class NewsBean {
            /**
             * date : 2018-01-23
             * id : 200010
             * listimage : /static/images/2018/01/23/1.jpg
             * title : 习进平:政法工作要履行好四项主要任务
             * type : news
             * url : /static/html/2018/01/23/20001.html
             */

            private String date;
            private int id;
            private String listimage;
            private String title;
            private String type;
            private String url;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getListimage() {
                return listimage;
            }

            public void setListimage(String listimage) {
                this.listimage = listimage;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TopnewsBean {
            /**
             * id : 20003
             * listimage : /static/images/2018/01/23/1.jpg
             * title : 习进平:政法工作要履行好四项主要任务
             * type : news
             * url : /static/html/2018/01/23/20001.html
             */

            private int id;
            private String listimage;
            private String title;
            private String type;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getListimage() {
                return listimage;
            }

            public void setListimage(String listimage) {
                this.listimage = listimage;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
