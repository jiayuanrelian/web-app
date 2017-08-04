package com.huateng.enums;
/**
 * 删除标示
 * @author zhuenran
 *
 */
public enum DelFlag {

	Del("已删除","1"),UNDel("未删除","0");
	
	private String desc;
	
	private String flag;
	
	DelFlag(String desc,String flag){
		this.desc = desc;
		this.flag = flag;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
