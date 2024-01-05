package cn.tedu.baking.controller;


import cn.tedu.baking.response.JsonResult;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {
    //  http://localhost:8080/test/cookie1

    /**
     * HttpServletRequest：
     * 目的： 負責處理客戶端的請求。
     * 功能： 提供有關客戶端請求的相關資訊，如參數、標頭、HTTP 方法等。
     * 取得資訊的方法： getParameter(), getHeader(), getMethod() 等。
     * 例子： 從客戶端瀏覽器接收的表單輸入、URL 參數等。
     */
//    設定一cookie的資料 並設定保存時間
    @RequestMapping("/cookie1")
    public JsonResult cookie1 (HttpServletResponse response){
        Cookie username = new Cookie("username", "keji");
        Cookie password = new Cookie("password", "123456");

        username.setMaxAge(60*60*24*7);

        response.addCookie(username);
        response.addCookie(password);
        return JsonResult.ok();
    }

//    獲取要求攜帶的cookie內容
     /**  HttpServletResponse：
     * 目的： 負責生成服務器對客戶端的回應。
     * 功能： 提供方法以設定回應的標頭、內容類型、狀態碼等，並將資料寫入回應流中。
     * 取得資訊的方法： 例如 setContentType(), setStatus(), getWriter() 等。
     * 例子： 將 HTML 內容、檔案、圖片等發送給客戶端。
     */

    @RequestMapping("/cookie2")
    public JsonResult cookie2 (HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie的username:" + name + ",cookie的value:" + value);
        }
        return JsonResult.ok();
    }

//    設定一個session的資料 並將資料存放到session
//    session是將資料放置在Srv.那的
    @RequestMapping("/session1")
    public JsonResult session1 (HttpSession session){
        session.setAttribute("name","Ming");
        session.setAttribute("gender","boy");
        return JsonResult.ok();
    }

//    從session取出對應的資料
    @RequestMapping("/session2")
    public JsonResult session2 (HttpSession session){
        String name = (String) session.getAttribute("name");
        String gender = (String) session.getAttribute("gender");
        System.out.println("name:" + name);
        System.out.println("gender:" + gender);
        return JsonResult.ok();
    }
}
