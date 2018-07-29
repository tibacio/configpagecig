/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.univocity.parsers.annotations.Parsed;

/**
 *
 * @author shengd
 */
public class Dealer {

    @Parsed(field = "DEALER_ID")
    private String id;

    @Parsed(field = "DEALER_CODE")
    private String code;

    @Parsed(field = "DEALER_NAME")
    private String name;

    @Parsed(field = "FK_CITY_ID")
    private String city;

    @Parsed(field = "FK_PROVINCE_ID")
    private String province;

    @Parsed(field = "CITY_NAME")
    private String cname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getRsd() {
        return rsd;
    }

    public void setRsd(String rsd) {
        this.rsd = rsd;
    }

    @Parsed(field = "PROVINCE_NAME")
    private String pname;

    @Parsed(field = "LARGER_REGION_CODE")
    private String rsd;

}
