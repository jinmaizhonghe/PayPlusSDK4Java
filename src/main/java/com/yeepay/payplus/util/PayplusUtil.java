package com.yeepay.payplus.util;

import com.yeepay.g3.utils.common.json.JSONArray;
import com.yeepay.g3.utils.common.json.JSONObject;
import com.yeepay.payplus.core.entity.PayplusResp;
import com.yeepay.payplus.exception.QRCodeException;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Marco on 16/12/2016.
 */
public class PayplusUtil {

    private static Logger logger = Logger.getLogger(PayplusUtil.class);

    /**
     * 如果用户不填写, 那么自动生成一个RequestNo, 与业务关联。
     *
     * @return
     *
     */
    public static String genRequestNo() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    public static void main(String[] args) {
        List<JSONObject> list = new ArrayList<JSONObject>();
        Map remitInfosMap = new HashMap<String, String>();

        remitInfosMap.put("remiteType", "AMOUNT");
        remitInfosMap.put("bankCode", "CMB");
        remitInfosMap.put("bankName", "招商银行");
        remitInfosMap.put("branchBankName", "");
        remitInfosMap.put("userName", "杨洋");
        remitInfosMap.put("cardNo", "6214850107101245");
        remitInfosMap.put("bankAccountType", "pr");
        remitInfosMap.put("province", "110000");
        remitInfosMap.put("city", "110000");
        remitInfosMap.put("payeeMobile", "18514591959");
        remitInfosMap.put("leaveWord", "易宝测试");
        remitInfosMap.put("value", "0.01");

        list.add(PayplusUtil.convert2Json(remitInfosMap));

        JSONArray ja = new JSONArray(list);

        System.out.println(ja);

    }

    /**
     * <p>convert a map to json Object</p>
     * @param map
     * @return
     */
    public static JSONObject convert2Json(Map<String, String> map) {
        JSONObject jo = new JSONObject(map);
        return jo;
    }

    /**
     * <p>convert a map to a json string</p>
     *
     * @param map
     * @return a json string which is converted from a map.
     */
    public static String convert2JsonString(Map<String, String> map) {
        JSONObject jo = new JSONObject(map);
        return jo.toString();
    }

    /**
     * <p>convert a list to an object of json array</p>
     *
     * @param list
     * @return a json array which is converted from a list.
     */
    public static String convert2JsonArray(List<JSONObject> list) {

        JSONArray jo = new JSONArray(list);
        logger.debug(jo);
        return jo.toString();
    }

    /**
     * 获取支付+规定的时间格式
     *
     * @param date
     * @return
     */
    public static String getFormatDateString(Date date) {
        DateFormat format = new SimpleDateFormat(PayplusConfig.DATE_FORMAT);
        return format.format(date);
    }

    //TODO 其他类型判断完善
    public static Boolean isNull(Object obj) {

        if (obj == null)
            return true;

        if (obj instanceof String) {
            String str = String.valueOf(obj);
            if (("null").equals(str) || "".equals(str))
                return true;
            else
                return false;
        } else {
            logger.error("other class type: " + obj.getClass().getName());
            return false;
        }
    }

    public static String getBase64Stream(String path) {

        File file = new File(path);
        FileInputStream fs = null;
        ByteBuffer byteBuffer = null;
        try {
            fs = new FileInputStream(file);
            FileChannel channel = fs.getChannel();
            byteBuffer = ByteBuffer.allocate((int) channel.size());
            channel.read(byteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String base64FileStr = org.apache.commons.codec.binary.Base64.encodeBase64String(byteBuffer.array());

        return base64FileStr;
    }

    public static void genQRCodeImage(PayplusResp trophy, String path) {

        if (trophy == null || trophy.getKeyInfo() == null || "".equals(trophy.getKeyInfo()) || trophy.getKeyInfo().contains("https://")) {
            throw new QRCodeException("\n\nHi buddy, please kindly check: \n 1, The request got correct return. \n 2, The service you called will send you QR code back. \n");
        }

        String hexImgString = trophy.getKeyInfo();

        //generate QRCode image
        byte[] b = hex2byte(hexImgString);
        ByteArrayInputStream in = new ByteArrayInputStream(b);
        BufferedImage image = null;
        try {
            image = ImageIO.read(in);
            ImageIO.write(image, "jpg", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static byte[] hex2byte(String s) {
        byte[] src = s.toLowerCase().getBytes();
        byte[] ret = new byte[src.length / 2];
        for (int i = 0; i < src.length; i += 2) {
            byte hi = src[i];
            byte low = src[i + 1];
            hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a')
                    : hi - '0');
            low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a')
                    : low - '0');
            ret[i / 2] = (byte) (hi << 4 | low);
        }
        return ret;
    }
}
