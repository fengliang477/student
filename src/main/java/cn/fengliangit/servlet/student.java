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

@WebServlet("/list-student-users")
public class student extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<studentuser> users=new ArrayList<>();
        String jdbcURL = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "060703";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name,sex,age,phone,email FROM student")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                studentuser user = new studentuser();
                user.setId((long) id);
                user.setName(name);
                user.setSex(sex);
                user.setAge(age);
                user.setPhone(phone);
                user.setEmail(email);
                users.add(user);




            }

        } catch (SQLException e) {
            e.printStackTrace();
        }












//        for (int i = 0; i < 6; i++) {
//            studentuser user = new studentuser();
//            user.setId(1000L+i);
//            user.setName("提莫"+i+"号");
//            user.setAge(RandomUtil.randomInt(18,30));
//            user.setSex(RandomUtil.randomString("男女",1));
//            user.setPhone(RandomUtil.randomNumbers(11));
//            user.setEmail(RandomUtil.randomString(10)+"@qq.com");
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
