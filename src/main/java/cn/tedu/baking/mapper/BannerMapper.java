package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.vo.BannerAdminVO;
import cn.tedu.baking.pojo.vo.BannerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    /**
     * 首頁查詢所有輪播圖
     *
     * @return 輪播圖頁面
     */
    List<BannerVO> select();

    /**
     * 管理員頁面查詢輪播圖
     *
     * @return 輪播圖頁面
     */
    List<BannerAdminVO> selectForAdmin();

    /**
     * 刪除輪播圖
     *
     * @param id 輪播圖id
     * @return 影響的記錄數
     */
    int deleteById(Long id);
}
