package com.guangyun;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by 001117030057 on 2017/4/6.
 */
public class TestNGLearn {
    @Test
    public void testEquals() {
        String str = "abc";
        Assert.assertEquals("abc", str);
    }

    @Test
    public void testSubstract() {
        int a = 3-1;
        Assert.assertTrue(a==1);
    }
}
