package org.kinscript.quimvana.dominio.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AiServiceQuimvana {
    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de peliculas Quimvana.
            Usa menos de 120 caracteres y hazlo con el buen estilo Chapin.
            """)
    String generarSaludo();
}
