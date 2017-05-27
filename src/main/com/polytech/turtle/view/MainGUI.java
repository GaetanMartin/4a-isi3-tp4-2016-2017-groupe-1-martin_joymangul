package com.polytech.turtle.view;// package logo;

import com.polytech.turtle.view.components.JIntegerField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0


 **************************************************************************/


public class MainGUI extends JFrame {
    private Sheet sheet;
    private JButton buttonReset = new JButton("Effacer");
    private JButton buttonAddTurtle = new JButton("Nouvelle tortue");
    private JMenuItem menuItemAddTurtle = new JMenuItem("Nouvelle tortue");


    private JMenuItem menuItemReset = new JMenuItem("Effacer");
    private JMenuItem menuItemQuit = new JMenuItem("Quitter");

    private JMenuItem menuItemHelp = new JMenuItem("Aide");
    private JMenuItem menuItemAbout = new JMenuItem("À propos");

    private JComboBox<String> colorList = new JComboBox<>();
    JToolBar toolBar;
    JMenu menuCommandes;


    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
        getContentPane().add(sheet, "Center");
        this.pack();
    }

    public Sheet getSheet() {
        return sheet;
    }



    public JButton getButtonReset() {
        return buttonReset;
    }

    public JButton getButtonAddTurtle() {return buttonAddTurtle; }



    public JMenuItem getMenuItemAddTurtle() {return menuItemAddTurtle;}



    public JMenuItem getMenuItemReset() {
        return menuItemReset;
    }

    public JMenuItem getMenuItemQuit() {
        return menuItemQuit;
    }

    public JMenuItem getMenuItemHelp() {
        return menuItemHelp;
    }

    public JMenuItem getMenuItemAbout() {
        return menuItemAbout;
    }



    public JComboBox<String> getColorList() {
        return colorList;
    }

    public MainGUI() {
        super("un logo tout simple");
        logoInit();
    }

    protected void logoInit() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(10, 10));

        // Boutons
        toolBar = new JToolBar();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        getContentPane().add(buttonPanel, "North");

        toolBar.add(initButton(buttonReset, "Nouveau dessin"));

        toolBar.add(initButton(buttonAddTurtle, "Nouvelle tortue"));


        // Create the combo box
        JLabel colorLabel = new JLabel("   Couleur: ");
        toolBar.add(colorLabel);
        toolBar.add(colorList);


        // Menus
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);    // on installe le menu bar
        JMenu menuFile = new JMenu("File"); // on installe le premier menu
        menubar.add(menuFile);
        menuFile.add(menuItemReset);
        menuFile.add(menuItemQuit);

        menuCommandes = new JMenu("Commandes"); // on installe le premier menu
        menubar.add(menuCommandes);
        menuCommandes.add(menuItemAddTurtle);

        JMenu menuHelp = new JMenu("Aide"); // on installe le premier menu
        menubar.add(menuHelp);
        menuHelp.add(menuItemHelp);
        menuHelp.add(menuItemAbout);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pack();
        setVisible(true);
    }

    JButton initButton(JButton button, String tooltipText) {
        button.setToolTipText(tooltipText);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setMargin(new Insets(0, 0, 0, 0));
        return button;
    }
}
