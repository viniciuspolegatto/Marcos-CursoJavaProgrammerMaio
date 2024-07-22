package servico;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JOptionPane;

import entidade.Atendente;
import entidade.Gerente;
import validacao.EntidadeValidacao;

public class EntidadeServico {
	
	public Double buscarSalarioAtendente(String qtdHoras) {
		Atendente atendente = new Atendente();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();
		
		if (entidadeValidacao.validaqtdHora(qtdHoras)== null) {
			JOptionPane.showMessageDialog(null, "O valor "+ qtdHoras + " Não é valido" );
		}else {
			return atendente.calcularSalario(entidadeValidacao.validaqtdHora(qtdHoras));
		}
		
		return null;
	}
	
	public Double buscarSalarioGerente(String qtdHoras) {
		Gerente gerente = new Gerente();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();
		
		if (entidadeValidacao.validaqtdHora(qtdHoras)== null) {
			JOptionPane.showMessageDialog(null, "O valor "+ qtdHoras + " Não é valido" );
		}else {
			return gerente.calcularSalario(entidadeValidacao.validaqtdHora(qtdHoras));
		}
		
		return null;
	}
	
	public void gerarPdfDetalharGerente(Gerente gerente) {
		String caminhoArquivo = "D:\\Git\\" + "RelatorioDetalharGerente-" + gerente.getNome()+".pdf" ;
		// Caminho do arquivo com o nome do gerente
		Document document = new Document();
		//Objeto java do Document que vai ser manipulado
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
			writer.setPageEvent(new RodapeTemplate());
			//Objeto gerador de PDF usando o cabeçalho e rodapé da classe  CabecalhoRodapeTemplate()
			
			
			document.open();//Abre Manipulação do objeto Document
			document.add(new Paragraph("Empresa: IMPACTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			//Adiciona nome da empresa no cabeçalho
			document.add(new Paragraph("Relatorio de Detalhe do Gerente", FontFactory.getFont(FontFactory.HELVETICA_BOLD,14)));
			//Adiciona o nome do relatorio
			document.add(new Paragraph(" "));// pular uma linha
			
			
			if(gerente != null) {	
			
				PdfPTable table = new PdfPTable(2);// Cria objeto da tabela com a quantidade de colunas
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				table.setWidthPercentage(100);//Ocupação da tabela na pagina
				
				table.addCell("CPF");//Primeiro item da primeira linha
				table.addCell(gerente.getCpf());//segundo item da primeira linha
				
				table.addCell("Nome");
				table.addCell(gerente.getNome());
				
				table.addCell("Salario");
				table.addCell(gerente.getSalario().toString());
			
				table.addCell("Cep");
				table.addCell(gerente.getEndereco().getCep());
				
				table.addCell("Localidade");
				table.addCell(gerente.getEndereco().getLocalidade());
				
				table.addCell("Logradouro");
				table.addCell(gerente.getEndereco().getLogradouro());
				
				table.addCell("Bairro");
				table.addCell(gerente.getEndereco().getBairro());
				
				table.addCell("Uf");
				table.addCell(gerente.getEndereco().getUf());
				
				table.addCell("Siafi");
				if(gerente.getEndereco().getSiafi() == null) {
					
					table.addCell("Não informado");
				}else {
					table.addCell(gerente.getEndereco().getSiafi());
				}
		
				document.add(table);

			}
			
			document.close();
			
			File pdfArquivo = new File(caminhoArquivo);
			
			if(pdfArquivo.exists()) {
				if(Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfArquivo);
				}else {
					System.out.println("PDF gerado mas não foi possivel abrir");
				}
				
			}else {
				System.out.println("PDF gerado mas não foi possivel encontrar");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	public void gerarPdfDetalharAtendente(Atendente atendente) {
		String caminhoArquivo = "C:\\Users\\Lucia\\Downloads\\" + "RelatorioDetalharAtendente-" + atendente.getNome()+".pdf" ;
		// Caminho do arquivo com o nome do gerente
		Document document = new Document();
		//Objeto java do Document que vai ser manipulado
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
			writer.setPageEvent(new RodapeTemplate());
			//Objeto gerador de PDF usando o cabeçalho e rodapé da classe  CabecalhoRodapeTemplate()
			
			
			document.open();//Abre Manipulação do objeto Document
			document.add(new Paragraph("Empresa: IMPACTA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14)));
			//Adiciona nome da empresa no cabeçalho
			document.add(new Paragraph("Relatorio de Detalhe do Atendente", FontFactory.getFont(FontFactory.HELVETICA_BOLD,14)));
			//Adiciona o nome do relatorio
			document.add(new Paragraph(" "));// pular uma linha
			
			
			if(atendente != null) {	
			
				PdfPTable table = new PdfPTable(2);// Cria objeto da tabela com a quantidade de colunas
				table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
				table.setWidthPercentage(100);//Ocupação da tabela na pagina
				
				table.addCell("CPF");//Primeiro item da primeira linha
				table.addCell(atendente.getCpf());//segundo item da primeira linha
				
				table.addCell("Nome");
				table.addCell(atendente.getNome());
				
				table.addCell("Salario");
				table.addCell(atendente.getSalario().toString());
			
				table.addCell("Cep");
				table.addCell(atendente.getEndereco().getCep());
				
				table.addCell("Localidade");
				table.addCell(atendente.getEndereco().getLocalidade());
				
				table.addCell("Logradouro");
				table.addCell(atendente.getEndereco().getLogradouro());
				
				table.addCell("Bairro");
				table.addCell(atendente.getEndereco().getBairro());
				
				table.addCell("Uf");
				table.addCell(atendente.getEndereco().getUf());
				
				table.addCell("Siafi");
				if(atendente.getEndereco().getSiafi() == null) {
					
					table.addCell("Não informado");
				}else {
					table.addCell(atendente.getEndereco().getSiafi());
				}
		
				document.add(table);

			}
			
			document.close();
			
			File pdfArquivo = new File(caminhoArquivo);
			
			if(pdfArquivo.exists()) {
				if(Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfArquivo);
				}else {
					System.out.println("PDF gerado mas não foi possivel abrir");
				}
				
			}else {
				System.out.println("PDF gerado mas não foi possivel encontrar");
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}
	
}
