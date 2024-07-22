package validacao;

public class EntidadeValidacao {
	
	public Integer validaqtdHora(String qtdHoraString) {
		
		int qtdHoraInt;
		try {
			qtdHoraInt = Integer.parseInt(qtdHoraString);
		} catch (Exception e) {
			return null;
		}
		
		return qtdHoraInt;
	}

}
