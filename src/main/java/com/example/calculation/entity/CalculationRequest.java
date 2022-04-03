package com.example.calculation.entity;

public class CalculationRequest {

    private String a1;

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    private String a2;

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String[] paramList;

    public String[] getParamList() {
        return paramList;
    }

    public void setParamList(String[] paramList) {
        this.paramList = paramList;
    }

    private String formula;


    public String getFormula() {
        return formula;
    }
    public void setFormula(String formula) {
        this.formula = formula;
    }

}
