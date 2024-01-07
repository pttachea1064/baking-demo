package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.*;
import cn.tedu.baking.pojo.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    Integer insert(Content content);

    List<ContentManagementVO> selectByType(Integer type, Long id);

    ContentUpdateVO selectByIdForUpdate(Long id);

    Integer update(Content content);

    Integer deleteById(Long id);

    List<ContentIndexVO> selectByTypeAndCategoryId(Integer type, Long categoryId);

    ContentDetailVO selectByIdForDetail(Long id);

    int updateViewCountById(Long id);

    List<ContentSimpleVO> selectByUserId(Long userId, Long contentId);

    List<ContentSimpleVO> selectHot();

    List<ContentIndexVO> selectListByType(Integer type);

    List<ContentIndexVO> selectByWd(String wd);

    List<ContentAdminVO> selectByTypeForAdmin(Integer type);

    int selectByContentId(Long contentId);
}
