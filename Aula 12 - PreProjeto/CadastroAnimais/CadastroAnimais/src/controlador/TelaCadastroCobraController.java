package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import gerenciaArquivo.ManipuladorArquivo;
//import persistencia.DaoCobra;
import repositorio.CobraRepositorioImplementacao;

public class TelaCadastroCobraController implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoEspecie;
	
	
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	//DaoGerente daoGerente = new DaoGerente(); NUNCA DEVEMOS CHAMAR A DAO PELO CONTROLLER
	CobraRepositorioImplementacao cobraRepositorioImp = new CobraRepositorioImplementacao();
	
	
	public TelaCadastroCobraController(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoEspecie) {
		
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoEspecie = caixaTextoTerceiroCampoRecebidoEspecie;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		registrarNoBanco();
		
		System.out.println("o nome: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("o caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("a especie: " + caixaTextoTerceiroCampoRecebidoEspecie.getText());
		
		
	}
	
	public void registrarNoBanco() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCaf(caixaTextoSegundoCampoRecebidoCaf.getText());
		cobra.setEspecie(caixaTextoTerceiroCampoRecebidoEspecie.getText());
		
		manipuladorArquivo.registrarCobra(cobra);
		
		
		if(cobraRepositorioImp.salvarCobraRepositorio(cobra)){
			JOptionPane.showMessageDialog(null, "Salvou com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Sem sucesso - Não Salvou");
			
		}
		
	}

}