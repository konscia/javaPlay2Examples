package exemplo1;
import javaPlay.GameEngine;

/**
 * Este exemplo mostra como ciar uma fase, adicionar um GameObject
 * e manipulá-lo utilizando o teclado.
 */
public class Exemplo1
{
    public static void main(String[] args) 
    {
		//Informa para a Engine que o ID 1 está conectado com o Controlador da Fase 1
        GameEngine.getInstance().addGameStateController(1, new Fase1Controle());

		//Informa para a engine que o Controlador inicial é o correspondente ao ID 1
        GameEngine.getInstance().setStartingGameStateController(1);

		//Roda a Engine.!! :-)
		GameEngine.getInstance().setFramesPerSecond(60);
        GameEngine.getInstance().run();        
    }
}
