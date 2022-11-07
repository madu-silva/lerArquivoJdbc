import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Arquivo arquivo = new Arquivo();

        arquivo.inserirNoBanco("C:\\Workspace\\ws-eclipse\\Arquivo.txt");
        arquivo.inserirNoBanco("C:\\Workspace\\ws-eclipse\\testeDois.txt");
        arquivo.buscarDadosBanco();

    }
}