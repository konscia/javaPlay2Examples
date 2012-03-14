package exemplo5;

import exemplo5.itens.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javax.swing.JOptionPane;

public class Fase1 implements GameStateController {
  
  private Jogador jogador;
  private Inimigo inimigo1;
  private Inimigo inimigo2;
  private InimigoPerseguidor inimigoPerseguidor;
  private Chegada chegada;

  public void load() {    
    this.jogador = new Jogador();

    this.inimigo1 = new Inimigo(200, 200);
    this.inimigo2 = new Inimigo(100, 400);
    
    this.inimigoPerseguidor = new InimigoPerseguidor();    
    this.chegada = new Chegada(750, 550);
  }

  public void step(long timeElapsed) {     
    this.jogador.step(timeElapsed);
    this.chegada.step(timeElapsed);   
    this.inimigo1.step(timeElapsed);
    this.inimigo2.step(timeElapsed);
    this.inimigoPerseguidor.persegue(this.jogador.getX(), this.jogador.getY());

    this.verificaColisoesComInimigos();
    
    if( this.jogador.temColisao( this.chegada.getRectangle() )){
      GameEngine.getInstance().setNextGameStateController( 200 );
    }

  }

  public void draw(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 800, 600);

    this.chegada.draw(g);
    this.jogador.draw(g);

    this.inimigo1.draw(g);
    this.inimigo2.draw(g);
    this.inimigoPerseguidor.draw(g);
  }
  
  public void start() { }
  public void unload() { }
  public void stop() {  }

  private void verificaColisoesComInimigos(){

    //Inimigo 1
    if(this.jogador.temColisao(this.inimigo1.getRectangle())){
        this.jogador.setX(50);
        this.jogador.setY(50);
    }

    //Inimigo 2
    if(this.jogador.temColisao(this.inimigo2.getRectangle())){
        this.jogador.setX(50);
        this.jogador.setY(50);
    }

    //Inimigo Perseguidor   
    if(this.jogador.temColisao(this.inimigoPerseguidor.getRectangle())){
      this.jogador.setX(50);
      this.jogador.setY(50);
    }
    
  }

}
