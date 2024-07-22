package controlador.atendente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cliente.EnderecoCliente;
import entidade.Atendente;
import entidade.Endereco;
import enuns.SetorEnum;
import repositorio.AtendenteRepositorioImplemetacao;
import tela.atendente.TelaMenuAtendente;

public class TelaCadastroAtendenteControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCpf;
	JComboBox<SetorEnum> caixaSelecaoSetor;
	JTextField qtdHora;
	JFrame frameTelaCadastroAtendente;
	JTextField jTextFieldCep;

	EnderecoCliente enderecoCliente = new EnderecoCliente();

	AtendenteRepositorioImplemetacao atendenteRepositorioImplemetacao = new AtendenteRepositorioImplemetacao();
	TelaMenuAtendente telaAtendente = new TelaMenuAtendente();

	public TelaCadastroAtendenteControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCpf, JComboBox<SetorEnum> caixaSelecaoSetor,
			JFrame frameTelaCadastroAtendente, JTextField caixaTextoQuartoCampoRecebidoSetor,
			JTextField jTextFieldCep) {

		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCpf = caixaTextoSegundoCampoRecebidoCpf;
		this.caixaSelecaoSetor = caixaSelecaoSetor;
		this.frameTelaCadastroAtendente = frameTelaCadastroAtendente;
		this.qtdHora = caixaTextoQuartoCampoRecebidoSetor;
		this.jTextFieldCep = jTextFieldCep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Atendente atendenteConfirmacao = populaAtendente();
		int confirmacao = JOptionPane.showConfirmDialog(null, "Confirme os dados:" +"\n"
														+ atendenteConfirmacao.getNome()+"\n"
														+atendenteConfirmacao.getCpf()+ "\n"
														+atendenteConfirmacao.getEndereco().getBairro()+ "\n"
														+atendenteConfirmacao.getEndereco().getLocalidade()+ "\n"
														+atendenteConfirmacao.getEndereco().getLogradouro()+ "\n"
														+atendenteConfirmacao.getEndereco().getUf()+ "\n"
														);
		if (confirmacao == 0) {
			registraNoBanco(atendenteConfirmacao);
			frameTelaCadastroAtendente.setVisible(false);
			telaAtendente.chamarTelaMenuAtendente();
		}
	}

	public Atendente populaAtendente() {

		Atendente atendente = new Atendente();
		atendente.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		atendente.setCpf(caixaTextoSegundoCampoRecebidoCpf.getText());
		atendente.setSetor(caixaSelecaoSetor.getSelectedItem().toString());
		try {
			atendente.setEndereco(enderecoCliente.buscarEnderecoPeloCep(jTextFieldCep.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return atendente;
	}

	public void registraNoBanco(Atendente atendenteConfirmado) {

		if (atendenteRepositorioImplemetacao.salvarAtendenteRepositorio(atendenteConfirmado, qtdHora.getText())) {
			JOptionPane.showMessageDialog(null, "Atendente Registrado com Sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao registrar o atendente");
		}

	}

}
