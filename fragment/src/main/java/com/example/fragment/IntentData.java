package com.example.fragment;

import java.io.Serializable;

public class IntentData implements Serializable {

    int contenttypeid;
    int contentid;

    public int getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(int contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
    }
}
