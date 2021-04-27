# 微信小程序开发规范文档

## 目录规范

#### 组件文件

所有组件相关文件统一放在components目录下。

![img](https://uploader.shimo.im/f/tf0F66FZ4403JbrS.png!thumbnail?accessToken=eyJhbGciOiJIUzI1NiIsImtpZCI6ImRlZmF1bHQiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE2MTk0ODg1NTcsImciOiJlSldnNTZpb1N2VTBkbllPIiwiaWF0IjoxNjE5NDg2NzU3LCJ1IjowfQ.ToAoqzZwCz6A-83JvVJnu5JNhISNmC8Noo4OsrONqXQ)

#### 图片文件

项目图片文件放置于根目录的images文件夹下，组件独有的图片放在当前组件images目录下

![img](https://uploader.shimo.im/f/N9w0O5KxassNub8s.png!thumbnail?accessToken=eyJhbGciOiJIUzI1NiIsImtpZCI6ImRlZmF1bHQiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE2MTk0ODg1NTcsImciOiJlSldnNTZpb1N2VTBkbllPIiwiaWF0IjoxNjE5NDg2NzU3LCJ1IjowfQ.ToAoqzZwCz6A-83JvVJnu5JNhISNmC8Noo4OsrONqXQ)

#### 模型文件

模型文件主要用于编写各类业务模型。项目模型文件放置于根目录的models文件夹下，组件相关模型放置于components目录下的models文件夹中。

![img](https://uploader.shimo.im/f/REv0pJdPckgg492K.png!thumbnail?accessToken=eyJhbGciOiJIUzI1NiIsImtpZCI6ImRlZmF1bHQiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE2MTk0ODg1NTcsImciOiJlSldnNTZpb1N2VTBkbllPIiwiaWF0IjoxNjE5NDg2NzU3LCJ1IjowfQ.ToAoqzZwCz6A-83JvVJnu5JNhISNmC8Noo4OsrONqXQ)

#### 行为文件

行为文件放在所引用的组件目录下。

![img](https://uploader.shimo.im/f/oeHMXmuA0U0esIAx.png!thumbnail?accessToken=eyJhbGciOiJIUzI1NiIsImtpZCI6ImRlZmF1bHQiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE2MTk0ODg1NTcsImciOiJlSldnNTZpb1N2VTBkbllPIiwiaWF0IjoxNjE5NDg2NzU3LCJ1IjowfQ.ToAoqzZwCz6A-83JvVJnu5JNhISNmC8Noo4OsrONqXQ)

# WXML规范

#### 标签

小程序视图层开发基于小程序框架为开发者提供的一系列基础组件，这些基础组件通常以双标签或单标签的形式使用。

- 双标签包括起始标签`<标签>`，结止标签和`属性`，`内容`在这两个标签之内

- 单标签只有一个`<标签/>`，有`属性`，没有`内容`

- wxml标签可以单独出现的情况，尽量单独出现，如<input />。

  > <input />

小程序规定，标签名有多个词时，词之间以连接符`-`连接。

```
<tag-name property="value">
  内容放这里...
</tag-name>

<tag-name property="value"/>
```

编码时要遵循标签的语义，要尽量使用最少的标签并保持最小的复杂度。

#### 代码大小写

所有标签和属性，大部分属性值统一使用小写

- 推荐写法

  ```
  <view class="demo">
      ...
  </view>
  ```

- 不推荐写法

  ```
  <view class="DEMO">
      ...
  </view>
  
  <VIEW CLASS="DEMO">
      ...
  </VIEW>
  ```

#### 标签的闭合

在小程序里，有些组件必须写成双标签，如视图容器类组件`view`；有些组件可以写成单标签，如媒体类组件`image`；但在小程序运行时，它们都会解析成双标签。

在小程序里，所有的标签一旦使用都必须被闭合，使用标签不闭合会报错，导致程序无法运行。

- 正确写法

  ```
  <view>
    <image src="src"></image>
    <image src="src"/>
    <text>我是一段文字，我有始有</text>
  </view>
  ```

- 错误写法

  ```
  <view>
    <image src="src">
    <text>我是一段文字，我有始有
  </view>
  ```

##### 团队约定

所有具有开始标签和结束标签的元素都要写上起止标签，某些可以省略结束标签的亦都要写上

- 推荐写法

  ```
  <view>
    <image src="src"></image>
    <input value="test"></input>
    <text>我是一段文字，我有始有</text>
  </view>
  ```

- 不推荐写法

  ```
  <view>
    <image src="src"/>
    <input value="test"/>
  </view>
  ```

#### 标签属性

##### 团队约定

- 标签属性值使用双引号语法

- 属性值可能写上的都写上

  - 推荐写法

    ```
    <button type="default"  disabled="{{true}}"> 按钮 </button>
    ```

  - 不推荐写法

    ```
    <button type='default'  disabled='{{true}}'> 按钮 </button>
    <button type="default"  disabled> 按钮 </button>
    ```

  - 错误写法

    ```
    <button type=default disabled=true> 按钮 </button>
    ```

- 谨慎使用id属性

  id属性具有唯一性，可以用来标识具体组件，应避免在样式上使用id属性（选择器）

- 属性书写顺序

  标签属性应按照以下顺序依次排列，以确保代码的可读性

  ```
  /*
      id,
      class,
      wx:for wx:item wx:key,
      wx:if,
      src,
      事件绑定类属性，如bind:tap,
      value,
      dataSet,(*需完善)
      组件自带的其它属性,
  */
  ```

#### 特殊字符

正常情况下的小程序里，文本和字符实体不能混合出现。

- 如需使用字符实体，需使用

  ```
  text
  ```

  组件并设置

  ```
  decode
  ```

  属性，并且decode目前仅可解析
  ```
  &nbsp;
  ```
  ```
  &lt;
  ```

  ```
&gt;
  ```
  
  ```
&amp;
  ```

  ```
  &apos;
  ```

  ```
&ensp;
  ```
  
  ```
&emsp;
  ```

  ，参考text文档
  
  - 正确用法

    ```
  <text decode>&lt; &nbsp; &gt;</text>
    ```
  
  - 错误用法

    ```
  <text>&lt; &nbsp; &gt;</text>
    <view decode>&lt; &nbsp; &gt;</view>
    ```
  
- 特殊符号使用输入法输入即可

- 连续空格的使用

  - 需使用`text`组件并设置`space`属性

  - 无`space`属性的`text`内多个连续空格最终只显示一个

  - 非`text`组件设置`space`属性不会有连续空格的效果

    - 正确写法

      ```
      <text space="ensp">1 1  1    1</text>
      // 输出：1 1  1    1
      ```

    - 无效写法

      ```
      <text>1 1  1    1</text>
      // 输出：1 1 1 1
      ```

#### 代码缩进

统一使用2个空格字符进行代码缩进

- 推荐写法

  ```
  <view>
    <text>2个空格字符缩进</text>
    <view>
      ...
    </text>
  <view/>
  ```

- 不推荐写法

  ```
  <view>
      <text>4个空格字符缩进</text>
      <view>
          ...
      </view>
  <view/>
  ```

在微信开发者工具-设置-编辑设置，勾选`用空格代码Tab`，`Tab`大小设置为2，使用格式化代码可以自动缩进对齐。

#### 每行最多字符数

120个字符

控制每行HTML的代码数量在50个字符以内，方便阅读浏览，多余的代码进行换行处理，标签所带属性每个属性间进行换行。

```
<c-music
  wx:if="{{classic.type===200}}"
  img="{{classic.img}}"
  content="{{classic.content}}"
\>
</c-music>
```

#### 代码嵌套

编写wxml代码时，需要保证页面结构稳固，同时需要避免多余的父元素，减少嵌套。

- 推荐写法

  ```
  <view class="user_info">
    <image class="avatar" src="src"></image>
    <text class="nickname">小明</text>
  </view>  
  ```

- 不推荐写法

  ```
  <view class="user_info">
    <view class="avatar">
      <image src="src"></image>
    </view>
    <view class="nickname">
      <text>小明</text>
    </view>
  </view>
  ```

块级标签的起止标签各占一行，行内标签的起止标签一般写在一行内，如果标签内容过多，起止标签则各占一行。

- 推荐写法

  ```
  <view class="user_info">
    <image src="src"></image>
    <text>小明</text>
    <text>
       原有奖励模式已改为积分奖励，针对部分未兑换礼品的用户，已为您补发积分奖励，如有疑问请联系微信客服：yiniankefu
    </text>
  </view>
  ```

- 不推荐写法

  ```
  <view class="user_info"><image src="src"></image><text>小明</text></view>
  ```

#### 样式

合理展现分离内容，不要使用内联样式。

- 推荐使用
```
<image class="tag"></image>
```

#### 注释

除组件外的其他块级元素，均需注释出其功能。

> 代码是由人编写并维护的，我们要尽可能保证写的代码能够自描述、注释良好并且易于他人理解。好的注释能够传达上下文关系和代码目的。

注释代码以`开头，以`-->`结尾。

- 标准写法

  ```
  <!-- 动态列表 -->
  ```

- 错误写法

  ```
  <!--> 动态列表 -->
  <!---> 动态列表 <-->
  ```

###### 团队约定

##### 单行注释

一般用于简单的描述，如状态描述，属性描述等。书写时应遵循以下规范：

- 注释内容前后各一个空格字符
- 注释位于注释代码上面
- 单独占一行

示例

- 推荐写法：

  ```
  <!-- 积分信息 -->
  <view> ... </view>
  ```

- 不推荐写法：

  ```
  <!--积分信息-->
  <view> ... </view>
  
  <!--积--分--信息-->
  <view> ... </view>
  
  <!-- 积分信息 --->
  <view> ... </view>
  
  <view> ... </view> <!-- 积分信息 -->
  
  <view>  <!-- 积分信息 -->
      ... 
  </view>
  ```

##### 代码块注释

一般用于描述某一块代码的名称或开始，结束位置。书写时应该遵循以下规范

- 注释内容前后各一个空格字符
- `` 表示代码块开始，`` 表示代码块结束
- 代码块与代码块之间相隔一行

示例

- 推荐写法：

  ```
  <!-- 动态详情 开始 -->
  <view class="event_list"> 
      ...
  </view>
  <!-- 动态详情 结束 -->
  
  <!-- 评论列表 开始 -->
  <view class="comment_list"> 
      ...
  </view>
  <!-- 评论列表 结束 -->
  ```

- 不推荐写法：

  ```
  <!-- 动态详情 开始 -->
  <view class="event_list"> 
      ...
  </view>
  <!-- 动态详情 结束 -->
  <!-- 评论列表 开始 -->
  <view class="comment_list"> 
      ...
  </view>
  <!-- 评论列表 结束 -->
  ```

# WXSS规范

#### 展开格式

样式代码书写一般有两种形式，一种是紧缩格式

```
.home{padding-top:44rpx;border:1rpx solid #fff;}
```

一种是展开格式

```
.home {
  padding-top: 44rpx;
  border: 1rpx solid #fff;
}
```

##### 团队约定

统一使用展开格式，这跟微信开者工具自动格式化也是一致的。

#### 缩进

CSS代码需有明显的代码缩进。每一个样式类之间空出一行。

统一使用2个空格代替`Tab`进行代码缩进。

```
.c-tag{
  width: 100%;
}
```

#### 分号

每个属性声明末尾都要加上分号`;`

- 推荐写法

  ```
  .avatar {
    width: 200rpx;
    height: 200rpx;
  }
  ```

- 不推荐写法

  ```
  .avatar {
    width: 200rpx;
    height: 200rpx
  }
  ```

#### 空格

选择器与左大括号`{`中间一个空格字符

- 推荐写法

  ```
  .name {
    color: red;
  }
  ```

- 不推荐写法

  ```
  .name{
    color: red;
  }
  ```

属性冒号与属性值之间一个空格字符

- 推荐写法

  ```
  .name {
    color: red;
  }
  ```

- 不推荐写法

  ```
  .name {
    color:red;
  }
  ```

逗号分割的属性值，逗号后面一个空格字符

- 推荐写法

  ```
  .name {
    color: rgba(125, 125, 125, 1);
    box-shadow: 1px 1px 1px #333, 2px 2px 2px #ccc;
  }
  ```

- 不推荐写法

  ```
  .name {
    color: rgba(125,125,125,1);
    box-shadow: 1px 1px 1px #333,2px 2px 2px #ccc;
  }
  ```

#### 属性值0

避免为属性值0指明单位

- 推荐写法

  ```
  .box {
    margin: 0 22rpx;
  }
  ```

- 不推荐写法

  ```
  .box {
    margin: 0rpx 22rpx;
  }
  ```

#### 十六进制

属性值为十六进制时，尽量使用简写

- 推荐写法

  ```
  .name {
    color: #fff;
  }
  ```

- 不推荐写法

  ```
  .name {
    color: #ffffff;
  }
  ```

#### 大小写

选择器，属性名，属性值统一使用小写

- 推荐写法

  ```
  .setting {
    display: flex
  }
  ```

- 不推荐写法

  ```
  .SETTING {
    DISPLAY: FLEX
  }
  .setting {
    DISPLAY: flex
  }
  ```

#### 使用双引号

统一使用双引号`""`

- 推荐写法

  ```
  @import "common.wxss";
  
  .setting {
    content: " ";
  }
  ```

- 不推荐写法

  ```
  @import 'common.wxss';
  
  .setting {
    content: ' ';
  }
  ```

#### 选择器

不使用id选择器

- 推荐写法

  ```
  .overview {
    color: blue;
  }
  ```

- 不推荐写法

  ```
  #overview {
    color: blue;
  }
  ```

不使用无具体语义的标签选择器

- 推荐写法

  ```
  .nickname text {
    color: red;
  }
  ```

- 不推荐写法

  ```
  view text{
    color: red;
  }
  ```

#### 简写的属性

尽量使用简写属性，并且同一属性放置在一起，避免散乱。

使用简写属性
```
.c-image {
  margin: 0 auto;
}
```
#### 属性书写顺序

由于布局定位属性可以从正常文档流中移除元素，并且能覆盖盒模型的相关样式，所以放在首位。盒模型决定了盒子的尺寸，大小，排在第二位。建议遵循以下顺序：

1. 布局定位属性：display / position / float / clear / visibility / overflow
2. 自身属性（盒模型）：width / height / margin / padding / border / background
3. 文本属性：color / font / text-decoration / text-align / vertical-align / white- space / break-word
4. 其他属性（CSS3）：content / cursor / border-radius / box-shadow / text-shadow / background:linear-gradient …

示例

```
/*按顺序排列属性*/
.box {
    display: block;
    position: relative;
    float: left;
    width: 100rpx;
    height: 100rpx;
    margin: 0 10rpx;
    padding: 20rpx 0;
    font-size: 36rpx;
    color: #333;
    background: rgba(0, 0, 0, .5);
    border-radius: 10px;
}
```

```
/*同一属性放在一块*/
.c-tag{
  margin-left: 10rpx;
  margin-right: 10rpx
}
```

#### 避免重申选择器

同一选择器的样式只应出现一次，反复重申选择器样式，会造成样式代码混乱，难以维护

- 推荐写法

  ```
  .name {
    color: #fff;
    font-size: 22rpx;
  }
  ```

- 不推荐写法

  ```
  .name {
    color: #eee;
  }
  
  .name {
    color: #fff;
    font-size: 22rpx;
  }
  ```

#### 样式块间隔

样式块与样式块相隔一行

- 推荐写法

  ```
  ...
  
  .avatar {
    width: 200rpx;
    height: 200rpx;
  }
  
  .name {
    color: #fff;
  }
  
  ...
  ```

- 不推荐写法

  ```
  ...
  .avatar {
    width: 200rpx;
    height: 200rpx;
  }
  .name {
    color: #fff;
  }
  ...
  ```

#### 模块间隔

模块与模块间相隔两行

- 推荐写法

  ```
  /* 模块A
  -------------------------------------------------- */
  .modules_a {}
  
  
  /* 模块B
  -------------------------------------------------- */
  .modules_b {}
  ```

- 不推荐写法

  ```
  /* 模块A
  -------------------------------------------------- */
  .modules_a {}
  /* 模块B
  -------------------------------------------------- */
  .modules_b {}
  ```

#### 尺寸单位

统一使用rpx
```
width: 100rpx;
font-size: 14rpx;
```

#### 布局

采用flex进行布局，禁止使用float以及vertical-align。


```CSS
.container{
  disaplay:  flex;
  flex-dirextion:  row;
}
```
#### 注释

基本语法

- 注释代码以`/*`开始，以`*/`结束

- 注释不能嵌套

- 示例

  ```
  /* 注释内容 */
  ```

###### 团队约定

**注释内容** 

对于一般性注解，书写简单的短语；对于较长的注解，书写完整的句子。

- 推荐写法

  ```
  /* 用户头像 */
  .avatar {
    width: 200rpx;
    height: 200rpx;
  }
  ```

- 不推荐写法

  ```
  /* 这是用户头像的样式 */
  .avatar {
    width: 200rpx;
    height: 200rpx;
  }
  ```

**注释位置**

注释应该写在被注释代码块的上一行

- 推荐写法

  ```
  /* 用户昵称 */
  .name {
    color: #fff;
  }
  ```

- 不推荐写法

  ```
  .name {/* 用户昵称 */
    color: #fff;
  }
  ```

**注释格式**

注释内容的第一个字符和最后一个字符皆为一个空格字符

- 推荐写法

  ```
  /* 用户昵称 */
  .name {
    color: #fff;
  }
  ```

- 不推荐写法

  ```
  /*用户昵称*/
  .name {
    color: #fff;
  }
  ```

**单行注释**

单行注释单独占一行

- 推荐写法

  ```
  /* 用户昵称 */
  .name {
    color: #fff;
  }
  ```

- 不推荐写法

  ```
  .name {/* 用户昵称 */
    color: #fff;
  }
  ```

## JS规范

### 1、JavaScript语言规范

#### 前奏

约定JavaScript使用ES6标准开发

#### 关键字

任何时候，避免使用语言保留关键字命名。

#### 变量声明

使用`let`代替`var`声明变量，

```
let loadding = -1;
loadding = 0;
```

使用`const`声明常量，常量名要求大写，多个词之间以下划线`_`连接。

```
const { HOST, GET_URL } = require("../../utils/api.js");
```

js允许一个声明可以有多个变量。我们约定，一个声明只有一个变量。

- 推荐写法

  ```
  let a = 0; 
  let b = 1;
  let c = 2;
  ```

- 不推荐写法

  ```
  let a = 0, b = 1, c = 2;
  ```

#### 字符串

字符串统一使用单引号`''`，不使用双引号`""`

```
let title = '中国火星探测器气动设计已完成 正进行试验验证';
```

字符串需要换行或由代码生成的字符串时使用模板字符串 ``

- 推荐写法

  ```
  // 字符串换行
  let content = `据了解，我国火星探测任务力争一次实现环绕、
    着陆和巡视三大目标。其中，着陆器的着陆过程涉及到多项空
    气动力学难题。`;
    
  // 代码拼接生成字符串
  let editor = '付毅飞';
  let text = `责任编辑${editor}`; 
  ```

- 不推荐写法

  ```
  // 字符串换行,使用 \n
  let content = '据了解，我国火星探测任务力争一次实现环绕、 \n 着陆和巡视三大目标。其中，着陆器的着陆过程涉及到多项空 \n气动力学难题。';
    
  // 代码拼接生成字符串
  let editor = '付毅飞';
  let text = '责任编辑' + editor; 
  ```

#### 数组

使用字面量创建数组

```
let arr = [];
```

使用新方法forEach，map，filter，reduce处理数组数据，代码书写更简洁

- 推荐写法

  ```
  // 取出数组里的偶数
  let arr = [1,2,3,4,5,6,7,8];
  let result = arr.filter(item=>item%2===0)
  // 输出：[2, 4, 6, 8]
  ```

- 不推荐写法

  ```
  // 取出数组里的偶数
  let arr = [1,2,3,4,5,6,7,8];
  let result = [];
  for(let i=0; i<arr.length; i++) {
    let item = arr[i];
    if(item%2===0) {
        result.push(item)
    }
  }
  // 输出：[2, 4, 6, 8]
  ```

使用解构赋值和扩展运算符`...`简化代码

#### 对象

使用字面量值创建函数

```
let obj = {};
```

属性简写，属性名跟值的变量（key和value）一样时，只写属性名

- 推荐写法

  ```
  let a = 5;
  let obj = {
    a,
    b: 12
  }
  ```

- 不推荐写法

  ```
  let a = 5;
  let obj = {
    a：a
    b: 12
  }
  ```

方法简写，不写`function`和`:`

- 推荐写法

  ```
  let obj = {
    a:13,
    show(){
      console.log(this.a);
    }
  }
  ```

- 不推荐写法

  ```
  let obj = {
  a: 13,
    show: function(){
      console.log(this.a);
    }
  }
  ```

#### this

用到`this`转换的地方，统一使用`that`

```
let that = this;
```

#### 回调函数规范

回调函数统一使用Promise函数的方式进行编写，回调成功的参数统一为res，错误参数为err。

```
// promise 处理回调

let back = new Promise((resolve, reject) => {

  if (/* 异步操作成功 */){
     resolve(value);
  } else {
     reject(error);
  }
});

back.then((res) => {
     console.log('成功回调！', res);
}).catch((err) => {
     console.log('失败回调！', error);
});
```

私有函数以及回调函数统一放置在生命周期函数后。

删除js文件中未用到的生命周期函数，保持代码的整洁。
```
Pages({

  data:{

  },

  onLoad:function(event){

  },

  _self:function(){

  }
})
```


每个函数之间用一个空行分离结构。

#### 数据绑定变量定义规范

所有涉及到数据绑定的变量均需在data中初始化。禁止在不定义的情况下直接setData。

```

Pages({

  data:{
    id : null
  },

  onLoad:function(event){
    let id = event.target.dataset.id;
    this.data.id = id;
  }
})
```
#### 点击事件规范

点击事件函数命名方式为 on + 事件名 或者业务名。
```
onLike: function(event){

}
```
### 2、JavaScript格式规范

#### 变量命名

变量名以及函数名统一采用驼峰命名法，正常情况下函数名前缀需加上清晰的动词表示函数功能，

私有函数或者属性以下划线开头表明。常量需用const 声明。

类的命名首字母需大写。

采用ES6 关键字let定义变量，尽量不使用var。


```
//定义常量
const a = 1

//定义变量
let imageContent =  res.data

//函数命名
getInfo:function(){
  return '';
}

//私有函数
_getInfo:function(){
  return '';
}
```

#### 分号

尽管现在JavaScript引擎知道该在什么情况下自动添加分号，由于项目历史原因和避免代码压缩时产生不必要的问题，我们约定使用分号。分号紧跟代码的最后一个字符。

- 推荐写法

  ```
  let loading = -1;
  ```

- 不推荐写法

  ```
  let loading = -1 ;
  ```

#### 逗号

逗号分割列表时，逗号放置在当前行的末尾。

- 推荐写法

  ```
  let bar = 1, 
      foo = 2;
  ```

- 不推荐写法

  ```
  let bar = 1 
      , foo = 2;
  ```

数组（或对象）的最后一个元素（或属性）后面的逗号是拖尾逗号，示例：

```
 let o = {
   a: 1,
   b: 2, // 拖尾逗号
 }
```

对于数组和对象，最后一个元素或属性与右括号`]`或`}`不在同一行时，可以（但不要求）使用拖尾逗号；在同一行时，禁止使用拖尾逗号。

- 推荐写法

  ```
  let arr = ['name',
    'age',
    'gender',
  ]
  let o1 = {a: 1,b: 2};
  let o2 = {
    a: 1,
    b: 2,
  };
  ```

- 错误写法

  ```
  let arr = ['name','age','gender',]
  let o1 = {a: 1,b: 2,}
  ```

#### 缩进

统一使用2个空格字符进行代码缩进。

#### 空格

##### 操作符

操作符前后加一个空格字符。

- 推荐写法

  ```
  let a = 1 + 2;
  ```

- 不推荐写法

  ```
  let a = 1+2;
  ```

##### 逗号

同一行内代码用到逗号，逗号后面加一个空格字符，提高代码可读性。

- 推荐写法

  ```
  let bar = 1, foo = 2;
  let arr = [1, 2, 3, 4, 5];
  ```

- 不推荐写法

  ```
  let bar = 1,foo = 2;
  let arr = [1,2,3,4,5]
  ```

##### 函数

函数声明式声明函数时，函数名与参数括号`()`连在一起，之间不加空格；参数括号`()`与函数体的左大括号`{`之间一个空格字符。

- 推荐写法

  ```
  function getInfo(userId) {
    ...
  }
  ```

- 不推荐写法

  ```
  function getInfo1 (userId) {
    ...
  }
  
  function getInfo2(userId){
    ...
  }
  ```

函数调用时，禁止有空格。

- 推荐写法

  ```
  getInfo();
  ```

- 错误写法

  ```
  getInfo ();
  ```

##### 对象字面量

对象字面量的属性名和冒号`:`之间不能有空格字符，冒号`:`和属性值之间一个空格字符。

- 推荐写法

  ```
  let o1 = { a: 1, b: 2, c: 3 }
  let o2 = {
      e: 5,
      f: 6,
      g: 7,
  }
  ```

- 不推荐写法

  ```
  let o1 = { a:1, b :2, c : 3}
  let o2 = {
      e:5,
      f :6,
      g : 7,
  }
  ```

对象字面量在一行内时，左括号`{`和右括号`}`与代码各间隔一个空格字符。

- 推荐写法

  ```
  let o1 = { a: 1, b: 2, c: 3 }
  ```

- 不推荐写法

  ```
  let o1 = {a: 1, b: 2, c: 3}
  ```

##### 单行代码

在单行代码中使用空格。

- 推荐写法

  ```
  function foo() { return true }
  if (true) { return true }
  ```

- 不推荐写法

  ```
  function foo(){return true}
  if(true){return true}
  ```

##### 代码块

大括号`{}`包裹起来的代码叫代码块，示例：

```
{
  let userId = 654321;
}
```

代码块前统一加一个空格字符

- 推荐写法

  ```
  if (true) {
    return '成功！' 
  }
  
  function getInfo() {
    ...
  }
  ```

- 不推荐写法

  ```
  if (true){
    return '成功！' 
  }
  
  function getInfo(){
    ...
  }
  ```

##### 计算属性

在对象的计算属性内，禁止有空格。

- 推荐写法

  ```
  obj['name']
  ```

- 不推荐写法

  ```
  obj['name' ]
  obj[ 'name']
  ```

#### 空行

空行对分离代码逻辑有帮助，但过多的空行会占据太多的屏幕空间，影响代码可读性。我们约定，最大连续空行数为2。

- 推荐写法

  ```
  if(true) {
    console.log('成功！');
  }
  
  function getUserInfo () {
    ...
  }
  ```

- 不推荐写法

  ```
  if(true) {
    console.log('成功！');
  }
  
  
  
  
  function getUserInfo () {
    ...
  }
  ```

在非空文件中，拖尾空行可以减少版本控制时的代码冲突。

- 推荐写法

```
function getUserInfo () {
  ...
}

// ↑上面一行是空行
```

- 不推荐写法

```
function getUserInfo () {
  ...
}
```

#### 大括号`{}`风格

用来描述大括号`{}`与代码块相对位置的方法很多，如下：

- 风格一

  ```
  if (true) {
    console.log('true');  
  } else {
    console.log('false');
  }
  ```

- 风格二

  ```
  if (true) {
    console.log('true');  
  } 
  else {
    console.log('false');
  }
  ```

- 风格三

  ```
  if (true) 
  {
    console.log('true');  
  }
  else
  {
    console.log('false');
  }
  ```

我们约定，使用风格一。

### 3、JavaScript注释规范

####  注释

注释分为单行注释和多行注释。

单行注释以`//`开头。

```
// 单行注释示例
```

多行注释以`/**`开始，以`*/`结束。

```
/**
 * 多行注释
 * 示例
 */
```

#### 团队约定

##### 单行注释

一般用于简单的描述，如状态描述，属性描述等。书写时应遵循以下规范：

- 注释符号`//`与注释内容之间一个空格字符
- 注释位于注释代码上面
- 单独占一行

示例

- 推荐写法：

  ```
  // 初始化
  let statusCode = -1; 
  ```

- 不推荐写法：

  ```
  //初始化
  let statusCode = -1; 
  let statusCode = -1;  // 初始化
  ```

##### 多行注释

一般用于描述某一块代码的功能，逻辑思路，或参数说明等。书写时应该遵循以下规范

- 注释开始符号`/*`和结束符号`*/`各占一行
- 结束符号`*/`前面加一个空格字符
- 代码块与代码块之间相隔一行

示例

- 推荐写法：

  ```
  /**
   * 多行注释
   * 多行注释
   * 多行注释
   */
  ```

- 不推荐写法：

  ```
  /* 多行注释
   * 多行注释
   * 多行注释
   * 多行注释
   */
   
   /* 多行注释多行注释 */
  ```

##### 文件注释

文件注释位于文件的最前面，主要是对当前这个文件的代码做个整体说明或注意的事项

示例

- 推荐写法：

  ```
  /*!
   * jRaiser 2 Javascript Library
   * sizzle - v1.9.1 (2013-03-15T10:07:24+0800)
   * http://jraiser.org/ | Released under MIT license
   *
   * Include sizzle (http://sizzlejs.com/)
   */
  ```

### 4、JavaScript数据交互规范

#### 一、使用指向page自身的this

在每个页面逻辑`.js`文件里全局声明`that`，在`Page()`函数的参数`onLoad`方法内把`this`赋给`that`

```
let that;
Page({
  ...
  onLoad: function () {
    that = this;
  }
  ...
})
```

#### 二、来源页面

> 当小程序功能增多，业务变得复杂，页面间的相互跳转也会更加频繁。从不同的来源页面跳转到同一个目标页面时，前者可能会要求后者差异化显示内容或进行不同的数据操作。后者则需要根据某种方式来区分不同的来源页从而进行相应的数据处理。

###### 团队约定

使用`navigator`组件或导航相关API时，`url`必带一个参数`f`，参数`f`值为来源页面的名称。目标页面通过参数`f`来区分来源页面。

```
// 从动态列表 event_list 进入个人主页 personal_page 

/* WXML */
<navigator url="/page/personal_page?f=event_list">跳转到新页面</navigator>

/* JavaScript */ 
wx.navigateTo({
  url: '/page/personal_page?f=event_list'
})
```

#### 三、网络请求(wx.request)

1. loading提示优化

   loading提示能让用户知道当前的操作进度，合理地显示loading提示，有助于提升产品气质和用户体验。

   > 通常我们认为，发起请求即显示loading提示，请求完成隐藏loading提示。用户所处的网络环境较差时，loading提示会正常显示隐藏，用户所处网络环境良好时，loading提示会闪一下。大多时候用户所处的网络环境都是良好的，网络请求能即时返回结果，此时就没必要显示loading提示，也可以避免那尴尬的一闪。

   ###### 团队约定

   网络请求在800毫秒内返回了结果，不显示loading提示，超过800毫秒还未返回结果开始显示loading提示。

   ###### 实现思路

   在请求之前声明一个变量loadingStatus来控制loading提示何时显示。loadingStatus有以下两个值，分别代表二个状态：

   | 值   | 状态说明 | 是否显示loading提示 |
   | ---- | -------- | ------------------- |
   | -1   | 初始值   | 显示                |
   | 0    | 请求完成 | 不显示              |

   ```
   let loadingStatus = -1;
   ```

   在请求之前放置一枚定时器，这个定时器在800毫秒之后执行，在其内控制是否显示loading提示。

   ```
   /* 
   * 定时器在800毫秒后执行时，会判断loadingStatus状态，
   * 如果loadingStatus还是初始值-1（没有被改变过），就显示loading提示。
   * 如果loadingStatus不是-1，说明网络请求已返回（此时loadingStatus的值应该是0）。
   */
   setTimeout(() => {
     if (loadingStatus === -1) {
       wx.showLoading({
         title: '加载中...'
       })
     }
   }, 800);
   ```

   在`wx.request`参数的`complete`里改变loadingStatus的值

   ```
   wx.request({
       ...
       complete: function () {
           // 请求完成，改变loadingSataus的值
           loadingSataus = 0;
       }  
   })
   ```

   完整流程

   ```
     ...
     getUserInfo: function () {
       // 其它代码...
       let loadingStatus = -1;
       setTimeout(() => {
         if (loadingStatus === -1) {
           wx.showLoading({
             title: '加载中...'
           })
         }
       }, 800)
       // 开始请求
       wx.request({
         url: 'your api url',
         method: 'GET',
         data: {
           userid: 123456
         },
         success: function (res) {
           // 处理返回结果
         },
         fail: function () {
           // 处理失败 
         },
         complete: function () {
           // 请求完成，关掉loading，改变loadingSataus的值
           wx.hideLoading();
           loadingSataus = 0;
         }
       })
   
     },
     ...
   ```

2. 限制重复请求

   我们的程序里有很多个请求，某个网络请求在未完成的情况下，该请求不应该再被发起，必须加以限制，保证业务流程有序进行。尽管有些限制在后端处理了，但前端也必须加以限制，把隐患扼杀在摇篮。

   > 连续的重复请求不加限制，会让前端程序数据错乱（如列表类数据加载），也会给后端造成不必要性能的负担，甚至引起数据库数据错乱。如：签到，领取积分，点赞（听说手快能多点几个）。

   ###### 实现思路

   在全局声明一个`allowRequest`用来控制请求是否能再次发起。

   | 值   | 状态说明               | 是否允许发起请求 |
   | ---- | ---------------------- | ---------------- |
   | -1   | 初始值，请求从未发起过 | 允许             |
   | 0    | 正在请求中             | 不允许           |
   | 1    | 请求完成               | 允许             |

   ```
     onLoad: function () {
       /*
        * 当disabled为-1或1时可以再次发起网络请求，为0时不可发起。
        */ 
       this.allowRequest = -1;
     }
   ```

   在发起请求之前通过`allowRequest`判断是否能发起请求。

   ```
   // allowRequest值为0，表明已经有一个当前的请求在执行，不能再次发起请求，中断操作。
   if(that.allowRequest === 0) {
     return;
   }
   // 如果可以发起请求，发起之前把allowRequest值改为0
   that.allowRequest = 0;
   ```

   请求完成，在`wx.request`参数的`complete`里改变`allowRequest`的值

   ```
   // 其它代码...
   complete: function () {
     // 把allowRequest的值改为1
     allowRequest = 1;
   }
   ```

   完整流程

   ```
     ...
     onLoad: function () {
       this.allowRequest = -1;
     }
     ...
     getUserInfo: function () {
       let that = this;
       // 进入请求之前，检查是否可以发起网络请求
       if(that.allowRequest === 0) {
         return;
       }
       // 如果可以请求，就把disabled的值改成0
       that.allowRequest = 0;
       // 开始请求
       wx.request({
         url: 'your api url',
         method: 'GET',
         data: {
           userid: 123456
         },
         success: function (res) {
           // 请求成功的代码
         },
         fail: function () {
          // 请求失败的代码
         },
         complete: function () {
           that.disabled = 1;
         }
       })
     },
     ...
   ```

3. 请求错误处理

   不管网络请求返回错误`error`还是请求失败`fail`，都应该反馈给用户。

   > 部分开者开发过程中处理网络请求结果时，只处理请求成功返回成功的结果，而对返回错误和请求失败没做处理，这是不科学的。（数据没有请求成功，又不给用户对应的错误反馈，用户会一脸懵比的。）

   ###### 团队约定

   为了方便开者准确定位错误和更舒适的用户体验，每个网络请求必须处理请返回错误`error`和请求失败`fail`，并适当地反馈给用户。

   `wx.request`参数的`fail`方法必须写法。

   ```
   getUserInfo: function () {
     ...
     wx.request({
       url: api.host + '/YinianProject/points/showPersonInfo',
       method: 'GET',
       data: {
         userid: userid + ''
       },
       success: function (res) {
         if (res.data.code === 0) {
           // 请求成功，返回成功
           // ...
         } else {
           // 请求成功，返回错误
           wx.showToast({
             title: '数据返回错误',
             image: '/images/toast_warning.png',
             duration: 2000
           })
         }
       },
       fail: function () {
         // 请求失败 
         wx.showToast({
           title: '请求失败',
           image: '/images/toast_warning.png',
           duration: 2000
         })
       },
       complete: function () {
         // 不管是请求成功还是失败
       }
   })
   
   },
   ```

####  Page参数内的方法声明顺序

使用微信开发者工具新建一个Page时，在`.js`的`Page`函数的参数内自带了一些属性和方法，自定义方法放在这些方法后面。



## 组件规范

#### 组件名命名规范

组件在使用时命名以 “c-”为开头的组件名，若组件名称为多个单词名拼接而成，采用 ' - ' 连接。

> **c来源于单词 ‘**components**’**     

<c-movies />

#### 触发事件规范

组件点击触发事件建议用冒号分隔开

<c-component-tag-name bind:myevent="onMyEvent" />

#### externalClasses命名规范

命名格式采用如下形式：c-class-{name}，name可自行定义

> c-class-icon

#### 组件样式规范

命名必须以 c- 开头，不允许使用内联样式以及id样式
```
.c-container{
  disaplay: flex;
  flex-dirextion: row
}
```
