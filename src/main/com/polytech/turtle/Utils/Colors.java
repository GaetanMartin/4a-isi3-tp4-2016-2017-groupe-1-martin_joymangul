package com.polytech.turtle.Utils;

import java.awt.*;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by p1508754 on 10/05/2017.
 */
public class Colors {


    private static Map<String, Color> colors =
            Collections.unmodifiableMap(Stream.of(
                    new AbstractMap.SimpleEntry<>("Noire", Color.BLACK),
                    new AbstractMap.SimpleEntry<>("Bleu", Color.BLUE),
                    new AbstractMap.SimpleEntry<>("Cyan", Color.CYAN),
                    new AbstractMap.SimpleEntry<>("Gris Foncé", Color.DARK_GRAY),
                    new AbstractMap.SimpleEntry<>("Rouge", Color.RED),
                    new AbstractMap.SimpleEntry<>("Vert", Color.GREEN),
                    new AbstractMap.SimpleEntry<>("Gris Claire", Color.LIGHT_GRAY),
                    new AbstractMap.SimpleEntry<>("Magenta", Color.MAGENTA),
                    new AbstractMap.SimpleEntry<>("Orange", Color.ORANGE),
                    new AbstractMap.SimpleEntry<>("Gris", Color.GRAY),
                    new AbstractMap.SimpleEntry<>("Rose", Color.PINK),
                    new AbstractMap.SimpleEntry<>("Jaune", Color.YELLOW))
                    .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));

    public static List<String> getColorName()
    {
         return Colors.colors.keySet().stream()
                .sorted().collect(Collectors.toList());
    }

    public static List<Color> getColors()
    {
        return Colors.colors.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());
    }

    public static Color getColor(String ColorName)
    {
        return Colors.colors.entrySet().stream()
                .filter(e -> e.getKey().equals(ColorName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }
}
