package com.example.calculation.entity;

import java.util.ArrayList;
import java.util.List;

public class FormularList {

    List<String> _formularList = new ArrayList<String>();
    public FormularList() {

        //DATE
        _formularList.add("DATE");
        _formularList.add("DATEVALUE");
        _formularList.add("DAYS");
        _formularList.add("DAYS360");
        _formularList.add("EDATE");
        _formularList.add("EOMONTH");
        _formularList.add("HOUR");
        _formularList.add("MINUTE");
        _formularList.add("MINUTE");
        _formularList.add("ISOWEEKNUM");
        _formularList.add("MONTH");
        _formularList.add("NETWORKDAYS");
        _formularList.add("NETWORKDAYSINTL");
        _formularList.add("NOW");
        _formularList.add("TODAY");
        _formularList.add("WEEKDAY");
        _formularList.add("YEAR");
        _formularList.add("WEEKNUM");
        _formularList.add("WORKDAY");
        _formularList.add("WORKDAYINTL");
        _formularList.add("YEARFRAC");
        _formularList.add("AND");
        _formularList.add("FALSE");
        _formularList.add("IF");
        _formularList.add("IFS");
        _formularList.add("IFERROR");
        _formularList.add("IFNA");
        _formularList.add("NOT");
        _formularList.add("OR");
        _formularList.add("SWITCH");
        _formularList.add("TRUE");
        _formularList.add("XOR");

        //MATH
        _formularList.add("ABS");
        _formularList.add("ACOS");
        _formularList.add("ACOSH");
        _formularList.add("ACOT");
        _formularList.add("ACOTH");
        _formularList.add("AGGREGATE");
        _formularList.add("ARABIC");
        _formularList.add("ASIN");
        _formularList.add("ASINH");
        _formularList.add("ATAN");
        _formularList.add("ATAN2");
        _formularList.add("ATANH");
        _formularList.add("BASE");
        _formularList.add("CEILING");
        _formularList.add("CEILINGMATH");
        _formularList.add("CEILINGPRECISE");
        _formularList.add("COMBIN");
        _formularList.add("COMBINA");
        _formularList.add("COS");
        _formularList.add("COSH");
        _formularList.add("COT");
        _formularList.add("COTH");
        _formularList.add("CSC");
        _formularList.add("CSCH");
        _formularList.add("DECIMAL");
        _formularList.add("ERF");
        _formularList.add("ERFC");
        _formularList.add("EVEN");
        _formularList.add("EXP");
        _formularList.add("FACT");
        _formularList.add("FACTDOUBLE");
        _formularList.add("FLOOR");
        _formularList.add("FLOORMATH");
        _formularList.add("FLOORPRECISE");
        _formularList.add("EXP");
        _formularList.add("FACT");
        _formularList.add("FACTDOUBLE");
        _formularList.add("FLOOR");
        _formularList.add("FLOORMATH");
        _formularList.add("FLOORPRECISE");
        _formularList.add("GCD");
        _formularList.add("INT");
        _formularList.add("ISEVEN");
        _formularList.add("ISOCEILING");
        _formularList.add("ISODD");
        _formularList.add("LCM");
        _formularList.add("LN");
        _formularList.add("LOG");
        _formularList.add("LOG10");
        _formularList.add("MOD");
        _formularList.add("MROUND");
        _formularList.add("MULTINOMIAL");
        _formularList.add("ODD");
        _formularList.add("POWER");
        _formularList.add("PRODUCT");
        _formularList.add("QUOTIENT");
        _formularList.add("RADIANS");
        _formularList.add("RAND");
        _formularList.add("RANDBETWEEN");
        _formularList.add("ROUND");
        _formularList.add("ROUNDDOWN");
        _formularList.add("ROUNDUP");
        _formularList.add("SEC");
        _formularList.add("SECH");
        _formularList.add("SIGN");
        _formularList.add("SIN");
        _formularList.add("SINH");
        _formularList.add("SQRT");
        _formularList.add("SQRTPI");
        _formularList.add("SUBTOTAL");
        _formularList.add("SUM");
        _formularList.add("SUMIF");
        _formularList.add("SIGN");
        _formularList.add("SIN");
        _formularList.add("SINH");
        _formularList.add("SQRT");
        _formularList.add("SQRTPI");
        _formularList.add("SUBTOTAL");
        _formularList.add("SUM");
        _formularList.add("SUMIF");
        _formularList.add("SUMIFS");
        _formularList.add("SUMPRODUCT");
        _formularList.add("SUMSQ");
        _formularList.add("SUMX2MY2");
        _formularList.add("SUMXMY2");
        _formularList.add("TAN");
        _formularList.add("TANH");
        _formularList.add("TRUNC");

        //TEXT
        _formularList.add("CHAR");
        _formularList.add("CLEAN");
        _formularList.add("CODE");
        _formularList.add("CONCATENATE");
        _formularList.add("EXACT");
        _formularList.add("FIND");
        _formularList.add("LEFT");
        _formularList.add("LEN");
        _formularList.add("LOWER");
        _formularList.add("LOWER");
        _formularList.add("MID");
        _formularList.add("NUMBERVALUE");
        _formularList.add("PROPER");
        _formularList.add("REGEXEXTRACT");
        _formularList.add("REGEXMATCH");
        _formularList.add("REGEXREPLACE");
        _formularList.add("REPT");
        _formularList.add("RIGHT");
        _formularList.add("ROMAN");
        _formularList.add("SEARCH");
        _formularList.add("SPLIT");
        _formularList.add("SUBSTITUTE");
        _formularList.add("T");
        _formularList.add("TRIM");
        _formularList.add("UNICHAR");
        _formularList.add("UNICODE");
        _formularList.add("UPPER");

    }


    public String getFormular(String formulaExpression)
    {
        String algorithmFormular = "";
        for (String retval: formulaExpression.split("\\(", 2)){
            if(_formularList.contains(retval));
            {
                int index =   _formularList.indexOf(retval);
                algorithmFormular =_formularList.get(index);
                break;
            }
        }

        return  algorithmFormular;
    }


    public Boolean isExistFormular(String formulaExpression)
    {
          for (String retval: formulaExpression.split("\\(", 2)) {
           if(_formularList.contains(retval))
           {
               return  true;
           }
        }
;       return  false;
    }
}
