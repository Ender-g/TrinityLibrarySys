# 崔尼蒂图书馆管理系统

## 一、项目简介

> 基于Java Swing开发的图书馆管理系统，包含用户注册/登录、图书管理、借阅管理、密码找回等功能模块，采用MySQL数据库存储数据，通过Resend邮件服务实现验证码发送功能。

## 二、技术栈

- **核心语言**：Java 18
- **前端界面**：Swing GUI框架
- **数据库**：MySQL 8.0+（支持软删除机制）
- **网络通信**：Resend邮件服务API
- **数据加密**：SHA-256密码加密
- **依赖管理**：Maven
- **第三方库**：
  - [Resend Java SDK](https://www.resend.com/docs)（邮件发送）
  - Gson（JSON解析）
  - MySQL JDBC驱动（数据库连接）

## 三、功能模块

### 用户端

- 注册/登录（含邮箱验证码）
- 密码找回（邮件验证）
- 密码更改（邮件验证）
- 账户注销（邮件验证）
- 借阅记录查询（仅当前用户）
- 图书借阅/归还

### 管理员端

- 用户管理（权限分配/删除）
- 图书库存管理（增删改）
- 已删除图书回收站
- 实时数据可视化

## 四、克隆指南

### 环境准备

1. 安装 [JDK 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
2. 安装 [MySQL 8.0+](https://dev.mysql.com/downloads/mysql/)
3. 搭建个人域名邮箱路由服务
4. 注册 [Resend开发者账户](https://resend.com/) 获取API密钥
5. 配置数据库连接（如有需要）

### 初始化流程

1. 创建数据库：```CREATE DATABASE db_library_app;```
2. 执行SQL脚本创建表结构（详见`src/main/java/sql`）
3. 配置邮件API密钥：(`src/main/java/top/playereg/ApiKeys.json`)

```json
{
  "SendEmailApiKey": "your_resend_api_key"
}
```

4. 配置数据库连接（如有需要）：

```java
// DbUtils.java
String url = "jdbc:mysql://127.0.0.1:3306/db_library_app?useSSL=false&serverTimezone=Asia/Shanghai";
String username = "root"; // 修改为你的MySQL用户名
String password = "123456"; // 修改为你的MySQL密码
```

## 五、开发者指南

### 数据库设计

#### 用户表(tb_user)

| 字段名            | 类型           | 描述          |
| -------------- | ------------ | ----------- |
| id             | INT          | 主键          |
| username       | VARCHAR(255) | 用户名         |
| password       | VARCHAR(64)  | SHA-256加密密码 |
| email          | VARCHAR(255) | 邮箱          |
| is_root        | TINYINT      | 权限等级(0/1)   |
| is_del         | TINYINT      | 软删除标记(0/1)  |
| bookBorrowID   | BIGINT       | 当前借阅书籍ID    |
| bookBorrowTime | BIGINT       | 借阅时间戳       |

#### 图书表(tb_books)

| 字段名        | 类型           | 描述         |
| ---------- | ------------ | ---------- |
| id         | INT          | 主键         |
| bookName   | VARCHAR(255) | 书名         |
| bookNumber | INT          | 库存数量       |
| is_del     | TINYINT      | 软删除标记(0/1) |

### 接口规范

邮件服务采用[Resend API v1](https://resend.com/docs/api-reference/emails/send-email)标准，请求示例：

```java
import com.resend.*;

public class Main {
    public static void main(String[] args) {
        Resend resend = new Resend("re_xxxxxxxxx");

        SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                .from("Acme <onboarding@resend.dev>")
                .to("delivered@resend.dev")
                .subject("hello world")
                .html("<p>it works!</p>")
                .build();

        SendEmailResponse data = resend.emails().send(sendEmailRequest);
    }
}
```

## 六、使用教程

1. 注册新账户
2. 邮箱验证激活
3. 普通用户登录后可进行：
   - 图书查询
   - 借阅操作
   - 查看借阅记录（仅当前用户）
4. 管理员登录后可进行：
   - 用户管理
   - 图书库存管理
   - 查看删除记录

## 七、常见问题

> ### Q: 启动报错`ClassNotFoundException`
> 
> ### A:
> 
> 1. 检查[pom.xml](file://D:\IdeaProjects\LibrarySys\pom.xml)依赖是否完整
> 2. 执行`mvn dependency:resolve`

> ### Q: 邮件验证码无法发送
> 
> ### A:
> 
> 1. 检查[ApiKeys.json](file://D:\IdeaProjects\LibrarySys\src\main\java\top\playereg\ApiKeys.json)配置
> 2. 确认Resend账户配额状态
> 3. 检查网络连接（参考[PingNetTool.java](file://D:\IdeaProjects\LibrarySys\src\main\java\top\playereg\sys\utils\PingNetTool.java)）

> ### Q: 登录提示"数据库操作失败"
> 
> ### A:
> 
> 1. 验证MySQL服务是否启动
> 2. 检查[DbUtils.java](file://D:\IdeaProjects\LibrarySys\src\main\java\top\playereg\sys\utils\DbUtils.java)连接参数
> 3. 确认数据库表结构是否完整

## 八、安全设计

- 密码存储：SHA-256哈希加密（[HashTool.java](file://D:\IdeaProjects\LibrarySys\src\main\java\top\playereg\sys\utils\HashTool.java)）
- 邮箱验证：5分钟时效验证码（[SendEmailTool.java](file://D:\IdeaProjects\LibrarySys\src\main\java\top\playereg\sys\utils\SendEmailTool.java)）
- 数据隔离：软删除机制（is_del字段）

## 九、版本历史

### v1.0.0 (2025-05-31)

- 实现基础CRUD功能
- 完成用户/管理员双角色系统
- 集成邮件验证系统

## 十、许可证

本项目遵循[GNU General Public License v3.0](LICENSE)，允许在遵守协议的前提下自由使用和修改。

---

## 🌐 关于我 🌐

### ♠️ 邮箱1：<playereg@vip.playereg.top>

### ♣️ 邮箱2：<playereg@email.playereg.top>

### ♥️ GitHub主页：[@Ender-g](https://github.com/ender-g)

### ♦️ B站主页：[@PlayerEG](https://space.bilibili.com/520500365)