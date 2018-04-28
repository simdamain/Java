package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modification extends JPanel {
    private Container container;
    private JLabel name;
    private JComboBox nameEdit;
    private JLabel firstName;
    private JComboBox firstNameEdit;
    private JLabel birthDate;
    private JSpinner birthDateSpinner;
    private JLabel hiringDate;
    private JSpinner hiringDateSpinner;
    private JLabel telNum;
    private JTextField telNumEdit;
    private JLabel eMail;
    private JTextField eMailEdit;
    private JLabel statut;
    private JCheckBox single,married;
    private JLabel localite;
    private JComboBox localiteEdit;
    private JPanel buttonPanel, formPanel;
    private JButton valid,exit;


    public Modification(){
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


        name.setHorizontalAlignment(SwingConstants.LEFT);
        firstName.setHorizontalAlignment(SwingConstants.LEFT);
        birthDate.setHorizontalAlignment(SwingConstants.LEFT);
        hiringDate.setHorizontalAlignment(SwingConstants.LEFT);
        telNum.setHorizontalAlignment(SwingConstants.LEFT);
        eMail.setHorizontalAlignment(SwingConstants.LEFT);
        statut.setHorizontalAlignment(SwingConstants.LEFT);
        localite.setHorizontalAlignment(SwingConstants.LEFT);

        Gestion g= new Gestion();

        nameEdit= new JComboBox();
        firstNameEdit= new JComboBox();
        birthDateSpinner= new JSpinner();
        birthDateSpinner.setModel(new SpinnerDateModel());
        birthDateSpinner.setEditor(new JSpinner.DateEditor(birthDateSpinner, "dd-MM-yyyy"));
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
        exit= new JButton("Retour");

        buttonPanel.add(valid);
        buttonPanel.add(exit);

        this.add(buttonPanel,BorderLayout.SOUTH);
        setVisible(true);




    }

    private class Gestion implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() ==single){
                married.setSelected(false);
                single.setSelected(true);
            }
            if(e.getSource() == married){
                married.setSelected(true);
                single.setSelected(false);
            }


        }
    }
}
