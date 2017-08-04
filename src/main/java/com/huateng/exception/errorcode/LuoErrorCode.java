package com.huateng.exception.errorcode;
/**
 * 错误代码
 * @author zhuenran
 *
 */
public enum LuoErrorCode {
	NOT_REPEAT("LUO001","实体标识不能重复"),
	ERROR_ADD_USER("LUO002","添加用户失败"),
	ERROR_ADD_ENTITYITEM("LUO003","添加实体属性失败"),
	SUCCESS_ADD_ENTITYITEM("LUO004","添加实体属性成功"),
	SUCCESS_DEL_ENTITYITEM("LUO005","删除实体属性成功"),
	UNKNOWN_ERROR("LUO999","系统繁忙，请稍后再试....");
    private String value;
    private String desc;

    private LuoErrorCode(String value, String desc) {
        this.setValue(value);
        this.setDesc(desc);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    @Override
    public String toString() {
    	return "[" + this.value + "]" + this.desc;
    }
}
