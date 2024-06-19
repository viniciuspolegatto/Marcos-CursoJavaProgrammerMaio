package tela.cobra;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaCadastroCobraController;
import enuns.EspecieEnum;
import enuns.FiloEnum;

public class TelaCadastroCobra {
	
	public void chamarTelaCadastroCobra () {
		
		GridLayout grid = new GridLayout (0,1);
		
		String primeiroCampo = "Digite o nome da Cobra";
		String segundoCampo  = "Digite o caf da Cobra";
		String terceiroCampo = "Digite a espécie da cobra";
		String quartoCampo = "Digite a quantidade de Quilos";
		
		
		JFrame frameTelaCadastroCobra = new JFrame();// Instanciando um JFrame Vazio
		
        // Posicionar a janela no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameTelaCadastroCobra.setLocation(dim.width / 2 - frameTelaCadastroCobra.getSize().width / 2, 
                                     dim.height / 2 - frameTelaCadastroCobra.getSize().height / 2);
        
		frameTelaCadastroCobra.setSize(200 , 250); // Altura e largura
		JPanel panelTelaCadastroCobra = new JPanel();// Cria o objeto painel
		
		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCobra.add(labelPrimeiroCampo);
		
		panelTelaCadastroCobra.setLayout(grid);
		
		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoPrimeiroCampo);
		
		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroCobra.add(labelSegundoCampo);
		
		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoSegundoCampo);
		
		
		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCobra.add(labelTerceiroCampo);
		
		//JTextField caixaTextoTerceiroCampo = new JTextField(10);
		//panelTelaCadastroCobra.add(caixaTextoTerceiroCampo);
		JComboBox<EspecieEnum> caixaSelecaoEspecie = new JComboBox<>(EspecieEnum.values());
		panelTelaCadastroCobra.add(caixaSelecaoEspecie);
		
		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroCobra.add(labelQuartoCampo);
		
		JTextField caixaTextoQuartoCampo = new JTextField(10);
		panelTelaCadastroCobra.add(caixaTextoQuartoCampo);
		
		
		JButton botaoCadastrar = new JButton("Cadastrar Cobra");
		panelTelaCadastroCobra.add(botaoCadastrar);
		
		
		frameTelaCadastroCobra.add(panelTelaCadastroCobra);
		frameTelaCadastroCobra.setVisible(true);
		
		TelaCadastroCobraController cadastroCobraController = new  TelaCadastroCobraController(
				caixaTextoPrimeiroCampo,caixaTextoSegundoCampo,caixaSelecaoEspecie, frameTelaCadastroCobra,caixaTextoQuartoCampo);
		botaoCadastrar.addActionListener(cadastroCobraController);
		
	}

}
