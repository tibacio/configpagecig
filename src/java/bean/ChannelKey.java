/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author shengd
 */
public class ChannelKey {
    private String ukey;
    private String media;
    private String cname;    
    private String tname;
    private int smartcode;
    private String ckey;

    public ChannelKey(String ckey) {
        this.ckey = ckey;
    }
    

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    public int getSmartcode() {
        return smartcode;
    }

    public void setSmartcode(int smartcode) {
        this.smartcode = smartcode;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }
            
}
