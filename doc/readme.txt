准备环境
	windows7
	jdk8
	maven3.3
	cas-server-4.0.0-release
	cas-client-3.1.12-release
	apache-tomcat-7.0.65

资源
　	官网：http://jasig.github.io/cas/
　	Cas Server下载：http://developer.jasig.org/cas/
　	Cas Client下载：http://developer.jasig.org/cas-clients/
一、配置证书
1生成证书
现在d盘创建文件夹cas-keys
C:\Users\Administrator>keytool -genkey -alias cas-server -keyalg RSA -keystore d:/cas-keys/cas-server.crt
输入密钥库口令:123456
再次输入新口令:123456
您的名字与姓氏是什么?
  [Unknown]:  cas-server             //这里填写域名
您的组织单位名称是什么?
  [Unknown]:  bigdata
您的组织名称是什么?
  [Unknown]:  howso
您所在的城市或区域名称是什么?
  [Unknown]:  gulou
您所在的省/市/自治区名称是什么?
  [Unknown]:  nanjing
该单位的双字母国家/地区代码是什么?
  [Unknown]:  ZH
CN=localhost, OU=bigdata, O=howso, L=gulou, ST=nanjing, C=ZH是否正确?
  [否]:  y

输入 <localhost> 的密钥口令
        (如果和密钥库口令相同, 按回车):
2导出证书
keytool -export -file d:/cas-keys/cas-server -alias cas-server
-keystore d:/cas-keys/cas-server.crt
输入密钥库口令:

3导入证书
keytool -import -keystore "C:\Program Files\Java\jdk1.8.0_73\jre/lib/security/cacerts" -file d:/cas-keys/cas-server -alias cas-server

二、配置cas服务器
1、从http://developer.jasig.org/cas/上下载cas服务器端cas-server-4.0.0-release.zip，在modules目录下找到cas-server-webapp-4.0.0.war，将其复制到D:\dev\tomcat7-cas-test\webapps下，并将名称改为cas.war
2、修改%TOMCAT_HOME%\conf\server.xml文件，去掉此文件83到93行之间的注释，修改为：
<Connector SSLEnabled="true" clientAuth="false" keystoreFile="d:/cas-keys/cas-server.crt" <!—生成证书时的路径，证书名-->
keystorePass="123456" <!—证书密码-->
maxThreads="150" port="8443" protocol="org.apache.coyote.http11.Http11Protocol" scheme="https" secure="true" sslProtocol="TLS"/>
3、测试：https://localhost:8443/cas
如果跳到https://localhost:8443/cas/login页面，则过程正常。
用户名和密码
casuser
Mellon
https://localhost:8443/cas/logout退出登录
三、配置cas客户端
1. 从http://developer.jasig.org/cas-clients/上下载cas-client-3.1.12-release.zip，在modules目录下找到cas-client-core-3.1.12.jar、
commons-collections-3.2.jar、commons-logging-1.1.jar复制到项目D:\dev\tomcat7\lib下
（配置tomcat7的端口Tomcat admin port为8006，HTTP/1.1为8081，SSL为8444，AJP/1.3为8010）
2. 添加映射域名，在C:\Windows\System32\drivers\etc\hosts文件中添加
127.0.0.1 cas-server
3. 创建web项目cas-demo，并在项目的web.xml配置过滤器
内容见web.xml
4、访问http://localhost:8081/cas-client/index.html
自动跳转到https//cas-server:8443/cas/login
输入用户名和密码 casuser Mellon
