package cn.tedu.baking.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*使該方法在Controller當中自動添加進入認證管理*/
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean()throws  Exception{
        return  super.authenticationManagerBean();
    }


    /*設置密碼成為加密的狀態*/
    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();//指定加密方式為固定式亂碼
    }



    @Override
    protected  void configure (HttpSecurity http) throws Exception{
        http.formLogin().loginPage("login.html");
        String[] urls = {"/admin.html", "/personal.html", "/postArticle.html", "/articleManagement.html", "/v1/users"};
        http.authorizeRequests()
                .mvcMatchers(urls)
                .authenticated()
                .anyRequest()
                .permitAll();

        http.csrf().disable();
        /**
         * CSRF是一種網路攻擊，攻擊者利用被攻擊用戶已經被授權的身份，
         * 在用戶不知情的情況下執行非法操作。Spring Security預設啟用CSRF保護，
         * 這意味著每次發送HTTP POST請求時，Spring Security會檢查請求中是否包含有效的CSRF令牌。
         * 如果沒有有效的CSRF令牌，則請求會被視為不合法，並阻止執行。
         */
    }

}
