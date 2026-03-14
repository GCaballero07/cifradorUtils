package com.jaiba.cifrador.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaiba.cifrador.entity.RequestCifrado;

@RestController
@RequestMapping("/api")
public class CifradoController {

  @PostMapping("/descifrar")
  public String descifrar(@RequestBody RequestCifrado request) {
    System.out.println(request);
    return "me estas consumiendo";
  }

}
