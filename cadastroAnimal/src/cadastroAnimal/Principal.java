package cadastroAnimal;

import java.util.Scanner;

import entidade.Animal;

public class Principal {

	public static void main(String[] args) {

Animal objetoAnimal = new Animal();// Cria o objeto vazio
		
		
		Scanner entradaDados = new Scanner(System.in);
		
		System.out.println("Infome o nome do Animal: ");
		objetoAnimal.nome = entradaDados.next();
		
		System.out.println("Informe a Idade do Animal: ");
		objetoAnimal.idade = Integer.parseInt(entradaDados.next());// Converte String para inteiro
		
		System.out.println("Informe o Peso do Animal: ");
		objetoAnimal.peso = Integer.parseInt(entradaDados.next());// Converte a String para double
		
		
		objetoAnimal.preco = calcularPreco(objetoAnimal.peso);
		
		imprimirResultadosNoConsole(objetoAnimal); // Chamo a execução do metodo para imprimir os resultados
	
		
	}//FIM DO METODO
	
	//Metodo pra imprimir resultado
	
	public static void imprimirResultadosNoConsole(Animal animal) {
		System.out.println("Nome do Animal:" + animal.nome);
		System.out.println("Idade do Animal:" + animal.idade);
		System.out.println("Preço do Animal:" + animal.preco);
		
			
	}
	
	public static Double calcularPreco(double peso) {
		
		double preco = peso * 10;
		
		return preco;
	}
	
	

}