package cn.fengliangit.servlet;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list-sc-users")
public class sc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<sca> users=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            sca user = new sca();
            user.setId(1000L+i);
            user.setName("提莫"+i+"号");
            user.setCid(RandomUtil.randomInt(18,30));
            user.setCname(RandomUtil.randomString("男女",1));
            user.setScore(Integer.parseInt(RandomUtil.randomNumbers(2)));
            user.setTname(RandomUtil.randomString(10)+"@qq.com");
            users.add(user);
        }
        // 将数据转为json数据
        String jsonData = JSONUtil.toJsonStr(users);
        // 设置响应格式
        resp.setContentType("application/json;charset=utf-8");
        // 响应数据
        resp.getWriter().write(jsonData);
    }
}
