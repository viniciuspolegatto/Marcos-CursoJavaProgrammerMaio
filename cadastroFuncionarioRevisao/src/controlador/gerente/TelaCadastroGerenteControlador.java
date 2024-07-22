package controlador.gerente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cliente.EnderecoCliente;
import entidade.Atendente;
import entidade.Endereco;
import entidade.Gerente;
import enuns.GerenciaEnum;
import gerenciaArquivo.ManipuladorArquivo;
import persistencia.dao.DaoGerente;
import repositorio.GerenteRepositorio;
import repositorio.GerenteRepositorioImplemetacao;

public class TelaCadastroGerenteControlador implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCpf;
	JComboBox<GerenciaEnum> caixaSelecaoSetor;
	JTextField qtdHora;
	JTextField jTextcep;
	JFrame frameTelaCadastroGerente;
	
	EnderecoCliente enderecoCliente = new EnderecoCliente();
	
	
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	// DaoGerente daoGerente = new DaoGerente(); NUNCA DEVEMOS CHAMAR A DAO PELO CONTROLLER
	GerenteRepositorioImplemetacao gerenteRepositorioImp = new GerenteRepositorioImplemetacao();
	
	
	
	public TelaCadastroGerenteControlador(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCpf, JComboBox<GerenciaEnum> caixaSelecaoSetor,
			JFrame frameTelaCadastroGerente, JTextField qtdHora, JTextField jTextcep) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCpf = caixaTextoSegundoCampoRecebidoCpf;
		this.caixaSelecaoSetor = caixaSelecaoSetor;
		this.frameTelaCadastroGerente = frameTelaCadastroGerente;
		this.qtdHora = qtdHora;
		this.jTextcep = jTextcep;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Gerente gerenteConfirmacao = populaGerente();
		int confirmacao = JOptionPane.showConfirmDialog(null, "Confirme os dados:" +"\n"
														+ gerenteConfirmacao.getNome()+"\n"
														+ gerenteConfirmacao.getCpf()+ "\n"
														+ gerenteConfirmacao.getEndereco().getBairro()+ "\n"
														+ gerenteConfirmacao.getEndereco().getLocalidade()+ "\n"
														+ gerenteConfirmacao.getEndereco().getLogradouro()+ "\n"
														+ gerenteConfirmacao.getEndereco().getUf()+ "\n"
														);
		if(confirmacao == 0) {
			registrarNoBanco(gerenteConfirmacao);
			
			System.out.println("o nome: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
			System.out.println("o cpf: " + caixaTextoSegundoCampoRecebidoCpf.getText());
			System.out.println("a gerencia: " + caixaSelecaoSetor.getSelectedItem().toString());
			frameTelaCadastroGerente.setVisible(false);
		}
		
	}
	
	public void registrarNoBanco(Gerente gerenteConfirmado) {
		
		if(gerenteRepositorioImp.salvarGerenteRepositorio(gerenteConfirmado, qtdHora.getText())){
			JOptionPane.showMessageDialog(null, "Sarrrvou com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Não Sarrrvou com sucesso");
			
		}
		
	}
	
	public Gerente populaGerente() {
		Gerente gerente = new Gerente();
		gerente.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		gerente.setCpf(caixaTextoSegundoCampoRecebidoCpf.getText());
		gerente.setGerencia(caixaSelecaoSetor.getSelectedItem().toString());
		try {
			gerente.setEndereco(enderecoCliente.buscarEnderecoPeloCep(jTextcep.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gerente;
	}

}
