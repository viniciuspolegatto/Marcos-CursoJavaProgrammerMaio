package persistencia.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private static String USUARIO = "root"; // O usuario do banco
	private static String SENHA = "root"; // A senha do banco
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/cadastro_usuario?useTimezone=true&serverTimezone=UTC";//URL DO BANCO
	
	/*
	private static String USUARIO = "urquav8yqcgb56gz"; // O usuario do banco
	private static String SENHA = "n4jInkrm1rKP7K0xb4w5"; // A senha do banco
	private static String BANCO_URL = "jdbc:mysql://bkb9ggi5dnxk2nodlute-mysql.services.clever-cloud.com:3306/bkb9ggi5dnxk2nodlute?useTimezone=true&serverTimezone=UTC";//URL DO BANCO
	*/
	
	public Connection criarConexaoComBaseCadastroUsuario() {
		
		Connection conexaoBandoDadosExemplo = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Aponta o drive do banco
			
			conexaoBandoDadosExemplo = DriverManager.getConnection(BANCO_URL,USUARIO,SENHA);// Tenta acessar o banco de dados e criar o objeto
			// Se algo ocorrer errado ele cai no cath
			System.out.println("Deu certo a conexão!!!!");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println("Deu errado a conexão!!!!");
		
		}
		
		return conexaoBandoDadosExemplo;
	}
	

}
