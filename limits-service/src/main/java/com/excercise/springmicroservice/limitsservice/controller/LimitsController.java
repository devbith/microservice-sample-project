package com.excercise.springmicroservice.limitsservice.controller;

import com.excercise.springmicroservice.limitsservice.beans.Limits;
import com.excercise.springmicroservice.limitsservice.configuration.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

  @Autowired
  private LimitsConfiguration limitsConfiguration;

  @GetMapping("/limits")
  public Limits retrieveLimits() {
    return new Limits(limitsConfiguration.getMinimum(), limitsConfiguration.getMaximum());
  }
}
