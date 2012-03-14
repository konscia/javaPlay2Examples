package exemplo5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javaPlay.GameObject;

public class Inimigo extends GameObject {

  private int passos;
  private int direcao;
  private int diametro;

  public Inimigo(int xInicial, int yInicial){
    this.x = xInicial;
    this.y = yInicial;

    this.passos = 0;
    this.direcao = 1; //para frente
    this.diametro = 50;
  }

  public void step(long timeElapsed) {
    
    if(this.passos < 30){
      this.x += 10 * this.direcao;
      this.passos++;
    } else {
      this.direcao *= -1;
      this.passos = 0;
    }
  }

  public void draw(Graphics g) {
    g.setColor(Color.red);
    g.fillOval(this.x, this.y, this.diametro, this.diametro);
  }

  public Rectangle getRectangle(){
		return new Rectangle(this.x, this.y, this.diametro, this.diametro);
	}

}
