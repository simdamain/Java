package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private Container container;
    private Button exit;
    private JMenuBar menuBar;
    private JMenu modifDB,workTask;
    private JMenuItem home,insertMenu,modificationMenu,delete,list;


    public MainFrame(){
        super("Pairi Daiza");
        setBounds(50,50,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar= new JMenuBar();
        home= new JMenu("Acceuil");
        modifDB = new JMenu("Modification de la base de donnée");
        workTask = new JMenu("Tâche métier");
        menuBar.add(home);
        menuBar.add(modifDB);
        menuBar.add(workTask);


        Gestion g= new Gestion();

        insertMenu= new JMenuItem("Insérer");
        modifDB.add(insertMenu);
        insertMenu.addActionListener(g);
        modificationMenu = new JMenuItem("Modifier");
        modifDB.add(modificationMenu);
        modificationMenu.addActionListener(g);
        delete= new JMenuItem("Supprimer");
        modifDB.add(delete);
        delete.addActionListener(g);
        list= new JMenuItem("Listing de la table");
        modifDB.add(list);
        list.addActionListener(g);


        exit = new Button("Fermer");
        exit.addActionListener(new CloseListener());

        container= getContentPane();
        container.add(exit,BorderLayout.SOUTH);

        setJMenuBar(menuBar);

        setVisible(true);
    }

    private class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class Gestion implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            if(e.getSource() == home)
            {
                container.removeAll();
                container.add(new MainFrame());
                container.repaint();
                setVisible(true);

            }
            if(e.getSource() == insertMenu)
            {
                container.removeAll();
                container.add(new Insert(container));
                container.repaint();
                setVisible(true);

            }
            if(e.getSource() == modificationMenu)
            {
                container.removeAll();
                container.add(new Modification());
                container.repaint();
                setVisible(true);
            }
        }
    }


}
