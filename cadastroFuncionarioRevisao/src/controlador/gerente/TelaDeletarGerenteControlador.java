package controlador.gerente;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import repositorio.GerenteRepositorioImplemetacao;
import tela.gerente.TelaMenuGerente;


public class TelaDeletarGerenteControlador implements ActionListener {

	TextField cpfRecebido;
	JFrame frameDeletar;
	GerenteRepositorioImplemetacao gerenteRepositorioImplemetacao = new GerenteRepositorioImplemetacao();
	
	TelaMenuGerente telaMenuGerente = new TelaMenuGerente();
	
	

	public TelaDeletarGerenteControlador(TextField cpfRecebido, JFrame frameDeletar) {
		
		this.cpfRecebido = cpfRecebido;
		this.frameDeletar = frameDeletar;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(gerenteRepositorioImplemetacao.excluirGerenteRepositorio(cpfRecebido.getText())) {
			JOptionPane.showMessageDialog(null, "O gerente de cpf " +cpfRecebido.getText()+ " Foi deletado");
			frameDeletar.setVisible(false);
			telaMenuGerente.chamarTelaMenuGerente();
			
		}else {
			JOptionPane.showMessageDialog(null, "O gerente de cpf " +cpfRecebido.getText()+ " Não foi deletado");
		}
		
		
	}
	
	

}
