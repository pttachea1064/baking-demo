package cn.tedu.baking.pojo.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private Long id;
    private String nickName;
    private String imgUrl;
}
