package tela;

import java.awt.GridLayout;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import controlador.TelaMenuInicialController;

public class TelaMenuInicial {

    public void chamarTelaMenuIniciar() {
        
        JFrame frameTelaInicial = new JFrame("Menu Inicial"); // Instanciando um JFrame com título
        
        // Definir comportamento de fechamento
        frameTelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Posicionar a janela no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameTelaInicial.setLocation(dim.width / 2 - frameTelaInicial.getSize().width / 2, 
                                     dim.height / 2 - frameTelaInicial.getSize().height / 2);
        
        // Configurar o layout do painel
        JPanel panelTelaInicial = new JPanel(new GridLayout(0, 1, 5, 5)); // 5 pixels de espaço entre os componentes
        panelTelaInicial.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor do painel
        
        JLabel labelOpcaoGerente = new JLabel("1 - Menu Cobra");
        panelTelaInicial.add(labelOpcaoGerente);
        
        JLabel labelOpcaoAtendente = new JLabel("2 - Menu Cachorro");
        panelTelaInicial.add(labelOpcaoAtendente);
        
        JTextField opcaoTexto = new JTextField(10);
        panelTelaInicial.add(opcaoTexto);
        
        JButton botaoEnviar = new JButton("Enviar");
        panelTelaInicial.add(botaoEnviar);
        
        frameTelaInicial.add(panelTelaInicial); // Adiciona o painel no frame
        frameTelaInicial.pack(); // Ajusta o frame ao tamanho dos componentes
        frameTelaInicial.setVisible(true); // Torna visível
        
        // Controlador para tratar evento do botão
        TelaMenuInicialController telaMenuInicialController = new TelaMenuInicialController(opcaoTexto, frameTelaInicial);
        botaoEnviar.addActionListener(telaMenuInicialController);
    }

}
