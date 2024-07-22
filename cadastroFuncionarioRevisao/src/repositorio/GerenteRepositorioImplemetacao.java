package repositorio;

import java.util.List;

import entidade.Gerente;
import persistencia.dao.DaoGerente;
import servico.EntidadeServico;

public class GerenteRepositorioImplemetacao implements GerenteRepositorio {

	@Override // Aponte que esse metodo é uma SobEscrita de um metodo da interface
	public boolean salvarGerenteRepositorio(Gerente gerente, String qtdHora) {
		
		DaoGerente daoGerente = new DaoGerente();
		EntidadeServico entidadeService = new EntidadeServico();
		
		if (entidadeService.buscarSalarioGerente(qtdHora) == null) {
			return false;
		}else {
			gerente.setSalario(entidadeService.buscarSalarioGerente(qtdHora));
			return daoGerente.salvarGerente(gerente);
		}
	}

	@Override
	public List<Gerente> listarGerenteRepositorio() {
		DaoGerente daoGerente = new DaoGerente();
		return daoGerente.retornaListaDeGerentes();
	}

	@Override
	public boolean excluirGerenteRepositorio(String cpf) {
		DaoGerente daoGerente = new DaoGerente();
		if(buscaGerentePorCpf(cpf) != null) {
			return daoGerente.deletarGerente(cpf);
		}else {
			return false;
		}
	}

	@Override
	public boolean alterarGerenteRepositorio(Gerente gerente) {
		DaoGerente daoGerente = new DaoGerente();
		return daoGerente.alterarGerente(gerente);
	}

	@Override
	public Gerente buscaGerentePorCpf(String cpf) {
		for(Gerente gerente:listarGerenteRepositorio() ) {
			if(gerente.getCpf().equals(cpf)) {
				return gerente;
			}
		}
		return null;
	}
}
