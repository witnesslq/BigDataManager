package com.bbz.bigdata.platform.module.modelview;

import com.bbz.bigdata.platform.rrdtool.jsonresultmodel.RRDJsonModel;
import lombok.Data;

/**
 *  集合概况的一些统计数字
 */

@Data
public class ClusterSummaryJM {

    private ClusterChartsJM clusterCharts;
    private ClusterNodeListJM clusterNodeList;

}
