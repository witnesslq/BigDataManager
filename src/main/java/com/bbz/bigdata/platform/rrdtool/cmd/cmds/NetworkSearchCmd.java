package com.bbz.bigdata.platform.rrdtool.cmd.cmds;

import com.bbz.bigdata.platform.rrdtool.Constant;
import com.bbz.bigdata.platform.rrdtool.cmd.ICmd;
import com.bbz.bigdata.platform.rrdtool.exception.BussException;
import com.bbz.bigdata.platform.rrdtool.jsonresultmodel.FullJsonModel;

import java.util.Collection;

public class NetworkSearchCmd implements ICmd{

	public NetworkSearchCmd(String hostName,String startTime,String endTime){
		this.cmdStr=Constant.rrdToolLocation
				+ " xport --start '"+startTime+"' --end '"+endTime
				+ "' DEF:'a0'='"+Constant.rrdDataLocation+hostName+"/bytes_in.rrd':'sum':AVERAGE"
				+ " DEF:'a1'='"+Constant.rrdDataLocation+hostName+"/bytes_out.rrd':'sum':AVERAGE"
				+ " LINE2:'a0'#33cc33:'In '"
				+ " VDEF:a0_last=a0,LAST"
				+ " VDEF:a0_min=a0,MINIMUM"
				+ " VDEF:a0_avg=a0,AVERAGE"
				+ " VDEF:a0_max=a0,MAXIMUM"
				+ " GPRINT:'a0_last':'Now\\:%5.1lf%s'"
				+ " GPRINT:'a0_min':'Min\\:%5.1lf%s'"
				+ " GPRINT:'a0_avg':'Avg\\:%5.1lf%s'"
				+ " GPRINT:'a0_max':'Max\\:%5.1lf%s\\l'"
				+ " LINE2:'a1'#5555cc:'Out'"
				+ " VDEF:a1_last=a1,LAST"
				+ " VDEF:a1_min=a1,MINIMUM"
				+ " VDEF:a1_avg=a1,AVERAGE"
				+ " VDEF:a1_max=a1,MAXIMUM"
				+ " GPRINT:'a1_last':'Now\\:%5.1lf%s'"
				+ " GPRINT:'a1_min':'Min\\:%5.1lf%s'"
				+ " GPRINT:'a1_avg':'Avg\\:%5.1lf%s'"
				+ " GPRINT:'a1_max':'Max\\:%5.1lf%s\\l'"
				+ " XPORT:'a0':'In '"
				+ " XPORT:'a1':'Out'";
	}
	
	private String cmdStr;
	
	@Override
	public String getCmd() {
		return cmdStr;
	}

	@Override
	public boolean canChangeToPercent() {
		return false;
	}
	
	@Override
	public void handleToPercent(FullJsonModel jsonModel, Collection<String> seleteFullNames) throws BussException{
		throw new BussException(BussException.CAN_NOT_TO_PERCENT);
	}
}
