package cn.tedu.baking.security;

import cn.tedu.baking.mapper.UserMapper;
import cn.tedu.baking.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserVO userVO = userMapper.selectByUserName(username);
        if (userVO != null) {
            String role = userVO.getIsAdmin() == 1 ? "ADMIN" : "USER";
            CustomUserDetails userDetails = new CustomUserDetails(
                    userVO.getId(),
                    userVO.getNickName(),
                    userVO.getIsAdmin(),
                    userVO.getImgUrl(),
                    username,
                    userVO.getPassword(),
                    AuthorityUtils.createAuthorityList(role));
            return userDetails;
        }
        return null;
    }
}
