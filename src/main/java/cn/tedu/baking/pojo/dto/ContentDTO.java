package cn.tedu.baking.pojo.dto;

import lombok.Data;

@Data
public class ContentDTO {
    /**
     * 新增的时候,不需要使用id属性,
     * 但是做修改时,会接收前端传入的id属性
     */
    private Long id;
    private String title;
    private String imgUrl;
    private String videoUrl;
    private String brief;
    private Long type;
    private Long categoryId;
    private Long createBy;
    private String content;
}
