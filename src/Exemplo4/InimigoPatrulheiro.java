package Exemplo4;

import Exemplo4.classes_abstratas.Inimigo;
import java.awt.Color;
import java.awt.Graphics;

public class InimigoPatrulheiro extends Inimigo {

  private int passos;
  private int direcao;

  public InimigoPatrulheiro(int xInicial, int yInicial){
    super(xInicial, yInicial);

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

}
