package exemplo5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javaPlay.GameObject;

public class InimigoPerseguidor extends GameObject {

  private int velocidade = 3;

  public InimigoPerseguidor(){
    this.x = 750;
    this.y = 550;
  }

  public void step(long timeElapsed) {
    //Não faz nada aqui.
  }

  public void draw(Graphics g) {
    g.setColor(Color.ORANGE);
    g.fillOval(this.x, this.y, 20, 20);
  }

  public void persegue(int xPerseguido, int yPerseguido){
    if(this.x < xPerseguido){
      this.x += this.velocidade;
    } else {
      this.x -= this.velocidade;
    }

    if(this.y < yPerseguido){
      this.y += this.velocidade;
    } else {
      this.y -= this.velocidade;
    }
  }

  public Rectangle getRectangle(){
		return new Rectangle(this.x, this.y, 20, 20);
	}

}
