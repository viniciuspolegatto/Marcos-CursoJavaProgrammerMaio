package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;

import entidade.Gerente;
//Só adicionei para o exercicio ter um FIM - NÃO SE PREOCUPE
public class ManipuladorArquivo {
	
	public boolean registrarGerente (Gerente gerente) {
		
		String enderecoArquivo = "C:\\CursoJavaProgrammerMaio\\CursoJavaProgrammerMaio\\cadastroFuncionarioRevisao\\registroGerentes.txt";
		
		try {
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			
			bufferedWriter.append("O nome do gerente é:" + gerente.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do gerente é:" + gerente.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("A gerencia do gerente é:" + gerente.getGerencia());
			
			bufferedWriter.close();
				
		} catch (Exception e) {
			System.out.println("Erro ao registrar o gerente!!!!"); 
			return  false;
		}
		
		return true;
	}


}
