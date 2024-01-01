package cn.tedu.baking.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DTO: 封装用户传递给后端的数据
 * VO: 封装后端业务传输的数据
 * ENTITY: 封装表数据
 * POJO: 实体类
 */
@Data
public class UserRegDTO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true, example = "黑大帅")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", required = true)
    private String nickName;
}
