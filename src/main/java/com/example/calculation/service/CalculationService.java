package com.example.calculation.service;
import com.example.calculation.entity.CalculationRequest;
import com.example.calculation.entity.CalculationResult;
import com.example.calculation.entity.FormularList;
import sun.security.ec.point.ProjectivePoint;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CalculationService {

    private  ScriptEngineManager engineManager;
    private  ScriptEngine engine;

    private  FormularList formularList;
    public CalculationService() {

        engineManager = new ScriptEngineManager();
        engine = engineManager.getEngineByName("nashorn");
        formularList = new FormularList();
    }

    public CalculationResult Excute(CalculationRequest request)
    {
        CalculationResult result = new CalculationResult();
        if(formularList.isExistFormular(request.getFormula())){
             String formula =  formularList.getFormular((request.getFormula()));

            int paramLength = request.paramList.length + 2;
            Object[] paramValuleList = new Object[paramLength];
            paramValuleList[0] = request.getA1();
            paramValuleList[1] = request.getA2();
            for (int i = 0; i < request.paramList.length; i++) {
                paramValuleList[i+2] =  request.paramList[i];
            }

            String formulaExpress = request.getFormula();
            int beginIndex =formulaExpress.indexOf("(")+1;
            int endIndex =formulaExpress.indexOf(")");
            formulaExpress = formulaExpress.substring(beginIndex,endIndex);
            String [] paramExpressList = formulaExpress.split(",");
            Object[] actualParamList = new Object[paramExpressList.length];
            Object[] retParamList = new Object[paramExpressList.length];

            //Replace A1,A2,A3 Value
            for (int i = 0; i < paramExpressList.length; i++) {

                String paramItemExpress =  paramExpressList[i];

                for (int j = 0; j < paramValuleList.length; j++) {

                    String paramName = String.format("A%d", j+1);
                    String paramValue =String.valueOf(paramValuleList[j]);
                    if(paramItemExpress.contains((paramName)))
                    {
                        actualParamList[i] = paramItemExpress.replace(paramName,paramValue);
                        retParamList[i] = paramItemExpress.replace(paramName,paramValue);
                        if (String.valueOf(actualParamList[i]).contains("="))
                        {
                             String parameExpress =String.valueOf(actualParamList[i]);
                             String logicResut = ExcuteExpression(parameExpress);
                             if(logicResut.toLowerCase()== "true")
                             {
                                 actualParamList[i] = true;

                             }
                             else
                             {
                                 actualParamList[i] = false;
                             }
                        }

                        break;
                    }

                    if(j == paramValuleList.length-1)
                    {
                        actualParamList[i] = paramItemExpress;
                        retParamList[i]  = paramItemExpress;
                    }
                }
            }

            // Calculation Result

             String finalResult =  this.ExcuteFormula(formula,actualParamList);

            // Build Final Result
             StringBuilder paramStrList = new StringBuilder();
            for (Object retval: retParamList)
            {
                paramStrList.append(String.valueOf(retval));
                paramStrList.append(',');
            }
            paramStrList.deleteCharAt(paramStrList.length()-1);
            String calculationExperss = String.format("%s(%s)",formula,paramStrList.toString());
            result.setResult(finalResult);
            result.setCalculationExperss(calculationExperss);
        }
        else
        {
            String formula = request.getFormula();
            formula =  formula.replace("A1",String.valueOf(request.getA1()));
            formula =  formula.replace("A2",String.valueOf(request.getA2()));

            for (int j = 0; j < request.paramList.length; j++) {
               String paramName = String.format("A%d", j+3);
               formula =  formula.replace(paramName, String.valueOf( request.paramList[j]));
            }
            String finalResult = this.ExcuteExpression(formula);
            result.setResult(finalResult);
            result.setCalculationExperss(formula);
        }

        return result;
    }

    public String ExcuteExpression(String expression)
    {
           String  result = "";
            try
            {
                result = String.valueOf(engine.eval(expression));
            }
            catch (javax.script.ScriptException e)
            {
                e.printStackTrace();
                System.out.println("excute failed");
            }
            return  result;
    }

    public String ExcuteFormula(String expression, Object... params)
    {
        String  result = "";
        try
        {
            engine.eval(new FileReader("src/main/resources/static/js/formula.min.js"));
            Invocable invocable = (Invocable) engine;
            System.out.println("Begin to Calculation");
            Object formulajs = engine.eval("formulajs");
            result = String.valueOf(invocable.invokeMethod(formulajs, expression, params));

            System.out.println("end to Calculation");
        }
        catch (javax.script.ScriptException e)
        {
            e.printStackTrace();
            System.out.println("excute failed");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("File not found");
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return  result;
    }




}

