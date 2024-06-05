package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private static String USUARIO = "root";
	private static String SENHA = "root"; // A senha do banco
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC";//URL DO BANCO
	
	public Connection criarConexaoComBaseTeste() {
		
		Connection conexaoBandoDadosTeste = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Aponta o drive do banco
			
			conexaoBandoDadosTeste = DriverManager.getConnection(BANCO_URL,USUARIO,SENHA);// Tenta acessar o banco de dados e criar o objeto
			// Se algo ocorrer errado ele cai no cath
			System.out.println("Deu certo a conexão!!!!");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println("Deu errado a conexão!!!!");
		
		}
		
		return conexaoBandoDadosTeste;
		
	}
}