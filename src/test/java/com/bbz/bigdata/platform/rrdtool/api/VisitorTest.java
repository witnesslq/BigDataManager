package com.bbz.bigdata.platform.rrdtool.api;

import com.bbz.bigdata.platform.rrdtool.Unit;
import com.bbz.bigdata.platform.rrdtool.measurement.Measurement;
import org.junit.Test;

/**
 * Created by liu_k on 2016/5/20.
 * test
 */
public class VisitorTest{

    @Test
    public void testVisit() throws Exception{
        Visitor visitor=new Visitor();
        String res=visitor.visit("", "05/18/2016 14:11", "05/18/2016 14:21", new Measurement.Detail[]{Measurement.Disk.Free,Measurement.Disk.Total}, Unit.TB, false);
        System.out.println(res);
    }
}