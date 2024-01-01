package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 根據類別類型查詢類別信息
     *
     * @param type 類別類型 1 → 食譜 2 → 視頻 3 → 咨詢
     * @return 對應類型的類別信息
     */
    public List<CategoryVO> selectByType(Integer type);
}
