package exemplo3;

import javaPlay.GameEngine;

public class Exemplo3 {
  public static void main(String args[]) {

    GameEngine.getInstance().addGameStateController( 100 , new Fase1());
    GameEngine.getInstance().setStartingGameStateController( 100 );

    GameEngine.getInstance().setFramesPerSecond(30);
    GameEngine.getInstance().run();
  }
}
