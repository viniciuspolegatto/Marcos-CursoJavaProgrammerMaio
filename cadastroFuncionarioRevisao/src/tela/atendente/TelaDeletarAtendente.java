package tela.atendente;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.atendente.TelaDeletarAtendenteControlador;
import entidade.Atendente;

public class TelaDeletarAtendente {
	
	public void deletarAtendente(List<Atendente> listaAtendentes) {

		int quantidadeDeLinhas = listaAtendentes.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][3];

		int posicaoColuna = 0;
		int posicaoLinha = 0;

		for (Atendente atendente : listaAtendentes) {

			tabelaString[posicaoLinha][posicaoColuna] = atendente.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = atendente.getNome();

			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = atendente.getSetor();

			posicaoLinha++;
			posicaoColuna = 0;

		}

		String nomeColunas[] = { "CPF", "NOME", "SETOR" };

		JFrame frameListarAtendente = new JFrame();

		frameListarAtendente.setSize(475, 450);

		JTable tabelaAtendentes = new JTable(tabelaString, nomeColunas);
		tabelaAtendentes.setSize(1000, 1000);
		tabelaAtendentes.setBounds(30, 40, 300, 300);

		JScrollPane scrollPaneListarAtendente = new JScrollPane(tabelaAtendentes);
		scrollPaneListarAtendente.setPreferredSize(new Dimension(400, 160));

		JPanel panelListarAtendente = new JPanel();
		panelListarAtendente.setSize(1000, 1000);
		JButton botaoMenu = new JButton("MENU");
		
		JButton botaoDeletar = new JButton("DELETAR");
		
		JTextField cpfTextField = new JTextField(10);

		panelListarAtendente.add(cpfTextField);
		panelListarAtendente.add(botaoDeletar);
		
		panelListarAtendente.add(scrollPaneListarAtendente);
		panelListarAtendente.add(botaoMenu);
		frameListarAtendente.add(panelListarAtendente);
		frameListarAtendente.setVisible(true);
		
		TelaDeletarAtendenteControlador telaDeletarAtendenteControlador = new TelaDeletarAtendenteControlador(frameListarAtendente, cpfTextField );
		botaoMenu.addActionListener(telaDeletarAtendenteControlador);
		botaoDeletar.addActionListener(telaDeletarAtendenteControlador);

	}

}
