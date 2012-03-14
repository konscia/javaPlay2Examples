package Exemplo4;

import Exemplo4.classes_abstratas.Item;
import Exemplo4.classes_abstratas.Inimigo;
import java.awt.Color;

public class MacaVerde extends Item {

  public MacaVerde(){
    super(Color.green);
  }

  public void encontrou(Jogador j) {
    j.aumentaVelocidade();
    this.setActive(false);
  }

  public void encontrou(Inimigo i) {
    i.aumentaDiametro();
    this.setActive(false);
  }
}

