package persistencia;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Cobra;

// Data Acess Objeto -> Essa classe é especialista em transações de banco de dados do objeto COBRA
public class DaoCobra {

	public boolean salvarCobra(Cobra cobra) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "insert into tb_cobra (caf, nome, especie) values (?, ?, ?)"; // Base do comando
																									// SQL

		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroAnimal(); // Recebe o objeto de
																								// conexão da classe
																								// Fabrica de conexão

			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																							// comando SQL que vai ser
																							// preparado

			preparaOcomandoSQL.setString(1, cobra.getCaf());// Coloca o valor no campo caf
			preparaOcomandoSQL.setString(2, cobra.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, cobra.getEspecie()); // Colocar o valor no campo especie

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("A Cobra foi registrada");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar a Cobra!!!");

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

	public List<Cobra> retornaListaDeCobras() {

		String comandoSqlBuscarCobra = "select * from tb_cobra";
		List<Cobra> listaCobra = new ArrayList<>();
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão

		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		ResultSet resultadoDaTabelaDoBanco = null;

		try {

			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroAnimal(); // Recebe o objeto de
																								// conexão da classe
																								// Fabrica de conexão
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlBuscarCobra);
			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {
				Cobra cobra = new Cobra();

				cobra.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				cobra.setCaf(resultadoDaTabelaDoBanco.getString("caf"));
				cobra.setEspecie(resultadoDaTabelaDoBanco.getString("especie"));

				listaCobra.add(cobra);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar a lista de cobras");
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

		return listaCobra;

	}

	public boolean deletarCobra(String caf) {

		boolean deletar = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlDelete = "delete from tb_cobra where caf = ?"; // Base do comando SQL

		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroAnimal(); // Recebe o objeto de
																								// conexão da class																				// Fabrica de conexã
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlDelete);// Armazena a conexão e o
																							// comando SQL que vai ser
																							// prepara
			preparaOcomandoSQL.setString(1, caf);// Coloca o valor no campo caf

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("Cobra Deletada");// Log

			deletar = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel deletar a cobra!!!");

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

		return deletar;
	}

	public boolean alterarCobra(Cobra cobra) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "UPDATE tb_cobra SET nome = ?, especie = ? WHERE caf = ? "; // Base do comando
																									// SQL

		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroAnimal(); // Recebe o objeto de
																								// conexão da classe
																								// Fabrica de conexão
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlInsert);// Armazena a conexão e o																			// comando SQL que vai se																			// preparado
			preparaOcomandoSQL.setString(1, cobra.getNome());
			preparaOcomandoSQL.setString(2, cobra.getEspecie()); // Colocar o valor no campo especie
			preparaOcomandoSQL.setString(3, cobra.getCaf());// Coloca o valor no campo caf
			 // Colocar o valor no campo nome
			

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
