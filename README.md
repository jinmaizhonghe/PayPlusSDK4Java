# PP-SDK In Action

> PP-SDK是基于[Payplus](http://www.jia007.com)接口封装的开发工具包。她屏蔽了大部分细节、简化了接入流程、同时提供了一些便捷的方法和标准化的参数枚举值。帮助开发者在接入过程中避开一些常见的问题，让开发者快速接入[Payplus](http://payplus.yeepay.com)的服务。

> *注: 该开发工具包仅支持Java语言，其他语言开发者可以参照Payplus的官方文档。*

## 一、快速接入

> *PayplusConnector 是一个核心类可以帮助我们接入Payplus核心系统。  
> 从此，你不再需要关注接口协议、加密方法、测试数据等等...*

### 准备工作

1. 在pom.xml里添加依赖。

   ```xml
    <dependencies>
        <dependency>
            <groupId>com.yeepay</groupId>
            <artifactId>pp-sdk</artifactId>
            <version>1.2</version>
        </dependency>
    </dependencies>
   ```

2. 在开发环境中创建payplus.properties文件，内容如下：

> 测试阶段：MODEL置为"TEST"，系统将使用默认配置进行测试，无须关心测试账号等信息。  
> 发布生产：MODEL置为"PRODUCTION"，须配置APP_KEY和APP_SECRET。

```properties
# Both are Required, if the value of MODEL does not equal "TEST"
APP_KEY=
APP_SECRET=

# Please set this element to "TEST", if you do not have a specified pair of APP_KEY and APP_SECRET.
# Otherwise, the element should be set to "PRODUCTION" if you decide to let your application to be published.
MODEL=TEST
```

### DEMO

下面我们使用Java作为开发语言，对接[Payplus](http://www.jia007.com)的用户注册接口。

```java
//pp-sdk核心类
PayplusConnector payplusConnector = new PayplusConnector();

//你也只可以指定payplus.properties文件的绝对或者相对路径
//PayplusConnector payplusConnector = new PayplusConnector("<绝对、相对路径>");

Map<String, String> params = new HashMap<String, String>();

//使用系统工具生成具有唯一性的requstNo
params.put("requestNo", PayplusUtil.genRequestNo());
params.put("merchantUserId", "Joey");

//call方法包含2个参数：常量URI和入参
PayplusResp payplusResp = payplusConnector.call(PayplusURI.USER_REGISTER, param);

//打印结果
payplusResp.print();
```

Console打印日志为：
> [Request of Payplus] 和 [Reponse of Payplus] 分别请求和响应参数  

```
[Request of Payplus]
service: user/register
merchantUserId: Joey
requestNo: 9a90660604524e4e89ab1f51eabc5127

[Reponse of Payplus]
requestNo: 9a90660604524e4e89ab1f51eabc5127
{
  "memberNo": "C211234567901952",
  "code": "1",
  "message": "success"
}
```

### 发布生产

需要修改payplus.properties, 填写APP_KEY和APP_SECRET, 并将MODEL置为PRODUCTION.

```properties
# Both are Required, if the value of MODEL does not equal "TEST"
APP_KEY=
APP_SECRET=

# Please set this element to "TEST", if you do not have a specified pair of APP_KEY and APP_SECRET.
# Otherwise, the element should be set to "PRODUCTION" if you decide to let your application to be published.
MODEL=PRODUCTION
```

## 二、接入指南

### 请求参数

> 目前，我们采用Map方式来进行参数传递。

```java

Map<String, String> params = new HashMap<String, String>();

params.put("requestNo", PayplusUtil.genRequestNo());
params.put("merchantNo", "BM12345678901221");
params.put("merchantUserId", "Joey");

```

### 响应参数

> 服务返回*PayplusResp*对象 包含的属性和对应的方法如下：

```java
public class PayplusResp {
    /**
     * 1.在某些接口中, 可能是H5页面链接
     * 2.另外一些接口, 二维码字节码
     */
    private String keyInfo;

    /**
     * 0-失败, 1-成功
     */
    private String state;

    /**
     * 响应实体, JSON串
     */
    private String respInfo;

    //for 3.2.1 sendRedPacket
    private String activeNo;

    //生成二维码图片
    public void genQRCodeImage(String path){
      //some operations
    }

    // 打印格式化的返回结果
    public void print(){
      // output formatted result.
    }
}
```

### 一些细节

> *PayplusUtil* 提供了若干个工具方法

* 自动生成requestNo

```java
/**
 * 基于JDK自带的UUID生成。
 * 当然，这个requestNo会作为返回参数封装在PayplusResp对象里。
 * 可以通过调用 payplusResp.getRequestNo() 获取。
 */
String requestNo = PayplusUtil.genRequestNo();
```

* 使用符合[Payplus](http://www.jia007.com)标准的时间格式

```java
String formattedDateString = PayplusUtil.getFormatDateString(new Date());
```

* 生成二维码图片

```java
//@params 出参对象、生成二维码地址
PayplusUtil.genQRCodeImage(trophy, path);
```

* 生成Base64文件字节码流

```java
//@params 被解析的文件地址
String Base64String = PayplusUtil.getBase64Stream(path);
```

* 为空判断

```java
Boolean flag = PayplusUtil.isNull(obj);
```

* 常量URI  

>*PayplusURI* 定义了全部可调用的服务。附：[接口&URI对照表](https://github.com/sharq34/pp-sdk/blob/master/URI_table.md)

```java
public class PayplusURI {

    // 2.1.2 实名
    public static final String USER_AUTH = "/rest/v1.0/payplus/user/auth";

    // 4.1.1 消费
    public static final String ORDER_CONSUME = "/rest/v1.0/payplus/order/consume";

    // 3.2.1 发送红包
    public static final String MARKETING_REDPACKET_SEND = "/rest/v1.0/payplus/merchant/sendRedPacket";

}

```
