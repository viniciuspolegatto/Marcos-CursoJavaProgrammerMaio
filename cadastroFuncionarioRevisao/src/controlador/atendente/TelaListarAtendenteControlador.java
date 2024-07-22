package controlador.atendente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import repositorio.AtendenteRepositorioImplemetacao;
import servico.EntidadeServico;
import tela.atendente.TelaMenuAtendente;

public class TelaListarAtendenteControlador implements ActionListener {

	
	JFrame telaListar;
	JTextField cpf;
	
	public TelaListarAtendenteControlador(JFrame telaListar, JTextField cpf) {
		this.cpf = cpf;
		this.telaListar = telaListar;
	}
	
	AtendenteRepositorioImplemetacao atendenteRepositorioImplemetacao = new AtendenteRepositorioImplemetacao();
	EntidadeServico entidadeServico = new EntidadeServico();

	TelaMenuAtendente telaMenuAtendente = new TelaMenuAtendente();
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "MENU") {
			telaListar.setVisible(false);
			telaMenuAtendente.chamarTelaMenuAtendente();
		}
		
		if(e.getActionCommand() == "DETALHAR") {
			entidadeServico.gerarPdfDetalharAtendente(atendenteRepositorioImplemetacao.buscaAtendentePorCpf(cpf.getText()));
		}
	}

}
