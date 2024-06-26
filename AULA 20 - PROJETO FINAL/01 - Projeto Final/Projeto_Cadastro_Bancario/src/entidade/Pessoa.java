package entidade;

public class Pessoa {

	
	//AQUI ESTAMOS DECLARANDO VALORES PRIVADOS PARA SEREM ACIONADOS VIA CONSTRUTORES
	// ENCAPSULAMENTO
	private String nome;
	private String cpf;
	private Double transacoes;
	
	
	
	// BOTÃO DIREITO - SOURCE - Generate Getters and Setters - ENCAPSULAMENTO
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getTransacoes() {
		return transacoes;
	}
	public void setTransacoes(Double transacoes) {
		this.transacoes = transacoes;
	}
	//Metodo Para calcular o salario vai ser a qtd * o salario padra de cada cargo
	public Double calcularBeneficioPremium(int transacoes) {
		
		return transacoes * 9.30;
	}
	
	
}
