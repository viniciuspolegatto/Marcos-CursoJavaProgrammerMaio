package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tela.TelaCadastroCobra;

public class TelaMenuCobraController implements ActionListener {

	//Atributo de Classe
	JTextField opcaoRecebida;
	
	// Telas
	TelaCadastroCobra cadastroCobra = new TelaCadastroCobra();

	public TelaMenuCobraController(JTextField opcaoRecebida) {
		this.opcaoRecebida = opcaoRecebida;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(opcaoRecebida.getText().equals("C1") || opcaoRecebida.getText().equals("C2") ) {
			switch (opcaoRecebida.getText()) {
				case "C1": {
					cadastroCobra.chamarTelaCadastroCobra();
					System.out.println("Direcione para o cadastro de cobra");
					break;
					
				}
				case "C2": {
					
					System.out.println("Direcione para a lista de cobra");
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
