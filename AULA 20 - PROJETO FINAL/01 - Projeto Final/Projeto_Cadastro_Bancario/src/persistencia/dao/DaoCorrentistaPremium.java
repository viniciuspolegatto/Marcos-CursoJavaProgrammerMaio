package persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidade.CorrentistaPremium;
import persistencia.FabricaConexao;

public class DaoCorrentistaPremium {
	
	// MÉTODO INCLUÍDO PARA ATENDER O BOTÃO CADASTRAR CLIENTE PREMIUM NO ControladorTelaCadastroPremium
	public boolean salvarCorrentistaPremium(CorrentistaPremium correntistaPremium) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "insert into tb_gerente (cpf, nome, gerencia, salario, cep, localidade,logradouro, bairro,uf) values (?,?,?,?,?,?,?,?,?)"; // Base do comando
																							// SQL

		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroUsuario(); // Recebe o objeto de
																								// conexão da classe
																								// Fabrica de conexão

			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																							// comando SQL que vai ser
																							// preparado

			preparaOcomandoSQL.setString(1, correntistaPremium.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, correntistaPremium.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, correntistaPremium.getTransacoes()); // Colocar o valor no campo email

		
		
			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("A pessoa foi registrada");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar a pessoa!!!");

		} finally { // Esse é obrigatorio
			try {
				if (connectionBaseExemplo != null) {
					connectionBaseExemplo.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai
													// encerrar
				}
				if (preparaOcomandoSQL != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return salvamento;
	}
}