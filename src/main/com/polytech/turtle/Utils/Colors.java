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

    private Color color;

    public Color getColor() {
        return color;
    }

    Colors(Color color) {
        this.color = color;
    }

    public Color getColor(String colorName)
    {
        return Colors.valueOf(colorName).getColor();
    }


    public List<String> getAllColorsName(){
        return Stream.of(Colors.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public Colors next()
    {
        return Colors.values()[(this.ordinal()+1) %  Colors.values().length];
    }
}
