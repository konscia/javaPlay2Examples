package exemplo5;

import exemplo5.itens.MacaVenenosa;
import exemplo5.itens.MacaVerde;
import java.awt.Color;
import java.awt.Graphics;
import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javax.swing.JOptionPane;

public class Fase2 implements GameStateController {
  
  private Jogador jogador;
  private Inimigo inimigo1;
  private Inimigo inimigo2;
  private InimigoPerseguidor inimigoPerseguidor;
  private Chegada chegada;

  private MacaVerde maca1;
  private MacaVenenosa maca2;

  public void load() {    
    this.jogador = new Jogador();

    this.inimigo1 = new Inimigo(200, 200);
    this.inimigo2 = new Inimigo(100, 400);
    
    this.inimigoPerseguidor = new InimigoPerseguidor();    
    this.chegada = new Chegada(750, 550);

    //NOVIDADE -> Inicialização das maçãs
    this.maca1 = new MacaVerde();
    this.maca2 = new MacaVenenosa();
  }

  public void step(long timeElapsed) {     
    this.jogador.step(timeElapsed);
    this.chegada.step(timeElapsed);   
    this.inimigo1.step(timeElapsed);
    this.inimigo2.step(timeElapsed);
    this.inimigoPerseguidor.persegue(this.jogador.getX(), this.jogador.getY());

    //NOVIDADE -> step dos ítens
    this.maca1.step(timeElapsed);
    this.maca2.step(timeElapsed);

    //NOVIDADE -> verifica colisão com os ítens
    this.verificaColisoesComItens();

    this.verificaColisoesComInimigos();

    if( this.jogador.temColisao( this.chegada.getRectangle() )){
      GameEngine.getInstance().setNextGameStateController( 300 );
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

    //NOVIDADE -> desenha as maçãs
    this.maca1.draw(g);
    this.maca2.draw(g);
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

  private void verificaColisoesComItens(){

    //Maçã 1
    if(this.jogador.temColisao(this.maca1.getRectangle())){
        //O que acontece quando encontra a maçã verde?
        //Passo a bola para a maçã.
        this.maca1.encontrou(this.jogador);
    }

    if(this.jogador.temColisao(this.maca2.getRectangle())){
        //O que acontece quando encontra a maçã vermelha?
        //Passo a bola para a maçã.
        this.maca2.encontrou(this.jogador);
    }

  }

}
