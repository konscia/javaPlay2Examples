package Exemplo4;

import javaPlay.GameEngine;

public class Exemplo4 {
  public static void main(String args[]) {

    GameEngine.getInstance().addGameStateController( 100 , new Fase1());
    GameEngine.getInstance().setStartingGameStateController( 100 );

    GameEngine.getInstance().setFramesPerSecond(30);
    GameEngine.getInstance().run();
  }
}
