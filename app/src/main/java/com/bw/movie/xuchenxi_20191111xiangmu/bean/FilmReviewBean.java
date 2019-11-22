package com.bw.movie.xuchenxi_20191111xiangmu.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class FilmReviewBean {

    /**
     * result : [{"commentContent":"动不动","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2182,"commentTime":1574164367000,"commentUserId":13686,"commentUserName":"哈喽","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":1.5},{"commentContent":"好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2180,"commentTime":1574163836000,"commentUserId":13768,"commentUserName":"nini","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"c5","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2151,"commentTime":1573717941000,"commentUserId":13655,"commentUserName":"tester7","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"电影好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115201938.unknown","commentId":2149,"commentTime":1573717415000,"commentUserId":13740,"commentUserName":"邢江艳","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.4},{"commentContent":"一般般","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-23/20191023202745.jpg","commentId":2148,"commentTime":1573649883000,"commentUserId":13565,"commentUserName":"ggh","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0.5},{"commentContent":"电影非常giao，一giao我里giaogiao","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-19/20191119203023.png","commentId":2147,"commentTime":1573645468000,"commentUserId":13733,"commentUserName":"曹兴满","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"一给我类giaogiao","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-16/20191116105137.png","commentId":2143,"commentTime":1573216411000,"commentUserId":13627,"commentUserName":"吴浩然","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":9.9},{"commentContent":"真尼玛好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115202522.jpg","commentId":2141,"commentTime":1573216258000,"commentUserId":13710,"commentUserName":"遇上方知有","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5},{"commentContent":"电影好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-11-15/20191115200650.jpg","commentId":2136,"commentTime":1573215304000,"commentUserId":13709,"commentUserName":"郝甜甜","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"站好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-10-25/20191025154434.jpg","commentId":2133,"commentTime":1573215014000,"commentUserId":13712,"commentUserName":"大明星","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentContent : 动不动
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 2182
         * commentTime : 1574164367000
         * commentUserId : 13686
         * commentUserName : 哈喽
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 1.5
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
