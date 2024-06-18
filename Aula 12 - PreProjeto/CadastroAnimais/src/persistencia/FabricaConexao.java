package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private static String USUARIO = "enge4068_impacta"; // O usuario do banco
	private static String SENHA = "imp@cta1"; // A senha do banco
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/cadastro_animal?useTimezone=true&serverTimezone=UTC";//URL DO BANCO
	
	public Connection criarConexaoComBaseCadastroAnimal() {
		
		Connection conexaoBandoDadosCadastro_Animal = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Aponta o drive do banco
			
			conexaoBandoDadosCadastro_Animal = DriverManager.getConnection(BANCO_URL,USUARIO,SENHA);// Tenta acessar o banco de dados e criar o objeto
			// Se algo ocorrer errado ele cai no cath
			System.out.println("Deu certo a conexão!!!!");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println("Deu errado a conexão!!!!");
		
		}
		
		return conexaoBandoDadosCadastro_Animal;
	}
	

}