package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.Comment;
import cn.tedu.baking.pojo.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 發表評論
     *
     * @param comment 評論內容
     * @return 影響的記錄數
     */
    int insert(Comment comment);

    /**
     * 基於稿件id查詢評論內容
     *
     * @param contentId 稿件id
     * @return
     */
    List<CommentVO> selectByContentId(Long contentId);
}
