package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ContentManagementVO {
    private Long id;

    private String title;

    private String imgUrl;

    private Long type;

    private Integer viewCount;

    private Integer commentCount;

    private Date createTime;

    private String brief;

    private String categoryName;
}
