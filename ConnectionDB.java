package Fatwaj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/*import com.mysql.jdbc.PreparedStatement;*/
public class ConnectionDB {
	static Connection connection = null;
	static String databaseName = "studentdatabase";

	static String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName + "?zeroDateTimeBehavior=convertToNull";

	static String username="root";
	static String password="1234" ;
	
  public static void main(String[] args) throws InstantiationException,IllegalAccessException, ClassNotFoundException, SQLException{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();
	  connection=DriverManager.getConnection(url,username,password);
	  PreparedStatement ps = connection.prepareStatement("INSERT INTO `studentdatabase`.`student` (`first name`, `last name`,`phone`,`email`,`gender`,`licence`,`mastere`,`ingenieur`) VALUES ('ou', 'jfdd','25','zizou','zizou','zizou',' ',' ')");
      int status =ps.executeUpdate();
      if(status !=0) {
    	  System.out.println("database was connected");
    	  System.out.println("Record was INSERTED");
    	  
      }}}
  
   /* try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/user", "root", "1234");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("show databases;");
      System.out.println("Connected");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}*/
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionDB {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le pilote JDBC MySQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection failed");
            e.printStackTrace(); // Ajoutez ceci pour obtenir des informations détaillées sur les erreurs
        }
        return connection;
    }
}*/

