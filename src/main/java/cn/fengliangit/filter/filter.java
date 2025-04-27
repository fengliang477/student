package cn.fengliangit.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器类，用于检查用户是否已登录
 * 拦截所有请求("/*")，检查是否存在有效的"fengliang" cookie
 */
@WebFilter("/index.html")
public class filter implements Filter {

    /**
     * 过滤器核心方法，处理所有请求
     * @param servletRequest 请求对象
     * @param servletResponse 响应对象
     * @param filterChain 过滤器链
     * @throws IOException 可能抛出的IO异常
     * @throws ServletException 可能抛出的Servlet异常
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String path = httpRequest.getRequestURI();

        // 排除登录页面的检查
        if (path.endsWith("/login.html") || path.endsWith(".css") || path.endsWith(".js")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        // 获取请求中的所有cookie
        Cookie[] cookies = httpRequest.getCookies();

        if (cookies != null) {
            // 遍历cookie查找名为"fengliang"的cookie
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("fengliang")) {
                    // 找到有效cookie，放行请求
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
            // 遍历完所有cookie都没找到"fengliang"，重定向到登录页
            ((javax.servlet.http.HttpServletResponse) servletResponse).sendRedirect("/login.html");
        } else {
            // 没有cookie，重定向到登录页
            ((javax.servlet.http.HttpServletResponse) servletResponse).sendRedirect("/login.html");
        }
    }
    /**
     * 过滤器初始化方法
     * @param filterConfig 过滤器配置对象
     * @throws ServletException 可能抛出的Servlet异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws  ServletException {
        // 初始化逻辑（当前为空实现）
    }

    /**
     * 过滤器销毁方法
     */
    @Override
    public void destroy() {
        // 销毁逻辑（当前为空实现）
    }
}
