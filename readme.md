# :memo: 每日算法DDU - java版

> :pushpin:  **DDU(day day up)仓库简介：**
> * 项目引入了 Hutool 以顺带练习这个热门工具库
> * 存放每日练习的算法题目和解题思路
> * 存放练习过程中遇到的知识点
> * 存放练习Java和使用idea过程中使用到的技巧
>
> 当前练习的**《剑指offer》**题目仓库：[gatieme/CodingInterviews](https://github.com/gatieme/CodingInterviews)

## 小知识点补充  :page_facing_up:

####  容器类知识点

* `Arrays.asList()`转换得到的不是真正的数组仅可用于读，对数据进行改动会抛异常（因为为实现相关方法）
如果需要将其转化成ArrayList可以使用：

    1. `new ArrayList<>(Arrays.asList(chars));`
    2. `new ArrayList(List.of(chars));   `  JDK9以上支持的 List类 中的方法

* 应当在迭代器中操作容器数据，而不是在foreach中

## 每日连击  :water_buffalo:

* 【03-03】1-5题 :heavy_plus_sign:
* 【03-15】6题 :heavy_plus_sign:



## idea*奇技淫巧* :green_heart:

> 当前项目下setting.zip为本机使用的idea设置备份
>
> IDEA版本为 MacOS-2020.1 开发版

* 推荐插件​ `CodeGlance`(代码最右显示代码地图) ​ `Rainbow Brackets`（对称括号着色便于分辨）
* 一直被我忽略的代码补全方式 `Postfix Completion` 即 `a.nn` => `if (a != null) {}` (`a.notnull`同理）
* 自带Postman -> REST Client
* **快捷键学习**
  * [Alt + Enter 介绍](https://github.com/judasn/IntelliJ-IDEA-Tutorial/blob/master/hotkey-alt-enter-introduce.md)
  * todo 标记！ 