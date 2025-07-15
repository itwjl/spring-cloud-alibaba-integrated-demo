# 配置中心 + 注册中心
- nacos客户端版本：3.0.2
- 线上nacos管理路径: http://123.56.133.1:8080/index.html nacos/nacos

## nacos部署文档

```bash 
docker run --name nacos-standalone-derby \
-e MODE=standalone \
-e NACOS_AUTH_TOKEN=MDFlNTE4ODctYjgxNC00YjM3LWJkZjMtNjZjZGI2ZjNmMjg4 \
-e NACOS_AUTH_IDENTITY_KEY=admin \
-e NACOS_AUTH_IDENTITY_VALUE=123456 \
-p 8080:8080 \
-p 8848:8848 \
-p 9848:9848 \
-d nacos/nacos-server:latest
```