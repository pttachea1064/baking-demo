package cn.tedu.baking.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BannerAdminVO {
    private Long id;
    /**
     * 輪播圖的存儲路徑
     */
    private String imgUrl;
    /**
     * 創建時間
     * Date類型默認的顯示格式: 2023-02-08T06:29:44.000+00:00
     * 一般都需要使用@JsonFormat註解轉換格式進行返回
     * ①pattern屬性: 設置模版 yyyy表示年 MM表示月 dd表示日
     * ②timezone屬性: 設置時區
     */
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date createTime;
}
