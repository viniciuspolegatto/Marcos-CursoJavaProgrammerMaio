package tela.gerente;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.gerente.TelaMenuGerenteControlador;

public class TelaMenuGerente {
	
	public void chamarTelaMenuGerente() {
		GridLayout grid = new GridLayout (0,1);
		
		JFrame frameTelaMenuGerente = new JFrame();// Instanciando um JFrame Vazio
		
		frameTelaMenuGerente.setSize(200 , 200); // Altura e largura
		JPanel panelTelaMenuGerente = new JPanel();// Cria o objeto painel
		
		JLabel labelOpcaoCadastroGerente = new JLabel("G1 - CADASTRAR GERENTE");//Cria a label 1
		panelTelaMenuGerente.add(labelOpcaoCadastroGerente);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoListaGerente = new JLabel("G2 - LISTAR GERENTE");//Cria a label 1
		panelTelaMenuGerente.add(labelOpcaoListaGerente);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoDeletarGerente = new JLabel("G3 - DELETAR GERENTE");//Cria a label 1
		panelTelaMenuGerente.add(labelOpcaoDeletarGerente);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoAlterarGerente = new JLabel("G4 - ALTERAR GERENTE");//Cria a label 1
		panelTelaMenuGerente.add(labelOpcaoAlterarGerente);// Adiciona a label 1 no painel
		
		
		panelTelaMenuGerente.setLayout(grid);
		
		JTextField opcaoTexto = new JTextField(10);// Caixa de texto
		
		panelTelaMenuGerente.add(opcaoTexto);//add o que foi digitado 
		
		JButton botaoEnviar = new JButton("Enviar");
		panelTelaMenuGerente.add(botaoEnviar);
		
		frameTelaMenuGerente.add(panelTelaMenuGerente);//Adiciona o painel no frame
		frameTelaMenuGerente.setVisible(true);//Deixa visivel
		
		TelaMenuGerenteControlador telaMenuGerenteControlador = new TelaMenuGerenteControlador(opcaoTexto, frameTelaMenuGerente);
		botaoEnviar.addActionListener(telaMenuGerenteControlador);
		
	}

}
