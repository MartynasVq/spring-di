package com.spring.learndi.examplebeans;

public class FakeJmsSource {

    String jmsName;
    String jmsPassword;
    String jmsUrl;

    public String getSecondUrl() {
        return secondUrl;
    }

    public void setSecondUrl(String secondUrl) {
        this.secondUrl = secondUrl;
    }

    String secondUrl;

    public String getJmsName() {
        return jmsName;
    }

    public void setJmsName(String jmsName) {
        this.jmsName = jmsName;
    }

    public String getJmsPassword() {
        return jmsPassword;
    }

    public void setJmsPassword(String jmsPassword) {
        this.jmsPassword = jmsPassword;
    }

    public String getJmsUrl() {
        return jmsUrl;
    }

    public void setJmsUrl(String jmsUrl) {
        this.jmsUrl = jmsUrl;
    }
}
