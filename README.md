# 崔尼蒂图书馆管理系统

## 项目简介
基于Java Swing开发的图书馆管理系统，包含用户注册/登录、图书管理、借阅管理、密码找回等功能模块，采用MySQL数据库存储数据，通过Resend邮件服务实现验证码发送功能。

## 技术栈
- Java 17
- Swing GUI框架
- MySQL 8.0+
- Resend邮件服务
- JDBC数据库连接

## 环境依赖
1. JDK 17+ 环境
2. MySQL数据库（需创建`db_library_app`数据库）
3. Resend邮件服务API密钥
4. `ApiKeys.json`配置文件格式：
   ```json
   {
     "SendEmailApiKey": "your_resend_api_key"
   }