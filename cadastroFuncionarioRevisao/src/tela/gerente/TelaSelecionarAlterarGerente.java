package tela.gerente;

import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.gerente.TelaSelecionarAlterarGerenteControlador;
import entidade.Gerente;

public class TelaSelecionarAlterarGerente {
	
	public void chamarTelaeletarGerente(List<Gerente> listaGerentes) {

		int quantidadeDeLinhas = listaGerentes.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Gerente gerente : listaGerentes) {

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = gerente.getNome();

			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getGerencia();

			posicaoLinha++;
			posicaoColuna = 0;

		}

		String nomeColunas[] = { "CPF", "NOME", "GERENCIA" };

		JFrame framealterarGerentes = new JFrame();

		framealterarGerentes.setSize(475, 450);

		JTable tabelaGerentes = new JTable(tabelaString, nomeColunas);
		tabelaGerentes.setSize(1000, 1000);
		tabelaGerentes.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarGerente = new JScrollPane(tabelaGerentes);
		scrollPaneListarGerente.setPreferredSize(new Dimension(400, 160));

		JPanel panelListarGerente = new JPanel();
		panelListarGerente.setSize(1000, 1000);

		panelListarGerente.add(scrollPaneListarGerente);
		
		JTextField cpf = new JTextField(10);
		panelListarGerente.add(cpf);
		
		JButton botaoalterar = new JButton("Alterar");
		panelListarGerente.add(botaoalterar);

		framealterarGerentes.add(panelListarGerente);
		framealterarGerentes.setVisible(true);
		
		TelaSelecionarAlterarGerenteControlador alterarGerenteControlador = new TelaSelecionarAlterarGerenteControlador(cpf, framealterarGerentes);
		botaoalterar.addActionListener(alterarGerenteControlador);
	}


}
