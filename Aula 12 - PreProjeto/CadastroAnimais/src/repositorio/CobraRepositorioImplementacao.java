package repositorio;

import java.util.List; 

import entidade.Cobra;
import persistencia.DaoCobra;

public class CobraRepositorioImplementacao implements CobraRepositorio {

	@Override // Aponte que esse metodo é uma SobEscrita de um metodo da interface
	public boolean salvarCobraRepositorio(Cobra cobra, String qtdQuilos) {
		DaoCobra daoCobra = new DaoCobra();
		EntidadeServico entidadeServico = new EntidadeServico();
		
		if (entidadeServico.buscarValorCobra(qtdQuilos) == null) {
			return false;
		}else {
			cobra.setValor(entidadeServico.buscarValorCobra(qtdQuilos));
		return daoCobra.salvarCobra(cobra);
		}
	}
	
		

	@Override
	public List<Cobra> listarCobraRepositorio() {
		DaoCobra daoCobra = new DaoCobra();
		return daoCobra.retornaListaDeCobras();
	}

	@Override
	public boolean excluirCobraRepositorio(String caf) {
		DaoCobra daoCobra = new DaoCobra();
		for(Cobra cobra: listarCobraRepositorio()) {
			if(cobra.getCaf().equals(caf)) {
				return daoCobra.deletarCobra(caf);
			}
		}
		return false;
	}

	@Override
	public boolean alterarCobraRepositorio(Cobra cobra) {
		DaoCobra daoCobra = new DaoCobra();
		return daoCobra.alterarCobra(cobra);
	}

	@Override
	public Cobra buscaCobraPorCaf(String caf) {
		for(Cobra cobra: listarCobraRepositorio()) {
			if(cobra.getCaf().equals(caf)) {
				return cobra;
			}
		}
		return null;
	}
}
