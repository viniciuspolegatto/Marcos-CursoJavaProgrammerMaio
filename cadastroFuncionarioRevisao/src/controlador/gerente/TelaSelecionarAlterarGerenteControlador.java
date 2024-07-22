package controlador.gerente;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.accessibility.Accessible;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Gerente;
import repositorio.GerenteRepositorioImplemetacao;
import tela.gerente.TelaFormularioAlterarGerente;

public class TelaSelecionarAlterarGerenteControlador implements ActionListener {

	JTextField cpf;
	JFrame jFrameTelaAlterar;
	
	
	GerenteRepositorioImplemetacao gerenteRepositorioImplemetacao = new GerenteRepositorioImplemetacao();
	TelaFormularioAlterarGerente alterarGerente = new TelaFormularioAlterarGerente();

	
	public TelaSelecionarAlterarGerenteControlador(JTextField cpf, JFrame framealterarGerentes) {
		this.cpf = cpf;
		this.jFrameTelaAlterar = framealterarGerentes;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Gerente gerente  = gerenteRepositorioImplemetacao.buscaGerentePorCpf(cpf.getText());
		
		if ( gerente == null) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado o seguinte CPF: " + cpf.getText() );
		}else {
			jFrameTelaAlterar.setVisible(false);
			alterarGerente.chamarTelaCadastroGerente(gerente);
		}
		
	}

}
