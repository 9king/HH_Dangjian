package com.mycompany.hh_dangjian.entity;

import java.util.List;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.entity
 * 文件名:StudyData
 * 创建者：zhuli
 * 创建时间: 2018/1/25  12:18
 * 描述:  TODO
 */
public class StudyData {

    /**
     * data : {"children":[{"id":21000,"title":"基层组织建设","type":1,"url":"/static/api/study/21000/list_1.json"},{"id":22000,"title":"发展党员工作","type":1,"url":"/static/api/study/22000/list_1.json"},{"id":23000,"title":"党员教育管理","type":1,"url":"/static/api/study/23000/list_1.json"},{"id":24000,"title":"党内选举工作","type":1,"url":"/static/api/study/24000/list_1.json"}],"extend":[10007,10006,10008,10014,10091,10010,10192,10009,10095,10093,10012,10011],"retcode":200}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * children : [{"id":21000,"title":"基层组织建设","type":1,"url":"/static/api/study/21000/list_1.json"},{"id":22000,"title":"发展党员工作","type":1,"url":"/static/api/study/22000/list_1.json"},{"id":23000,"title":"党员教育管理","type":1,"url":"/static/api/study/23000/list_1.json"},{"id":24000,"title":"党内选举工作","type":1,"url":"/static/api/study/24000/list_1.json"}]
         * extend : [10007,10006,10008,10014,10091,10010,10192,10009,10095,10093,10012,10011]
         * retcode : 200
         */

        private int retcode;
        private List<ChildrenBean> children;
        private List<Integer> extend;

        public int getRetcode() {
            return retcode;
        }

        public void setRetcode(int retcode) {
            this.retcode = retcode;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public List<Integer> getExtend() {
            return extend;
        }

        public void setExtend(List<Integer> extend) {
            this.extend = extend;
        }

        public static class ChildrenBean {
            /**
             * id : 21000
             * title : 基层组织建设
             * type : 1
             * url : /static/api/study/21000/list_1.json
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
}
