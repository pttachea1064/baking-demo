package cn.tedu.baking.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserAdminVO {
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 是否是管理员
     * 0 → 普通用户(默认值)
     * 1 → 管理员
     * 修改为Boolean的原因是前端的开关组件会基于布尔值进行转换
     * true转换为1
     * false转换为0
     * 后端传入的数字可以转换为布尔值
     * 1为true
     * 0为false
     */
    private Boolean isAdmin;
    /**
     * 头像图片路径
     */
    private String imgUrl;
}
