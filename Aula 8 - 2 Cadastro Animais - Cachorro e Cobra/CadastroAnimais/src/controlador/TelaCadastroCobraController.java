package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import entidade.Cobra;
import gerenciaArquivo.ManipuladorArquivo;

public class TelaCadastroCobraController implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoEspecie;
	
	
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	
	
	
	public TelaCadastroCobraController(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoEspecie) {
		
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoEspecie = caixaTextoTerceiroCampoRecebidoEspecie;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		registrarArquivo();
		
		System.out.println("o nome: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("o cpf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("a gerencia: " + caixaTextoTerceiroCampoRecebidoEspecie.getText());
		
		
	}
	
	public void registrarArquivo() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCaf(caixaTextoSegundoCampoRecebidoCaf.getText());
		cobra.setEspecie(caixaTextoTerceiroCampoRecebidoEspecie.getText());
		
		manipuladorArquivo.registrarCobra(cobra);
	}

}
