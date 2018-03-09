package ro.bogdanmunteanu.testapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ro.bogdanmunteanu.testapp.helpers.NumberHelper;

public class FibonacciUnitTest {

    @Test
    public void assertFibonacciValues()
    {
        List<Integer> results = new ArrayList<>();
        results.addAll(NumberHelper.generateFibonacciList(10));
        Assert.assertTrue(results.get(0)==0);
        Assert.assertTrue(results.get(1)==1);
        Assert.assertTrue(results.get(2)==1);
        Assert.assertTrue(results.get(3)==2);
        Assert.assertTrue(results.get(4)==3);
        Assert.assertTrue(results.get(5)==5);
        Assert.assertTrue(results.get(6)==8);
        Assert.assertTrue(results.get(7)==13);
        Assert.assertTrue(results.get(8)==21);
        Assert.assertTrue(results.get(9)==34);
    }

}
