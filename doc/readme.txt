׼������
	windows7
	jdk8
	maven3.3
	cas-server-4.0.0-release
	cas-client-3.1.12-release
	apache-tomcat-7.0.65

��Դ
��	������http://jasig.github.io/cas/
��	Cas Server���أ�http://developer.jasig.org/cas/
��	Cas Client���أ�http://developer.jasig.org/cas-clients/
һ������֤��
1����֤��
����d�̴����ļ���cas-keys
C:\Users\Administrator>keytool -genkey -alias cas-server -keyalg RSA -keystore d:/cas-keys/cas-server.crt
������Կ�����:123456
�ٴ������¿���:123456
����������������ʲô?
  [Unknown]:  cas-server             //������д����
������֯��λ������ʲô?
  [Unknown]:  bigdata
������֯������ʲô?
  [Unknown]:  howso
�����ڵĳ��л�����������ʲô?
  [Unknown]:  gulou
�����ڵ�ʡ/��/������������ʲô?
  [Unknown]:  nanjing
�õ�λ��˫��ĸ����/����������ʲô?
  [Unknown]:  ZH
CN=localhost, OU=bigdata, O=howso, L=gulou, ST=nanjing, C=ZH�Ƿ���ȷ?
  [��]:  y

���� <localhost> ����Կ����
        (�������Կ�������ͬ, ���س�):
2����֤��
keytool -export -file d:/cas-keys/cas-server -alias cas-server
-keystore d:/cas-keys/cas-server.crt
������Կ�����:

3����֤��
keytool -import -keystore "C:\Program Files\Java\jdk1.8.0_73\jre/lib/security/cacerts" -file d:/cas-keys/cas-server -alias cas-server

��������cas������
1����http://developer.jasig.org/cas/������cas��������cas-server-4.0.0-release.zip����modulesĿ¼���ҵ�cas-server-webapp-4.0.0.war�����临�Ƶ�D:\dev\tomcat7-cas-test\webapps�£��������Ƹ�Ϊcas.war
2���޸�%TOMCAT_HOME%\conf\server.xml�ļ���ȥ�����ļ�83��93��֮���ע�ͣ��޸�Ϊ��
<Connector SSLEnabled="true" clientAuth="false" keystoreFile="d:/cas-keys/cas-server.crt" <!������֤��ʱ��·����֤����-->
keystorePass="123456" <!��֤������-->
maxThreads="150" port="8443" protocol="org.apache.coyote.http11.Http11Protocol" scheme="https" secure="true" sslProtocol="TLS"/>
3�����ԣ�https://localhost:8443/cas
�������https://localhost:8443/cas/loginҳ�棬�����������
�û���������
casuser
Mellon
https://localhost:8443/cas/logout�˳���¼
��������cas�ͻ���
1. ��http://developer.jasig.org/cas-clients/������cas-client-3.1.12-release.zip����modulesĿ¼���ҵ�cas-client-core-3.1.12.jar��
commons-collections-3.2.jar��commons-logging-1.1.jar���Ƶ���ĿD:\dev\tomcat7\lib��
������tomcat7�Ķ˿�Tomcat admin portΪ8006��HTTP/1.1Ϊ8081��SSLΪ8444��AJP/1.3Ϊ8010��
2. ���ӳ����������C:\Windows\System32\drivers\etc\hosts�ļ������
127.0.0.1 cas-server
3. ����web��Ŀcas-demo��������Ŀ��web.xml���ù�����
���ݼ�web.xml
4������http://localhost:8081/cas-client/index.html
�Զ���ת��https//cas-server:8443/cas/login
�����û��������� casuser Mellon
