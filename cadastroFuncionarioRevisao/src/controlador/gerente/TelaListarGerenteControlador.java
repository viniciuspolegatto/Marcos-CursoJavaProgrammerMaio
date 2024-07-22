package controlador.gerente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import entidade.Gerente;
import repositorio.GerenteRepositorioImplemetacao;
import servico.EntidadeServico;

public class TelaListarGerenteControlador implements ActionListener {
	
	JTextField jTextFieldcpf;
		
	public TelaListarGerenteControlador(JTextField jTextFieldcpf) {
		super();
		this.jTextFieldcpf = jTextFieldcpf;
	}
	
	GerenteRepositorioImplemetacao gerenteRepositorioImplemetacao = new GerenteRepositorioImplemetacao();
	EntidadeServico entidadeServico = new EntidadeServico();

	@Override
	public void actionPerformed(ActionEvent e) {
		Gerente gerente = gerenteRepositorioImplemetacao.buscaGerentePorCpf(jTextFieldcpf.getText());
		entidadeServico.gerarPdfDetalharGerente(gerente);
		
		
	}

}
