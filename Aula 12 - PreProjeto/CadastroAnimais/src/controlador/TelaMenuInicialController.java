package controlador;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tela.TelaMenuCobra;
import tela.TelaMenuCachorro;


/*public class TelaMenuInicialController implements ActionListener {


	JTextField opcao;
	JFrame frameTelaInicial;
	JButton botaoMenuCachorro;
	JButton botaoMenuCobra;
	
	
	TelaMenuCobra telaMenuCobra = new TelaMenuCobra();
	TelaMenuCachorro telaMenuCachorro = new TelaMenuCachorro();
	
	
	public TelaMenuInicialController(JTextField opcao, JFrame frameTelaInicial) {
		this.opcao = opcao;
		this.frameTelaInicial = frameTelaInicial;		
	}
		
	@Override//
	public void actionPerformed(ActionEvent e) {
		caixaDeTexto();
		botaoMenuCobra();
		botaoMenuCachorro();
	}
		
	public void caixaDeTexto() {
		
		if(opcao.getText().equals("1") || opcao.getText().equals("2") ) {
				switch (opcao.getText()) {
					case "1": {
						telaMenuCobra.chamarTelaMenuCobra();
						System.out.println("Direcione para tela da cobra");
						frameTelaInicial.setVisible(false);
						break;
						
					}
					case "2": {
						telaMenuCachorro.chamarTelaMenuCachorro();
						System.out.println("Direcione para tela do cachorro");
						break;
					}
					case "3": {
							System.exit(0);
							break;
					}					
				}
		}	
		else {
			JOptionPane.showMessageDialog(null, "A opcão " + opcao.getText() +" Não é valida");	
			}
		}
	
	public void botaoMenuCobra() {
		telaMenuCobra.chamarTelaMenuCobra();
		System.out.println("Direcione para tela da cobra");
		frameTelaInicial.setVisible(false);
		}
	
	public void botaoMenuCachorro() {
		telaMenuCachorro.chamarTelaMenuCachorro();
		System.out.println("Direcione para tela do cachorro");
		frameTelaInicial.setVisible(false);
		}
	
}
*/









public class TelaMenuInicialController implements ActionListener {

    JTextField opcao;
    JFrame frameTelaInicial;
    TelaMenuCobra telaMenuCobra = new TelaMenuCobra();
    TelaMenuCachorro telaMenuCachorro = new TelaMenuCachorro();

    public TelaMenuInicialController(JTextField opcao, JFrame frameTelaInicial) {
        this.opcao = opcao;
        this.frameTelaInicial = frameTelaInicial;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("MENU_COBRA".equals(command)) {
            telaMenuCobra.chamarTelaMenuCobra();
            System.out.println("Direcione para tela da cobra");
            frameTelaInicial.setVisible(false);
        } else if ("MENU_CACHORRO".equals(command)) {
            telaMenuCachorro.chamarTelaMenuCachorro();
            System.out.println("Direcione para tela do cachorro");
            frameTelaInicial.setVisible(false);
        } else {
            caixaDeTexto();
        }
    }

    public void caixaDeTexto() {
        String input = opcao.getText();
        switch (input) {
            case "1":
                telaMenuCobra.chamarTelaMenuCobra();
                System.out.println("Direcione para tela da cobra");
                frameTelaInicial.setVisible(false);
                break;
            case "2":
                telaMenuCachorro.chamarTelaMenuCachorro();
                System.out.println("Direcione para tela do cachorro");
                frameTelaInicial.setVisible(false);
                break;
            case "3":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "A opção " + opcao.getText() + " não é válida");
                break;
        }
    }
}
