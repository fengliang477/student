package cn.fengliangit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
login(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
login(req,resp);
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("fengliang") && password.equals("123456")) {
            setcookie(req, resp);
            resp.sendRedirect("/index.html");


        }
        else {
            resp.getWriter().write("用户名或密码错误");
        }

    }
    private void setcookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("fengliang", "123456");
        cookie.setMaxAge(60 * 60 * 24 * 7);
        resp.addCookie(cookie);





    }

}
