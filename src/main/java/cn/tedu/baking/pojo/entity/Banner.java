package cn.tedu.baking.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Banner {
    private Long id;

    private String imgUrl;

    private Integer sort;

    private Date createTime;
}
