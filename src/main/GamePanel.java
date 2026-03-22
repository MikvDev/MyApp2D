import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements  Runnable{

    // Configurações da tela
    final int originalTileSize = 16; // 16 x 16
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48

    final int maxScreenCol = 16;
    final int maxScreenRow = 12; // CORRIGIDO: maxSrceenRow -> maxScreenRow

    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; 


    Thread gameThread; // contador para o fps(frames por segundo)

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Ajuda na renderização (performance)
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){
        while (gameThread != null) { 
            System.out.println("Jogo está rodando!");
        }
    }
}
