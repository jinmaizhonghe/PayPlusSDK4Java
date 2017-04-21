# 功能和PayplusURI常量对照表

| 功能     | URI（prefix: /rest/v1.0/payplus）  | PayPlusURI常量                   |
| :----- | :------------------------------- | :----------------------------- |
| 分账方注册  | /merchant/registerLedgerMerchant | LEDGER_REGISTER                |
| 资质上传   | /merchant/uploadQualifications   | LEDGER_UPLOAD                  |
| 商户余额查询 | /merchant/queryMerchantBalance   | MERCHANT_BALANCE               |
| 商户充值   | /order/merchantRecharge          | MERCHANT_RECHARGE              |
| 商户充值   | /order/query                     | ORDER_QUERY                    |
| 商户转账   | /transfer/merchantTransfer       | MERCHANT_TRANSFER              |
| 用户账户注册 | /user/register                   | USER_REGISTER                  |
| 实名认证   | /user/auth                       | USER_AUTH                      |
| 用户证件上传 | /user/authCredentials            | USER_UPLOAD                    |
| 用户信息查询 | /user/queryUserInfo              | USER_INFO                      |
| 绑卡     | /user/bindCard                   | USER_BINDCARD                  |
| 解绑卡    | /user/unbindCard                 | USER_UNBINDCARD                |
| 查询绑卡列表 | /user/queryBindCardList          | USER_CARDLIST                  |
| 用户余额查询 | /user/queryUserBalance           | USER_BALANCE                   |
| 绑卡列表页面 | /user/getBindCardListPage        | USER_CARDLIST_PAGE             |
| 重置支付密码 | /user/getPswdResetUrl            | USER_RESETPWD                  |
| 验证支付密码 | /user/getPswdVerifyUrl           | USER_VERIFYPWD                 |
| 充值     | /order/recharge                  | ORDER_RECHARGE                 |
| 转账     | /transfer/transfer               | ORDER_TRANSFER                 |
| 转账查询   | /transfer/query                  | ORDER_TRANSFER_QUERY           |
| 提现     | /withdraw/withdraw               | ORDER_WITHDRAW                 |
| 提现查询   | /withdraw/query                  | ORDER_WITHDRAW_QUERY           |
| 发送卡券   | /merchant/sendCoupon             | COUPON_SEND                    |
| 领取卡券   | /user/receiveCoupon              | COUPON_RECEIVE                 |
| 未领取卡券  | /user/queryUnReceivedCoupons     | COUPON_UNRECEIVED              |
| 已领取卡券  | /user/queryAllCoupons            | COUPON_ALL_RECEIVED            |
| 可用卡券   | /user/queryAvailableCoupons      | COUPON_AVAILABLE               |
| 全部卡券   | /user/getAllCouponsPage          | COUPON_LIST_PAGE               |
| 发送营销红包 | /merchant/sendRedPacket          | MARKETING_REDPACKET_SEND       |
| 领取营销红包 | /user/receiveRedPacket           | MARKETING_REDPACKET_RECEIVE    |
| 未领取红包  | /user/queryUnReceivedRedPackets  | MARKETING_REDPACKET_UNRECEIVED |
| 消费     | /order/consume                   | ORDER_CONSUME                  |
| 订单查询   | /order/query                     | ORDER_QUERY                    |
| 退款     | /refund/refund                   | ORDER_REFUND                   |
| 退款查询   | /refund/query                    | ORDER_REFUND_QUERY             |
| 分账     | /divide/divide                   | ORDER_DIVIDE                   |
| 分账查询   | /divide/query                    | ORDER_DIVIDE_QUERY             |
| 企业付款   | /remit/remit                     | MERCHANT_REMIT                 |
| 企业付款查询 | /remit/query                     | MERCHANT_REMIT_QUERY           |
|        |                                  |                                |