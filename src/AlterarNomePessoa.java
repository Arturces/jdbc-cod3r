import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.println( "Informe o codigo da pessoa: ");
        int codigo = entrada.nextInt();

        String select = "SELECT codigo, nome  FROM pessoas WHERE codigo = ?";
        String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement st = conexao.prepareStatement(select);
        st.setInt(1,codigo);
        ResultSet resultado = st.executeQuery();

        if(resultado.next()) {
            Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));

            System.out.println("O nome atual é " + p.getNome());
            entrada.nextLine();

            System.out.println("Informe o novo nome: ");
            String novoNome = entrada.nextLine();

            st.close();

            st = conexao.prepareStatement(update);
            st.setString(1,novoNome);
            st.setInt(2,codigo);
            st.execute();

            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("èssoa não encontrada!");
        }
    }
}
