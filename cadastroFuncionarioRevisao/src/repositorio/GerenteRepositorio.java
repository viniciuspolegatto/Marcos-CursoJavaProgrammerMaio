package repositorio;

import java.util.List;

import entidade.Gerente;

public interface GerenteRepositorio {
	
	public boolean salvarGerenteRepositorio(Gerente gerente, String qtdHora);
	
	public List<Gerente> listarGerenteRepositorio();
	
	public boolean excluirGerenteRepositorio(String cpf);
	
	public boolean alterarGerenteRepositorio(Gerente gerente);
	
	public Gerente buscaGerentePorCpf(String cpf);

}


