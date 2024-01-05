package cn.tedu.baking.controller;

import cn.tedu.baking.mapper.UserMapper;
import cn.tedu.baking.pojo.dto.UserLoginDTO;
import cn.tedu.baking.pojo.dto.UserRegDTO;
import cn.tedu.baking.pojo.dto.UserUpdateDTO;
import cn.tedu.baking.pojo.entity.User;
import cn.tedu.baking.pojo.vo.UserVO;
import cn.tedu.baking.response.JsonResult;
import cn.tedu.baking.response.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;


    @PostMapping("reg")
    public JsonResult reg(@RequestBody UserRegDTO userRegDTO) {
        UserVO userVO =
                userMapper.selectByUserName(userRegDTO.getUserName());
        if (userVO != null) {
            return new JsonResult(StatusCode.USERNAME_ALREADY_EXISTS);
        }
        User user = new User();
        BeanUtils.copyProperties(userRegDTO, user);
        user.setCreateTime(new Date());
        /*   encoder 設定密碼加密方式 */
        user.setPassword(encoder.encode(userRegDTO.getPassword()));
        userMapper.insert(user);
        return JsonResult.ok();
    }

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("login")
    public JsonResult login(@RequestBody UserLoginDTO userLoginDTO,
                            HttpSession session) {

        try {
            Authentication result = manager.authenticate(new UsernamePasswordAuthenticationToken(
                    userLoginDTO.getUserName(), userLoginDTO.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(result);
            System.out.println("user-Message:"+result.getPrincipal());

        }catch (InternalAuthenticationServiceException e){
            System.out.println("the user is null");
            return new JsonResult(StatusCode.USERNAME_ERROR);
        }catch (BadCredentialsException e ){
            System.out.println("password is error!!");
            return  new JsonResult(StatusCode.PASSWORD_ERROR);
        }

        UserVO userVO = userMapper.selectByUserName(userLoginDTO.getUserName());
        if (userVO == null) {
            return new JsonResult(StatusCode.USERNAME_ERROR);
        }
        if (!userVO.getPassword().equals(userLoginDTO.getPassword())) {
            return new JsonResult(StatusCode.PASSWORD_ERROR);
        }
        //將已經登入的使用者保存到session當中
        session.setAttribute("user",userVO);
        return JsonResult.ok(userVO);
    }

    @GetMapping("logout")
    public JsonResult logout() {
        SecurityContextHolder.clearContext();
        return JsonResult.ok();
    }

//    ----------------update-------------------------------------update---------------------

    @PostMapping("update")
    public JsonResult update (@RequestBody UserUpdateDTO userUpdateDTO){
        //判斷大頭貼是否添加
        if (userUpdateDTO.getImgUrl() != null) {
            String imgUrl = userMapper.selectImgUrlById(userUpdateDTO.getId());
            new File("d:/file"+imgUrl).delete();//刪除圖片位置
        }
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO,user);
        userMapper.update(user);
        return JsonResult.ok();

    }

}