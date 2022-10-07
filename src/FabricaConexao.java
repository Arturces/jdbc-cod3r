import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

   public static Connection getConexao(){

       try {
           final String url = "jdbc:mysql://localhost/jdbc_cod3r";
           final String usuario = "root";
           final String senha = "584412";

           return DriverManager.getConnection(url,usuario,senha);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }
}