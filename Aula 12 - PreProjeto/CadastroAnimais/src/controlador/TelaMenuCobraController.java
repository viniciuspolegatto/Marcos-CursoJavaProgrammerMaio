package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistencia.DaoCobra;
import repositorio.CobraRepositorio;
import repositorio.CobraRepositorioImplementacao;
import tela.TelaCadastroCobra;
import tela.TelaDeletarCobra;
import tela.TelaListarCobra;

public class TelaMenuCobraController implements ActionListener {

	//Atributo de Classe
	JTextField opcaoRecebida;
	JFrame frameTelaMenuCobra;
	
	// Telas
	TelaCadastroCobra cadastroCobra = new TelaCadastroCobra();
	TelaListarCobra telaListarCobra = new TelaListarCobra();
	TelaDeletarCobra telaDeletarCobra = new TelaDeletarCobra();
	CobraRepositorioImplementacao cobraRepositorio = new CobraRepositorioImplementacao();

	public TelaMenuCobraController(JTextField opcaoRecebida, JFrame frameTelaMenuCobra) {
		this.opcaoRecebida = opcaoRecebida;
		this.frameTelaMenuCobra = frameTelaMenuCobra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(opcaoRecebida.getText().equals("C1") || opcaoRecebida.getText().equals("C2") ) {
			switch (opcaoRecebida.getText()) {
				case "C1": {
					cadastroCobra.chamarTelaCadastroCobra();
					System.out.println("Direcione para o cadastro de cobra");
					frameTelaMenuCobra.setVisible(false);
					break;
					
				}
				case "C2": {
					telaListarCobra.listarCobra(cobraRepositorio.listarCobraRepositorio());
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
