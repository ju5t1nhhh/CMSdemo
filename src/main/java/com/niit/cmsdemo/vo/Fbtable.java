package com.niit.cmsdemo.vo;

import com.niit.cmsdemo.domain.Fbanswer;
import com.niit.cmsdemo.domain.Fbquestion;

import java.io.Serializable;
import java.util.List;

public class Fbtable implements Serializable{

    private static final long serialVersionUID = -4710803910591792784L;

    private Fbquestion fbquestion;
    private List<Fbanswer> fbanswers;

    @Override
    public String toString() {
        return "Fbtable{" +
                "fbquestion=" + fbquestion +
                ", fbanswers=" + fbanswers +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Fbquestion getFbquestion() {
        return fbquestion;
    }

    public void setFbquestion(Fbquestion fbquestion) {
        this.fbquestion = fbquestion;
    }

    public List<Fbanswer> getFbanswers() {
        return fbanswers;
    }

    public void setFbanswers(List<Fbanswer> fbanswers) {
        this.fbanswers = fbanswers;
    }
}
