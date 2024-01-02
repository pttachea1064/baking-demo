package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.BannerMapper;
import cn.tedu.baking.pojo.vo.BannerVO;
import cn.tedu.baking.response.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/banners/")
public class BannerController {
    @Autowired
    BannerMapper bannerMapper;

    @GetMapping("")
    public JsonResult select(){
        List<BannerVO> list = bannerMapper.select();
        return JsonResult.ok(list);
    }

    @GetMapping("admin")
    public JsonResult selectForAdmin(){
        return JsonResult.ok(bannerMapper.selectForAdmin());
    }

    @PostMapping("{id}/delete")
    public JsonResult delete(@PathVariable Long id) {
        bannerMapper.deleteById(id);
        return JsonResult.ok();
    }
}



