package cn.tedu.baking.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    //顯示狀態代碼
    private Integer code;

    //顯示狀態代碼的意涵
    private String msg;

    //Server給Client的具體資料
    private Object data;


    //方法1. 不用返回具體資料的Controller方法
    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //方法2.基於方法1.上使用自訂的枚舉狀態代碼
    public JsonResult(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    //方法3.比方法2.多一個資料參數
    public JsonResult(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    //方法4.用於快速建造JsonResult物件 並且初始化3個屬性:code msg data
    public JsonResult(Object data) {
        this.code = StatusCode.SUCCESS.getCode();
        this.msg = StatusCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 兩個靜態方法 一個有回傳資料 一個無回傳資料
    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return ok(null);
    }
}
