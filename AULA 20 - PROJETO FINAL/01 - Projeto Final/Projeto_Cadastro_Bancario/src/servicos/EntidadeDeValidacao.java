package servicos;

public class EntidadeDeValidacao {

	public Integer validaTransacoes(String transacoesString) {
		
		int transacoesInt;
		try {
			transacoesInt = Integer.parseInt(transacoesString);
		} catch (Exception e) {
			return null;
		}
		
		return transacoesInt;
	}

}