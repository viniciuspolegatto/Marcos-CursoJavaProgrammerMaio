package tela.atendente;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.atendente.TelaMenuAtendenteControlador;

public class TelaMenuAtendente {
	
	public void chamarTelaMenuAtendente() {
		GridLayout grid = new GridLayout (0,1);
		
		JFrame frameTelaMenuAtendente = new JFrame();// Instanciando um JFrame Vazio
		
		frameTelaMenuAtendente.setSize(200 , 200); // Altura e largura
		JPanel panelTelaMenuAtendente = new JPanel();// Cria o objeto painel
		
		JLabel labelOpcaoCadastroAtendente = new JLabel("A1 - CADASTRAR Atendente");//Cria a label 1
		panelTelaMenuAtendente.add(labelOpcaoCadastroAtendente);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoListaAtendente = new JLabel("A2 - LISTAR Atendente");//Cria a label 1
		panelTelaMenuAtendente.add(labelOpcaoListaAtendente);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoDeletarAtendente = new JLabel("A3 - DELETAR Atendente");//Cria a label 1
		panelTelaMenuAtendente.add(labelOpcaoDeletarAtendente);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoAlterarAtendente = new JLabel("A4 - ALTERAR Atendente");//Cria a label 1
		panelTelaMenuAtendente.add(labelOpcaoAlterarAtendente);// Adiciona a label 1 no painel
		
		
		panelTelaMenuAtendente.setLayout(grid);
		
		JTextField opcaoTexto = new JTextField(10);// Caixa de texto
		
		panelTelaMenuAtendente.add(opcaoTexto);//add o que foi digitado 
		
		JButton botaoEnviar = new JButton("Enviar");
		panelTelaMenuAtendente.add(botaoEnviar);
		
		frameTelaMenuAtendente.add(panelTelaMenuAtendente);//Adiciona o painel no frame
		frameTelaMenuAtendente.setVisible(true);//Deixa visivel
		
		TelaMenuAtendenteControlador atendenteControlador = new TelaMenuAtendenteControlador(opcaoTexto, frameTelaMenuAtendente);
		botaoEnviar.addActionListener(atendenteControlador);
		
	}
}
