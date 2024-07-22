package controlador.gerente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Gerente;
import repositorio.GerenteRepositorioImplemetacao;
import tela.gerente.TelaMenuGerente;

public class TelaFormularioAlterarGerenteControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	String caixaTextoSegundoCampoRecebidoCpf;
	JTextField caixaTextoTerceiroCampoRecebidoGerencia;
	JFrame frameTelaAlterarGerente;
	
	public TelaFormularioAlterarGerenteControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			String caixaTextoSegundoCampoRecebidoCpf, JTextField caixaTextoTerceiroCampoRecebidoGerencia,
			JFrame frameTelaAlterarGerente) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCpf = caixaTextoSegundoCampoRecebidoCpf;
		this.caixaTextoTerceiroCampoRecebidoGerencia = caixaTextoTerceiroCampoRecebidoGerencia;
		this.frameTelaAlterarGerente = frameTelaAlterarGerente;
	}
	GerenteRepositorioImplemetacao gerenteRepositorioImplemetacao = new GerenteRepositorioImplemetacao();
	TelaMenuGerente telaMenuGerente = new TelaMenuGerente();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		alterarGerenteNoBanco();
		
	}
	
	public void alterarGerenteNoBanco() {
		Gerente gerente = new Gerente();
		gerente.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		gerente.setCpf(caixaTextoSegundoCampoRecebidoCpf);
		gerente.setGerencia(caixaTextoTerceiroCampoRecebidoGerencia.getText());
		
		if(gerenteRepositorioImplemetacao.alterarGerenteRepositorio(gerente)){
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			frameTelaAlterarGerente.setVisible(false);
			telaMenuGerente.chamarTelaMenuGerente();
		}else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");
			
		}
	}

}
