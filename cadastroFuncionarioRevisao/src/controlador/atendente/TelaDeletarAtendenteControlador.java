package controlador.atendente;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.AtendenteRepositorioImplemetacao;
import tela.atendente.TelaMenuAtendente;

public class TelaDeletarAtendenteControlador implements ActionListener {
	
	JFrame telaDeletarAtendente;
	JTextField cpf;
	
	
	public TelaDeletarAtendenteControlador(JFrame telaDeletarAtendente, JTextField cpf) {
		this.telaDeletarAtendente = telaDeletarAtendente;
		this.cpf = cpf;
	}

	AtendenteRepositorioImplemetacao atendenteRepositorioImplemetacao = new AtendenteRepositorioImplemetacao();
	
	TelaMenuAtendente telaTelaMenuAtendente = new TelaMenuAtendente();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("DELETAR")) {
			if(atendenteRepositorioImplemetacao.deletaAtendenteRepositorio(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "Atendente Deletado!!");
				telaDeletarAtendente.setVisible(false);
				telaTelaMenuAtendente.chamarTelaMenuAtendente();
			}
		}
		if(e.getActionCommand().equals("MENU")) {
			telaDeletarAtendente.setVisible(false);
			telaTelaMenuAtendente.chamarTelaMenuAtendente();
		}
		
	}
	
	
	
	

}
