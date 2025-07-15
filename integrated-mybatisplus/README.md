MySQL8.0部署文档

1. 创建Docker容器
```bash
docker run --name mysql-3306 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456-e MYSQL_ROOT_HOST='%' -d mysql:latest --bind-address=0.0.0.0
docker exec -it mysql-3306 /bin/bash
mysql -uroot -p
```

2. 授权MySQL远程连接
```mysql
select host from mysql.user where user = 'root';
# 如果查询结果没有 ‘%’，则执行下面语句
grant all PRIVILEGES on *.* to root@'%' WITH GRANT OPTION;
```

3. 授权MySQL连接本地navicat
```mysql
grant all PRIVILEGES on *.* to root@'%' WITH GRANT OPTION;
ALTER user 'root'@'%' IDENTIFIED BY '123456' PASSWORD EXPIRE NEVER;
ALTER user 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
FLUSH PRIVILEGES;
```

参考：[Docker安装mysql8-超详细、每步都有截图](https://blog.csdn.net/a1150499208/article/details/131437199)
