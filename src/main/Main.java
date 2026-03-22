import javax.swing.*;

public class Main{
    
    public static void main(String[] args){
        // Crimos uma janela chamada window
        JFrame window = new JFrame();
        // Quando clicarmos no x da janela ela vai fechar
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Se é possivel redimencionar a janela
        window.setResizable(false);
        // Nome da janela 2d advenure
        window.setTitle("2d adventure");
       
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        // Trazer a janela sempre para o meio da tela, null(ou seja não tem direção)
        window.setLocationRelativeTo(null);
        // Mostrar a janela
        window.setVisible(true);

        gamePanel.startGameThread();



        
    }
}


// compilar com javac, jdk
// usuario final jre