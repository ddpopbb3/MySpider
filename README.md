# MySpider
这周好迷，不知道该干什么，找了网上的例子做了个爬虫玩一下。

主要用到jsoup这个开源库，相关的api去官网查吧，主要是解析html的。

# 2017-8-17
更新了pom文件 
还有目录树（再次感谢九日同学）
```
├── pom.xml
├── README.md
└── src
   ├── it
   │   ├── settings.xml
   │   └── simple-it
   │       ├── pom.xml
   │       └── verify.groovy
   └── main
       └── java
           └── com
               └── spider
                   └── demo
                       └── lyp
                           ├── ExractService
                           │   ├── ExtractService.java
                           │   └── RecursionService.java
                           ├── LinkTypeData
                           │   └── LinkTypeData.java
                           ├── main
                           │   └── Main.java
                           ├── MyFirstSpider
                           │   ├── CSDNblogCrawler.java
                           │   ├── MyLowSpider2.java
                           │   └── MyLowSpider.java
                           ├── Rule
                           │   └── Rule.java
                           ├── RuleException
                           │   └── RuleException.java
                           ├── Thread
                           │   └── FileThread.java
                           └── Util
                               ├── DBUtil.java
                               ├── FileUtil.java
                               └── TextUtil.java
```

# 2017-8-21
更新了pom文件 
下一阶段任务：
	1.图形化界面
	2.增加关键字过滤
	3.数据入库去重
	4.支持指定下载路径
	5.支持java -jar 方式运行
