package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaMenuCobraController;

public class TelaMenuCobra {
	
	public void chamarTelaMenuCobra() {
		GridLayout grid = new GridLayout (0,1);
		
		JFrame frameTelaMenuCobra = new JFrame();// Instanciando um JFrame Vazio
		
		frameTelaMenuCobra.setSize(200 , 200); // Altura e largura
		JPanel panelTelaMenuCobra = new JPanel();// Cria o objeto painel
		
		JLabel labelOpcaoCadastroCobra = new JLabel("C1 - CADASTRAR COBRA");//Cria a label 1
		panelTelaMenuCobra.add(labelOpcaoCadastroCobra);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoListaCobra = new JLabel("C2 - LISTAR COBRA");//Cria a label 1
		panelTelaMenuCobra.add(labelOpcaoListaCobra);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoDeletarCobra = new JLabel("C3 - DELETAR COBRA");//Cria a label 1
		panelTelaMenuCobra.add(labelOpcaoDeletarCobra);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoAlterarCobra = new JLabel("C4 - ALTERAR COBRA");//Cria a label 1
		panelTelaMenuCobra.add(labelOpcaoAlterarCobra);// Adiciona a label 1 no painel
		
		
		panelTelaMenuCobra.setLayout(grid);
		
		JTextField opcaoTexto = new JTextField(10);// Caixa de texto
		
		panelTelaMenuCobra.add(opcaoTexto);//add o que foi digitado 
		
		JButton botaoEnviar = new JButton("Enviar");
		panelTelaMenuCobra.add(botaoEnviar);
		
		frameTelaMenuCobra.add(panelTelaMenuCobra);//Adiciona o painel no frame
		frameTelaMenuCobra.setVisible(true);//Deixa visivel
		
		TelaMenuCobraController telaMenuCobraController = new TelaMenuCobraController(opcaoTexto, frameTelaMenuCobra);
		botaoEnviar.addActionListener(telaMenuCobraController);
		
	}

}
