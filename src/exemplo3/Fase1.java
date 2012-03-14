package exemplo3;

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
  private ArrayList<InimigoPerseguidor> inimigosPerseguidores;
  private Chegada chegada;

  public void load() {
    this.numeroExecucoesStep = 0;
    this.jogador = new Jogador();

    this.inimigos = new ArrayList<Inimigo>();
    this.inimigos.add( new Inimigo(100, 100) );
    this.inimigos.add( new Inimigo(600, 400) );
    this.inimigos.add( new Inimigo(300, 550) );
    this.inimigos.add( new Inimigo(200, 200) );
    
    this.inimigosPerseguidores = new ArrayList<InimigoPerseguidor>();
    this.inimigosPerseguidores.add( new InimigoPerseguidor() );
    
    this.chegada = new Chegada(750, 550);
  }

  public void step(long timeElapsed) { 
    this.numeroExecucoesStep++;
    this.jogador.step(timeElapsed);
    this.chegada.step(timeElapsed);
   
    for(Inimigo i : this.inimigos ){
       i.step(timeElapsed);

       if(this.jogador.temColisao(i.getRectangle())){
        this.jogador.setX(50);
        this.jogador.setY(50);
      }
    }

    for(InimigoPerseguidor i : this.inimigosPerseguidores ){
      i.persegue( this.jogador.getX(), this.jogador.getY() );

      if(this.jogador.temColisao(i.getRectangle())){
        this.jogador.setX(50);
        this.jogador.setY(50);
      }
    }
    
    if( this.jogador.temColisao( this.chegada.getRectangle() )){
      JOptionPane.showMessageDialog(null, "Você venceu, parabéns.");
      System.exit(0);
    }

    Random sorteador = new Random();
    if( sorteador.nextInt(40) == 1){
      this.inimigosPerseguidores.add( new InimigoPerseguidor() );
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
    
    for(InimigoPerseguidor i : this.inimigosPerseguidores ){
      i.draw(g);
    }
  }
  
  public void start() { }
  public void unload() { }
  public void stop() {  }

}
