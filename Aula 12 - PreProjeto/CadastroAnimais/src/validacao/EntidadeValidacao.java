package validacao;

public class EntidadeValidacao {
	
	public Integer validaqtdQuilos(String qtdQuilosString) {
		
		int qtdQuilosInt;
		try {
			qtdQuilosInt = Integer.parseInt(qtdQuilosString);
		} catch (Exception e) {
			return null;
		}
		
		return qtdQuilosInt;
	}

}