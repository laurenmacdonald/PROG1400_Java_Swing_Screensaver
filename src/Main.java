import classes.ProgramWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Starting point for your GUI application
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProgramWindow frame = new ProgramWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
