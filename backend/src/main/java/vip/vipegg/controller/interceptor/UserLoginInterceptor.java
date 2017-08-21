package vip.vipegg.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import vip.vipegg.common.Constants;
import vip.vipegg.util.StringUtils;
import vip.vipegg.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!isLogin(request)){
            if(Utils.isAjax(request)){
                PrintWriter out = response.getWriter();
                response.setContentType("application/json;charset=utf-8");
                out.write("{\"code\":401}");
                out.flush();
                out.close();
            }else{
                // 登录跳转url
                String forwardUrl = request.getRequestURI();
                String queryStr = request.getQueryString();
                if(StringUtils.hasText(queryStr)){
                    forwardUrl += "?" + queryStr;
                }
                request.getSession().setAttribute(Constants.FORWARD_URL, forwardUrl);
                response.sendRedirect("/login");
            }
            return false;
        }
        return true;
    }

    private boolean isLogin(HttpServletRequest request){
        return null != request.getSession().getAttribute(Constants.Admin_SESSION);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
