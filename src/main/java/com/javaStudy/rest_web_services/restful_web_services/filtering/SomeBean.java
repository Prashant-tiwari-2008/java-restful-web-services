package com.javaStudy.rest_web_services.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

//todo : read hwo to read documentation
//@JsonIgnoreProperties({"var1","var2"})
public class SomeBean {

    @JsonView(View.View1.class) // => for dynamic filtering
    private String var1;

//   @JsonIgnore  => or we can define at class level check class
    @JsonView(View.View2.class)  // => for dynamic filtering
    private String var2;

    @JsonView({View.View1.class, View.View2.class})  // => for dynamic filtering
    private String var3;

    public SomeBean(String var1, String var2, String var3) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                ", var3='" + var3 + '\'' +
                '}';
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

}
