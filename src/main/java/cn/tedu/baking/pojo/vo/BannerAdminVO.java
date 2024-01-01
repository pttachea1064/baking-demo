package cn.tedu.baking.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BannerAdminVO {
    private Long id;
    /**
     * 轮播图的存储路径
     */
    private String imgUrl;
    /**
     * 创建时间
     * Date类型默认的显示格式: 2023-02-08T06:29:44.000+00:00
     * 一般都需要使用@JsonFormat注解转换格式进行返回
     * ①pattern属性: 设置模版 yyyy表示年 MM表示月 dd表示日
     * ②timezone属性: 设置时区
     */
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
    private Date createTime;
}
