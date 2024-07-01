package servicos;

import javax.swing.JOptionPane;

import entidade.CorrentistaPremium;

public class EntidadeDeDirecionamentos {

	
	public Double buscarTransacoesCorrentistaPremium(String transacoes) {
		CorrentistaPremium correntistaPremium = new CorrentistaPremium();
		EntidadeDeValidacao entidadeDeValidacao = new EntidadeDeValidacao();
		
		if (entidadeDeValidacao.validaTransacoes(transacoes)== null) {
			JOptionPane.showMessageDialog(null, "O valor "+ transacoes + " Não é valido" );
		}else {
			return correntistaPremium.calcularBeneficioPremium(entidadeDeValidacao.validaTransacoes(transacoes));
		}
		
		return null;
	}
	
}
