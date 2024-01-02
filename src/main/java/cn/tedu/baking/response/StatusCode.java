package cn.tedu.baking.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusCode {

    /**
     * 所有的枚舉實例都在最上面
     */

     SUCCESS(1, "成功"),
     NOT_LOGIN(1000, "未登錄"),
     LOGIN_SUCCESS(1001, "登錄成功"),
     PASSWORD_ERROR(1002, "密碼錯誤"),
     USERNAME_ERROR(1003, "用戶名錯誤"),
     USERNAME_ALREADY_EXISTS(1004, "用戶名已存在"),
     FORBIDDEN_ERROR(1005, "無權訪問"),
     OPERATION_SUCCESS(2001, "操作成功"),
     OPERATION_FAILED(2002, "操作失敗"),
     VALIDATE_ERROR(3002, "參數校驗失敗");

     private Integer code;
     private String msg;


}
