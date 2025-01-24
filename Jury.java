package Fatwaj;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
public class Jury extends JFrame implements ActionListener {
	private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel titleLabel,blankLabel2, fnLabel1, tlLabel1,lnLabel1,fnLabel2, tlLabel2,blankLabel,lnLabel2, fnLabel3, tlLabel3,lnLabel3, fnLabel4, tlLabel4,lnLabel4;
    private  JTextField fnTf1,lnTf1,fnTf2,lnTf2,fnTf3,lnTf3,fnTf4,lnTf4;
    private JButton addButton,clearButton,deleteButton;
    private String[] rows = new String[9];
    private String[] columns = {"prenompres", "nompres", "prenomrapp", "nomrapp","prenomexamin", "nomprexamin","prenomenca", "nomenca",};


	Jury(){
        initComponents();
    }
    public void initComponents(){
        
    // this.setDefaultCloseOperation(JFrame.EXIT ON CLOSE);
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setTitle("Jury Group");
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(255, 204, 204)); // Couleur de fond légèrement rose
        
        Font titleFont = new Font("Arial", Font.BOLD, 24); // Augmentation de la taille de la police du titre
        Font labelFont = new Font("Arial", Font.BOLD, 18); // Police de taille supérieure pour les libellés
        Font buttonFont = new Font("Arial", Font.BOLD, 16); // Police de taille supérieure pour le bouton

        titleLabel = new JLabel("Les jurys : ");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(80, 10, 300, 30); // Ajustement de la position et de la taille
        c.add(titleLabel);
        

        
        tlLabel1 = new JLabel("le président :");
        tlLabel1.setBounds(40, 40, 300, 20);
        tlLabel1.setFont(labelFont);
        c.add(tlLabel1);
        
        

        
        fnLabel1 = new JLabel("Prenom:");
        fnLabel1.setBounds(40, 80, 80, 20);
        fnLabel1.setFont(labelFont);
        c.add(fnLabel1);
        
        fnTf1 = new JTextField();
        fnTf1.setBounds(130, 80, 200, 25); // Ajustement de la position et de la taille
        fnTf1.setFont(labelFont);
        c.add(fnTf1);

        lnLabel1 = new JLabel("Nom:");
        lnLabel1.setBounds(40, 120, 80, 20); // Ajustement de la position
        lnLabel1.setFont(labelFont);
        c.add(lnLabel1);
        
        lnTf1 = new JTextField();
        lnTf1.setBounds(130, 120, 200, 25); // Ajustement de la position et de la taille
        lnTf1.setFont(labelFont);
        c.add(lnTf1);
       
        
        
        tlLabel2 = new JLabel("le rapporteur :");
        tlLabel2.setBounds(40, 150, 300, 20);
        tlLabel2.setFont(labelFont);
        c.add(tlLabel2);
        
        

        
        fnLabel2 = new JLabel("Prenom:");
        fnLabel2.setBounds(40, 180, 80, 20);
        fnLabel2.setFont(labelFont);
        c.add(fnLabel2);
        
        fnTf2 = new JTextField();
        fnTf2.setBounds(130, 180, 200, 25); // Ajustement de la position et de la taille
        fnTf2.setFont(labelFont);
        c.add(fnTf2);

        lnLabel2 = new JLabel("Nom:");
        lnLabel2.setBounds(40, 220, 80, 20); // Ajustement de la position
        lnLabel2.setFont(labelFont);
        c.add(lnLabel2);
        
        lnTf2 = new JTextField();
        lnTf2.setBounds(130, 220, 200, 25); // Ajustement de la position et de la taille
        lnTf2.setFont(labelFont);
        c.add(lnTf2);


        
        tlLabel3 = new JLabel("l'examinateur :");
        tlLabel3.setBounds(40, 250, 300, 20);
        tlLabel3.setFont(labelFont);
        c.add(tlLabel3);
        
        

        
        fnLabel3 = new JLabel("Prenom:");
        fnLabel3.setBounds(40, 280, 80, 20);
        fnLabel3.setFont(labelFont);
        c.add(fnLabel3);
        
        fnTf3 = new JTextField();
        fnTf3.setBounds(130, 280, 200, 25); // Ajustement de la position et de la taille
        fnTf3.setFont(labelFont);
        c.add(fnTf3);

        lnLabel3 = new JLabel("Nom:");
        lnLabel3.setBounds(40, 320, 80, 20); // Ajustement de la position
        lnLabel3.setFont(labelFont);
        c.add(lnLabel3);
        
        lnTf3 = new JTextField();
        lnTf3.setBounds(130, 320, 200, 25); // Ajustement de la position et de la taille
        lnTf3.setFont(labelFont);
        c.add(lnTf3);
        
        
        
        tlLabel4 = new JLabel("l'encadreur :");
        tlLabel4.setBounds(40, 350, 300, 20);
        tlLabel4.setFont(labelFont);
        c.add(tlLabel4);
        
        

        
        fnLabel4 = new JLabel("Prenom:");
        fnLabel4.setBounds(40, 380, 80, 20);
        fnLabel4.setFont(labelFont);
        c.add(fnLabel4);
        
        fnTf4 = new JTextField();
        fnTf4.setBounds(130, 380, 200, 25); // Ajustement de la position et de la taille
        fnTf4.setFont(labelFont);
        c.add(fnTf4);

