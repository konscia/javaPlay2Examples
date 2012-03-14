package exemplo5.itens;

import exemplo5.Jogador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javaPlay.GameObject;

public abstract class Item extends GameObject {

  //Informa se o ítem ainda está ativo
  protected boolean active;
  //Informa o tamanho do quadrado do ítem
  protected int lado;
  //Define a cor do ítem
  protected Color cor;

  public Item(Color cor){
    this.cor = cor;
    this.lado = 20;
    this.active = true;

    //Sorteia posição aleatória para o ítem
    Random sorteador = new Random();
    this.x = sorteador.nextInt(780);
    this.y = sorteador.nextInt(580);
  }


  /**
   * Método que deve ser executado quando um jogador
   * encontrar um determninado ítem na fase
   */
  public abstract void encontrou(Jogador j);


  public void step(long timeElapsed) {
    //De tempos em tempos, reaparece em outro lugar
    Random sorteador = new Random();
    if(sorteador.nextInt(500) == 200){
      this.x = sorteador.nextInt(780);
      this.y = sorteador.nextInt(580);
      this.setActive(true);
    }
  }

  public void draw(Graphics g) {
    if(this.isActive()){
      g.setColor(this.cor);
      g.fillRect(this.x, this.y, this.lado, this.lado);
    }
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean isActive) {
    this.active = isActive;
  }

  public Rectangle getRectangle(){
    return new Rectangle(this.x, this.y, this.lado, this.lado);
  }

}
