# 崔尼蒂图书馆管理系统

## 项目简介
基于Java Swing开发的图书馆管理系统，包含用户注册/登录、图书管理、借阅管理、密码找回等功能模块，采用MySQL数据库存储数据，通过Resend邮件服务实现验证码发送功能。

## 功能模块
- **用户系统**
  - 邮箱注册/验证码验证
  - 登录认证与会话保持
  - 密码重置流程
- **管理界面**
  - 用户管理
  - 图书管理
  - 借阅记录管理
  - 统计分析
- **邮件服务**
  - 验证码自动发送
  - HTML邮件模板渲染

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