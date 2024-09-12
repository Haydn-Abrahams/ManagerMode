package za.ca.cput;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class GUI extends JFrame implements ActionListener {
    
    private JFrame mainFrame;
    private JPanel panelNorth, panelSouth, panelCenter;
    private JButton btnSave, btnExit;
    private JComboBox cbxCLub;
    private JLabel lblfirstName, lbllastName, lblClub, lblimage;
    private JRadioButton rbFinTakeover, rbNoFinTakeover;
    private JTextField txtfirstName, txtlastName;
    private JCheckBox cbPreTournament;
    private ImageIcon icImage, image;
    private Image newImage;
    String first, last;
    
    public GUI () {
        super("FIFA: Manager Career Mode");
        
        //adding panels
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        
        //adding image
        icImage = new ImageIcon(getClass().getResource("Career mode.jpeg"));
        newImage = icImage.getImage().getScaledInstance(300, 150, Image.SCALE_DEFAULT);
        icImage = new ImageIcon(newImage);
        lblimage = new JLabel(icImage); 
        add(lblimage);
        //lblimage.setSize(20, 10);
        
        //adding text fields
        txtfirstName = new JTextField();
        txtlastName = new JTextField();
        
        //adding buttons
        btnSave = new JButton("Save and Exit");
        btnExit =new JButton("Exit");
        
        //adding labels
        lblfirstName = new JLabel("  First Name: ");
        lblClub = new JLabel("  Club: ");
        lbllastName = new JLabel("  Last Name: ");
        
        //adding combo box
        cbxCLub = new JComboBox();
        cbxCLub.addItem("Select Club");
        cbxCLub.addItem("Arsenal");
        cbxCLub.addItem("Aston Villa");
        cbxCLub.addItem("Brentford");
        cbxCLub.addItem("Brighton");
        cbxCLub.addItem("Burnley");
        cbxCLub.addItem("Chelsea");
        cbxCLub.addItem("Crystal Palace");
        cbxCLub.addItem("Everton");
        cbxCLub.addItem("Leeds");
        cbxCLub.addItem("Leicester");
        cbxCLub.addItem("Liverpool");
        cbxCLub.addItem("Manchester City");
        cbxCLub.addItem("Manchester United");
        cbxCLub.addItem("Tottenham");
        cbxCLub.addItem("Wolves");
        cbxCLub.addItem("West Ham");
        
                        
        //adding checkbox
        cbPreTournament = new JCheckBox("Pre-Season Tournament");
        
        //adding radio buttons
        rbFinTakeover = new JRadioButton("Financial Takeover");
        rbNoFinTakeover = new JRadioButton("No Financial Takeover");
   
    }    
   
    public void setGUI() {  
     
        // changing background colour 
        panelNorth.setBackground(new Color(76, 169, 179));
        panelCenter.setBackground(new Color(76, 169, 179));
        panelSouth.setBackground(Color.lightGray); 
        
        
        //adding image
        panelNorth.add(lblimage);
        
        //adding items to first row
        panelCenter.add(lblClub);
        panelCenter.add(cbxCLub);
        
        //adding items to second row
        panelCenter.add(lblfirstName);
        panelCenter.add(txtfirstName);
       
        //adding items to third row
        panelCenter.add(lbllastName);
        panelCenter.add(txtlastName);
        
        //adding itemes to 4th and 5th row
        panelCenter.add(rbFinTakeover);
        panelCenter.add(rbNoFinTakeover);
        panelCenter.add(cbPreTournament);
        
        panelCenter.setLayout(new GridLayout(5, 2));
        
        //adding buttons
        panelSouth.add(btnSave);
        panelSouth.add(btnExit);
        
        panelSouth.setLayout(new GridLayout(1, 2));
        
        btnSave.addActionListener(this);
        btnExit.addActionListener(this);
        
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
       
        //providing buttons with actions
        btnSave.addActionListener(this);
        btnExit.addActionListener(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(400, 450);
        
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String club = (String) cbxCLub.getSelectedItem();
        String name = txtfirstName.getText();
        String surname = txtlastName.getText();
        boolean finTakeover;
        boolean preTourn;
        
        if (rbFinTakeover.isSelected()) {
            finTakeover = true;
        } else 
            finTakeover = false;
        
        if (cbPreTournament.isSelected()) {
            preTourn = true;
        } else
            preTourn = false;

        Manager newManager = new Manager(club, name, surname, finTakeover, preTourn);
        
        try {
            if (e.getSource() == btnSave) {
                if (club.equalsIgnoreCase("Select Club")) {
                    //JOptionPane.showMessageDialog(null, "Please select a club");
                    newManager.writeToFile(false);
            
                } else if (name.isEmpty() || surname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in empty fields");
                    newManager.writeToFile(false);
        
                } else if (rbFinTakeover == null ) {//&& rbNoFinTakeover == null) {
                    JOptionPane.showMessageDialog(null, "Please select whether you will be having a financial takeover or not");
                    newManager.writeToFile(false);
        
                } else if (!name.matches("^[a-zA-Z]+$") ||!surname.matches("^[a-zA-Z]+$")){
                    JOptionPane.showMessageDialog(null, "Incorrect Data Type");
                    newManager.writeToFile(false);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Manager created");
                    newManager.writeToFile(true);
                }
                resetForm();
      
        
            } else if (e.getSource() == btnExit) {
                System.exit(0);
            }
            
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        }
    }

    public void resetForm() {
        txtfirstName.setText("");
        txtlastName.setText("");
        rbFinTakeover.setSelected(false);
        rbNoFinTakeover.setSelected(false);
        cbPreTournament.setSelected(false);
        cbxCLub.setSelectedIndex(0);
    }
}

