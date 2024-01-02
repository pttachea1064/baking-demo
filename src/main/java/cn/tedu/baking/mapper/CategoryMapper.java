package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    public List<CategoryVO> selectByType(Integer type);
}
