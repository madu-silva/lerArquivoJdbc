import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Arquivo {

    String path = "C:\\Workspace\\ws-eclipse\\Arquivo.txt";
    Connection conn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    public String lerArquivo() {

        try (BufferedReader buffeReader = new BufferedReader(new FileReader(path))) {
            String linha = buffeReader.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = buffeReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void inserirNoBanco() {
        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(
                    "INSERT INTO arquivos "
                            + "(caminhoArquivo) "
                            + "values "
                            + "(?)");

            ps.setString(1, "caminhoTeste.txt");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public String buscarDadosBanco() {

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from arquivos");

            while(rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("caminhoArquivo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}


