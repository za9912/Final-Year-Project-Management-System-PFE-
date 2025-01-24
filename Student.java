package Fatwaj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import One.StudentDAO;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student extends JFrame implements ActionListener {

    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel titleLabel, fnLabel, lnLabel, phoneLabel;
    private JTextField fnTf, lnTf, phoneTf, gpaTf, GenderTf, gpaTf1;
    private JButton addButton, updateButton, clearButton, deleteButton;
    private JRadioButton radioComputer, radioElectronic;
    private ButtonGroup licenceGroup,masterGroup,engineerGroup;
    private JRadioButton radioRecherche, radioProfessionnel;
    private JRadioButton radioInfo,radioElectro;
    private Connection connection;


    private String[] columns = {"First name", "Last name", "Phone number", "Email", "Gender", "Licence","Mastere","Ingenieur"};
    private String[] rows = new String[8];
    
    Student(){
        initComponents();
        initializeDatabaseConnection();
    }
    private void initializeDatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "1234");
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initComponents() {
    	 c = this.getContentPane(); // Initialisez d'abord le conteneur

         Font font = new Font("Arial", Font.BOLD, 16);
         JLabel engineerLabel = new JLabel("Ingénieur");
         engineerLabel.setBounds(10, 430, 150, 30);
         engineerLabel.setFont(font);
         c.add(engineerLabel);

        // JRadioButton
         radioInfo = new JRadioButton("Ing-Informatique");
         radioElectro = new JRadioButton("Ing-Électronique");
         radioInfo.setBounds(110, 430, 120, 30);
         radioElectro.setBounds(240, 430, 120, 30);
         radioInfo.setFont(font);
         radioElectro.setFont(font);
         c.add(radioInfo);
         c.add(radioElectro);

         engineerGroup = new ButtonGroup();
         engineerGroup.add(radioInfo);
         engineerGroup.add(radioElectro);


         JLabel masterLabel = new JLabel("Mastère");
         masterLabel.setBounds(10,380, 150, 30);
         masterLabel.setFont(font);
         c.add(masterLabel);

         radioRecherche = new JRadioButton("Recherche");
         radioProfessionnel = new JRadioButton("Professionnel");
         radioRecherche.setBounds(110, 380, 120, 30);
         radioProfessionnel.setBounds(240, 380, 120, 30);
         radioRecherche.setFont(font);
         radioProfessionnel.setFont(font);
         c.add(radioRecherche);
         c.add(radioProfessionnel);

         masterGroup = new ButtonGroup();
         masterGroup.add(radioRecherche);
         masterGroup.add(radioProfessionnel);
        
        JLabel licenceLabel = new JLabel("Licence");
        licenceLabel.setBounds(10, 330, 150, 30);
        licenceLabel.setFont(font);
        c.add(licenceLabel);

        // Boutons radio pour les licences
        radioComputer = new JRadioButton("Informatique");
        radioElectronic = new JRadioButton("Électronique");
        radioComputer.setBounds(110, 330, 120, 30);
        radioElectronic.setBounds(240, 330, 120, 30);
        radioComputer.setFont(font);
        radioElectronic.setFont(font);
        c.add(radioComputer);
        c.add(radioElectronic);

        // Ajout des boutons radio à un groupe pour permettre la sélection exclusive
        licenceGroup = new ButtonGroup();
        licenceGroup.add(radioComputer);
        licenceGroup.add(radioElectronic);

        this.setSize(780, 690);
        this.setLocationRelativeTo(null);
        this.setTitle("styudent table");

        c.setLayout(null); // Définissez le gestionnaire de mise en page
        c.setBackground(Color.RED);

        titleLabel = new JLabel("Student Registration");
        titleLabel.setFont(font);
        titleLabel.setBounds(140, 10, 250, 50);
        c.add(titleLabel);

        fnLabel = new JLabel("First name");
        fnLabel.setBounds(10, 80, 140, 30);
        fnLabel.setFont(font);
        c.add(fnLabel);

        JLabel fnLabel1 = new JLabel("Last name");
        fnLabel1.setBounds(10, 130, 140, 30);
        fnLabel1.setFont(font);
        c.add(fnLabel1);
        fnTf = new JTextField();
        fnTf.setBounds(110, 80, 200, 30);
        fnTf.setFont(font);
        c.add(fnTf);

        addButton = new JButton("Add");
        addButton.setBounds(400, 80, 100, 30);
        addButton.setFont(font);
        c.add(addButton);

        lnTf = new JTextField();
        lnTf.setBounds(110, 130, 200, 30);
        lnTf.setFont(font);
        c.add(lnTf);

        updateButton = new JButton("update");
        updateButton.setBounds(400, 130, 100, 30);
        updateButton.setFont(font);
        c.add(updateButton);

        phoneLabel = new JLabel("phone");
        phoneLabel.setBounds(10, 180, 150, 30);
        phoneLabel.setFont(font);
        c.add(phoneLabel);

        phoneTf = new JTextField();
        phoneTf.setBounds(110, 180, 200, 30);
        phoneTf.setFont(font);
        c.add(phoneTf);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(400, 180, 100, 30);
        deleteButton.setFont(font);
        c.add(deleteButton);

        JLabel gpaLabel = new JLabel("Email");
        gpaLabel.setBounds(10, 230, 150, 30);
        gpaLabel.setFont(font);
        c.add(gpaLabel);

        JLabel gendeerLabel = new JLabel("Gender");
        gendeerLabel.setBounds(10, 280, 150, 30);
        gendeerLabel.setFont(font);
        c.add(gendeerLabel);

        GenderTf = new JTextField();
        GenderTf.setBounds(110, 280, 200, 30);
        GenderTf.setFont(font);
        c.add(GenderTf);

        gpaTf = new JTextField();
        gpaTf.setBounds(110, 230, 200, 30);
        gpaTf.setFont(font);
        c.add(gpaTf);
        clearButton = new JButton("clear");
        clearButton.setBounds(400, 230, 100, 30);
        clearButton.setFont(font);
        c.add(clearButton);

        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.GREEN);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10, 500, 740, 250);
        c.add(scroll);

        /*addButton.addActionListener(this);*/
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addStudentToDatabase();
                // Ajoutez l'étudiant à la table
            	addStudentToTable();

                // Affichez le nouveau frame
                displayNewFrame();
            }
        });

    // Méthode pour insérer un étudiant dans la base de données
    


        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mettez à jour l'étudiant dans la base de données
                updateStudentInDatabase();

                // Mettez à jour l'étudiant dans la table
                updateStudentInTable();
            }
        });
        clearButton.addActionListener(this);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Vérifiez si le bouton "Delete" a été cliqué
                if (e.getSource() == deleteButton) {
                    // Obtenez l'index de la ligne sélectionnée dans la table
                    int selectedRowIndex = table.getSelectedRow();
                    if (selectedRowIndex >= 0) { // Vérifiez si une ligne a été sélectionnée
                        try {
                            // Récupérez la valeur de la colonne 'first name' de la ligne sélectionnée
                            String firstName = (String) table.getValueAt(selectedRowIndex, 0);
                            
                            // Supprimez la ligne de la base de données en utilisant le 'first name' comme identifiant
                            String deleteQuery = "DELETE FROM student WHERE `first name`=?";
                            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                            deleteStatement.setString(1, firstName);
                            int rowsDeleted = deleteStatement.executeUpdate();
                            if (rowsDeleted > 0) {
                                System.out.println("Student deleted successfully from the database!");
                            } else {
                                System.out.println("No student deleted from the database!");
                            }
                            
                            // Supprimez également la ligne de la table Swing
                            model.removeRow(selectedRowIndex);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No row has been selected or no row exists.");
                    }
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                int numberOfRow = table.getSelectedRow();

                String f_name = model.getValueAt(numberOfRow, 0).toString();
                String l_name = model.getValueAt(numberOfRow, 1).toString();
                String phone = model.getValueAt(numberOfRow, 2).toString();
                String gpa = model.getValueAt(numberOfRow, 3).toString();
                fnTf.setText(f_name);
                lnTf.setText(l_name);
                phoneTf.setText(phone);
                gpaTf.setText(gpa);
            }
        });

     
    }
 // Méthode pour mettre à jour un étudiant dans la base de données
    private void updateStudentInDatabase() {
        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex != -1) { // Vérifiez si une ligne est sélectionnée dans la table
            try {
                String sql = "UPDATE student SET `last name`=?, `phone`=?, `email`=?, `gender`=?, `licence`=?, `mastere`=?, `ingenieur`=? WHERE `first name`=?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, lnTf.getText());
                statement.setString(2, phoneTf.getText());
                statement.setString(3, gpaTf.getText());
                statement.setString(4, GenderTf.getText());

                // Obtenez la valeur sélectionnée des boutons radio pour licence, mastère et ingénieur
                String selectedLicence = getSelectedLicence();
                String selectedMastere = getSelectedMastere();
                String selectedIngenieur = getSelectedIngenieur();

                // Assurez-vous que les valeurs ne sont pas nulles avant de les définir dans la déclaration PreparedStatement
                if (selectedLicence != null) {
                    statement.setString(5, selectedLicence);
                } else {
                    statement.setNull(5, Types.VARCHAR);
                }
                if (selectedMastere != null) {
                    statement.setString(6, selectedMastere);
                } else {
                    statement.setNull(6, Types.VARCHAR);
                }
                if (selectedIngenieur != null) {
                    statement.setString(7, selectedIngenieur);
                } else {
                    statement.setNull(7, Types.VARCHAR);
                }

                // Utilisation du champ 'first name' pour identifier l'enregistrement à mettre à jour
                statement.setString(8, fnTf.getText());

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Student updated successfully!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                System.err.println("Erreur de format de nombre lors de la mise à jour de l'étudiant.");
            }
        } else {
            System.out.println("Veuillez sélectionner une ligne à mettre à jour.");
        }
    }



    // Méthode pour mettre à jour un étudiant dans la table Swing
    private void updateStudentInTable() {
        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex != -1) { // Vérifiez si une ligne est sélectionnée dans la table
            // Mettez à jour les valeurs dans la table Swing avec les valeurs des champs de texte
            model.setValueAt(fnTf.getText(), selectedRowIndex, 0);
            model.setValueAt(lnTf.getText(), selectedRowIndex, 1);
            model.setValueAt(phoneTf.getText(), selectedRowIndex, 2);
            model.setValueAt(gpaTf.getText(), selectedRowIndex, 3);
            model.setValueAt(GenderTf.getText(), selectedRowIndex, 4);
            model.setValueAt(getSelectedLicence(), selectedRowIndex, 5);
            model.setValueAt(getSelectedMastere(), selectedRowIndex, 6);
            model.setValueAt(getSelectedIngenieur(), selectedRowIndex, 7);
        }
    }
    private void addStudentToDatabase() {
        try {
        	 String sql = "INSERT INTO student (`first name`, `last name`, `phone`, `email`, `gender`, `licence`, `mastere`, `ingenieur`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fnTf.getText());
            statement.setString(2, lnTf.getText());
            statement.setString(3, phoneTf.getText());
            statement.setString(4, gpaTf.getText());
            statement.setString(5, GenderTf.getText());
            statement.setString(6, getSelectedLicence());
            statement.setString(7, getSelectedMastere());
            statement.setString(8, getSelectedIngenieur());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student added to database successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

       private void addStudentToTable() {
        // Récupérez les valeurs des champs
        String firstName = fnTf.getText();
        String lastName = lnTf.getText();
        String phoneNumber = phoneTf.getText();
        String gpa = gpaTf.getText();
        String gender = GenderTf.getText();
        String licence = getSelectedLicence();
        String mastere = getSelectedMastere(); // Obtenez la sélection du label radio "Mastere"
        String ingenieur = getSelectedIngenieur();

        // Ajoutez les valeurs à la table
        model.addRow(new Object[]{firstName, lastName, phoneNumber, gpa, gender, licence, mastere,ingenieur});
    }
    private String getSelectedMastere() {
    	if (radioRecherche.isSelected()) {
            return "Recherche";
        } else if (radioProfessionnel.isSelected()) {
            return "Professionnel";
        } else {
            return ""; // Retournez une chaîne vide si rien n'est sélectionné
        }
    }
    private String getSelectedIngenieur() {
        if (radioInfo.isSelected()) {
            return "Ing-Informatique";
        } else if (radioElectro.isSelected()) {
            return "Ing-Électronique";
        } else {
            return ""; // Retourne une chaîne vide si rien n'est sélectionné
        }
    }

    // Méthode pour obtenir la licence sélectionnée
    private String getSelectedLicence() {
        if (radioComputer.isSelected()) {
            return "Informatique";
        } else if (radioElectronic.isSelected()) {
            return "Électronique";
        } else {
            return "";
        }
    }
    
 // Méthode pour afficher un nouveau frame
    private void displayNewFrame() {
        // Créez et configurez le nouveau frame
    	Jury frame = new Jury();
        frame.setVisible(true);
    }

    // Ajoutez cette méthode à votre classe Student
    private void addRowToTable(String licence) {
        // Ajoutez les valeurs appropriées à la table
        rows[0] = fnTf.getText();
        rows[1] = lnTf.getText();
        rows[2] = phoneTf.getText();
        rows[3] = gpaTf.getText();
        rows[4] = GenderTf.getText();
        rows[5] = licence; // Ajoutez la licence sélectionnée
        model.addRow(rows); // Ajoutez la ligne à la table
    }
    


    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        
     if(e.getSource()==addButton) {
    	 rows[0] = fnTf.getText();
         rows[1] = lnTf.getText();
         rows[2] = phoneTf.getText();
         rows[3] = gpaTf.getText();
         rows[4] = GenderTf.getText();
         model.addRow(rows);
         Jury frame = new Jury();
         frame.setVisible(true);
    	    
         
         
     } 
     else if(e.getSource() == clearButton){
    	    fnTf.setText("");
    	    lnTf.setText("");
    	    phoneTf.setText("");
    	    gpaTf.setText("");
    	    GenderTf.setText("");
    	    licenceGroup.clearSelection();
    	    masterGroup.clearSelection();
    	    engineerGroup.clearSelection();
    	}



     
     else if(e.getSource()==deleteButton){
         
         int numberOfRow = table.getSelectedRow();
         if(numberOfRow>=0){
             
             model.removeRow(numberOfRow);
             
         }
         
         else{
             
             JOptionPane.showMessageDialog(null, "no row has been seleted or no row exits");
         }
     }
     
     else if(e.getSource()==updateButton){
         
        
    	 int numberOfRow = table.getSelectedRow();
    	    String f_name = fnTf.getText();
    	    String l_name = lnTf.getText();
    	    String phone = phoneTf.getText();
    	    String gpa = gpaTf.getText();
    	    String gender = GenderTf.getText();
    	    String licence = getSelectedLicence();
    	    String mastere = getSelectedMastere();
    	    String ingenieur = getSelectedIngenieur();

    	    model.setValueAt(f_name,numberOfRow, 0);
    	    model.setValueAt(l_name,numberOfRow, 1);
    	    model.setValueAt(phone,numberOfRow, 2);
    	    model.setValueAt(gpa,numberOfRow, 3);
    	    model.setValueAt(gender,numberOfRow, 4);
    	    model.setValueAt(licence, numberOfRow, 5);
    	    model.setValueAt(mastere, numberOfRow, 6);
    	    model.setValueAt(ingenieur, numberOfRow, 7);
    	    
     }
         
        
    

     }
         


    }
    	
    









