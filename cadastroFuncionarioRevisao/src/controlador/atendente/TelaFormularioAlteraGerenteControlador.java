package controlador.atendente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Atendente;
import repositorio.AtendenteRepositorioImplemetacao;
import tela.atendente.TelaMenuAtendente;

public class TelaFormularioAlteraGerenteControlador implements ActionListener {

	JFrame telaListarAlterar;
	JTextField nome;
	JTextField setor;
	String cpf;
	
	
	public TelaFormularioAlteraGerenteControlador(JFrame telaListarAlterar, JTextField nome, JTextField setor,
			String cpf) {
		this.telaListarAlterar = telaListarAlterar;
		this.nome = nome;
		this.setor = setor;
		this.cpf = cpf;
	}
	
	AtendenteRepositorioImplemetacao atendenteRepositorioImplemetacao = new AtendenteRepositorioImplemetacao();
	TelaMenuAtendente telaAtendente = new TelaMenuAtendente();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		alterarAtendente();
		
	}

	private void alterarAtendente() {
		Atendente atendente = new Atendente();
		atendente.setCpf(cpf);
		atendente.setNome(nome.getText());
		atendente.setSetor(setor.getText());
		
		if(atendenteRepositorioImplemetacao.alterarAtendenteRepositorio(atendente)) {
			JOptionPane.showMessageDialog(null, "O atendente " + atendente.getNome() + " Foi Alterado");
			telaListarAlterar.setVisible(false);
			telaAtendente.chamarTelaMenuAtendente();
		}else {
			JOptionPane.showMessageDialog(null, "O atendente " + atendente.getNome() + " Não Foi Alterado");
		}
		
		
		
	}

}
