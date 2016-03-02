package com.xnyu.pt.Bean;

import java.util.List;

/**
 * Created by xnyu on 2016/1/17.
 */
public class CarerBean {

    /**
     * code : 200
     * message : 200
     * size : 692
     * total : 692
     * data : [{"id":3171,"uid":2312,"level":2,"room":false,"meal":false,"workTime":2,"ageRange":0,"price":"20","xheight":116.296059,"yheight":39.929305,"publish":true,"img":"","photo":"","phone":"13671191296","age":39,"sex":0,"interview":"","location":"北京市海淀区阜成路甲52-1号","name":"李明","worktime":2,"address":"北京市海淀区阜成路甲52-1号"}]
     */

    private int code;
    private String message;
    private int size;
    private int total;
    /**
     * id : 3171
     * uid : 2312
     * level : 2
     * room : false
     * meal : false
     * workTime : 2
     * ageRange : 0
     * price : 20
     * xheight : 116.296059
     * yheight : 39.929305
     * publish : true
     * img :
     * photo :
     * phone : 13671191296
     * age : 39
     * sex : 0
     * interview :
     * location : 北京市海淀区阜成路甲52-1号
     * name : 李明
     * worktime : 2
     * address : 北京市海淀区阜成路甲52-1号
     */

    private List<DataEntity> data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getSize() {
        return size;
    }

    public int getTotal() {
        return total;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private int id;
        private int uid;
        private int level;
        private boolean room;
        private boolean meal;
        private int workTime;
        private int ageRange;
        private String price;
        private double xheight;
        private double yheight;
        private boolean publish;
        private String img;
        private String photo;
        private String phone;
        private int age;
        private int sex;
        private String interview;
        private String location;
        private String name;
        private int worktime;
        private String address;

        public void setId(int id) {
            this.id = id;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setRoom(boolean room) {
            this.room = room;
        }

        public void setMeal(boolean meal) {
            this.meal = meal;
        }

        public void setWorkTime(int workTime) {
            this.workTime = workTime;
        }

        public void setAgeRange(int ageRange) {
            this.ageRange = ageRange;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setXheight(double xheight) {
            this.xheight = xheight;
        }

        public void setYheight(double yheight) {
            this.yheight = yheight;
        }

        public void setPublish(boolean publish) {
            this.publish = publish;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public void setInterview(String interview) {
            this.interview = interview;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWorktime(int worktime) {
            this.worktime = worktime;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getId() {
            return id;
        }

        public int getUid() {
            return uid;
        }

        public int getLevel() {
            return level;
        }

        public boolean isRoom() {
            return room;
        }

        public boolean isMeal() {
            return meal;
        }

        public int getWorkTime() {
            return workTime;
        }

        public int getAgeRange() {
            return ageRange;
        }

        public String getPrice() {
            return price;
        }

        public double getXheight() {
            return xheight;
        }

        public double getYheight() {
            return yheight;
        }

        public boolean isPublish() {
            return publish;
        }

        public String getImg() {
            return img;
        }

        public String getPhoto() {
            return photo;
        }

        public String getPhone() {
            return phone;
        }

        public int getAge() {
            return age;
        }

        public int getSex() {
            return sex;
        }

        public String getInterview() {
            return interview;
        }

        public String getLocation() {
            return location;
        }

        public String getName() {
            return name;
        }

        public int getWorktime() {
            return worktime;
        }

        public String getAddress() {
            return address;
        }
    }
}
