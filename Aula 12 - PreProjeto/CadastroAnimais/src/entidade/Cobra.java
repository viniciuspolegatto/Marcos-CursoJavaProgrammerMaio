package entidade;

public class Cobra extends CadastroGeral {
	
	private String especie;
	
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	@Override // SobreEscrever um metodo que já existe em uma classe pai
	public Double calcularValor(int qtdQuilos) {
		
		return qtdQuilos * 50.0;
		
	}

	
}

/*	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	@Override // SobreEscrever um metodo que já existe em uma classe pai
	public Double calcularValor(int qtdQuilos) {
		
		return qtdQUilos * 50.0;
		
	}
}
	*/