        lnLabel4 = new JLabel("Nom:");
        lnLabel4.setBounds(40, 420, 80, 20); // Ajustement de la position
        lnLabel4.setFont(labelFont);
        c.add(lnLabel4);
        
        lnTf4 = new JTextField();
        lnTf4.setBounds(130, 420, 200, 25); // Ajustement de la position et de la taille
        lnTf4.setFont(labelFont);
        c.add(lnTf4);


        
        JButton addButton = new JButton("Ajouter");
        addButton.setBounds(40, 450, 100, 30);
        addButton.setFont(buttonFont);
        c.add(addButton);

        // Bouton Supprimer
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.setBounds(160, 450, 100, 30);
        deleteButton.setFont(buttonFont);
        c.add(deleteButton);

        // Bouton Date
        JButton dateButton = new JButton("Date");
        dateButton.setBounds(280, 450, 100, 30);
        dateButton.setFont(buttonFont);
        c.add(dateButton);
        
        
        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setSelectionBackground(Color.GREEN);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10, 500, 740, 250);
        c.add(scroll);

        
        /*addButton.addActionListener(this);*/
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ajoutez l'étudiant à la table
                addStudentToTable();

                // Affichez le nouveau frame
                displayNewFrame();
            }
        });
        dateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                int numberOfRow = table.getSelectedRow();

                String f_name = model.getValueAt(numberOfRow, 0).toString();
                String l_name = model.getValueAt(numberOfRow, 1).toString();
                String f_name2 = model.getValueAt(numberOfRow, 2).toString();
                String l_name2 = model.getValueAt(numberOfRow, 3).toString();
                String f_name3 = model.getValueAt(numberOfRow, 4).toString();
                String l_name3 = model.getValueAt(numberOfRow, 5).toString();
                String f_name4 = model.getValueAt(numberOfRow, 6).toString();
                String l_name4 = model.getValueAt(numberOfRow, 7).toString();

                fnTf1.setText(f_name);
                lnTf1.setText(l_name);
                fnTf2.setText(f_name2);
                lnTf2.setText(l_name2);
                fnTf2.setText(f_name3);
                lnTf2.setText(l_name3);
                fnTf2.setText(f_name4);
                lnTf2.setText(l_name4);
            }
        });}
    
private void addStudentToTable() {
    // Récupérez les valeurs des champs
    String firstNameP = fnTf1.getText();
    String lastNameP = lnTf1.getText();
    String firstNameR = fnTf2.getText();
    String lastNameR = lnTf2.getText();
    String firstNameEX = fnTf3.getText();
    String lastNameEX = lnTf3.getText();
    String firstNameEN = fnTf4.getText();
    String lastNameEN = lnTf4.getText();

    // Ajoutez les valeurs à la table
    model.addRow(new Object[]{firstNameP, lastNameP, firstNameR, lastNameR,firstNameEX, lastNameEX, firstNameEN, lastNameEN});
    }
     
    private void displayNewFrame() {
        /// Création d'un objet Date pour obtenir la date actuelle
        Date currentDate = new Date();

        // Formatage de la date pour l'affichage dans la boîte de message
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        // Création du message à afficher dans la boîte de message
        String message = "La date actuelle est : " + formattedDate;

        // Affichage de la boîte de message avec la date
        JOptionPane.showMessageDialog(null, message, "Date Actuelle", JOptionPane.INFORMATION_MESSAGE);
    
    }
    private void addRowToTable(String licence) {
        // Ajoutez les valeurs appropriées à la table
        rows[0] = fnTf1.getText();
        rows[1] = lnTf1.getText();
        rows[2] = fnTf2.getText();
        rows[3] = lnTf2.getText();
        rows[4] = fnTf3.getText();
        rows[5] = lnTf3.getText();
        rows[6] = fnTf4.getText();
        rows[7] = lnTf4.getText();
        model.addRow(rows); // Ajoutez la ligne à la table
    }
public void actionPerformed(ActionEvent e) {
    
    
    if(e.getSource()==addButton) {
        
        rows[0] = fnTf1.getText();
        rows[1] = lnTf1.getText();
        rows[2] = fnTf2.getText();
        rows[3] = lnTf2.getText();
        rows[4] = fnTf3.getText();
        rows[5] = lnTf3.getText();
        rows[6] = fnTf4.getText();
        rows[7] = lnTf4.getText();
        model.addRow(rows);
   	 JFrame newFrame = new JFrame("New Frame");
   	    newFrame.setSize(400, 300);
   	    newFrame.setLocationRelativeTo(null); // Centrer sur l'écran
   	    newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ferme seulement ce frame

   	    // Contenu du nouveau frame
   	    Container newContainer = newFrame.getContentPane();
   	    newContainer.setLayout(null); // ou utilisez un layout approprié

   	    // Ajouter des composants au nouveau frame
   	    // Par exemple :
   	    JLabel label = new JLabel("New Frame Content");
   	    label.setBounds(50, 50, 200, 30);
   	    newContainer.add(label);

   	    // Afficher le nouveau frame
   	    newFrame.setVisible(true);
   	 
   	    
        
        
    } 
     if(e.getSource() == deleteButton){
    	int numberOfRow = table.getSelectedRow();
        if(numberOfRow>=0){
            
            model.removeRow(numberOfRow);
            
        }
        
        else{
            
            JOptionPane.showMessageDialog(null, "no row has been seleted or no row exits");
        }
    
   	}}}












