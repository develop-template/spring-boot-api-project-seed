package cn.huacloud.tax.boot.common.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void trimPreCent() {
        String str1 = "%12%e%";
        String replace = str1.replace("%", "\\%");
        System.out.println(replace);
    }
}