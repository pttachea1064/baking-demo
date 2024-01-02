package cn.tedu.baking.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Content {
    private Long id;

    private String title;

    private String imgUrl;

    private String videoUrl;

    private String content;

    private Long type;

    private Integer viewCount;

    private Integer commentCount;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    private String brief;

    private Long categoryId;
}
