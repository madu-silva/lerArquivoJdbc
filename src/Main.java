import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Arquivo arquivo = new Arquivo();
        System.out.println(arquivo.lerArquivo());

        arquivo.buscarDadosBanco();
        arquivo.inserirNoBanco();
    }
}