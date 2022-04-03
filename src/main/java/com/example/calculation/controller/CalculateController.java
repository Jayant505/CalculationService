package com.example.calculation.controller;

import com.example.calculation.entity.CalculationRequest;
import com.example.calculation.entity.CalculationResult;
import com.example.calculation.service.CalculationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @RequestMapping("/result")
      public CalculationResult CalculateResult(@RequestBody CalculationRequest request) {

        CalculationService  calService = new CalculationService();
        return  calService.Excute(request);
    }



}
