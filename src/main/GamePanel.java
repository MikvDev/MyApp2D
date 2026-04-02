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
        double drawInterval = 1000000000/FPS; // intervalo para desenhar frames
        double delta = 0;
        long lastTime = System.nanoTime(); // tempo antes do loop
        long currentTime;// tempo durante o loop
        long timer =0;
        int drawCount =0;
        while(gameThread != null){
            currentTime = System.nanoTime(); // tempo
            delta += (currentTime - lastTime) / drawInterval;
            timer +=(currentTime - lastTime);
            lastTime = currentTime;

            if(delta > 1){

                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;

            }
    
    
}
    }
public void update(){ // vai calcuar a posição, colisoes e pontuações
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
    Graphics2D g3 = (Graphics2D)g;
    g2.setColor(Color.white);
    g2.fillRoundRect(222, 222, tileSize, tileSize, 200,200);
    
    g3.setColor(Color.red);
    g3.fillRect(playerX,playerY, tileSize,tileSize);
    g3.dispose();
    g2.dispose();
}
}
