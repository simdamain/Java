package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.*;

public class Insert extends JPanel {

    private JLabel name;
    private JTextField nameEdit;
    private JLabel firstName;
    private JTextField firstNameEdit;
    private JLabel birthDate;
    private JSpinner birthDateSpinner;
    private JLabel hiringDate;
    private JSpinner hiringDateSpinner;
    private JLabel telNum;
    private JTextField telNumEdit;
    private JLabel eMail;
    private JTextField eMailEdit;
    private JLabel statut;
    private ButtonGroup statutGroup;
    private JCheckBox single,married;
    private JLabel localite;
    private JComboBox localiteEdit;
    private JPanel buttonPanel, formPanel;
    private JButton valid,reset,exit;
    private Container container;


    public Insert(Container container){
        setBounds(50,50,500,500);

        formPanel= new JPanel();
        formPanel.setLayout(new GridLayout(10,2,10,10));
        buttonPanel= new JPanel();


        name = new JLabel("Nom* :");
        firstName = new JLabel("Prénom* :");
        birthDate = new JLabel("Date de naissance* :");
        hiringDate = new JLabel("Date d'embauche* :");
        telNum = new JLabel("Numéro de téléphone :");
        eMail = new JLabel("Email :");
        statut = new JLabel("Statut :");
        localite = new JLabel("Localité* :");
        Calendar calendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);


        name.setHorizontalAlignment(SwingConstants.LEFT);
        firstName.setHorizontalAlignment(SwingConstants.LEFT);
        birthDate.setHorizontalAlignment(SwingConstants.LEFT);
        hiringDate.setHorizontalAlignment(SwingConstants.LEFT);
        telNum.setHorizontalAlignment(SwingConstants.LEFT);
        eMail.setHorizontalAlignment(SwingConstants.LEFT);
        statut.setHorizontalAlignment(SwingConstants.LEFT);
        localite.setHorizontalAlignment(SwingConstants.LEFT);

        Gestion g= new Gestion();

        nameEdit= new JTextField();
        firstNameEdit= new JTextField();

        birthDateSpinner= new JSpinner();
        birthDateSpinner.setModel(new SpinnerDateModel());
        birthDateSpinner.setEditor(new JSpinner.DateEditor(birthDateSpinner, "dd-MM-yyyy"));
        birthDateSpinner.setValue(calendar.getTime());
        birthDateSpinner.setModel(new SpinnerDateModel());
        birthDateSpinner.setMaximumSize(new SpinnerDateModel(new GregorianCalendar().getTime()));



        hiringDateSpinner= new JSpinner();
        hiringDateSpinner.setModel(new SpinnerDateModel());
        hiringDateSpinner.setEditor(new JSpinner.DateEditor(hiringDateSpinner, "dd-MM-yyyy"));
        telNumEdit= new JTextField();
        eMailEdit= new JTextField();
        single= new JCheckBox("Célibataire",false);
        single.addActionListener(g);
        married= new JCheckBox("Marié",false);
        married.addActionListener(g);
        localiteEdit = new JComboBox();

        nameEdit.setHorizontalAlignment(SwingConstants.LEFT);
        firstNameEdit.setHorizontalAlignment(SwingConstants.LEFT);
        telNumEdit.setHorizontalAlignment(SwingConstants.LEFT);
        eMailEdit.setHorizontalAlignment(SwingConstants.LEFT);
        single.setHorizontalAlignment(SwingConstants.LEFT);
        married.setHorizontalAlignment(SwingConstants.LEFT);


        formPanel.add(name);
        formPanel.add(nameEdit);
        formPanel.add(firstName);
        formPanel.add(firstNameEdit);
        formPanel.add(birthDate);
        formPanel.add(birthDateSpinner);
        formPanel.add(hiringDate);
        formPanel.add(hiringDateSpinner);
        formPanel.add(telNum);
        formPanel.add(telNumEdit);
        formPanel.add(eMail);
        formPanel.add(eMailEdit);
        formPanel.add(statut);
        formPanel.add(single);
        formPanel.add(new JLabel());
        formPanel.add(married);
        formPanel.add(localite);
        formPanel.add(localiteEdit);
        formPanel.add(new JLabel("* champs obligatoires") );



        this.add(formPanel,BorderLayout.CENTER);

        valid= new JButton("Valider");
        reset= new JButton("Réinitialiser");
        exit= new JButton("Retour");

        buttonPanel.add(valid);
        valid.addActionListener(g);
        buttonPanel.add(reset);
        reset.addActionListener(g);
        buttonPanel.add(exit);
        exit.addActionListener(g);

        this.add(buttonPanel,BorderLayout.SOUTH);
        setVisible(true);

    }

    private class Gestion implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           if(e.getSource() ==single){
               married.setSelected(false);
               single.setSelected(true);
           }
           if(e.getSource() == married){
               married.setSelected(true);
               single.setSelected(false);
           }

           if(e.getSource() == valid){
                   Boolean erreur = false;
                   if(nameEdit != null ){

                   }
                   String regex="^[\\w\\-\\+]+(\\.[\\w\\-]+)*@[\\w\\-]+(\\.[\\w\\-]+)*\\.[\\w\\-]{2,4}$";
                   Pattern pattern= Pattern.compile(regex);
                   Matcher matcher= pattern.matcher(eMailEdit.getText());
                   if (!matcher.find()){
                       eMail.setForeground(Color.red);
                       erreur= true;
                   }

                   if(erreur){
                       JOptionPane.showMessageDialog(null,"Vous ne respecter pas les caractéristiques");
                   }

            }
           if(e.getSource() == reset){
               nameEdit.setText("");
               firstNameEdit.setText("");
               Calendar calendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);
               birthDateSpinner.setValue(calendar.getTime());
               hiringDateSpinner.setValue(new GregorianCalendar().getTime());
               telNumEdit.setText("");
               eMailEdit.setText("");
               single.setSelected(false);
               married.setSelected(false);



           }
           if(e.getSource() ==exit){
                container.removeAll();
                MainFrame.getContainer().repaint();
                repaint();
            }

        }
    }
}
