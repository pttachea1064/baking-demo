package cn.tedu.baking.pojo.dto;

import lombok.Data;

/**
 * TODO 作业: 添加评论
 */
@Data
public class CommentDTO {
    private String content;
    private Long userId;
    private Long contentId;
}
