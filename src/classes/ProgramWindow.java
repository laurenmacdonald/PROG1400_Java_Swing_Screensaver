package classes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProgramWindow extends JFrame {     //The class used as the main window for your GUI screensaver program.

    private JPanel contentPane;
    public ProgramWindow(){
        //Setting up window to hold program.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1050, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        //Make JPanel from DrawingPanel
        DrawingPanel drawing = new DrawingPanel();
        drawing.setBackground(new Color(243,235,255));

        //Adding DrawingPanel JPanel to window
        contentPane.add(drawing);
        drawing.setLayout(null);

    }
}
