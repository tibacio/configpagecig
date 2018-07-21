/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.univocity.parsers.annotations.Parsed;

/**
 *
 * @author baci
 */
public class SendLeadRecord {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getDealercode() {
        return dealercode;
    }

    public void setDealercode(String dealercode) {
        this.dealercode = dealercode;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getHiname() {
        return hiname;
    }

    public void setHiname(String hiname) {
        this.hiname = hiname;
    }

    public String getCatetype() {
        return catetype;
    }

    public void setCatetype(String catetype) {
        this.catetype = catetype;
    }

    public String getLowname() {
        return lowname;
    }

    public void setLowname(String lowname) {
        this.lowname = lowname;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Parsed(field = "姓名")
    private String name;
    @Parsed(field = "电话")
    private String mobile;
    @Parsed(field = "试驾车型")
    private String series;
    @Parsed(field = "经销商")
    private String dealercode;
    @Parsed(field = "类型")
    private String media;
    @Parsed(field = "渠道大类")
    private String hiname;
    @Parsed(field = "接触方式")
    private String catetype;
    @Parsed(field = "渠道小类")
    private String lowname;
    @Parsed(field = "注册时间")
    private String ctime;
    @Parsed(field = "城市")
    private String city;
    @Parsed(field = "省份")
    private String province;

    @Parsed(field = "试驾车型详细")
    private String car;

    @Parsed(field = "备注")
    private String remark;

    @Override
    public String toString() {
        return "SendLeadRecord{" + "name=" + name + ", mobile=" + mobile + ", series=" + series + ", dealercode=" + dealercode + ", media=" + media + ", hiname=" + hiname + ", catetype=" + catetype + ", lowname=" + lowname + ", ctime=" + ctime + ", city=" + city + ", province=" + province + ", car=" + car + ", remark=" + remark + '}';
    }
    
    
}
