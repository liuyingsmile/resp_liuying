package com.tool;

import org.apache.log4j.Logger;

/**
 * Created by liuying on 2017/4/9.
 */


public class Logtool {
    //初始化一个Logger对象
    private static Logger log = Logger.getLogger(Logtool.class);

    public static void startTestCase(String sTestCaseName) {
        log.info("-----------------------------------------");
        log.info("*****    " + sTestCaseName + "   ************");
    }

    public static void endTestCase(String sTestCaseName) {
        log.info("*****    " + "测试用例执行结束" + "   ************");
        log.info("-----------------------------------------");
    }

    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void error(String message) {
        log.error(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }

    public static void fatal(String message) {
        log.fatal(message);
    }
}
