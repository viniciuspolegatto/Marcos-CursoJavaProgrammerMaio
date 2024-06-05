package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;

import entidade.Cobra;
import entidade.Cachorro;


public class ManipuladorArquivo {
	
	public void registrarCobra (Cobra cobra) {
		
		String enderecoArquivo = "D:\\JAVA PROGRAMMING - Autonomo\\8 - Cadastro Animais\\8 - 1 Git Luciano\\CursoJavaProgrammerMaio\\cadastroFuncionarioRevisao\\registroAnimais.txt";
		
		try {
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			
			bufferedWriter.append("O nome do gerente é:" + cobra.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do gerente é:" + cobra.getCaf());
			bufferedWriter.newLine();
			bufferedWriter.append("A especie da Cobra é:" + cobra.getEspecie());
			
			bufferedWriter.close();
				
		} catch (Exception e) {
			System.out.println("Erro ao registrar a cobra!!!!"); 
		}
	}

	
	public void registrarCachorro (Cachorro cachorro) {
		
		String enderecoArquivo = "D:\\JAVA PROGRAMMING - Autonomo\\8 - Cadastro Animais\\8 - 1 Git Luciano\\CursoJavaProgrammerMaio\\cadastroFuncionarioRevisao\\registroAnimais.txt";
		
		try {
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			
			bufferedWriter.append("O nome do gerente é:" + cachorro.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do gerente é:" + cachorro.getCaf());
			bufferedWriter.newLine();
			bufferedWriter.append("A especie da Cobra é:" + cachorro.getEspecie());
			
			bufferedWriter.close();
				
		} catch (Exception e) {
			System.out.println("Erro ao registrar o cachorro!!!!"); 
		}
	}


}
