
package entidade;


public abstract class CadastroGeral {

	
	private String nome;
	private String caf;
	private String especie;
	private Double valor;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCaf() {
		return caf;
	}
	public void setCaf(String caf) {
		this.caf = caf;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	//Metodo Para calcular o salario vai ser a qtd * o salario padra de cada cargo
	public Double calcularValor(int qtdQuilos) {
		
		return qtdQuilos * 9.30;
		
	}
	

	

}