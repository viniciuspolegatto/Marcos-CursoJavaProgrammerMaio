package tela;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaMenuCachorroController;

public class TelaMenuCachorro {
	
	public void chamarTelaMenuCachorro() {
		JFrame frameTelaMenuCachorro = new JFrame();// Instanciando um JFrame Vazio
		
        // Posicionar a janela no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameTelaMenuCachorro.setLocation(dim.width / 2 - frameTelaMenuCachorro.getSize().width / 2, 
                                     dim.height / 2 - frameTelaMenuCachorro.getSize().height / 2);
		
		frameTelaMenuCachorro.setSize(200 , 200); // Altura e largura
		JPanel panelTelaMenuCachorro = new JPanel();// Cria o objeto painel
		
		JLabel labelOpcaoCadastroCachorro = new JLabel("C1 - CADASTRAR CACHORRO");//Cria a label 1
		panelTelaMenuCachorro.add(labelOpcaoCadastroCachorro);// Adiciona a label 1 no painel
		
		JLabel labelOpcaoListaCachorro = new JLabel("C2 - LISTAR CACHORRO");//Cria a label 1
		panelTelaMenuCachorro.add(labelOpcaoListaCachorro);// Adiciona a label 1 no painel
		
		
		JTextField opcaoTexto = new JTextField(10);// Caixa de texto
		
		panelTelaMenuCachorro.add(opcaoTexto);//add o que foi digitado 
		
		JButton botaoEnviar = new JButton("Enviar");
		panelTelaMenuCachorro.add(botaoEnviar);
		
		frameTelaMenuCachorro.add(panelTelaMenuCachorro);//Adiciona o painel no frame
		frameTelaMenuCachorro.setVisible(true);//Deixa visivel
		
		TelaMenuCachorroController telaMenuCachorroController = new TelaMenuCachorroController(opcaoTexto);
		botaoEnviar.addActionListener(telaMenuCachorroController);
		
	}

}
