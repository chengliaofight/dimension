package com.dimension.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BaseNode implements Serializable {
    private Long nodeid;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String location;

    private Date collecttime;

    private String description;

    private String nodename;

    private Integer tableid;

    private String address;

    private Integer userid;

    private Integer nodetype;

    private String isvalid;
    
    private List<Wifi> wifis;
    
    private List<Basestation> basestations;
    
    private List<File> files;
    
    private List<Field> other;
    
    private Table table;

    private static final long serialVersionUID = 1L;

    public Long getNodeid() {
        return nodeid;
    }

    public void setNodeid(Long nodeid) {
        this.nodeid = nodeid;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getCollecttime() {
        return collecttime;
    }

    public void setCollecttime(Date collecttime) {
        this.collecttime = collecttime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename == null ? null : nodename.trim();
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getNodetype() {
        return nodetype;
    }

    public void setNodetype(Integer nodetype) {
        this.nodetype = nodetype;
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }

	public List<Wifi> getWifis() {
		return wifis;
	}

	public void setWifis(List<Wifi> wifis) {
		this.wifis = wifis;
	}

	public List<Basestation> getBasestations() {
		return basestations;
	}

	public void setBasestations(List<Basestation> basestations) {
		this.basestations = basestations;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<Field> getOther() {
		return other;
	}

	public void setOther(List<Field> other) {
		this.other = other;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
    
}