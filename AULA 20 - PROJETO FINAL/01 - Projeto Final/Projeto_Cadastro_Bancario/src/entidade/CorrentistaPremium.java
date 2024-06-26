package entidade;

public class CorrentistaPremium extends Pessoa {

	@Override
	public Double calcularBeneficioPremium (int transacoes) {
		
		return transacoes*50.0;
		
	}
	
	
}
