package com.example.project;

public class StuModel {
    public String name,adno,plce,dis,par,mob,eml,pass;

    public StuModel() {
    }

    public StuModel(String name, String adno, String plce, String dis, String par, String mob, String eml, String pass) {
        this.name = name;
        this.adno = adno;
        this.plce = plce;
        this.dis = dis;
        this.par = par;
        this.mob = mob;
        this.eml = eml;
        this.pass = pass;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdno() {
        return adno;
    }

    public void setAdno(String adno) {
        this.adno = adno;
    }

    public String getPlce() {
        return plce;
    }

    public void setPlce(String plce) {
        this.plce = plce;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEml() {
        return eml;
    }

    public void setEml(String eml) {
        this.eml = eml;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
