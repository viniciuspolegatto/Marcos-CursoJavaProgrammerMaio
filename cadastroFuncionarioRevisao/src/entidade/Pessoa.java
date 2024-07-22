package entidade;

public abstract class Pessoa {
	
	private String nome;
	private String cpf;
	private Double salario;
	private Endereco endereco;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

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
	
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	//Metodo Para calcular o salario vai ser a qtd * o salario padra de cada cargo
	public Double calcularSalario(int qtdHora) {
		
		return qtdHora * 9.30;
		
	}


}
