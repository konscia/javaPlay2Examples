package exemplo3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javaPlay.GameObject;

public class Inimigo extends GameObject {

  private int passos;
  private int direcao;

  public Inimigo(int xInicial, int yInicial){
    this.x = xInicial;
    this.y = yInicial;

    this.passos = 0;
    this.direcao = 1; //para frente
  }

  public void step(long timeElapsed) {
    
    if(this.passos < 15){
      this.x += 2 * this.direcao;
      this.passos++;
    } else {
      this.direcao *= -1;
      this.passos = 0;
    }
  }

  public void draw(Graphics g) {
    g.setColor(Color.red);
    g.fillOval(this.x, this.y, 20, 20);
  }

  public Rectangle getRectangle(){
		return new Rectangle(this.x, this.y, 20, 20);
	}

}
