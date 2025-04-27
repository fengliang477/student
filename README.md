# 学生管理系统项目文档

## 一、项目概述
本学生管理系统是一个基于Web的应用程序，用于管理学生、教师、课程以及成绩等信息。系统提供了登录、信息查询、添加、编辑和删除等基本功能，方便学校管理人员进行日常信息管理。

## 二、功能模块

### 1. 登录模块
- 提供用户名和密码输入框，用户输入信息后点击登录按钮进行验证。
- 代码文件：`student/src/main/webapp/login.html` 和 `student/src/main/webapp/js/login.js`

### 2. 首页模块
- 显示欢迎信息和一些统计数据，如学生总数、教师总数、课程数量等。
- 提供导航菜单，方便用户切换到不同的管理页面。
- 代码文件：`student/src/main/webapp/index.html`

### 3. 学生管理模块
- 可以搜索学生信息，添加新学生，编辑和删除学生信息。
- 代码文件：`student/src/main/webapp/student.html` 和 `student/src/main/webapp/student-add.html`

### 4. 教师管理模块
- 实现教师信息的搜索、添加、编辑和删除功能。
- 代码文件：`student/src/main/webapp/teacher.html` 和 `student/src/main/webapp/teacher-add.html`

### 5. 课程管理模块
- 对课程信息进行管理，包括搜索、添加、编辑和删除课程。
- 代码文件：`student/src/main/webapp/course.html` 和 `student/src/main/webapp/course-add.html`

### 6. 成绩管理模块
- 管理学生的成绩信息，可搜索、添加、编辑和删除成绩记录。
- 代码文件：`student/src/main/webapp/sc.html` 和 `student/src/main/webapp/sc-add.html`

## 三、代码结构

### 1. Java代码
- **实体类**：位于 `student/src/main/java/cn/fengliangit/servlet` 目录下，包括 `teacheruser.java`、`courcea.java` 和 `sca.java`，用于定义教师、课程和成绩的实体类。
```java
// teacheruser.java
@Data
public class teacheruser{
    private Long id;
    private String name;
    private String sex;
    private Integer age;
    private String phone;
    private String email;
}
```

### 2. HTML页面
- 位于 `student/src/main/webapp` 目录下，包含各个功能模块的页面文件，如 `index.html`、`student.html`、`teacher.html` 等。

### 3. CSS样式
- 位于 `student/src/main/webapp/css` 目录下，`index.css` 用于整体页面布局和样式设置，`add.css` 用于添加信息页面的样式。
```css
/* index.css 部分代码 */
.search{
    margin-top: 10px;
    margin-bottom: 10px;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: right;
}
```

### 4. JavaScript代码
- 位于 `student/src/main/webapp/js` 目录下，`getuser.js` 用于获取用户信息并渲染到页面上，`login.js` 用于处理登录逻辑。
```javascript
// getuser.js 部分代码
function getsUserData() {
    fetch('/list-student-users', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => response.json())
      .then(data => {
            console.log(data);
            data.forEach(user => {
                // 渲染用户数据到页面
            });
        });
}
```

## 四、依赖信息
项目使用Maven进行依赖管理，相关依赖信息在 `student/pom.xml` 文件中定义。

### 1. Lombok
用于简化Java实体类的开发，自动生成getter、setter等方法。
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.26</version>
    <scope>provided</scope>
</dependency>
```

### 2. Servlet API
提供Servlet开发所需的API。
```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

### 3. Hutool
一个Java工具包，提供了丰富的工具类和方法。
```xml
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.8.35</version>
</dependency>
```

## 五、部署信息
项目使用Tomcat 7作为服务器，通过 `tomcat7-maven-plugin` 进行部署。
```xml
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <port>8080</port>
        <uriEncoding>UTF-8</uriEncoding>
        <path>/</path>
    </configuration>
</plugin>
```
