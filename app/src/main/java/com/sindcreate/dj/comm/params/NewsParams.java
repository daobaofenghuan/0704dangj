package com.sindcreate.dj.comm.params;

import com.sindcreate.dj.comm.PostParams;

/**
 * Created by Double on 2018/7/4.
 */

public class NewsParams extends PostParams{
    /**
     * pagination : {"current":1,"pagesize":1,"total":0}
     * query : {}
     */

    private PaginationBean pagination=new PaginationBean();
    private QueryBean query=new QueryBean();

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }

    public QueryBean getQuery() {
        return query;
    }

    public void setQuery(QueryBean query) {
        this.query = query;
    }

    public static class PaginationBean {
        /**
         * current : 1
         * pagesize : 1
         * total : 0
         */

        private int current;
        private int pagesize;
        private int total;

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static class QueryBean {
    }
}
