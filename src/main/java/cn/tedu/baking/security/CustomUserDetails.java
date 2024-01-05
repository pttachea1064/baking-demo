package cn.tedu.baking.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUserDetails extends User {//User是Security的
    private Long id;
    private String nickName;
    private Integer isAdmin;
    private String imgUrl;

    public CustomUserDetails(Long id, String nickName, Integer isAdmin, String imgUrl, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.nickName = nickName;
        this.isAdmin = isAdmin;
        this.imgUrl = imgUrl;
    }
}
