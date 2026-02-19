package com.example.setter_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class setterController {

  private isetter setvalue;

  @Autowired
  public void setSetvalue(isetter setvalue) {
    this.setvalue = setvalue;
  }

  @GetMapping("val")
  public String getValue() {
      return setvalue.getValue();
  }
  

}
