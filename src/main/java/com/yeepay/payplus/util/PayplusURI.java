package com.yeepay.payplus.util;

/**
 * Created by Marco on 16/12/2016.
 */
public class PayplusURI {

    /**
     * 1.1.1 分账方注册
     */
    public static final String LEDGER_REGISTER = "/rest/v1.0/payplus/merchant/registerLedgerMerchant";

    /**
     * 1.1.2 分账方资质上传
     */
    public static final String LEDGER_UPLOAD = "/rest/v1.0/payplus/merchant/uploadQualifications";

    /**
     * 1.1.3 商户余额查询
     */
    public static final String MERCHANT_BALANCE = "/rest/v1.0/payplus/merchant/queryMerchantBalance";

    /**
     * 1.2.1 商户充值
     */
    public static final String MERCHANT_RECHARGE = "/rest/v1.0/payplus/order/merchantRecharge";

    /**
     * 1.2.2 商户充值查询
     * 4.1.2 订单查询
     */

    /**
     * 1.2.3 商户转账
     */
    public static final String MERCHANT_TRANSFER = "/rest/v1.0/payplus/transfer/merchantTransfer";

    /**
     * 1.2.4 转账查询
     * 2.4.3 转账查询
     */

    /**
     * 4.1.7 企业付款
     */
    public static final String MERCHANT_REMIT = "/rest/v1.0/payplus/remit/remit";

    /**
     * 4.1.8 企业付款查询
     */
    public static final String MERCHANT_REMIT_QUERY = "/rest/v1.0/payplus/remit/query";

    /**
     * 2.1.1 用户注册
     */
    public static final String USER_REGISTER = "/rest/v1.0/payplus/user/register";

    /**
     * 2.1.2 实名
     */
    public static final String USER_AUTH = "/rest/v1.0/payplus/user/auth";

    /**
     * 2.1.3 用户证件上传
     */
    public static final String USER_UPLOAD = "/rest/v1.0/payplus/user/authCredentials";

    /**
     * 2.1.4 用户信息查询
     */
    public static final String USER_INFO = "/rest/v1.0/payplus/user/queryUserInfo";

    /**
     * 2.2.1 绑卡
     * 2.1.2 实名
     */
    public static final String USER_BINDCARD = "/rest/v1.0/payplus/user/bindCard";

    /**
     * 2.2.2 解绑卡
     */
    public static final String USER_UNBINDCARD = "/rest/v1.0/payplus/user/unbindCard";

    /**
     * 2.2.3 绑卡列表
     */
    public static final String USER_CARDLIST = "/rest/v1.0/payplus/user/queryBindCardList";

    /**
     * 2.2.4 余额查询
     */
    public static final String USER_BALANCE = "/rest/v1.0/payplus/user/queryUserBalance";

    /**
     * 2.2.5 绑卡列表页面
     */
    public static final String USER_CARDLIST_PAGE = "/rest/v1.0/payplus/user/getBindCardListPage";

    /**
     * 2.3.1 重置密码
     */
    public static final String USER_RESETPWD = "/rest/v1.0/payplus/user/getPswdResetUrl";

    /**
     * 2.3.2 用户验密
     */
    public static final String USER_VERIFYPWD = "/rest/v1.0/payplus/user/getPswdVerifyUrl";

    /**
     * 2.4.1 充值
     */
    public static final String ORDER_RECHARGE = "/rest/v1.0/payplus/order/recharge";

    /**
     * 2.4.2 用户转账
     */
    public static final String ORDER_TRANSFER = "/rest/v1.0/payplus/transfer/transfer";

    /**
     * 2.4.3 转账查询
     */
    public static final String ORDER_TRANSFER_QUERY = "/rest/v1.0/payplus/transfer/query";

    /**
     * 2.4.4 提现
     */
    public static final String ORDER_WITHDRAW = "/rest/v1.0/payplus/withdraw/withdraw";

    /**
     * 2.4.5 提现查询
     */
    public static final String ORDER_WITHDRAW_QUERY = "/rest/v1.0/payplus/withdraw/query";

    /**
     * 3.1.1 发送卡券
     */
    public static final String COUPON_SEND = "/rest/v1.0/payplus/merchant/sendCoupon";

    /**
     * 3.1.2 领取卡券
     */
    public static final String COUPON_RECEIVE = "/rest/v1.0/payplus/user/receiveCoupon";

    /**
     * 3.1.3 查询未领取卡券
     */
    public static final String COUPON_UNRECEIVED = "/rest/v1.0/payplus/user/queryUnReceivedCoupons";

    /**
     * 3.1.4 查询已领取卡券(包括已使用和未使用)
     */
    public static final String COUPON_ALL_RECEIVED = "/rest/v1.0/payplus/user/queryAllCoupons";

    /**
     * 3.1.5 可用卡券查询
     */
    public static final String COUPON_AVAILABLE = "/rest/v1.0/payplus/user/queryAvailableCoupons";

    /**
     * 3.1.6 查询所有卡券列表页面 TODO
     */
    public static final String COUPON_LIST_PAGE = "/rest/v1.0/payplus/user/getAllCouponsPage";

    /**
     * 3.2.1 发送红包
     */
    public static final String MARKETING_REDPACKET_SEND = "/rest/v1.0/payplus/merchant/sendRedPacket";

    /**
     * 3.2.2 领取红包
     */
    public static final String MARKETING_REDPACKET_RECEIVE = "/rest/v1.0/payplus/user/receiveRedPacket";

    /**
     * 3.2.3 查询未领取红包
     */
    public static final String MARKETING_REDPACKET_UNRECEIVED = "/rest/v1.0/payplus/user/queryUnReceivedRedPackets";

    /**
     * 4.1.1 消费
     */
    public static final String ORDER_CONSUME = "/rest/v1.0/payplus/order/consume";

    /**
     * 4.1.2 订单查询
     */
    public static final String ORDER_QUERY = "/rest/v1.0/payplus/order/query";

    /**
     * 4.1.3 退款
     */
    public static final String ORDER_REFUND = "/rest/v1.0/payplus/refund/refund";

    /**
     * 4.1.4 退款查询
     */
    public static final String ORDER_REFUND_QUERY = "/rest/v1.0/payplus/refund/query";

    /**
     * 4.1.5 分账
     */
    public static final String ORDER_DIVIDE = "/rest/v1.0/payplus/divide/divide";

    /**
     * 4.1.6 分账查询
     */
    public static final String ORDER_DIVIDE_QUERY = "/rest/v1.0/payplus/divide/query";

}

