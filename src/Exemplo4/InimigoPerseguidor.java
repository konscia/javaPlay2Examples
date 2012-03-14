package Exemplo4;

import Exemplo4.classes_abstratas.Inimigo;
import java.awt.Color;

public class InimigoPerseguidor extends Inimigo {

  private int velocidade = 2;

  public InimigoPerseguidor(){
    super(750, 550);
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

  public void step(long timeElapsed) {}

}
