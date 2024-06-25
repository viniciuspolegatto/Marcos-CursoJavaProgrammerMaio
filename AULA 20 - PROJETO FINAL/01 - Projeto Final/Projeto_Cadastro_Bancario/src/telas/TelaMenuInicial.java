 package telas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

import controladores.ControladorTelaMenuInicial;


public class TelaMenuInicial {

    public void chamarTelaMenuInicial() {
        JFrame frameTelaInicial = new JFrame("Menu Inicial"); // Instanciando um JFrame com título

        // Definir comportamento de fechamento
        frameTelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o layout do painel
        JPanel panelTelaInicial = new JPanel(new GridLayout(0, 1, 5, 5)); // 5 pixels de espaço entre os componentes
        panelTelaInicial.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor do painel

        JLabel labelMensagemTopo = new JLabel("<html><div style='text-align: center;'>Aperte o Botão ou informe o <br> número desejado = 1 ou 2</div></html>", SwingConstants.CENTER);
        panelTelaInicial.add(labelMensagemTopo);

        JLabel labelEspaco1 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaInicial.add(labelEspaco1);
        
        JButton botaoMenuPremium = new JButton("CLIENTE PREMIUM = 1");
        panelTelaInicial.add(botaoMenuPremium);

        JButton botaoMenuGeral = new JButton("CLIENTE STANDARD = 2");
        panelTelaInicial.add(botaoMenuGeral);

        JLabel labelEspaco2 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaInicial.add(labelEspaco2);
        
        JTextField opcaoTexto = new JTextField(10);
        panelTelaInicial.add(opcaoTexto);

        JLabel labelEspaco3 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaInicial.add(labelEspaco3);
        
        JButton botaoEnviar = new JButton("ENTRAR");
        panelTelaInicial.add(botaoEnviar);

        frameTelaInicial.add(panelTelaInicial); // Adiciona o painel no frame
        frameTelaInicial.setSize(300, 300); // Define o tamanho da janela (largura x altura)

        // Posicionar a janela no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameTelaInicial.setLocation(dim.width / 2 - frameTelaInicial.getSize().width / 2,
                                     dim.height / 2 - frameTelaInicial.getSize().height / 2);

        frameTelaInicial.setVisible(true); // Torna visível

        // Controlador para tratar evento do botão
        ControladorTelaMenuInicial controladorTelaMenuInicial = new ControladorTelaMenuInicial(opcaoTexto, frameTelaInicial);
        botaoEnviar.addActionListener(controladorTelaMenuInicial);

        botaoMenuPremium.setActionCommand("MENU_PREMIUM");
        botaoMenuGeral.setActionCommand("MENU_STANDARD");
        botaoMenuPremium.addActionListener(controladorTelaMenuInicial);
        botaoMenuGeral.addActionListener(controladorTelaMenuInicial);

        // Adiciona KeyListener para o campo de texto
        opcaoTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    controladorTelaMenuInicial.actionPerformed(new ActionEvent(opcaoTexto, ActionEvent.ACTION_PERFORMED, "ENTER"));
                }
            }
        });
    }
}
