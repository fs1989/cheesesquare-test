package com.support.android.designlibdemo;

import cn.bmob.v3.BmobObject;

/**
 * Created by Dan on 2016-01-17.
 */
public class FeedItem extends BmobObject {

    Integer id;
    Integer likes;
    String name;
    String desc;
    String avarar;
    String image;
    String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAvatar() {
        return avarar;
    }

    public void setAvator(String avarar) {
        this.avarar = avarar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
