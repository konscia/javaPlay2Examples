package exemplo1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javaPlay.GameEngine;
import javaPlay.GameObject;

class Bola extends GameObject {

  //Tamanho em pixals da Bola
  private int diametro;
  //Cor da bola
  private Color cor;
  //Velocidade da bolinha em pixels por step
  //Se a velocidade for negativa, a bolinha se moverá na direção contrária
  private int velocidadeHorizontal;

  public Bola() {
      
           
      
    //Configura posição inicial e tamanho.
    //Lembre que x e y são atribtos herdados da classe GameObject.
    this.x = 0;
    this.y = 100;
    this.diametro = 25;
    //Cria a cor da bola em RGB. Os valores para cada cor devem estar entre 0 e 255
    this.cor = new Color(120, 250, 80);
    //Coemça com a bolinha parada
    this.velocidadeHorizontal = 0;
  }

  public void step(long timeElapsed) {
    //Altera posição horizontal da bolinha. Se a velocidade for negativa a bolinha se moverá para trás
    this.x += this.velocidadeHorizontal;

    //Mas ops..e se ela passar do espaço da tela?
    if (this.tocaParedeDireita()) {
      this.inverteDirecaoHorizontal();
      this.x = 800 - this.diametro; //Volta para posição antes de bater na lateral
    }

    if (this.tocaParedeEsquerda()) {
      this.inverteDirecaoHorizontal();
      this.x = 0; //Volta para posição antes de bater na lateral
    }
  }

  public void draw(Graphics g) {
    g.setColor(this.cor);
    g.fillOval(this.x, this.y, this.diametro, this.diametro);
  }

  public void aumentaVelocidadeHorizontal() {
    this.velocidadeHorizontal += 1;
  }

  public void diminuiVelocidadeHorizontal() {
    this.velocidadeHorizontal -= 1;
  }

  public boolean tocaParedeDireita() {
    return (this.x + this.diametro >= 800);
  }

  public boolean tocaParedeEsquerda() {
    return (this.x <= 0);
  }

  public void inverteDirecaoHorizontal() {
    this.velocidadeHorizontal *= -1;
  }

  public void mudaCor() {
    Random sorteador = new Random();
    this.cor = new Color(sorteador.nextInt(255), sorteador.nextInt(255), sorteador.nextInt(255));
  }

  public void para() {
    this.velocidadeHorizontal = 0;
  }
  
  public int getDiametro(){
      return this.diametro;
  }
}
