package com.tydic.books.interceptor;

import com.tydic.books.controller.BeforeLogInController;
import lombok.Getter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@SessionAttributes(value = {"userId"})
public class logInInterceptor implements HandlerInterceptor {
    @Getter
    private int userId;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("Log In 拦截器：前");
        //获取会话
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(BeforeLogInController.getUserIdKey());
        if (attribute != null){
            System.out.println("通过拦截器");
//            System.out.println(session.getId());
            return true;
        }
        System.out.println("拦截器拦截");
//        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("Log In 拦截器：后");
    }

}
