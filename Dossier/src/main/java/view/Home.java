package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel {
        private Container container;
        private Button exit;


        public Home(){
            //MainFrame.super("Pairi Daiza");
            setBounds(50,50,500,500);


            exit = new Button("Fermer");
            exit.addActionListener(new CloseListener());


            this.add(exit,BorderLayout.SOUTH);



            setVisible(true);
        }

        private class CloseListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
}
