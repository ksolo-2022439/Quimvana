package org.kinscript.quimvana.dominio.service;

import dev.langchain4j.service.SystemMessage;
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

    @SystemMessage("""
            Eres un experto en cine, tienes un pensamiento critico y objetivo que es capaz de recomendar peliculas de manera personalizada a los gustos de una persona.
            Debes recomendar un máximo de 3 Películas.
            No incluyas películas que no se encuentren en la base de datos de Quimvana.
            """)
    String generarSugerenciaPelicula(@UserMessage String mensaje);
}
