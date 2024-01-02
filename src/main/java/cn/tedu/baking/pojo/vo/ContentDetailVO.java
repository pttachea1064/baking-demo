package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ContentDetailVO {
    private Long id;

    private String title;

    private String videoUrl;

    private String content;

    private Long type;

    private Integer viewCount;

    private Integer commentCount;

    private Date createTime;

    private String brief;

    private String nickName;

    private String userImgUrl;

    private Long userId;
}
