# :memo: 每日算法DDU - java版

> :pushpin:  **DDU(day day up)仓库简介：**
> * 项目引入了 Hutool 以顺带练习这个热门工具库
> * 存放每日练习的算法题目和解题思路
> * 存放练习过程中遇到的知识点
> * 存放练习Java和使用idea过程中使用到的技巧
> PS: *该仓库为测试全不覆盖仓库~即不考虑异常情况*
>
> 当前练习的 **《剑指offer》** 题目仓库：[gatieme/CodingInterviews](https://github.com/gatieme/CodingInterviews)

## 小知识点补充  :page_facing_up:

####  容器类知识点

* `Arrays.asList()`转换得到的不是真正的数组仅可用于读，对数据进行改动会抛异常（因为为实现相关方法）
如果需要将其转化成ArrayList可以使用：

    1. `new ArrayList<>(Arrays.asList(chars));`
    2. `new ArrayList(List.of(chars));   `  JDK9以上支持的 List类 中的方法
* 应当在迭代器中操作容器数据，而不是在foreach中
* 通常使用我们会使用 [Deque类](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Deque.html) 来实现堆栈队列操作，即使用一个双端队列
* 利用String对象的不可变性来作为`HashMap<String,Object>`的很有好处（案例见*FisherYatesShuffle.java*）
  * 速度快：缓存机制
  * 线程安全：不可变
  * 所有对象都有`toString()`便于转化
  * ```java 
    //  int[] -> List 的方法
    		Arrays.stream(list).boxed().collect(Collectors.toList());
    //  转化ArrayList -> int[] 的方法
    		arrayList.stream().mapToInt(e -> e).toArray();
    ```
* boolean类型的数据在java中最终是以int保存的,对其进行位操作是被允许的。
* java优先队列 `PriorityQueue` 可以用来实现最小堆（最大堆），其中 `toArray()` 方法返回的是无序的！！
* lambda表达式中可以使用原子类操作来和外部代码块设值进行通信，体现了可见性和原子性，可见性由volatile提供，原子性由cas提供
* 关于构建数组的小技巧：在`javascript`中设置对象属性时通常会保留末尾的,以方便调换位置或者复制，在java的数组定义中我们也是可以保留,方便复制等操作的。

## 每日连击  :water_buffalo:

* 【03-03】001 - 005题 :heavy_plus_sign:
* 【03-15】006题 :heavy_plus_sign:
* 【03-16】007题 :heavy_plus_sign:
* 【~ - 03-18】008 - 011题 :heavy_plus_sign:
* 【03-19】012、014题 :heavy_plus_sign:
* 【03-20】015-016题 :heavy_plus_sign:
* 【03-21】017、018、019题 :heavy_plus_sign:
* 【03-22】020、021、022题 :heavy_plus_sign:
* 【03-23】023、024题 :heavy_plus_sign:
* 【03-24】025、026题 :heavy_plus_sign:
* 【03-25】027、028题 :heavy_plus_sign:
* 【03-26】029题 :heavy_plus_sign:
* 【03-27】030题 :heavy_plus_sign:
* 【03-28】031、032、033、034、035题 :heavy_plus_sign:
* 【03-29】036、037、038、039、040题 :heavy_plus_sign:
* 【03-30】041、042、044、045题 :heavy_plus_sign:
* 【03-31】046、047、049、051题 :heavy_plus_sign:
* 【04-01】052、053、054、055题 :heavy_plus_sign:
* 【04-02】056、057、058、059题 :heavy_plus_sign:

## idea*奇技淫巧* :green_heart:

> 当前项目下setting.zip为本机使用的idea设置备份
>
> IDEA版本为 MacOS-2020.1 开发版

* 推荐插件​ 
    * `CodeGlance` : 代码最右显示代码地图
    * `Rainbow Brackets` : 对称括号着色便于分辨
    * `FormatIncrementer` : 逐行递增数字 `control + shift + 1`
* 一直被我忽略的代码补全方式 `Postfix Completion` 即 `a.nn` => `if (a != null) {}` (`a.notnull`同理）
* 自带Postman -> REST Client
* **快捷键学习**
  * [Alt + Enter 介绍](https://github.com/judasn/IntelliJ-IDEA-Tutorial/blob/master/hotkey-alt-enter-introduce.md)
  * todo 标记！ 

## 不熟练的知识点

* ==构建递归算法的思维能力很软！！