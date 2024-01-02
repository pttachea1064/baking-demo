package cn.tedu.baking.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ContentSimpleVO {
    private Long id;

    private String title;

    private String imgUrl;

    private Date createTime;
}
