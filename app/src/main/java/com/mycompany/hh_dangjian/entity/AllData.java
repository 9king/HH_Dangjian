package com.mycompany.hh_dangjian.entity;

import java.util.List;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.entity
 * 文件名:AllData
 * 创建者：zhuli
 * 创建时间: 2018/1/24  15:53
 * 描述:  TODO
 */
public class AllData {

    /**
     * data : [{"id":10001,"title":"首页","type":1,"url":"/static/api/school/10001/list_1.json"},{"id":20000,"title":"新闻","type":2,"url":"/static/api/news/30001/list_1"},{"id":40001,"title":"学习","type":4,"url":"/static/api/news/40001/list_4.json"}]
     * extend : [10001,20001,30001,40001]
     * retcode : 200
     */

    private int retcode;
    private List<DataBean> data;
    private List<Integer> extend;

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<Integer> getExtend() {
        return extend;
    }

    public void setExtend(List<Integer> extend) {
        this.extend = extend;
    }

    public static class DataBean {
        /**
         * id : 10001
         * title : 首页
         * type : 1
         * url : /static/api/school/10001/list_1.json
         */

        private int id;
        private String title;
        private int type;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
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
