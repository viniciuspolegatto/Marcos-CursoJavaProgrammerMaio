package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.CobraRepositorioImplementacao;
import tela.TelaCadastroCobra;
import tela.TelaDeletarCobra;
import tela.TelaListarCobra;
import tela.TelaSelecionarAlterarCobra;


public class TelaMenuCobraController implements ActionListener {

	//Atributo de Classe
	JTextField opcaoRecebida;
	JFrame frameTelaMenuCobra;
	
	// Telas
	TelaCadastroCobra cadastroCobra = new TelaCadastroCobra();
	TelaListarCobra telaListarCobra = new TelaListarCobra();
	TelaDeletarCobra telaDeletarCobra = new TelaDeletarCobra();
	TelaSelecionarAlterarCobra alterarSelecionarCobra = new TelaSelecionarAlterarCobra();

	CobraRepositorioImplementacao cobraRepositorio = new CobraRepositorioImplementacao();
	


	

	public TelaMenuCobraController(JTextField opcaoRecebida, JFrame frameTelaMenuCobra) {
		
		this.opcaoRecebida = opcaoRecebida;
		this.frameTelaMenuCobra = frameTelaMenuCobra;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(opcaoRecebida.getText().equals("C1") || opcaoRecebida.getText().equals("C2") || opcaoRecebida.getText().equals("C3") || 
				opcaoRecebida.getText().equals("C4") ) {
			
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
				case "C3": {
					telaDeletarCobra.chamarTelaDeletarCobra(cobraRepositorio.listarCobraRepositorio());
					System.out.println("Direcione para deletar de cobra");
					break;
				}
				case "C4": {
					alterarSelecionarCobra.chamarTelaeletarCobra(cobraRepositorio.listarCobraRepositorio());
					System.out.println("Direcione para deletar de cobra");
					break;
				}
				case "SAIR": {
						System.exit(0);
						break;
						
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "A opcão " + opcaoRecebida.getText() +" Não é valida");
		}
	}
}
