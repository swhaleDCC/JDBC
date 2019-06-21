# JDBC
A Asset Management System Based on Java GUI and MySQL

基于Java GUI的资产管理系统的设计与实现

首先要下载MySQL数据库，下载的时候要记住用户名和密码。

Assets是一个工程文件，使用NetBeans可以直接打开整个工程运行。

在NetBeans的服务里面建立数据库连接，在工程的database.properties文件里面把用户名和密码改成你设置的数据库的用户名和密码。

需要把mysql-connector-java-8.0.13加到工程的库文件夹里面。

driver=com.mysql.cj.jdbc.Driver

url=jdbc:mysql://localhost:3306/assetsdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true

我用的MySQL是8.0的，driver和url如上所示，其中url中的“assetsdb”是在这个项目中使用的数据库的名字，可以根据实际情况修改。

先执行工程里面的creatDB.sql，建立表，再运行工程就可以了。

下载MySQL还需要插件，可能因为插件太大上传时间太长就没有上传。
