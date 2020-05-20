# JDBC
A Asset Management System Based on Java GUI and MySQL

Assets是一个工程文件，使用NetBeans8.0可以直接打开整个过程运行。

首先要下载MySQL8.0数据库，下载的时候要记住用户名和密码。

在NetBeans的服务里面建立数据库连接，在项目database.properties里面把用户名和密码改成你设置的数据库的用户名和密码

```
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/assetsdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true
```

我用的MySQL是8.0的，driver和url如上所示，其中url中的“assetsdb”是在这个项目中建立的数据库的名字，可以根据实际情况修改。

先执行工程里面的creatDB.sql，建立表，再运行过程就可以了。
