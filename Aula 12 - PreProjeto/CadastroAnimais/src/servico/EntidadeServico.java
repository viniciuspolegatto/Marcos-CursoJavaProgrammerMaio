package servico;

import javax.swing.JOptionPane;

import entidade.Cobra;
import validacao.EntidadeValidacao;

public class EntidadeServico {
	
	/*public Double buscarCustoCachorro(String qtdQuilos) {
		Cachorro chorro = new Cachorro();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();
		
		if (entidadeValidacao.validaqtdHora(qtdQuilos)== null) {
			JOptionPane.showMessageDialog(null, "O valor "+ qtdQuilos + " Não é valido" );
		}else {
			return cachorro.calcularValor(entidadeValidacao.validaqtdQuilos(qtdQuilos));
		}
		
		return null;
	} */
	
	public Double buscarValorCobra(String qtdQuilos) {
		Cobra cobra = new Cobra();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();
		
		if (entidadeValidacao.validaqtdQuilos(qtdQuilos)== null) {
			JOptionPane.showMessageDialog(null, "O valor "+ qtdQuilos + " Não é valido" );
		}else {
			return cobra.calcularValor(entidadeValidacao.validaqtdQuilos(qtdQuilos));
		}
		
		return null;
	}
	
}