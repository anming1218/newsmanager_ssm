package com.ming.ssm.domain;
import java.io.Serializable;

/**
 *@program: newsmannager_ssm
 *@description: 主题的实体类
 *@author: ming
 *@create: 2020-07-30 12:48
 */
public class Topic implements Serializable {
    private String tid;
    private String topicname;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }
}
