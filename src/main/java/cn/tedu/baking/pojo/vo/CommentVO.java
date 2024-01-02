package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    private Long id;

    private String content;

    private String nickName;

    private String userImgUrl;

    private Date createTime;
}
