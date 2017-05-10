package com.polytech.turtle.view.components;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

/**
 * Created by p1509413 on 10/05/2017.
 * Enables the input of integer only
 */
class IntegerDocument extends PlainDocument {

    /**
     * Blocks other than integer inputs
     * @param offs @see PlainDocument
     * @param str @see PlainDocument
     * @param a  @see PlainDocument
     * @throws BadLocationException @see PlainDocument
     */
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str != null) {
            try {
                Integer.decode(str);
                super.insertString(offs, str, a);
            } catch (NumberFormatException ex) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
