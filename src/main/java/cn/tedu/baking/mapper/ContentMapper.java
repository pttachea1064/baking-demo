package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.*;
import cn.tedu.baking.pojo.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {
    /**
     * 發布稿件
     *
     * @param content 稿件具體信息
     */
    Integer insert(Content content);

    /**
     * 查詢當前用戶的各類型稿件信息
     *
     * @param type 稿件類型 1 → 食譜 2 → 視頻 3 → 咨詢
     * @param id   用戶id
     * @return 稿件集合
     */
    List<ContentManagementVO> selectByType(Integer type, Long id);

    /**
     * 編輯稿件時,根據稿件的id查詢稿件信息
     *
     * @param id 稿件id
     * @return 稿件信息
     */
    ContentUpdateVO selectByIdForUpdate(Long id);

    /**
     * 根據id修改稿件信息
     *
     * @param content 要修改的稿件內容
     * @return 影響的行數
     */
    Integer update(Content content);

    /**
     * 根據稿件編號刪除稿件
     *
     * @param id 稿件編號
     * @return
     */
    Integer deleteById(Long id);

    /**
     * 根據一級分類和二級分類查詢稿件信息
     *
     * @param type       一級分類
     * @param categoryId 二級分類
     * @return 對應的稿件信息
     */
    List<ContentIndexVO> selectByTypeAndCategoryId(Integer type, Long categoryId);

    /**
     * 根據稿件的id查詢稿件詳細內容
     *
     * @param id 稿件id
     * @return 稿件詳細內容
     */
    ContentDetailVO selectByIdForDetail(Long id);

    /**
     * 根據稿件id修改稿件的瀏覽量
     *
     * @param id 稿件id
     * @return 修改的記錄數
     */
    int updateViewCountById(Long id);

    /**
     * 根據作者id查詢作者的其他稿件
     *
     * @param userId    作者id
     * @param contentId 稿件id
     * @return 其他稿件信息
     */
    List<ContentSimpleVO> selectByUserId(Long userId, Long contentId);

    /**
     * 查詢熱門稿件(訪問量最高的前4條)
     *
     * @return 稿件信息
     */
    List<ContentSimpleVO> selectHot();

    /**
     * 首頁根據一級分類查詢該分類下的所有稿件
     *
     * @param type 一級分類
     * @return 稿件信息
     */
    List<ContentIndexVO> selectListByType(Integer type);

    /**
     * 根據關鍵字查詢稿件信息
     *
     * @param wd 關鍵字
     * @return
     */
    List<ContentIndexVO> selectByWd(String wd);

    /**
     * 管理員界面根據一級分類查詢稿件信息
     *
     * @param type 一級分類
     * @return 稿件信息
     */
    List<ContentAdminVO> selectByTypeForAdmin(Integer type);

    /**
     * 根據稿件id修改稿件的評論量
     *
     * @param contentId 稿件id
     * @return 影響的記錄數
     */
    int updateCommentCountById(Long contentId);
}
