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
public class Leads {
 

    @Parsed(field = "大区")
    private String rsd;

    public String getRsd() {
        return rsd;
    }

    public void setRsd(String rsd) {
        this.rsd = rsd;
    }


    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getHiname() {
        return Hiname;
    }

    public void setHiname(String Hiname) {
        this.Hiname = Hiname;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }


    @Parsed(field = "media")
    private String media;
    
    @Parsed(field = "小类")
    private String channel;

    @Parsed(field = "中类")
    private String Hiname;

    @Parsed(field = "大类")
    private String catename;

    @Parsed(field = "车系")
    private String series;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
    
   
    @Parsed(field = "创建时间")
    private String ctime;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    @Parsed(field = "经销商")
    private String dname;

    @Parsed(field = "代码")
    private String dcode;

    @Parsed(field = "小区")
    private String sd;
 
    
    @Parsed(field = "电话")
    private String mobile;
 
    
    @Parsed(field = "姓名")
    private String cname;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
 
    
}
