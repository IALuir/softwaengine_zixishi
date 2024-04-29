package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class CarPosition extends BaseEntity{

    private static final long serialVersionUID = 1L;
    private int carid;

    @Excel(name = "lat")
    private float lat;

    @Excel(name = "lng")
    private float lng;

    @Excel(name = "carnumid")
    private int carnumid;

    @Excel(name = "cartime")
    private String cartime;

    public int getcarid() {return carid; }

    public void setcarid(int carid)
    {
        this.carid = carid;
    }

    public float getlat()
    {
        return lat;
    }

    public void setlat(float lat)
    {
        this.lat = lat;
    }

    public float getlng()
    {
        return lng;
    }

    public void setlng(float lng)
    {
        this.lng = lng;
    }

    public int getcarnumid() {return carnumid; }

    public void setcarnumid(int carnumid)
    {
        this.carnumid = carnumid;
    }

    public String getcartime() {return cartime; }

    public void setcartime(String cartime)
    {
        this.cartime = cartime;
    }
}
