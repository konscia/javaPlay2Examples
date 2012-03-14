package Exemplo4;

import Exemplo4.classes_abstratas.Item;
import Exemplo4.classes_abstratas.Inimigo;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MacaVenenosa extends Item {

  public MacaVenenosa(){
    super(Color.red);
  }

  public void encontrou(Jogador j) {
    j.diminuiVelocidade();
    this.setActive(false);
  }

  public void encontrou(Inimigo i) {
    i.diminuiDiametro();
    this.setActive(false);
  }
}
