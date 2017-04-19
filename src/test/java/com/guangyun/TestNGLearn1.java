package com.guangyun;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by 001117030057 on 2017/4/5.
 */

public class TestNGLearn1{



    @Test
    public void testAdd() {
        int a = 1+3;
        Assert.assertTrue(a==4);
    }
}