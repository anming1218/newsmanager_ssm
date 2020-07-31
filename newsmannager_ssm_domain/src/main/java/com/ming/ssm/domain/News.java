package com.ming.ssm.domain;
import com.ming.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *@program: newsmannager_ssm
 *@description: 新闻的实体类
 *@author: ming
 *@create: 2020-07-30 12:46
 */
public class News implements Serializable {
    private String nid;
    private Topic topic;
    private String title;
    private String author;
    private String summary;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creattime;
    private String creattimeStr;
    private String creatby;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifytime;
    private String modifytimeStr;
    private String modifyby;
    private int frequency;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getCreattimeStr() {
        if (creattime != null) {
            creattimeStr = DateUtils.dateToString(creattime, "yyyy-MM-dd HH:mm:ss");
        }
        return creattimeStr;
    }

    public void setCreattimeStr(String creattimeStr) {
        this.creattimeStr = creattimeStr;
    }

    public String getModifytimeStr() {
        if (modifytime != null) {
            modifytimeStr = DateUtils.dateToString(modifytime, "yyyy-MM-dd HH:mm:ss");
        }
        return modifytimeStr;
    }

    public void setModifytimeStr(String modifytimeStr) {
        this.modifytimeStr = modifytimeStr;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getCreatby() {
        return creatby;
    }

    public void setCreatby(String creatby) {
        this.creatby = creatby;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getModifyby() {
        return modifyby;
    }

    public void setModifyby(String modifyby) {
        this.modifyby = modifyby;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
