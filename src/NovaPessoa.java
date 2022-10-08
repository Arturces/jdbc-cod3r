import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = entrada.nextLine();

        Connection conexao = FabricaConexao.getConexao();


        String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?)";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setString(1, nome);
        st.setInt(2,199);

        st.execute();

        System.out.println("Pessoa incluida com sucesso");
        entrada.close();
    }
}
