package controlador.gerente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistencia.dao.DaoGerente;
import repositorio.GerenteRepositorio;
import repositorio.GerenteRepositorioImplemetacao;
import tela.gerente.TelaCadastroGerente;
import tela.gerente.TelaDeletarGerente;
import tela.gerente.TelaListarGerente;
import tela.gerente.TelaSelecionarAlterarGerente;


public class TelaMenuGerenteControlador implements ActionListener {

	//Atributo de Classe
	JTextField opcaoRecebida;
	JFrame frameTelaMenuGerente;
	
	// Telas
	TelaCadastroGerente cadastroGerente = new TelaCadastroGerente();
	TelaListarGerente telaListarGerente = new TelaListarGerente();
	TelaDeletarGerente telaDeletarGerente = new TelaDeletarGerente();
	TelaSelecionarAlterarGerente alterarSelecionarGerente = new TelaSelecionarAlterarGerente();

	GerenteRepositorioImplemetacao gerenteRepositorio = new GerenteRepositorioImplemetacao();
	


	

	public TelaMenuGerenteControlador(JTextField opcaoRecebida, JFrame frameTelaMenuGerente) {
		
		this.opcaoRecebida = opcaoRecebida;
		this.frameTelaMenuGerente = frameTelaMenuGerente;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(opcaoRecebida.getText().equals("G1") || opcaoRecebida.getText().equals("G2") || opcaoRecebida.getText().equals("G3") || 
				opcaoRecebida.getText().equals("G4") ) {
			
			switch (opcaoRecebida.getText()) {
				case "G1": {
					cadastroGerente.chamarTelaCadastroGerente();
					System.out.println("Direcione para o cadastro de gerente");
					frameTelaMenuGerente.setVisible(false);
					break;
				}
				case "G2": {
					telaListarGerente.listarGerente(gerenteRepositorio.listarGerenteRepositorio());
					System.out.println("Direcione para a lista de gerente");
					break;
				}
				case "G3": {
					telaDeletarGerente.chamardTelaeletarGerente(gerenteRepositorio.listarGerenteRepositorio());
					System.out.println("Direcione para deletar de gerente");
					break;
				}
				case "G4": {
					alterarSelecionarGerente.chamarTelaeletarGerente(gerenteRepositorio.listarGerenteRepositorio());
					System.out.println("Direcione para deletar de gerente");
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
