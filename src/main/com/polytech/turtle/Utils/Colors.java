package com.polytech.turtle.Utils;

import java.awt.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

/**
 * Created by p1508754 on 10/05/2017.
 */
public enum Colors {

    NOIRE(Color.black),
    BLEU(Color.blue),
    CYAN(Color.cyan),
    GRIS_FONCE(Color.darkGray),
    ROUGE(Color.red),
    VERT(Color.green),
    GRIS_CLAIRE(Color.lightGray),
    MAGENTA(Color.magenta),
    ORANGE(Color.orange),
    GRIS(Color.gray),
    ROSE(Color.pink),
    JAUNE(Color.yellow);

    private static Color color;

    public static Color getColor() {
        return color;
    }

    Colors(Color color) {

    }

    public static Color getColor(String colorName)
    {
        return Colors.valueOf(colorName).getColor();
    }


    public static List<String> getAllColorsName(){
        return Stream.of(Colors.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
