package com.niit.cmsdemo.vo;

import com.niit.cmsdemo.domain.StuSource;

import java.io.Serializable;
import java.util.List;

public class StuSourceResponse implements Serializable{

    private static final long serialVersionUID = 9115693895129394145L;

    private StuSource stuSource;
    private List<StuSource> sonStuSources;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StuSource getStuSource() {
        return stuSource;
    }

    public void setStuSource(StuSource stuSource) {
        this.stuSource = stuSource;
    }

    public List<StuSource> getSonStuSources() {
        return sonStuSources;
    }

    public void setSonStuSources(List<StuSource> sonStuSources) {
        this.sonStuSources = sonStuSources;
    }

    @Override
    public String toString() {
        return "StuSourceResponse{" +
                "stuSource=" + stuSource +
                ", sonStuSources=" + sonStuSources +
                '}';
    }
}
