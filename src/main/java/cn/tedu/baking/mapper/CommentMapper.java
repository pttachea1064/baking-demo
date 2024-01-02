package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.Comment;
import cn.tedu.baking.pojo.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    int insert(Comment comment);

    List<CommentVO> selectByContentId(Long contentId);
}
