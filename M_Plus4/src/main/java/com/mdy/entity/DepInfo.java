package com.mdy.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mdy
 * @since 2020-05-19
 */
@TableName("depinfo")
public class DepInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "did", type = IdType.AUTO)
    private Integer did;
    private String dname;
    private String dremark;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDremark() {
        return dremark;
    }

    public void setDremark(String dremark) {
        this.dremark = dremark;
    }

    @Override
    public String toString() {
        return "Depinfo{" +
        ", did=" + did +
        ", dname=" + dname +
        ", dremark=" + dremark +
        "}";
    }
}
