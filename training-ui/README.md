## 开发

```bash
# 克隆项目
git clone 

# 进入项目目录


# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm run dev
```

浏览器访问 http://localhost:80

## 发布

```bash
# 构建测试环境
npm run build:stage

# 构建生产环境
npm run build:prod

```
## 部署系统

#后端部署
1.maven 打包项目成jar包
2.使用命令 Java -jar xxx.jar 运行

#前端部署
1.通过发布命令 npm run build:prod 生成dist文件夹，包含静态文件，其中index.html是服务入口
2.Nginx 代理配置

```
worker_processes  1;

events {
    worker_connections  1024;
}

http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
    keepalive_timeout  65;

    server {
        listen       80;
        server_name  localhost;

		location / {
            root   home/xxx/xxx/dist;  #静态文件目录
			try_files $uri $uri/ /index.html;
            index  index.html index.htm;
        }
		
        #接口入口
		location /prod-api/{
			proxy_set_header Host $http_host;
			proxy_set_header X-Real-IP $remote_addr;
			proxy_set_header REMOTE-HOST $remote_addr;
			proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
			proxy_pass http://localhost:8080/;  #后台访问
		}

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
}
```