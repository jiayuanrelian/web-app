package com.huateng.model;

import java.util.Date;
import java.util.List;
/**
 * 菜单实体
 * @author zhuenran
 *
 */
public class Menu {
	
    private Integer id;

    private Integer pid;

    private String name;

    private String page;

    private String click;

    private String tip;

    private String createId;

    private Date createTime;

    private String updaterId;

    private Date updateTime;
    
    private Integer order;

    private List<Menu> menus;
    
    public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click == null ? null : click.trim();
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId == null ? null : updaterId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}