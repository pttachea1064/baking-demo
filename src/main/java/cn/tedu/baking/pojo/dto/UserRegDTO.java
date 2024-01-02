package cn.tedu.baking.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DTO: 封裝用戶使用者傳遞給後端的數據
 * VO: 封裝後端業務傳輸的數據
 * ENTITY: 封裝表數據
 * POJO: 實體類
 */

@Data
public class UserRegDTO {

    @ApiModelProperty(value = "用戶名", required = true, example = "黑大帥")
    private String userName;

    @ApiModelProperty(value = "密碼", required = true)
    private String password;

    @ApiModelProperty(value = "暱稱", required = true)
    private String nickName;
}
