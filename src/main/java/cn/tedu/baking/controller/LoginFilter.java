package cn.tedu.baking.controller;

import cn.tedu.baking.pojo.vo.UserVO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter (filterName = "loginFilter",urlPatterns = "/admin.html")
//使用該註解 表示當前這個是一個篩選過濾的器具
/*urlPatterns表示在何處攔截過濾*/
//登入的篩選器 繼承servlet的Filter 並Override其中的方法
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 類型轉換的原因：
         * 在Servlet程式中，當我們需要使用到更具體的HTTP相關資訊時，例如處理HTTP的Session、Cookies、獲取HTTP方法等，就需要將 ServletRequest 和 ServletResponse 類型轉換為它們的子介面，即 HttpServletRequest 和 HttpServletResponse。
         * 這樣做允許我們使用更多與HTTP相關的功能和資訊，而不僅僅是通用的Servlet功能。
         */
        System.out.println("Filter is starting!!");
         HttpServletRequest  request = (HttpServletRequest)servletRequest;
         HttpServletResponse  response = (HttpServletResponse)servletResponse;

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("user");
        //登入失敗的時候跳回登入畫面
        if (user == null){
            response.sendRedirect("/login.html");
            return;
        }
        //登入成功的時候可以訪問後面的內容
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
