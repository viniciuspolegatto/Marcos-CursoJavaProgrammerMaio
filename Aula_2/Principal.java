import java.util.Scanner; // Objeto java Padrão para receber dados atraves do console.

public class Principal{
	
	public static void main(String[] args){

		Scanner entradaDeDados = new Scanner (System.in); // Objeto java Padrão para receber dados atraves do console.
	
		Atleta objetoAtleta = new Atleta(); // Chamar e inicializar
		
		System.out.println("Digite o nome do Atleta:");  // Trecho de codigo usado para apresentar a mensagem para o usuario.
		
		objetoAtleta.nomeAtleta = entradaDeDados.next(); // Estou armazenando o valor digitado pelo usuario na variavel Nome. 

		System.out.println("O nome recebido foi: " + objetoAtleta.nomeAtleta);

		System.out.println("Digite a idade do Atleta: ");
		objetoAtleta.idade = Integer.parseInt(entradaDeDados.next());

		System.out.println("A idade do atleta: " + objetoAtleta.idade);

		 
		
	}	
}