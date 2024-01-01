package cn.tedu.baking.pojo.vo;

import lombok.Data;

@Data
public class UserVO {
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
     * 是否是管理员
     * 0 → 普通用户(默认值)
     * 1 → 管理员
     */
    private Integer isAdmin;
    /**
     * 头像路径
     */
    private String imgUrl;
}
