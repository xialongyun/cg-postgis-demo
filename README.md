# 任务
一、创建springboot+mybatis/mybatis-plus项目     
数据库相关：
1. 使用PostgreSQL数据库从nyc.bak文件中恢复数据，生成第一个数据库（里面有市场数据表、人口数据表、建筑数据表。
   备份指令
恢复数据库前，需要添加postgis函数库，以支持空间数据和空间函数。
```
pg_dump -h localhost -U postgres databasename > C:\databasename.bak
```
- 恢复指令
```
psql -h localhost -U postgres -d databasename < C:\databasename.bak
```
2. 解析zip包中的json数据，分析并自建合适的PostgreSQL数据库结构，存入数据库。
-  通用数据库模板
```xml
<update id="createTable" parameterType="java.lang.String">
        CREATE TABLE ${tableName} (
            adcode integer PRIMARY KEY NOT NULL,
            index integer NOT NULL,
            name varchar(2048) NOT NULL,
            level varchar(2048) NOT NULL,
            children integer,
            parent integer,
            the_geom public.geometry
        )
</update>
```
数据库结构如下：
- 省级数据库(对台湾省特殊处理)
  - 市级数据库(对直辖市特殊处理)
    - 区级数据库

3. 将热度Excel用Navicat或者其他工具，导入到数据库中。

功能相关：
基于第一组数据：
1：输入地理范围geojson  ，能够查询该区域内有多少人口和市场
要求POST方法的HTTP接口，接口名和参数名自定义

url http://127.0.0.1:8800/market/queryMarketAndPopulation
postman测试集合：cg-test-01.postman_collection.json

基于第二组数据:
1：输入经纬度，能够查询该点在哪个省市区
要求GET方法的HTTP接口，接口名和参数名自定义
http://127.0.0.1:8800/region/queryPoint?x=116.366794&y=39.915309
http://127.0.0.1:8800/region/queryPoint?x=121.490343&y=31.222770
http://127.0.0.1:8800/region/queryPoint?x=120.4435&y=22.44120

2：输入省或者市名称，能够查询该辖区下所有下级行政区划名字列表
要求GET方法的HTTP接口，接口名和参数名自定义
http://127.0.0.1:8800/region/queryRegion/吉林省
http://127.0.0.1:8800/region/queryRegion/北京市

基于第三组数据：
输入左上经纬度、右下经纬度，返回由左上和右下点经纬度构成的地理范围内，所有的内容，并按照“热度公式”从高到低排序。
要求GET方法的HTTP接口，接口名和参数名自定义
http://127.0.0.1:8800/hot/queryHotData?l_x=116.366794&l_y=39.915309&r_x=117.366794&r_y=38.915309

备注：
热度基础值：（1+read_amount+comment_amount+share_amount+focus_amount）*hot_level
时间系数：3天以内内容 系数为10   3-7天内容为5   7天以上为1
热度公式：热度基础值*时间系数