package com.example.project;

public class Model {
   public String code,titl,desc,auth,publ,type,pric;

    public Model() {
    }

    public Model(String code, String titl, String desc, String auth, String publ, String type, String pric) {
        this.code = code;
        this.titl = titl;
        this.desc = desc;
        this.auth = auth;
        this.publ = publ;
        this.type = type;
        this.pric = pric;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitl() {
        return titl;
    }

    public void setTitl(String titl) {
        this.titl = titl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getPubl() {
        return publ;
    }

    public void setPubl(String publ) {
        this.publ = publ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPric() {
        return pric;
    }

    public void setPric(String pric) {
        this.pric = pric;
    }
}
