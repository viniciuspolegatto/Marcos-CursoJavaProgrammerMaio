package tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaCadastroCobraController;

public class TelaCadastroCobra {
	
	public void chamarTelaCadastroCobra () {
		
		String primeiroCampo = "Digite o nome da Cobra";
		String segundoCampo  = "Digite o caf da Cobra";
		String terceiroCampo = "Digite a espécie da cobra";
		
		JFrame frameTelaCadastroCobra = new JFrame();// Instanciando um JFrame Vazio
		
		frameTelaCadastroCobra.setSize(200 , 250); // Altura e largura
		JPanel panelTelaCadastroCobra = new JPanel();// Cria o objeto painel
		
		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCobra.add(labelPrimeiroCampo);
		
		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoPrimeiroCampo);
		
		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroCobra.add(labelSegundoCampo);
		
		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoSegundoCampo);
		
		
		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCobra.add(labelTerceiroCampo);
		
		JTextField caixaTextoTerceiroCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoTerceiroCampo);
		
		
		JButton botaoCadastrar = new JButton("Cadastrar Cobra");
		panelTelaCadastroCobra.add(botaoCadastrar);
		
		
		frameTelaCadastroCobra.add(panelTelaCadastroCobra);
		frameTelaCadastroCobra.setVisible(true);
		
		TelaCadastroCobraController cadastroCobraController = new  TelaCadastroCobraController(
				caixaTextoPrimeiroCampo,caixaTextoSegundoCampo,caixaTextoTerceiroCampo);
		botaoCadastrar.addActionListener(cadastroCobraController);
		
	}

}
