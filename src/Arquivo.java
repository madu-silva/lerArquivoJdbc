import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Arquivo {
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    private void lerArquivo(String path) {

        try (BufferedReader buffeReader = new BufferedReader(new FileReader(path))) {
            String linha = buffeReader.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = buffeReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserirNoBanco(String path) {
        Connection conn = null;
        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(
                    "INSERT INTO arquivos "
                            + "(caminhoArquivo) "
                            + "values "
                            + "(?)");

            ps.setString(1, path);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public String buscarDadosBanco() {
        Connection conn = null;
        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from arquivos");

            while(rs.next()) {
                lerArquivo(rs.getString("caminhoArquivo"));
//                System.out.println(rs.getInt("Id") + ", " + rs.getString("caminhoArquivo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
        return null;
    }
}


