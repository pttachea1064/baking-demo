package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.vo.BannerAdminVO;
import cn.tedu.baking.pojo.vo.BannerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    List<BannerVO> select();

    List<BannerAdminVO> selectForAdmin();

    int deleteById(Long id);
}
