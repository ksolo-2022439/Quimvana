package org.kinscript.quimvana.web.controller;

import lombok.Value;
import org.kinscript.quimvana.dominio.service.AiServiceQuimvana;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    private final AiServiceQuimvana aiService;

    public HolaController(AiServiceQuimvana aiService) {
        this.aiService = aiService;
    }


    @GetMapping("/hola")
    public String holaMundo() {return this.aiService.generarSaludo();}

}
