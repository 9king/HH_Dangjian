package com.mycompany.hh_dangjian.entity;

import java.util.List;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.entity
 * 文件名:PartyWorkData
 * 创建者：zhuli
 * 创建时间: 2018/1/26  12:26
 * 描述:  TODO
 */
public class PartyWorkData {

    /**
     * data : {"study":[{"date":"2018-01-23 ","id":21000,"title":"基层党组织的基本任务是什么?","type":"study","url":"/static/html/2018/01/23/21000.html"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<StudyBean> study;

        public List<StudyBean> getStudy() {
            return study;
        }

        public void setStudy(List<StudyBean> study) {
            this.study = study;
        }

        public static class StudyBean {
            /**
             * date : 2018-01-23
             * id : 21000
             * title : 基层党组织的基本任务是什么?
             * type : study
             * url : /static/html/2018/01/23/21000.html
             */

            private String date;
            private int id;
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
