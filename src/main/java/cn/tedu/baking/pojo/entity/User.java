package cn.tedu.baking.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否是管理员
     * 0 → 普通用户(默认值)
     * 1 → 管理员
     */
    private Integer isAdmin;
    /**
     * 头像图片路径
     */
    private String imgUrl;
}
