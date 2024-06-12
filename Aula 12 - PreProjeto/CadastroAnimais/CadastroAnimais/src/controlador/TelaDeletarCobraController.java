package controlador;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import repositorio.CobraRepositorioImplementacao;
import tela.TelaMenuCobra;

public class TelaDeletarCobraController implements ActionListener {

	TextField cafRecebido;
	JFrame frameDeletar;
	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	
	TelaMenuCobra telaMenuCobra = new TelaMenuCobra();
	
	

	public TelaDeletarCobraController(TextField cafRecebido, JFrame frameDeletar) {
		
		this.cafRecebido = cafRecebido;
		this.frameDeletar = frameDeletar;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(cobraRepositorioImplementacao.excluirCobraRepositorio(cafRecebido.getText())) {
			JOptionPane.showMessageDialog(null, "A cobra de CAF " + cafRecebido.getText() + " foi deletada");
			frameDeletar.setVisible(false);
			telaMenuCobra.chamarTelaMenuCobra();
			
		}else {
			JOptionPane.showMessageDialog(null, "A cobra de CAF " + cafRecebido.getText() + " não foi deletada");
		}
		
		
	}
	
	

}
