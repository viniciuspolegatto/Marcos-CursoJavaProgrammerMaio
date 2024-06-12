package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import repositorio.CobraRepositorioImplementacao;
import tela.TelaMenuCobra;

public class TelaFormularioAlterarCobraController implements ActionListener {

	JTextField caixaTextoPrimeiroCampoRecebidoNome;
	String caixaTextoSegundoCampoRecebidoCaf;
	JTextField caixaTextoTerceiroCampoRecebidoEspecie;
	JFrame frameTelaAlterarCobra;
	
	public TelaFormularioAlterarCobraController(JTextField caixaTextoPrimeiroCampoRecebidoNome,
			String caixaTextoSegundoCampoRecebidoCaf, JTextField caixaTextoTerceiroCampoRecebidoEspecie,
			JFrame frameTelaAlterarCobra) {
		this.caixaTextoPrimeiroCampoRecebidoNome = caixaTextoPrimeiroCampoRecebidoNome;
		this.caixaTextoSegundoCampoRecebidoCaf = caixaTextoSegundoCampoRecebidoCaf;
		this.caixaTextoTerceiroCampoRecebidoEspecie = caixaTextoTerceiroCampoRecebidoEspecie;
		this.frameTelaAlterarCobra = frameTelaAlterarCobra;
	}
	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();
	TelaMenuCobra telaMenuCobra = new TelaMenuCobra();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		alterarCobraNoBanco();
	}
	
	public void alterarCobraNoBanco() {
		Cobra cobra = new Cobra();
		cobra.setNome(caixaTextoPrimeiroCampoRecebidoNome.getText());
		cobra.setCaf(caixaTextoSegundoCampoRecebidoCaf);
		cobra.setEspecie(caixaTextoTerceiroCampoRecebidoEspecie.getText());
		
		if(cobraRepositorioImplementacao.alterarCobraRepositorio(cobra)){
			JOptionPane.showMessageDialog(null, "Alterou com sucesso");
			frameTelaAlterarCobra.setVisible(false);
			telaMenuCobra.chamarTelaMenuCobra();
		}else {
			JOptionPane.showMessageDialog(null, "Não Alterou com sucesso");
		}
	}

}
