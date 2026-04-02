//// Aqui vamos configurar as entradas do teclado para mover o personagem 
/// 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput  implements KeyListener{ // Keylistener() para  usar precisa implementar os três metodos abaixo 
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    @Override
    public void keyTyped(KeyEvent e){
        // não vamos usar esse
    }
    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getExtendedKeyCode(); // vai retornar qual tecla foi retornada(WASD);
        if (code == KeyEvent.VK_W)
            upPressed = true;                    // SEE o usuario pressionar: W
        if (code == KeyEvent.VK_A) // A 
            leftPressed = true;
        if (code == KeyEvent.VK_S)  // S 
            downPressed = true;
        if (code == KeyEvent.VK_D) // D
            rightPressed = true;

    }
    @Override
    public void keyReleased(KeyEvent e){ // Soltou a tecla, se não o boneco vai ir ao infinito e além
         int code = e.getExtendedKeyCode();
           if (code == KeyEvent.VK_W)
            upPressed = false;                    // SEE o usuario pressionar: W
        if (code == KeyEvent.VK_A) // A 
            leftPressed = false;
        if (code == KeyEvent.VK_S)  // S 
            downPressed = false;
        if (code == KeyEvent.VK_D) // D
            rightPressed = false;
    }
}
