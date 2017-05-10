package main.com.polytech.turtle.view.components;

import javax.swing.*;
import javax.swing.text.Document;

public class JIntegerField extends JTextField {

    /**
     * Retrieve the contents of this field as an <TT>int</TT>.
     *
     * @return the contents of this field as an <TT>int</TT>.
     */
    public int getInt() {
        final String text = getText();
        if (text == null || text.length() == 0) {
            return 0;
        }
        return Integer.parseInt(text);
    }

    /**
     * Set the contents of this field to the passed int
     *
     * @param value The new value for this field.
     */
    public void setInt(int value) {
        setText(String.valueOf(value));
    }

    /**
     * Create a new document model for this control that only accepts
     * integral values.
     *
     * @return The new document model.
     */
    protected Document createDefaultModel() {
        return new IntegerDocument();
    }
}