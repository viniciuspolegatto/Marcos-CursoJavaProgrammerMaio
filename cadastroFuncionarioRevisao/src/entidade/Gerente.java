package entidade;

public class Gerente extends Pessoa {
	
	private String gerencia;

	public String getGerencia() {
		return gerencia;
	}
	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}
	
	@Override // SobreEscrever um metodo que já existe em uma classe pai
	public Double calcularSalario(int qtdHora) {
		
		return qtdHora * 50.0;
		
	}

	
}
