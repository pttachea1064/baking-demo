package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.User;
import cn.tedu.baking.pojo.vo.UserAdminVO;
import cn.tedu.baking.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    UserVO selectByUserName(String userName);

    int update(User user);

    String selectImgUrlById(Long id);

    List<UserAdminVO> select();

    int deleteById(Long id);
}
