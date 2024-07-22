package persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Endereco;
import entidade.Gerente;
import persistencia.configuracao.FabricaConexao;

// Data Acess Objeto -> Essa classe é especialista em transações de banco de dados do objeto GERENTE
public class DaoGerente {

	public boolean salvarGerente(Gerente gerente) {

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

			preparaOcomandoSQL.setString(1, gerente.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, gerente.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, gerente.getGerencia()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(4, gerente.getSalario().toString());
			preparaOcomandoSQL.setString(5, gerente.getEndereco().getCep());
			preparaOcomandoSQL.setString(6, gerente.getEndereco().getLocalidade());
			preparaOcomandoSQL.setString(7,	gerente.getEndereco().getLogradouro());
			preparaOcomandoSQL.setString(8, gerente.getEndereco().getBairro());
			preparaOcomandoSQL.setString(9, gerente.getEndereco().getUf());
		
		
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

	public List<Gerente> retornaListaDeGerentes() {

		String comandoSqlBuscarGerente = "select * from tb_gerente";
		List<Gerente> listaGerente = new ArrayList<>();
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão

		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		ResultSet resultadoDaTabelaDoBanco = null;

		try {

			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroUsuario(); // Recebe o objeto de
																								// conexão da classe
																								// Fabrica de conexão
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlBuscarGerente);
			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {
				Gerente gerente = new Gerente();
				Endereco endereco = new Endereco();

				gerente.setEndereco(endereco);
				
				gerente.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				gerente.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				gerente.setGerencia(resultadoDaTabelaDoBanco.getString("gerencia"));
				gerente.setSalario(Double.parseDouble(resultadoDaTabelaDoBanco.getString("salario")));
				gerente.getEndereco().setCep(resultadoDaTabelaDoBanco.getString("cep"));
				gerente.getEndereco().setBairro(resultadoDaTabelaDoBanco.getString("bairro"));
				gerente.getEndereco().setLogradouro(resultadoDaTabelaDoBanco.getString("logradouro"));
				gerente.getEndereco().setLocalidade(resultadoDaTabelaDoBanco.getString("localidade"));
				gerente.getEndereco().setUf(resultadoDaTabelaDoBanco.getString("uf"));
				
				/*
				 	endereco.setCep(resultadoDaTabelaDoBanco.getString("cep"));
					endereco.setBairro(resultadoDaTabelaDoBanco.getString("bairro"));
					endereco.setLogradouro(resultadoDaTabelaDoBanco.getString("logradouro"));
					endereco.setLocalidade(resultadoDaTabelaDoBanco.getString("localidade"));
					endereco.setUf(resultadoDaTabelaDoBanco.getString("uf"));
				 */
				
				
				listaGerente.add(gerente);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar a lista de gerentes");
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

		return listaGerente;

	}

	public boolean deletarGerente(String cpf) {

		boolean deletar = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlDelete = "delete from tb_gerente where cpf = ?"; // Base do comando SQL

		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroUsuario(); // Recebe o objeto de
																								// conexão da class																				// Fabrica de conexã
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlDelete);// Armazena a conexão e o
																							// comando SQL que vai ser
																							// prepara
			preparaOcomandoSQL.setString(1, cpf);// Coloca o valor no campo cpf

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("Gerente Deletado");// Log

			deletar = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel deletar o pessoa!!!");

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
	
	public boolean alterarGerente(Gerente gerente) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "UPDATE tb_gerente SET nome = ?, gerencia = ? WHERE cpf = ? "; // Base do comando
																									// SQL

		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroUsuario(); // Recebe o objeto de
																								// conexão da classe																				// Fabrica de conexão
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlInsert);// Armazena a conexão e o																			// comando SQL que vai se																			// preparado
			preparaOcomandoSQL.setString(1, gerente.getNome());
			preparaOcomandoSQL.setString(2, gerente.getGerencia()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(3, gerente.getCpf());// Coloca o valor no campo cpf
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
