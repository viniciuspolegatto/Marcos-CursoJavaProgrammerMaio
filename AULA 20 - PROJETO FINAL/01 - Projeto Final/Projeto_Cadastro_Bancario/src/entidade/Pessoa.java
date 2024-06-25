package entidade;

public class Pessoa {

	
	//AQUI ESTAMOS DECLARANDO VALORES PRIVADOS PARA SEREM ACIONADOS VIA CONSTRUTORES
	// ENCAPSULAMENTO
	private String nome;
	private String cpf;
	
	
	
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
	
	
	
	
	
}
