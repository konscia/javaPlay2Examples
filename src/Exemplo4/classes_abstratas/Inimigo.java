package Exemplo4.classes_abstratas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javaPlay.GameObject;

public abstract class Inimigo extends GameObject {

  private int diametro;

  public Inimigo(int xInicial, int yInicial){
    this.x = xInicial;
    this.y = yInicial;

    this.diametro = 20;
  }

  public void draw(Graphics g) {
    g.setColor(Color.blue);
    g.fillOval(this.x, this.y, this.diametro, this.diametro);
  }

  public boolean temColisao(Rectangle r2){
    return this.getRectangle().intersects(r2);
  }

  public Rectangle getRectangle(){
		return new Rectangle(this.x, this.y, this.diametro, this.diametro);
	}

  public void aumentaDiametro(){
    this.diametro += 15;
  }

  public void diminuiDiametro(){
    this.diametro -= 5;
  }

}
