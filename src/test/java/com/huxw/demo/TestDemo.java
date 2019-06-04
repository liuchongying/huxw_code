package com.huxw.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @Author: huxw
 * @Date: 2019-4-16 9:25
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDemo {
    @Test
    /**
     * @Author huxw
     * @Description 测试回文数
     * @Date 2019-4-16 9:33
     * @Param []
     * @return void
     **/
    public void testHuiwen() throws Exception {
        String s = "abcdefedcba";
        //boolean result = checkHuiwen(s);
        boolean result = isHuiwen(s);
        System.out.println("结果为：" + result);
        assertEquals(true, result);
    }

    /**
     * @return
     * @Author huxw
     * @Description 判断是否为回文数
     * @Date 2019-4-16 9:16
     * @Param
     **/
    private boolean checkHuiwen(String str) {
        int len = str.length();
        if (len > 1) {
            int half = len / 2;
            String firstStr = str.substring(0, half);
            String endStr = "";
            if (len % 2 == 0) {
                endStr = str.substring(half, len);
            } else {
                endStr = str.substring(half + 1, len);
            }
            String strZhuan = "";
            for (int i = endStr.length() - 1; i >= 0; i--) {
                strZhuan += endStr.charAt(i);
            }
            if (firstStr.equals(strZhuan)) {
                return true;
            } else {
                return false;
            }
        } else if (len == 1) {
            return true;
        }
        return false;
    }

    /**
     * @return
     * @Author huxw
     * @Description 递归判断是否为回文数
     * @Date 2019-4-16 9:58
     * @Param
     **/
    private boolean isHuiwen(String str) {
        while (str.length() > 1) {
            int length = str.length();
            char first = str.charAt(0);
            char last = str.charAt(length - 1);
            if (first == last) {
                String strcpy = str.substring(1, length - 1);
                System.out.println(strcpy);
                isHuiwen(strcpy);
            } else {
                return false;
            }
            //不加break,就会进入死循环,因为退出循环也是一层一层的。做改错题肯定有意思。
            break;
        }
        return true;
    }
}
