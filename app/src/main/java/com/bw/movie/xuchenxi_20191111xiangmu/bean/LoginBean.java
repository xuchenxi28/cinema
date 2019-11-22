package com.bw.movie.xuchenxi_20191111xiangmu.bean;

public class LoginBean {

    /**
     * result : {"sessionId":"157343671688713779","userId":13779,"userInfo":{"email":"485131108@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":13779,"lastLogStringime":1573436695000,"nickName":"奉天","sex":1}}
     * message : 登陆成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * sessionId : 157343671688713779
         * userId : 13779
         * userInfo : {"email":"485131108@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","id":13779,"lastLogStringime":1573436695000,"nickName":"奉天","sex":1}
         */

        private String sessionId;
        private String userId;
        private UserInfoBean userInfo;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * email : 485131108@qq.com
             * headPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
             * id : 13779
             * lastLogStringime : 1573436695000
             * nickName : 奉天
             * sex : 1
             */

            private String email;
            private String headPic;
            private String id;
            private long lastLogStringime;
            private String nickName;
            private String sex;

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public long getLastLogStringime() {
                return lastLogStringime;
            }

            public void setLastLogStringime(long lastLogStringime) {
                this.lastLogStringime = lastLogStringime;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }
        }
    }
}
