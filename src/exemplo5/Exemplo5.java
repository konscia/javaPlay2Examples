package exemplo5;

import javaPlay.GameEngine;

public class Exemplo5 {
  public static void main(String args[]) {

    GameEngine.getInstance().addGameStateController( 100 , new Fase1());    

    GameEngine.getInstance().addGameStateController( 200 , new Fase2());

    GameEngine.getInstance().addGameStateController( 300 , new Fase3());

    GameEngine.getInstance().setStartingGameStateController( 100 );

    GameEngine.getInstance().setFramesPerSecond(30);
    GameEngine.getInstance().run();
  }
}
