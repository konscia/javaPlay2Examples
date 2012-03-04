package exemplo2;
import exemplo2.controles.Fase1Controle;
import exemplo2.controles.FimControle;
import javaPlay.GameEngine;

/**
 * Este exemplo mostra como ciar uma fase, adicionar um GameObject
 * e manipulá-lo utilizando o teclado.
 */
public class Exemplo2
{
    public static void main(String[] args) 
    {
		//Informa para a Engine que o ID 1 está conectado com o Controlador da Fase 1
        GameEngine.getInstance().addGameStateController(Global.FASE1_ID, new Fase1Controle());

		//Informa para a Engine que o ID 2 está conectado com o Controlador do fim do jogo
        GameEngine.getInstance().addGameStateController(Global.FIM_ID, new FimControle());

		//Informa para a engine que o Controlador inicial é o correspondente ao ID 1
        GameEngine.getInstance().setStartingGameStateController(Global.FASE1_ID);

		//Roda a Engine.!! :-)
		GameEngine.getInstance().setFramesPerSecond(60);
        GameEngine.getInstance().run();        
    }
}
