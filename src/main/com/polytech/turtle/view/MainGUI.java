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
    public static final Dimension VGAP = new Dimension(1, 5);
    private static final Dimension HGAP = new Dimension(5, 1);

    private Sheet sheet;
    private JIntegerField textFieldStep = new JIntegerField();
    private JButton buttonMove = new JButton("Avancer");
    private JButton buttonRight = new JButton("Droite");
    private JButton buttonLeft = new JButton("Gauche");
    private JButton buttonUp = new JButton("Lever");
    private JButton buttonDown = new JButton("Baisser");
    private JButton buttonReset = new JButton("Effacer");
    private JButton buttonAddTurtle = new JButton("Nouvelle tortue");

    private JButton buttonSquare = new JButton("Carré");
    private JButton buttonPolygon = new JButton("Polygone");
    private JButton buttonSpiral = new JButton("Spiral");
    private JButton buttonManual = new JButton("Manuelle");
    private JButton buttonAutomatic = new JButton("Autonomes");
    private JButton buttonFlocking = new JButton("Flocking");

    private JMenuItem menuItemMove = new JMenuItem("Avancer");
    private JMenuItem menuItemRight = new JMenuItem("Droite");
    private JMenuItem menuItemLeft = new JMenuItem("Gauche");
    private JMenuItem menuItemUp = new JMenuItem("Lever Crayon");
    private JMenuItem menuItemDown = new JMenuItem("Baisser Crayon");
    private JMenuItem menuItemAddTurtle = new JMenuItem("Nouvelle tortue");


    private JMenuItem menuItemReset = new JMenuItem("Effacer");
    private JMenuItem menuItemQuit = new JMenuItem("Quitter");

    private JMenuItem menuItemHelp = new JMenuItem("Aide");
    private JMenuItem menuItemAbout = new JMenuItem("À propos");

    private JComboBox<String> colorList = new JComboBox<>();


    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
        getContentPane().add(sheet, "Center");
        this.pack();
    }

    public Sheet getSheet() {
        return sheet;
    }

    public JButton getButtonMove() {
        return buttonMove;
    }

    public JButton getButtonRight() {
        return buttonRight;
    }

    public JButton getButtonLeft() {
        return buttonLeft;
    }

    public JButton getButtonUp() {
        return buttonUp;
    }

    public JButton getButtonDown() {
        return buttonDown;
    }

    public JButton getButtonReset() {
        return buttonReset;
    }

    public JButton getButtonAddTurtle() {return buttonAddTurtle; }

    public JButton getButtonManual() {
        return buttonManual;
    }

    public JButton getButtonAutomatic() {
        return buttonAutomatic;
    }

    public JButton getButtonFlocking() {
        return buttonFlocking;
    }

    public JMenuItem getMenuItemMove() {
        return menuItemMove;
    }

    public JMenuItem getMenuItemRight() {
        return menuItemRight;
    }

    public JMenuItem getMenuItemLeft() {
        return menuItemLeft;
    }

    public JMenuItem getMenuItemUp() {
        return menuItemUp;
    }

    public JMenuItem getMenuItemDown() {
        return menuItemDown;
    }

    public JMenuItem getMenuItemAddTurtle() {return menuItemAddTurtle;}

    public JTextField getTextFieldStep() {
        return textFieldStep;
    }

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

    public JButton getButtonSquare() {
        return buttonSquare;
    }

    public JButton getButtonPolygon() {
        return buttonPolygon;
    }

    public JButton getButtonSpiral() {
        return buttonSpiral;
    }

    public int getStepValue() {
        return textFieldStep.getInt();
    }

    public JComboBox<String> getColorList() {
        return colorList;
    }

    public MainGUI() {
        super("un logo tout simple");
        logoInit();
    }

    private void logoInit() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(10, 10));

        // Boutons
        JToolBar toolBar = new JToolBar();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        getContentPane().add(buttonPanel, "North");

        toolBar.add(initButton(buttonReset, "Nouveau dessin"));

        toolBar.add(Box.createRigidArea(HGAP));
        toolBar.add(textFieldStep);

        toolBar.add(initButton(buttonMove,  "Avancer 50"));
        toolBar.add(initButton(buttonRight,  "Droite 45"));
        toolBar.add(initButton(buttonLeft, "Gauche 45"));
        toolBar.add(initButton(buttonUp,  "Lever Crayon"));
        toolBar.add(initButton(buttonDown, "Baisser Crayon"));
        toolBar.add(initButton(buttonAddTurtle, "Nouvelle tortue"));


        // Create the combo box
        toolBar.add(Box.createRigidArea(HGAP));
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

        JMenu menuCommandes = new JMenu("Commandes"); // on installe le premier menu
        menubar.add(menuCommandes);
        menuCommandes.add(menuItemMove);
        menuCommandes.add(menuItemRight);
        menuCommandes.add(menuItemLeft);
        menuCommandes.add(menuItemUp);
        menuCommandes.add(menuItemDown);
        menuCommandes.add(menuItemAddTurtle);

        JMenu menuHelp = new JMenu("Aide"); // on installe le premier menu
        menubar.add(menuHelp);
        menuHelp.add(menuItemHelp);
        menuHelp.add(menuItemAbout);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // First row of button at the bottom
        JPanel bottomButtonPanel = new JPanel(new GridLayout(0,3));
        bottomButtonPanel.add(buttonManual);
        bottomButtonPanel.add(buttonAutomatic);
        bottomButtonPanel.add(buttonFlocking);

        // Second row of button at the bottom
        bottomButtonPanel.add(buttonSquare);
        bottomButtonPanel.add(buttonPolygon);
        bottomButtonPanel.add(buttonSpiral);

        getContentPane().add(bottomButtonPanel, "South");
        //getContentPane().add(p2, "South");

        pack();
        setVisible(true);
    }

    private JButton initButton(JButton button, String tooltipText) {
        button.setToolTipText(tooltipText);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setMargin(new Insets(0, 0, 0, 0));
        return button;
    }
}
