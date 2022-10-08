import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o codigo: ");
        int codigo = entrada.nextInt();

        Connection conexao = FabricaConexao.getConexao();
        String sql = "DELETE FROM pessoas WHERE codigo = ?";

        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, codigo);

        int contador = st.executeUpdate();

        if (contador > 0) {
            System.out.println("Pessoa excluida com sucesso!");
        } else {
            System.out.println("Nada Feito!");
        }
        System.out.println("Linhas afetadas: " + contador);

        conexao.close();
        entrada.close();
    }
}
