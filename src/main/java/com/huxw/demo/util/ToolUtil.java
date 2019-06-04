package com.huxw.demo.util;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: huxw
 * @Date: 2019-4-6 16:00
 * @Version 1.0
 */
public class ToolUtil {
    /**
     * 生成主键（32位）
     *
     * @return
     */
    public static String generateID() {
        return generateID(System.currentTimeMillis());
    }

    /**
     * @return
     * @Author huxw
     * @Description T根据指定时间生成主键，该方法只能用来对比主键生成时间，切忌不能用来生成主键插入数据库
     * @Date 2019-4-6 16:04
     * @Param
     **/
    public static String generateID(Date date) {
        return generateID(date.getTime());
    }

    /**
     * 根据指定时间生成主键
     *
     * @param time
     * @return
     */
    public static String generateID(long time) {
        String rtnVal = Long.toHexString(time);
        rtnVal += UUID.randomUUID();
        rtnVal = rtnVal.replaceAll("-", "");
        return rtnVal.substring(0, 32);
    }
}
