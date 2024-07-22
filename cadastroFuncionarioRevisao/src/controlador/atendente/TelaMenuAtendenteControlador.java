package controlador.atendente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import repositorio.AtendenteRepositorio;
import repositorio.AtendenteRepositorioImplemetacao;
import tela.atendente.TelaCadastroAtendente;
import tela.atendente.TelaDeletarAtendente;
import tela.atendente.TelaListarAtendente;
import tela.atendente.TelaSelecionarAlterarAtendente;

public class TelaMenuAtendenteControlador implements ActionListener {

	JTextField opcao;
	JFrame telaMenuAtendente;
	

	public TelaMenuAtendenteControlador(JTextField opcao, JFrame telaMenuAtendente) {
		this.opcao = opcao;
		this.telaMenuAtendente = telaMenuAtendente;
	}
	
	TelaCadastroAtendente telaCadastroAtendente = new TelaCadastroAtendente();
	TelaListarAtendente telaListarAtendente = new TelaListarAtendente();
	TelaDeletarAtendente telaAtendente = new TelaDeletarAtendente();
	TelaSelecionarAlterarAtendente telaAlterarAtendente = new TelaSelecionarAlterarAtendente();
	AtendenteRepositorioImplemetacao  atendenteRepositorioImplemetacao = new AtendenteRepositorioImplemetacao();

	@Override
	public void actionPerformed(ActionEvent e) {
		if(opcao.getText().equals("A1") || opcao.getText().equals("A2") || opcao.getText().equals("A3") || opcao.getText().equals("A4")) {
			switch (opcao.getText()) {
				case "A1": {
					telaMenuAtendente.setVisible(false);
					telaCadastroAtendente.chamarTelaCadastroAtendente();
					break;
				}
				case "A2": {
					telaMenuAtendente.setVisible(false);
					telaListarAtendente.listarAtendente(atendenteRepositorioImplemetacao.listarAtendenteRepositorio());
					break;
				}
				case "A3": {
					telaMenuAtendente.setVisible(false);
					telaAtendente.deletarAtendente(atendenteRepositorioImplemetacao.listarAtendenteRepositorio());
					break;
				}
				case "A4": {
					telaMenuAtendente.setVisible(false);
					telaAlterarAtendente.alterarAtendente(atendenteRepositorioImplemetacao.listarAtendenteRepositorio());
					break;
				}
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Opção Invalido");
		}
		
		
		
	}

}
