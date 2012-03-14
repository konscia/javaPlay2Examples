package Exemplo4;

import Exemplo4.classes_abstratas.Inimigo;
import Exemplo4.classes_abstratas.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javaPlay.GameStateController;
import javax.swing.JOptionPane;

public class Fase1 implements GameStateController {

  private int numeroExecucoesStep;
  private Jogador jogador;
  private ArrayList<Inimigo> inimigos;
  private ArrayList<Item> itens;
  private Chegada chegada;

  public void load() {
    this.numeroExecucoesStep = 0;
    this.jogador = new Jogador();

    this.itens = new ArrayList<Item>();

    Random sorteador = new Random();
    for(int i = 0; i < 10; i++){
      this.itens.add(new MacaVerde());
      this.itens.add(new MacaVenenosa());
    }

    this.inimigos = new ArrayList<Inimigo>();
    this.inimigos.add( new InimigoPatrulheiro(100, 100) );
    this.inimigos.add( new InimigoPatrulheiro(600, 400) );
    this.inimigos.add( new InimigoPatrulheiro(300, 550) );
    this.inimigos.add( new InimigoPatrulheiro(200, 200) );        
    this.inimigos.add( new InimigoPerseguidor() );
    this.inimigos.add( new InimigoPerseguidor() );
    this.inimigos.add( new InimigoPerseguidor() );
    this.inimigos.add( new InimigoPerseguidor() );
    
    this.chegada = new Chegada(750, 550);
  }

  public void step(long timeElapsed) { 
    this.numeroExecucoesStep++;
    this.jogador.step(timeElapsed);
    this.chegada.step(timeElapsed);

    this.stepInimigos(timeElapsed);

    for(Item i : this.itens){
      i.step(timeElapsed);
    }

    this.verificaColisaoComItens();
    
    if( this.jogador.temColisao( this.chegada.getRectangle() )){
      JOptionPane.showMessageDialog(null, "Você venceu, parabéns.");
      System.exit(0);
    }

  }

  private void stepInimigos(long timeElapsed){
    for(Inimigo i : this.inimigos ){
       i.step(timeElapsed);

       if(i instanceof InimigoPerseguidor){
         InimigoPerseguidor i2 = (InimigoPerseguidor)i;
         i2.persegue(this.jogador.getX(), this.jogador.getY());
       }

       if(this.jogador.temColisao(i.getRectangle())){
         this.jogador.setX(50);
         this.jogador.setY(50);
       }
    }
  }

  public void draw(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 800, 600);

    this.chegada.draw(g);
    this.jogador.draw(g);

    for(Inimigo i : this.inimigos ){
       i.draw(g);
    }

    for(Item i : this.itens ){
       i.draw(g);
    }
  }
  
  public void start() { }
  public void unload() { }
  public void stop() {  }

  private void verificaColisaoComItens() {
    for(Item i : this.itens){
      if(!i.isActive()){
        continue;
      }

      if(this.jogador.temColisao(i.getRectangle())){
        i.encontrou(this.jogador);
      }
      
      for(Inimigo inimigo : this.inimigos){
        if(inimigo.temColisao( i.getRectangle() )){
          i.encontrou( inimigo );
        }
      }

    }
  }

}
