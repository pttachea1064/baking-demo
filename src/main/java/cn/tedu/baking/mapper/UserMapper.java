package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.User;
import cn.tedu.baking.pojo.vo.UserAdminVO;
import cn.tedu.baking.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 註冊使用者
     *
     * @param user 註冊的使用者信息
     * @return 影響的記錄數
     */
    int insert(User user);

    /**
     * 基於用戶名查詢用戶信息
     *
     * @param userName 用戶名
     * @return 用戶信息(包含id 、 user_name 、 nickname 、 is_admin和img_url)
     */
    UserVO selectByUserName(String userName);

    /**
     * 根據id修改用戶信息
     *
     * @param user 要更改的用戶信息
     * @return 影響的記錄數
     */
    int update(User user);

    /**
     * 根據id查詢用戶的頭像路徑
     *
     * @param id 用戶id
     * @return 頭像路徑(有值, 有頭像 ; 無值, 無頭像)
     */
    String selectImgUrlById(Long id);

    /**
     * 查詢所有用戶信息
     *
     * @return 封裝所有用戶信息的集合(不包含密碼)
     */
    List<UserAdminVO> select();

    /**
     * 根據id刪除指定的用戶記錄
     *
     * @param id 用戶id
     * @return 影響的記錄數
     */
    int deleteById(Long id);
}
