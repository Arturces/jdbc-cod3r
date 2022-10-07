import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        /*final String url = "jdbc:mysql://localhost";
        final String usuario = "root";
        final String senha = "584412";

        Connection conexao =
                DriverManager.getConnection(url,usuario,senha);*/

        Connection conexao = FabricaConexao.getConexao();

        Statement st = conexao.createStatement();
        st.execute("CREATE DATABASE IF NOT EXISTS jdbc_cod3r");
        //st.execute("DROP DATABASE IF NOT EXISTS jdbc_cod3r2");

        System.out.println("Conexão Pronta!");
        conexao.close();
    }
}