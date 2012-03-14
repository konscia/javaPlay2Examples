package exemplo3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import javaPlay.GameObject;

public class Chegada extends GameObject {

  private Color cor;
  private int vermelhoEVerde = 230;

  public Chegada(int x, int y){
    this.x = x;
    this.y = y;
    this.cor = new Color(this.vermelhoEVerde, this.vermelhoEVerde, 20);
  }

  public void step(long timeElapsed) {
    this.vermelhoEVerde += 5;
    if(this.vermelhoEVerde > 250){
      this.vermelhoEVerde = 180;
    }

    this.cor = new Color(this.vermelhoEVerde, this.vermelhoEVerde, 100);
  }

  @Override
  public void draw(Graphics g) {
    Polygon estrela = new Polygon();
    estrela.addPoint(this.x, this.y);
    estrela.addPoint(this.x+10, this.y+20);
    estrela.addPoint(this.x-10, this.y+20);
    estrela.addPoint(this.x, this.y);

    Polygon estrela2 = new Polygon();
    int x2 = this.x;
    int y2 = this.y+25;
    estrela2.addPoint(x2, y2);
    estrela2.addPoint(x2+10, y2-20);
    estrela2.addPoint(x2-10, y2-20);
    estrela2.addPoint(x2, y2);
    
    g.setColor(this.cor);
    g.fillPolygon(estrela);
    g.fillPolygon(estrela2);
  }

  public Rectangle getRectangle(){
		return new Rectangle(this.x, this.y, 20, 25);
	}

}
