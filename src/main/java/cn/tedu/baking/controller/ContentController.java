package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.ContentMapper;
import cn.tedu.baking.pojo.dto.ContentDTO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.vo.ContentIndexVO;
import cn.tedu.baking.pojo.vo.ContentUpdateVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.security.CustomUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/contents/")
public class ContentController {

    @Autowired
    private ContentMapper contentMapper;

    @PostMapping("add-new")
    public JsonResult addNew (@RequestBody ContentDTO contentDTO,
                              @AuthenticationPrincipal CustomUserDetails details){
        Content content = new Content();
        BeanUtils.copyProperties(contentDTO,content);
        if (content.getId() !=null){
            content.setUpdateTime(new Date());
            content.setUpdateBy(details.getId());
            contentMapper.update(content);
        }
        else{
            content.setCreateTime(new Date());
            contentMapper.insert(content);
        }
        return JsonResult.ok();
    }

    @GetMapping("{type}/management")
    public JsonResult management(@PathVariable Integer type,
                                 @AuthenticationPrincipal CustomUserDetails details){
        return JsonResult.ok(contentMapper.selectByType(type, details.getId()));

    }

    @GetMapping("{id}/update")
    public  JsonResult selectForUpdate(@PathVariable Long id){
        return JsonResult.ok(contentMapper.selectByIdForUpdate(id));
    }

    @PostMapping("{id}/delete")
    public JsonResult delete (@PathVariable Long id){
        ContentUpdateVO contentUpdateVO = contentMapper.selectByIdForUpdate(id);
        new File("d:/file"+contentUpdateVO.getImgUrl()).delete();

        if (contentUpdateVO.getType() == 2){
            new File("d:/file"+contentUpdateVO.getVideoUrl()).delete();
        }
        contentMapper.deleteById(id);
        return JsonResult.ok();
    }

    @GetMapping("{type}/{categoryId}/index")
    public JsonResult selectIndex(@PathVariable Integer type,
                                  @PathVariable Long categoryId) {
        System.out.println("type = " + type + ", categoryId = " + categoryId);
        List<ContentIndexVO> list = contentMapper.selectByTypeAndCategoryId(type, categoryId);
        return JsonResult.ok(list);
    }

    @GetMapping("{id}/detail")
    public JsonResult selectDetail(@PathVariable Long id) {
        contentMapper.updateViewCountById(id);
        return JsonResult.ok(contentMapper.selectByIdForDetail(id));
    }

    @GetMapping("{userId}/{contentId}/other")
    public JsonResult selectOther(@PathVariable Long userId,
                                  @PathVariable Long contentId) {
        return JsonResult.ok(contentMapper.selectByUserId(userId, contentId));
    }

    @GetMapping("hot")
    public JsonResult selectHot() {
        return JsonResult.ok(contentMapper.selectHot());
    }

    @GetMapping("{type}/list")
    public JsonResult selectList(@PathVariable Integer type) {
        return JsonResult.ok(contentMapper.selectListByType(type));
    }

    @GetMapping("{wd}/search")
    public JsonResult search(@PathVariable String wd) {
        return JsonResult.ok(contentMapper.selectByWd(wd));
    }

    @GetMapping("{type}/admin")
    public JsonResult selectAdmin(@PathVariable Integer type) {
        return JsonResult.ok(contentMapper.selectByTypeForAdmin(type));
    }

}
