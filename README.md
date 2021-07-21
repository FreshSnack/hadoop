## Hadoop
[Hadoop中文文档](http://hadoop.apache.org/docs/r1.0.4/cn/quickstart.html)

[Mac安装Hadoop](https://blog.csdn.net/vbirdbest/article/details/88189753)

[Unable to load native](https://blog.csdn.net/l1028386804/article/details/51538611)
```
log4j.logger.org.apache.hadoop.util.NativeCodeLoader=ERROR
```
[No such file or directory](https://blog.csdn.net/hoodzwh/article/details/82430606)

[hadoop fs -ls / ConnectionRefused](https://coding.imooc.com/learn/questiondetail/73485.html)
```
hadoop fs -mkdir -p /user/[current login user]
```
```shell
# MD5函数使用，可以基于此实现文件MD5校验
$ md5 README.md build.gradle 
MD5 (README.md) = bd53cf92202bca18990c215879352c69
MD5 (build.gradle) = 5a4c1f00d50d875e2be207ed4944a7e7
```

```shell
# 获取帮助信息
hadoop fs -help mkdir
```
```java
// 异常：unknown protocol: hdfs
// step 1 添加hdfs协议
static { URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory()); }
// step 2 添加依赖 Hadoop client
implementation group: 'org.apache.hadoop', name: 'hadoop-client', version: '3.3.0'
```
## HBase
[下载地址](http://archive.apache.org/dist/hbase/)

https://bbs.csdn.net/topics/397511816

hbase2.3.X要搭配hadoop3.2.X才行，用hadoop3.3.X不匹配


#安装hadoop
```shell
# namenode初始化 
hdfs namenode -format
```

```xml
<!--hdfs-site.xml配置-->
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
</configuration>
```

```xml
<!--core-site.xml配置-->
<configuration>
    <property>
        <name>hadoop.tmp.dir</name>
        <value>/usr/local/Cellar/hadoop/hdfs/tmp</value>
        <description>A base for other temporary directories.</description>
    </property>
    <property>
        <name>fs.default.name</name>
        <value>hdfs://localhost:9000</value>
    </property>
</configuration>
```

```
namenode和datanode路径
/tmp/hadoop-dingmingxuan/dfs
```
```shell
# 启动
start-all.sh
# 关闭
stop-all.sh
# 查看
jps
```

```xml
<!--hbase-site.xml配置-->
<configuration>
  <property>
      <name>hbase.rootdir</name>
      <value>hdfs://master:9000/hbase</value>
  </property>
  <property>
    <name>hbase.cluster.distributed</name>
    <value>false</value>
  </property>
  <property>
    <name>hbase.tmp.dir</name>
    <value>./tmp</value>
  </property>
  <property>
    <name>hbase.unsafe.stream.capability.enforce</name>
    <value>false</value>
  </property>
</configuration>
```

```shell
# hbase控制台地址
http://localhost:16010/master-status
```