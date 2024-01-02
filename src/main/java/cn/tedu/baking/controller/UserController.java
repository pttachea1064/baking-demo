package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.UserMapper;
import cn.tedu.baking.pojo.dto.UserLoginDTO;
import cn.tedu.baking.pojo.dto.UserRegDTO;
import cn.tedu.baking.pojo.entity.User;
import cn.tedu.baking.pojo.vo.UserVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("reg")
    public JsonResult reg(@RequestBody UserRegDTO userRegDTO) {
        UserVO userVO = userMapper.selectByUserName(userRegDTO.getUserName());
        if (userVO != null) {
            return new JsonResult(StatusCode.USERNAME_ALREADY_EXISTS);
        }
        User user = new User();
        BeanUtils.copyProperties(userRegDTO, user);
        user.setCreateTime(new Date());
        userMapper.insert(user);
        return JsonResult.ok();
    }

    @PostMapping("login")
    public JsonResult login(@RequestBody UserLoginDTO userLoginDTO) {
        UserVO userVO = userMapper.selectByUserName(userLoginDTO.getUserName());
        if (userVO == null) {
            return new JsonResult(StatusCode.USERNAME_ERROR);
        }
        if (!userVO.getPassword().equals(userLoginDTO.getPassword())) {
            return new JsonResult(StatusCode.PASSWORD_ERROR);
        }
        return JsonResult.ok(userVO);
    }

    @GetMapping("logout")
    public JsonResult logout() {
        return JsonResult.ok();
    }
}