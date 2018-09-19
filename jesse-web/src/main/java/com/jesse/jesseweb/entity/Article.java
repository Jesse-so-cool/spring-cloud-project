package com.jesse.jesseweb.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Date;

@Data
@ToString
public class Article {

    @Id
    private Integer id;

    private Integer userId;

    private String username;

    private String status;
    @Transient
    private User user;

    private String content;

    private String title;

    private Integer isDeleted = 0;

    private Integer viewCount;

    private String mainImg;

    private Date deployDate;

    private Date updateDate;

    public Article() {

    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, Integer userId, String username, String content, String title, Integer isDeleted, Integer viewCount, String mainImg, Date deployDate, Date updateDate, String status) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.content = content;
        this.title = title;
        this.isDeleted = isDeleted;
        this.viewCount = viewCount;
        this.mainImg = mainImg;
        this.deployDate = deployDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public Article(Integer id, Integer userId, String username, String title, Integer viewCount) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.title = title;
        this.viewCount = viewCount;
    }
}
