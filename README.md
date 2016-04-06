空格两个回车换行

克隆项目:  
	git bash: git clone https://github.com/zjls007/hub.git  
	eclipse: import -> projects from git -> 输入地址 -> 下一步。。。  
导入为Maven项目：  
    eclipse: import -> existing Maven Projects  
	导入后切换pom中的jdk版本为本地jdk版本:1.6,1.7,1.8  
	右键工程 -> Maven -> update project  
运行项目：  
    mvn tomcat7:run  
