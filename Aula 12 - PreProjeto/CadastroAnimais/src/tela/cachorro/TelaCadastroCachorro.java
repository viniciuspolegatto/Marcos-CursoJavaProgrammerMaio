package tela.cachorro;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaCadastroCachorroController;

public class TelaCadastroCachorro {
	
	public void chamarTelaCadastroCachorro() {
		
		String primeiroCampo = "Digite o nome do Cachorro";
		String segundoCampo  = "Digite o CAF do Cachorro";
		String terceiroCampo = "Digite a espécie do cachorro";
		
		JFrame frameTelaCadastroCachorro = new JFrame();// Instanciando um JFrame Vazio
		
        // Posicionar a janela no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameTelaCadastroCachorro.setLocation(dim.width / 2 - frameTelaCadastroCachorro.getSize().width / 2, 
                                     dim.height / 2 - frameTelaCadastroCachorro.getSize().height / 2);
		
		frameTelaCadastroCachorro.setSize(200 , 250); // Altura e largura
		JPanel panelTelaCadastroCachorro = new JPanel();// Cria o objeto painel
		
		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCachorro.add(labelPrimeiroCampo);
		
		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoPrimeiroCampo);
		
		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroCachorro.add(labelSegundoCampo);
		
		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoSegundoCampo);
		
		
		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCachorro.add(labelTerceiroCampo);
		
		JTextField caixaTextoTerceiroCampo = new JTextField(10);
		panelTelaCadastroCachorro.add(caixaTextoTerceiroCampo);
		
		
		JButton botaoCadastrar = new JButton("Cadastrar Cachorro");
		panelTelaCadastroCachorro.add(botaoCadastrar);
		
		
		frameTelaCadastroCachorro.add(panelTelaCadastroCachorro);
		frameTelaCadastroCachorro.setVisible(true);
		
		TelaCadastroCachorroController cadastroCachorroController = new  TelaCadastroCachorroController(
				caixaTextoPrimeiroCampo,caixaTextoSegundoCampo,caixaTextoTerceiroCampo);
		botaoCadastrar.addActionListener(cadastroCachorroController);
		
	}

}
