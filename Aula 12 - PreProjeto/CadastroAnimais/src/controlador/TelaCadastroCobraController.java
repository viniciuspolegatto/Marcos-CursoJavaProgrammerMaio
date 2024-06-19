package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import enuns.EspecieEnum;
import gerenciaArquivo.ManipuladorArquivo;
//import persistencia.DaoCobra;
import repositorio.CobraRepositorioImplementacao;

public class TelaCadastroCobraController implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JComboBox<EspecieEnum> caixaSelecaoEspecie;
	JTextField qtdQuilos;
	JFrame frameTelaCadastroCobra;
	
	
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	//DaoGerente daoGerente = new DaoGerente(); NUNCA DEVEMOS CHAMAR A DAO PELO CONTROLLER
	CobraRepositorioImplementacao cobraRepositorioImp = new CobraRepositorioImplementacao();
	
	
	public TelaCadastroCobraController(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JComboBox<EspecieEnum> caixaSelecaoEspecie,
			JFrame frameTelaCadastroCobra, JTextField qtdQuilos) {
		
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaSelecaoEspecie = caixaSelecaoEspecie;
		this.frameTelaCadastroCobra = frameTelaCadastroCobra;
		this.qtdQuilos = qtdQuilos;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		registrarNoBanco();
		
		System.out.println("o nome: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("o caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("a especie: " + caixaSelecaoEspecie.getSelectedItem().toString());
		frameTelaCadastroCobra.setVisible(false);
		
		
	}
	
	public void registrarNoBanco() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCaf(caixaTextoSegundoCampoRecebidoCaf.getText());
		cobra.setEspecie(caixaSelecaoEspecie.getSelectedItem().toString());
		
		manipuladorArquivo.registrarCobra(cobra);
		
		
		if(cobraRepositorioImp.salvarCobraRepositorio(cobra, qtdQuilos.getText())){
			JOptionPane.showMessageDialog(null, "Salvou com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Sem sucesso - Não Salvou");
			
		}
		
	}

}