import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements  Runnable{

    // Configurações dad tela
    final int originalTileSize = 16; // 16 x 16
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48

    final int maxScreenCol = 16;
    final int maxScreenRow = 12; // CORRIGIDO: maxSrceenRow -> maxScreenRow

    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; 
    int FPS = 60;

    KeyInput keyH = new KeyInput();
    Thread gameThread; // contador para o fps(frames por segundo)

    int playerX = 100, playerY = 100, playerSpeed = 4;



    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // Ajuda na renderização (performance)
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){
        while (gameThread != null) { 
           // sleep medoth
           double drawInterval = 1000000000/FPS; // usamos nanosegunodos para calcular

        // podemos atulizar o jogo de 30 a 60 frames por segundo
        // Isso fara com que o personagem seja atulizado(posição, ação, ou etc..)
        // para isso vamos criar 2 metodos:
            update();//assim que atualizamos a tela 
            repaint();
        
    }
}
public void update(){
    if(keyH.upPressed == true){
        playerY -= playerSpeed; // vai diminuir do y para subir
    }
    else if(keyH.downPressed == true){
        playerY += playerSpeed;

        
        // min 14:40
    }else if(keyH.leftPressed == true){// velocidade do jogador significa os pixeis, velocidade que ele avança 
        playerX -= playerSpeed;

 
    }else if(keyH.rightPressed == true){
        playerX += playerSpeed;

    }

}
public void paintComponent(Graphics g){ // desenhar objetos na tela, e como um lapis ou pincel
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.white);
    g2.fillRect(playerX,playerY, tileSize, tileSize);
    g2.dispose();
}
}
