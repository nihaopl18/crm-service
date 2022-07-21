package cn.com.yusys.yscimc.operation.constant;

import java.util.Arrays;
import java.util.Objects;

/**
 * 渠道接口错误码信息
 * @author hujun3
 * @date 2021-01-05
 */
public enum ChannelErrorCodeEnum {
    /**
     * 接口错误码
     */
    SUCCESS("000000","交易成功","Transaction is successful",""),
    ERROR("000001","交易失败","Transaction is failed",""),

    PARAMS_NULL("100001","报文内容为空","The message content is empty",""),
    PARAMS_DATA_ERR("100002","报文结构错误","Message structure error",""),
    SIGN_TYPE_NULL("100003","缺少signType参数","Missing signtype parameter",""),
    SIGN_TYPE_null("100004","签名类型错误","Wrong signature type",""),
    SIGN_VALUE_NULL("100005","缺少signValue参数","Missing signvalue parameter",""),
    SIGN_FAIL("100006","接口验签失败","Interface signature verification failed",""),

    VALID_FAIL("200001","必填参数为空或错误","Required parameter is empty or error",""),
    TRANSCODE_NULL("200002","交易码为空","Transaction code is empty",""),
    TRANSCODE_ERR("200003","交易码错误","Transaction code error",""),
    CHNLCODE_NULL("200004","渠道代码为空","Channel code is empty",""),
    CHNLCODE_ERR("200005","渠道代码错误","Channel code error",""),
    REQ_TIME_NULL("200006","请求时间为空","The request time is empty",""),
    REQ_TIME_ERR("200007","请求时间格式错误","Request time format error",""),
    LANGUAGE_NULL("200008","语言标识为空","The language ID is empty",""),
    NOT_SUPPORT_ARG_VALUE("200009","不支持的参数值","Not support arg value",""),

    NOT_FOUND_ORIGINAL_TRANSACTION("300501","找不到原始交易-冲正失败","Failed to find original transaction reversal",""),
    RECT_POINT_ERR("300502","积分不足-冲正失败","Correction failure due to insufficient points",""),
    RECT_COUPON_ERR("300503","卡券已核销-冲正失败","Failed to write off the card and voucher",""),
    RECT_GAME_ERR("300504","游戏资格核销-冲正失败","Game qualification verification and correction failed",""),

    COUPON_WRITE_ERR("300601","卡券code错误","Card code error",""),
    INTE_WRITE_ERR("300602","核销失败积分不足","Failed to write off points",""),
    VERIFICATION_TYPE_ERR("300603","核销类型错误","The type of verification is wrong",""),

    OLD_BUS_ERR("300701","原始交易不存在，冲正处理失败","Original transaction does not exist, reversal processing failed",""),
    COUPON_ERROR("300702","未查询到卡券信息", "Coupon information not found", ""),
    COUPON_USED("300703", "存在已核销卡券","The coupon has expired", ""),
    COUPON_EXP("300704", "存在已过期卡券", "Coupon is expired", ""),
    MONEY_NOT_ENOUGH("300705", "消费金额未满足最低金额", "Consumption amount does not meet the minimum amount", ""),
    COUPON_NOT_MATCHED("300706", "存在不属于该用户的卡券", "There is a coupon that does not belong to the customer", ""),
    DUPLICATE_ORDER_OR_BUSS_NO("300707", "已存在的订单号或流水号", "Existing order number or serial number", ""),
    ORDER_NOT_EXIST("300708", "订单不存在", "Order does not exist", ""),
    REVERSAL_POINTS_EXCEED("300709", "冲正积分超过核销积分", "Reversal points exceed write off points", ""),

    /*客户权益账单查询*/
    RIGHT_AND_CHANGE_TYPE_NOT_MATCH("300801","权益类型与变动类型不匹配","Mismatch between equity type and change type",""),

    ORDER_MONEY_ERR("300901","订单金额为空或格式错误","Order money is empty",""),
    TOTAL_PAY_MONEY_ERR("300902","支付总金额格式错误","Incorrect format of payment total amount",""),
    PAY_WAY_ERR("300903","交易类型错误","The type of verification is wrong",""),

    /*权益转赠业务错误码*/
    SCORE_TRANSFER_CUST_UNDIFIND("301101","赠送者MDC客户号不存在，积分转赠失败。",
            "The MDC customer number of the giver does not exist, the bonus transfer failed",
            "Nomor pelanggan MDC dari pemberi tidak ada, transfer bonus gagal"),
    SCORE_TRANSFER_SCORE_NOT_ENOUGH("301102","客户积分不够，积分转赠失败。",
            "The customer's points are not enough, and the transfer of points fails",
            "Titik pelanggan tidak cukup, dan transfer titik gagal"),
    CUST_SCORE_FAILED("301103","查询客户积分信息失败",
            "Failed to query customer credit information",""),
    CUST_COUPON_FAILED("301104","查询客户卡券信息失败",
            "Failed to query customer card coupon information",""),
    TRANSFER_CUST_ERROR("301105","赠送对象不能是自己",
            "Can't gift points to yourself",""),

    /*积分发红包业务错误码*/
    SEND_RED_PKT_CUST_UNDIFIND("301201","发送红包MDC客户号不存在，发送红包失败。",
            "MDC customer number of sending red packet does not exist, sending red packet failed.",
            "Nomor pelanggan MDC mengirim paket merah tidak ada, mengirim paket merah gagal"),
    SEND_RED_PKT_SCORE_NOT_ENOUGH("301202","客户积分不足，发送红包失败。",
            "Customer points is not enough, sending red packets failed.",
            "Titik pelanggan tidak cukup, mengirim paket merah gagal"),

    /*积分发红包领取业务错误码*/
    SEND_RED_PKT_GET_TRANSCODE_UNDIFIND("301301","发放红包原交易流水号不存在，红包领取失败。",
            "The original transaction serial number of the red envelope does not exist, and the red envelope collection fails.",
            "Nomor seri transaksi asli dari amplop merah tidak ada, dan koleksi amplop merah gagal"),
    SEND_RED_PKT_GET_RED_EXPIRED("301302","红包已过期，领取失败。",
            "The red envelope has expired. Collection failed.",
            "Sampul merah telah habis. Koleksi gagal"),

        /*商户权益系统权益核销*/
    RAI_WRITE_OFF_COUPON_CODE_UNDIFIND("301501","卡券CODE不存在，核销失败。",
            "Certificate verification failed, code does not exist.",
            "Kode kartu tidak ada, menulis gagal"),
    RAI_WRITE_OFF_COUPON_CODE_USED("301502","该卡券CODE已核销，不能进行重复核销。",
            "The code of the card voucher has been written off and cannot be written off repeatedly",
            "Kode voucher kartu telah ditulis dan tidak dapat ditulis ulang-ulang"),
    RAI_WRITE_OFF_COUPON_EXPIRED("301503","卡券已过期，核销失败。",
            "The card certificate has expired, verification failed.",
            "Sertifikat kartu telah habis, verifikasi gagal"),
    COUPON_CUST_NOT_MATCH("301504","卡券不属于该客户，无法核销。",
            "The coupon does not belong to the customer, cannot be written off.",
            "Kupon bukan milik pelanggan dan tidak dapat ditukarkan."),
    COUPON_COST_OWNER_NOT_MATCH("301505","卡券成本属主不符，无法核销。",
            "The cost owner of coupon does not match, cannot be written off.",
            "Pemilik biaya kupon tidak cocok, tidak dapat dihapuskan."),
    NOT_EXTERNAL_IMPORT_COUPON("301506","不是外部导入卡券，无法核销。",
            "The coupon is not external_import, cannot be written off.",
            ""),

    /*客户领券错误码*/
    COUPON_NOT_AVAILABLE("301701","卡券未上架或不在上架时间内",
            "coupons is not available",
            ""),
    CUSTOMER_NOT_ELIGIBLE("301702","客户没有领取资格",
            "The customer is not eligible to get coupon",
            ""),
    COUPON_STOCK_NOT_ENOUGH("301703","卡券库存不足",
            "Insufficient inventory of cards and coupons",
            ""),

    /*客户积分调加业务错误码*/
    SCORE_ADD_MCTID_UNDIFIND("301801","成本分摊属主不存在，积分调加失败。",
            "Cost allocation owner does not exist, points adjustment failed",
            "Pemilik alokasi biaya tidak ada, penyesuaian titik gagal"),
    SCORE_ADD_SCORE_NOT_ENOUGH("301802","成本分摊属主积分池不够，积分调加失败。",
            "The main pool of cost allocation is not enough and the adjustment fails",
            "Pool utama alokasi biaya tidak cukup dan penyesuaian gagal"),
    DATE_VALID_FAIL("301803","调加积分有效期错误","addScoreValidDate parameter error",""),

    TRAIL_PAYMENT_NULL("302501","没有支付试算记录","There is no trial payment record",""),


    /*权益实时累积错误码*/
    TRANS_TYPE_ERR("302601","累积类型错误","Trans type is error",
            ""),

    /** 卡卷信息查询 */
    COUPON_NOT_EXIT("302701","卡卷信息不存在","Coupons is not exist",
                           ""),
    /** 红包领取错误码 */
    RED_ENVELOPE_NOT_EXIT("301301","发放红包原交易流水号不存在","The original transaction serial number of the red envelope does not exist, and the red envelope collection fails",""),
    RED_ENVELOPE_EXPIRED("301302","红包已过期，领取失败","The red envelope has expired. Collection failed",""),
    RED_ENVELOPE_HAS_BEEN_COLLECTED("301303","红包已领取，不可重复领取","The red envelope has been collected",""),

    CUSTOMER_NUMBER_MISSING("400102", "缺少客户号", "Missing customer id", ""),
    ORDER_HAS_REVERSED("400103", "该订单已冲正", "The order has been reversed", ""),


    ;


    /**
     * 错误码
     */
    private final String code;
    /**
     * 中文描述
     */
    private final String zh_desc;
    /**
     * 英文描述
     */
    private final String en_desc;
    /***
     * 印尼语描述
     */
    private final String id_desc;

    ChannelErrorCodeEnum(String value, String zhDesc, String enDesc, String idDesc ) {
        this.code = value;
        this.zh_desc = zhDesc;
        this.en_desc = enDesc;
        this.id_desc = idDesc;

    }

    public String getCode() {
        return code;
    }
    public String getZhDesc() {
        return zh_desc;
    }
    public String getEnDesc() {
        return en_desc;
    }
    public String getIdDesc() {
        return id_desc;
    }

    public static String getTypeByCode(String code,String language) {
        ChannelErrorCodeEnum er = Arrays.stream(ChannelErrorCodeEnum.values()).filter(item -> Objects.equals(code,
                item.getCode())).findFirst().orElseThrow(() -> new IllegalStateException("非法的类型"));
        return er.getZhDesc();
    }
}
