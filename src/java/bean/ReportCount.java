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
public class ReportCount {

    @Parsed(field = "day")
    private String day;

    @Parsed(field = "LARGER_REGION_CODE")
    private String rsd;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRsd() {
        return rsd;
    }

    public void setRsd(String rsd) {
        this.rsd = rsd;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
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

    @Parsed(field = "count")
    private int count;

    @Parsed(field = "month")
    private int month;

    @Parsed(field = "year")
    private int year;

    @Parsed(field = "week")
    private int week;

    @Parsed(field = "media")
    private String media;

    @Parsed(field = "HighLvlChannelName")
    private String Hiname;

    @Parsed(field = "catetype")
    private String catename;

    @Parsed(field = "SERIES_NAME")
    private String series;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

}
