package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tela.TelaCadastroCachorro;
import tela.TelaCadastroCobra;

public class TelaMenuCachorroController implements ActionListener {

	//Atributo de Classe
	JTextField opcaoRecebida;
	
	// Telas
	TelaCadastroCachorro cadastroCachorro = new TelaCadastroCachorro();
	TelaCadastroCobra cadastroCobra = new TelaCadastroCobra();

	public TelaMenuCachorroController(JTextField opcaoRecebida) {
		this.opcaoRecebida = opcaoRecebida;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(opcaoRecebida.getText().equals("C1") || opcaoRecebida.getText().equals("C2") ) {
			switch (opcaoRecebida.getText()) {
				case "C1": {
					cadastroCachorro.chamarTelaCadastroCachorro();
					System.out.println("Direcione para o cadastro de cobra");
					break;
					
				}
				case "C2": {
					cadastroCachorro.chamarTelaCadastroCachorro();
					System.out.println("Direcione para a lista de cachorro");
					break;
				}
				case "3": {
						System.exit(0);
						break;
						
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "A opcão " + opcaoRecebida.getText() +" Não é valida");
		}
	}
}
