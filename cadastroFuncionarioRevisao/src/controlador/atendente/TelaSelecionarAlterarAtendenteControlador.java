package controlador.atendente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Atendente;
import repositorio.AtendenteRepositorioImplemetacao;
import tela.atendente.TelaFormularioAlteraGerente;
import tela.atendente.TelaMenuAtendente;

public class TelaSelecionarAlterarAtendenteControlador implements ActionListener{

	JFrame telaListarAlterar;
	JTextField cpf;
	
	

	public TelaSelecionarAlterarAtendenteControlador(JFrame telaListarAlterar, JTextField cpf) {
		
		this.telaListarAlterar = telaListarAlterar;
		this.cpf = cpf;
	}

	TelaMenuAtendente telaAtendente = new TelaMenuAtendente();
	TelaFormularioAlteraGerente formularioAlteraGerente = new TelaFormularioAlteraGerente();
	AtendenteRepositorioImplemetacao atendenteRepositorioImplemetacao = new AtendenteRepositorioImplemetacao();


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("ALTERAR")) {
			
			System.out.println("ir para alterar");
			Atendente atendente = atendenteRepositorioImplemetacao.buscaAtendentePorCpf(cpf.getText());
			
			if(atendente != null){
				formularioAlteraGerente.chamarTelaCadastroAtendente(atendente);	
				telaListarAlterar.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "O CPF "+ cpf.getText() + " Não foi Encontrado!!" );
			}
			
		}
		
		if(e.getActionCommand().equals("MENU")){
			System.out.println("Voltar para o menu");
			telaAtendente.chamarTelaMenuAtendente();
			telaListarAlterar.setVisible(false);
		
			
		}
		
	}

}
