package cn.tedu.baking.pojo.vo;

import lombok.Data;

@Data
public class UserVO {
    private Long id;

    private String userName;

    private String password;

    private String nickName;

    private Integer isAdmin;

    private String imgUrl;
}
