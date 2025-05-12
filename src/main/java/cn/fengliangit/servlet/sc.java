package cn.fengliangit.servlet;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list-sc-users")
public class sc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<sca> users=new ArrayList<>();
        String jdbcURL = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "060703";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT studentid,name,tid,tname,sc,teachername FROM score")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("studentid");
                String name = resultSet.getString("name");
                int tid = resultSet.getInt("tid");
                String tname = resultSet.getString("tname");
                int sc = resultSet.getInt("sc");
                String teachername = resultSet.getString("teachername");

                sca user = new sca();
                user.setId(id);
                user.setName(name);
                user.setCid(tid);
                user.setCname(tname);
                users.add(user);




            }

        } catch (SQLException e) {
            e.printStackTrace();
        }









//        for (int i = 0; i < 6; i++) {
//            sca user = new sca();
//            user.setId(1000L+i);
//            user.setName("提莫"+i+"号");
//            user.setCid(RandomUtil.randomInt(18,30));
//            user.setCname(RandomUtil.randomString("男女",1));
//            user.setScore(Integer.parseInt(RandomUtil.randomNumbers(2)));
//            user.setTname(RandomUtil.randomString(10)+"@qq.com");
//            users.add(user);
//        }
        // 将数据转为json数据
        String jsonData = JSONUtil.toJsonStr(users);
        // 设置响应格式
        resp.setContentType("application/json;charset=utf-8");
        // 响应数据
        resp.getWriter().write(jsonData);
    }
}
