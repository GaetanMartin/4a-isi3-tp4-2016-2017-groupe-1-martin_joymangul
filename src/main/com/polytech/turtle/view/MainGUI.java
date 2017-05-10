package main.com.polytech.turtle.view;// package logo;

import main.com.polytech.turtle.model.Turtle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/*************************************************************************

 Un petit Logo minimal qui devra etre ameliore par la suite

 J. Ferber - 1999-2001

 Cours de DESS TNI - Montpellier II

 @version 2.0
 @date 25/09/


 **************************************************************************/


public class MainGUI extends JFrame {
    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);

    private Sheet sheet;
    private JTextField textFieldStep = new JTextField();
    private JButton buttonMove = new JButton("Avancer");
    private JButton buttonRight = new JButton("Droite");
    private JButton buttonLeft = new JButton("Gauche");
    private JButton buttonUp = new JButton("Lever");
    private JButton buttonDown = new JButton("Baisser");
    private JButton buttonReset = new JButton("Effacer");

    private JButton buttonSquare = new JButton("Carré");
    private JButton buttonPolygon = new JButton("Polygone");
    private JButton buttonSpiral = new JButton("Spiral");

    private JMenuItem menuItemMove = new JMenuItem("Avancer");
    private JMenuItem menuItemRight = new JMenuItem("Droite");
    private JMenuItem menuItemLeft = new JMenuItem("Gauche");
    private JMenuItem menuItemUp = new JMenuItem("Lever Crayon");
    private JMenuItem menuItemDown = new JMenuItem("Baisser Crayon");

    private JMenuItem menuItemReset = new JMenuItem("Effacer");
    private JMenuItem menuItemQuit = new JMenuItem("Quitter");

    private JMenuItem menuItemHelp = new JMenuItem("Aide");
    private JMenuItem menuItemAbout = new JMenuItem("À propos");

    private String[] colorStrings = {"noir", "bleu", "cyan", "gris fonce", "rouge",
            "vert", "gris clair", "magenta", "orange",
            "gris", "rose", "jaune"};

    private JComboBox colorList = new JComboBox(colorStrings);


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

    public JComboBox getColorList() {
        return colorList;
    }

    public String getStepValue() {
        String s = textFieldStep.getText();
        return (s);
    }

    public MainGUI() {
        super("un logo tout simple");
        logoInit();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void logoInit() {
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

        JMenu menuHelp = new JMenu("Aide"); // on installe le premier menu
        menubar.add(menuHelp);
        menuHelp.add(menuItemHelp);
        menuHelp.add(menuItemAbout);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // les boutons du bas
        JPanel p2 = new JPanel(new GridLayout());
        p2.add(buttonSquare);
        p2.add(buttonPolygon);
        p2.add(buttonSpiral);

        getContentPane().add(p2, "South");

        pack();
        setVisible(true);
    }

    public JButton initButton(JButton button, String tooltipText) {
        button.setToolTipText(tooltipText);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setMargin(new Insets(0, 0, 0, 0));
        return button;
    }
}
