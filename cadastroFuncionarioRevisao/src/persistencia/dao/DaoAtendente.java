package persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Atendente;
import entidade.Endereco;
import entidade.Gerente;
import entidade.Atendente;
import persistencia.configuracao.FabricaConexao;


public class DaoAtendente {
	
	public boolean salvarAtendente(Atendente atendente) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "insert into tb_atendente (cpf, nome, setor, salario, cep, localidade,logradouro, bairro,uf) values (?,?,?,?,?,?,?,?,?)"; // Base do comando
																									// SQL

		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroUsuario(); // Recebe o objeto de
																								// conexão da classe																				// Fabrica de conex
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																			// prepar
			preparaOcomandoSQL.setString(1, atendente.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, atendente.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, atendente.getSetor()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(4, atendente.getSalario().toString());
			preparaOcomandoSQL.setString(5, atendente.getEndereco().getCep());
			preparaOcomandoSQL.setString(6, atendente.getEndereco().getLocalidade());
			preparaOcomandoSQL.setString(7, atendente.getEndereco().getLogradouro());
			preparaOcomandoSQL.setString(8, atendente.getEndereco().getBairro());
			preparaOcomandoSQL.setString(9, atendente.getEndereco().getUf());
			
			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("A pessoa foi registrada");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Não foi possivel salvar a pessoa!!!");

		} finally { // Esse é obrigatorio
			try {
				if (connectionBaseExemplo != null) {
					connectionBaseExemplo.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai									// encerrar
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
	
	public List<Atendente> retornaListaDeAtendentes() {

		String comandoSqlBuscarAtendente = "select * from tb_Atendente";
		List<Atendente> listaAtendente = new ArrayList<>(); // Objeto que vai ser retornado
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão

		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		ResultSet resultadoDaTabelaDoBanco = null;

		try {

			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroUsuario(); // Recebe o objeto de
																								// conexão da classe
																								// Fabrica de conexão
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlBuscarAtendente);
			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {
				Atendente atendente = new Atendente();
				
				Endereco endereco = new Endereco();

				atendente.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				atendente.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				atendente.setSetor(resultadoDaTabelaDoBanco.getString("setor"));
				atendente.setSalario(Double.parseDouble(resultadoDaTabelaDoBanco.getString("salario")));
			
				
				endereco.setCep(resultadoDaTabelaDoBanco.getString("cep"));
				endereco.setBairro(resultadoDaTabelaDoBanco.getString("bairro"));
				endereco.setLogradouro(resultadoDaTabelaDoBanco.getString("logradouro"));
				endereco.setLocalidade(resultadoDaTabelaDoBanco.getString("localidade"));
				endereco.setUf(resultadoDaTabelaDoBanco.getString("uf"));
				atendente.setEndereco(endereco);
				listaAtendente.add(atendente);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar a lista de Atendentes");
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

		return listaAtendente; // Ele vai retornar o objeto

	}
	
	public boolean deletarAtendente(String cpf) {

		boolean deletar = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlDelete = "delete from tb_atendente where cpf = ?"; // Base do comando SQL

		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroUsuario(); // Recebe o objeto de
																								// conexão da class																				// Fabrica de conexã
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlDelete);// Armazena a conexão e o
																							// comando SQL que vai ser
																							// prepara
			preparaOcomandoSQL.setString(1, cpf);// Coloca o valor no campo cpf

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("Atendente Deletado");// Log

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
	
	public boolean alterarAtendente(Atendente atendente) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBaseExemplo = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "UPDATE tb_atendente SET nome = ?, setor = ? WHERE cpf = ?"; // Base do comando
																									// SQL
		try {
			connectionBaseExemplo = conexaoFabricaConexao.criarConexaoComBaseCadastroUsuario(); // Recebe o objeto de																			// conexão da classe																				// Fabrica de conexão
			preparaOcomandoSQL = connectionBaseExemplo.prepareStatement(comandoSqlInsert);// Armazena a conexão e o																			// comando SQL que vai se																			// preparado
			preparaOcomandoSQL.setString(1, atendente.getNome());
			preparaOcomandoSQL.setString(2, atendente.getSetor()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(3, atendente.getCpf());// Coloca o valor no campo cpf
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
