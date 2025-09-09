package org.kinscript.quimvana.persistence.mapper;

import org.kinscript.quimvana.dominio.Gender;
import org.mapstruct.Named;

public class GenderMapper {

    @Named("generarGender")
    public static Gender generarGender(String genero) {
        if (genero == null) return null;

        return switch (genero.toUpperCase()) {
            case "ACCION" -> Gender.ACTION;
            case "ANIMADA" -> Gender.ANIMATED;
            case "CIENCIA_FICCION" -> Gender.SCI_FY;
            case "CRIMEN" -> Gender.CRIME;
            case "DRAMA" -> Gender.DRAMA;
            case "DRAMA_BELICO" -> Gender.BELIC_DRAMA;
            case "FANTASIA" -> Gender.FANTASY;
            case "SUSPENSO" -> Gender.SUSPENSE;
            case "TERROR" -> Gender.HORROR;
            default -> null;

        };
    }

    @Named("generarGenero")
    public static String generarGenero(Gender gender) {
        if (gender == null) return null;

        return switch (gender) {
            case Gender.ACTION -> "ACCION";
            case Gender.ANIMATED -> "ANIMADA";
            case Gender.SCI_FY -> "CIENCIA_FICCION";
            case Gender.CRIME -> "CRIMEN";
            case Gender.DRAMA -> "DRAMA";
            case Gender.BELIC_DRAMA -> "DRAMA_BELICO";
            case Gender.FANTASY -> "FANTASY";
            case Gender.SUSPENSE -> "SUSPENSE";
            case Gender.HORROR -> "TERROR";
            default -> null;
        };
    }
}