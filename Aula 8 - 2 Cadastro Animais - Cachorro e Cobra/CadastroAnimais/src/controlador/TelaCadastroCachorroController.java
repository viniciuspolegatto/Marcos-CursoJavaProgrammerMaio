package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import entidade.Cachorro;
import gerenciaArquivo.ManipuladorArquivo;

public class TelaCadastroCachorroController implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	JTextField caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoEspecie;
	
	
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
	
	
	
	public TelaCadastroCachorroController(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			JTextField caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoEspecie) {
		
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoEspecie = caixaTextoTerceiroCampoRecebidoEspecie;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		registrarArquivo();
		
		System.out.println("o nome: " + caixaTextoPrimeiroCampoRecebidoNome.getText());
		System.out.println("o caf: " + caixaTextoSegundoCampoRecebidoCaf.getText());
		System.out.println("a espécie: " + caixaTextoTerceiroCampoRecebidoEspecie.getText());
		
		
	}
	
	public void registrarArquivo() {
		Cachorro cachorro = new Cachorro();
		cachorro.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cachorro.setCaf(caixaTextoSegundoCampoRecebidoCaf.getText());
		cachorro.setEspecie(caixaTextoTerceiroCampoRecebidoEspecie.getText());
		
		manipuladorArquivo.registrarCachorro(cachorro);
	}

}
