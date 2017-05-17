package com.polytech.turtle.Utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by MOISSON Matthieu
 * on 14/05/2017.
 */
public class ColorsTest{

    @Before
    public void setUp() {
    }

    /*
        To verify if all principal colors are present.
     */
    @Test
    public void should_give_true_on_test_same_name_colors(){
        //Given
        List<String> colorsNameNeeded = getListNameColors();
        List<String> colorsNameFind;
        colorsNameFind = Colors.getColorName();
        //When
        //Then
        for (String aColorsNameNeeded : colorsNameNeeded) {
            assertThat(colorsNameFind.contains(aColorsNameNeeded)).isTrue();
        }
    }

    /*
        To verify if all principal colors are present.
     */
    @Test
    public void should_give_true_on_test_same_color(){
        //Given
        List<Color> colorsNeeded = getListColors();
        List<Color> colorsFind;
        colorsFind = Colors.getColors();
        //When
        //Then
        for (Color aColorsNeeded : colorsNeeded) {
            assertThat(colorsFind.contains(aColorsNeeded)).isTrue();
        }
    }

    @Test
    public void should_give_true_on_test_get_color_by_string(){
        //Given
        List<Color> colorsNeeded = getListColors();
        List<String> colorsNameNeeded = getListNameColors();
        //When
        //Then
        for(int i = 0; i < colorsNameNeeded.size(); i++){
            assertThat(Colors.getColor(colorsNameNeeded.get(i)) == colorsNeeded.get(i)).isTrue();
        }
    }

    @After
    public void testApresTeste(){
    }

    private List<Color> getListColors(){
        List<Color> colorsNeeded = new ArrayList<>();
        colorsNeeded.add(Color.BLACK);
        colorsNeeded.add(Color.BLUE);
        /*
        colorsNeeded.add(Color.CYAN);
        colorsNeeded.add(Color.DARK_GRAY);
        colorsNeeded.add(Color.RED);
        colorsNeeded.add(Color.GREEN);
        colorsNeeded.add(Color.lightGray);
        colorsNeeded.add(Color.MAGENTA);
        colorsNeeded.add(Color.ORANGE);
        colorsNeeded.add(Color.GRAY);
        */
        colorsNeeded.add(Color.PINK);
        colorsNeeded.add(Color.YELLOW);
        return colorsNeeded;
    }

    private List<String> getListNameColors(){
        List<String> colorsNameNeeded = new ArrayList<>();
        colorsNameNeeded.add("Noire");
        colorsNameNeeded.add("Bleu");
        /*
        colorsNameNeeded.add("Cyan");
        colorsNameNeeded.add("Gris Foncé");
        colorsNameNeeded.add("Rouge");
        colorsNameNeeded.add("Vert");
        colorsNameNeeded.add("Gris Claire");
        colorsNameNeeded.add("Magenta");
        colorsNameNeeded.add("Orange");
        colorsNameNeeded.add("Gris");
        */
        colorsNameNeeded.add("Rose");
        colorsNameNeeded.add("Jaune");
        return colorsNameNeeded;
    }
}
