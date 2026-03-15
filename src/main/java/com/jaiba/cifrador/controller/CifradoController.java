package com.jaiba.cifrador.controller;

import com.jaiba.cifrador.business.CifradoBusiness;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaiba.cifrador.entity.RequestCifrado;

@RestController
@RequestMapping("/api")
public class CifradoController {

  @PostMapping("/descifrar/mw")
  public String descifrarMW(@RequestBody RequestCifrado request) {
    CifradoBusiness cifradoBusiness = new CifradoBusiness(request);
    String vSalida = "Me estas consumiendo";


    return vSalida;
  }

  @PostMapping("/descifrar/mw/simetrico")
  public String descifrarMWSimetrico(@RequestBody RequestCifrado request) {
    CifradoBusiness cifradoBusiness = new CifradoBusiness(request);
    String vSalida = "Me estas consumiendo";


    return vSalida;
  }

  @PostMapping("/descifrar/alnova")
  public String descifrarAlnova(@RequestBody RequestCifrado request) {
    CifradoBusiness cifradoBusiness = new CifradoBusiness(request);
    String vSalida = "Me estas consumiendo";


    return vSalida;
  }

}
