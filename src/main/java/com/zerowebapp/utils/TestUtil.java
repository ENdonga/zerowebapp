package com.zerowebapp.utils;

import com.zerowebapp.base.TestBase;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 5;
    public static long IMPLICIT_WAIT = 3;

    public void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
    }
}
