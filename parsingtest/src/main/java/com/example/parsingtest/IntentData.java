package com.example.parsingtest;

import java.io.Serializable;

public class IntentData implements Serializable {

    int contentid;
    int contenttypeid;

    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
    }

    public int getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(int contenttypeid) {
        this.contenttypeid = contenttypeid;
    }
}
