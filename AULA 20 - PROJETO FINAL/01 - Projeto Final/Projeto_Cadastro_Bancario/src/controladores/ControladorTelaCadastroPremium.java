package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.CorrentistaPremium;
import repositorio.CorrentistaPremiumRepositorioImplementacao;



public class ControladorTelaCadastroPremium implements ActionListener {


	JTextField opcaoTexto;
	JTextField opcaoTexto3;
	JTextField opcaoTexto4;
	JTextField opcaoTexto5;
	JTextField opcaoTexto6;
	JTextField opcaoTexto7;
	JFrame frameTelaCadastroPremium;
	
	//EnderecoCorrentista enderecoCorrentista = new EnderecoCorrentista();
	
	
	//ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	// DaoCorrentistaPremium daoCorrentistaPremium = new DaoCorrentistaPremium() **** NUNCA DEVEMOS CHAMAR A DAO PELO CONTROLLER ***
	CorrentistaPremiumRepositorioImplementacao correntistaPremiumRepositorioImp = new CorrentistaPremiumRepositorioImplementacao();
	
	
	
	public ControladorTelaCadastroPremium(JTextField opcaoTexto, JTextField opcaoTexto3, JTextField opcaoTexto4,
			JTextField opcaoTexto5, JTextField opcaoTexto6, JTextField opcaoTexto7, JFrame frameTelaCadastroPremium) {
		this.opcaoTexto = opcaoTexto;
		this.opcaoTexto3 = opcaoTexto3;
		this.opcaoTexto4 = opcaoTexto4;
		this.opcaoTexto5 = opcaoTexto5;
		this.opcaoTexto6 = opcaoTexto6;
		this.opcaoTexto7 = opcaoTexto7;
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		CorrentistaPremium correntistaPremiumConfirmacao = populaCorrentistaPremium();
		int confirmacao = JOptionPane.showConfirmDialog(null, "Confirme os dados:" +"\n"
														+ correntistaPremiumConfirmacao.getNome()+"\n"
														+ correntistaPremiumConfirmacao.getCpf()+ "\n"
														+ correntistaPremiumConfirmacao.getTransacoes()+ "\n"
														);
		if(confirmacao == 0) {
			registrarNoBanco(correntistaPremiumConfirmacao);
			
			System.out.println("o nome: " + opcaoTexto.getText());
			System.out.println("o cpf: " + opcaoTexto3.getText());
			//System.out.println("a gerencia: " + caixaSelecaoSetor.getSelectedItem().toString());
			frameTelaCadastroPremium.setVisible(false);
		}
		
	}
	
	public void registrarNoBanco(CorrentistaPremium correntistaPremiumConfirmado) {
		
		if(correntistaPremiumRepositorioImp.salvarGerenteRepositorio(correntistaPremiumConfirmado, transacoes.getText())){
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar");
			
		}
		
	}
	
	public CorrentistaPremium populaCorrentistaPremium() {
		CorrentistaPremium correntistaPremium = new CorrentistaPremium();
		correntistaPremium.setNome(opcaoTexto.getText());
		correntistaPremium.setCpf(opcaoTexto3.getText());
		//correntistaPremium.setGerencia(caixaSelecaoSetor.getSelectedItem().toString());
		try {
			correntistaPremium.setEndereco(enderecoCorrentista.buscarEnderecoPeloCep(jTextcep.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correntistaPremium;
	}

}