package exemplo2.controles;

import exemplo2.gameobjects.Vidas;
import exemplo2.gameobjects.Bola;
import exemplo2.gameobjects.Raio;
import exemplo2.gameobjects.Pontos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javaPlay.GameEngine;
import javaPlay.GameStateController;
import javaPlay.Keyboard;

/**
 * Executa as operações essenciais de um jogo como inicialização, rodada e desenho
 * para a fase 1.
 */
public class Fase1Controle implements GameStateController
{   
    Bola jogador;	
	Raio[] raios;
	Pontos pontos;
	Vidas vidas;
	boolean pause;

	// Carrega todos os objetos e recursos que serão necessários para o jogo
    public void load() {
		//Inicializa Jogador
		this.jogador = new Bola();

		//Inicializa Raios
		raios = new Raio[16];
		for(int i = 0; i < raios.length; i++){
			raios[i] = new Raio();
		}
		//Inicializa Pause
		pause = false;

		//Inicializa pontos
		pontos = new Pontos();

		//Inicializa Vidas
		vidas = new Vidas();
	}

	//Método executado a cada iteração do jogo.
    public void step(long timeElapsed) {

		this.acoesTeclado();
		if(this.pause){
			//Trava movimentação
			return;
		}

		if(this.vidas.getVidas() <= 0){
			GameEngine.getInstance().setNextGameStateController(2);
		}

		this.verificaRaioTocaJogador();

		//Executa etapa de cada objeto
		pontos.step(timeElapsed);
        jogador.step(timeElapsed);
		for(int i = 0; i < this.raios.length; i++){
			this.raios[i].step(timeElapsed);
		}
    }

	//Realiza o desenho desta fase e dos seus respectivos objetos.
    public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.white);
		g.fillRect(610, 10, 180, 580);

		jogador.draw(g);
		pontos.draw(g);
		vidas.draw(g);

		for(int i = 0; i < this.raios.length; i++){
			this.raios[i].draw(g);
		}
	}

	private void acoesTeclado(){
		Keyboard k = GameEngine.getInstance().getKeyboard();
		if(k.keyDown(Keyboard.RIGHT_KEY)){
			jogador.aumentaVelocidadeHorizontal();
		}
		if(k.keyDown(Keyboard.LEFT_KEY)){
			jogador.diminuiVelocidadeHorizontal();
		}
		if(k.keyDown(KeyEvent.VK_P)){
			this.pause = !this.pause;
		}
	}
	
	private void verificaRaioTocaJogador(){
		//Verifica todos os raios
		for(int i = 0; i < this.raios.length; i++){
			//Pega retângulo que representa o raio
			Rectangle r = this.raios[i].getRetangulo();
			//Verifica se o círculo do jogador bate no retângulo do raio.
			if(jogador.getElipse().intersects(r)){
				//A brincadeira é que o jogador vai perdendo tamanho conforme é atingido
				jogador.diminuiDiametro();
				pontos.perde(100);
				vidas.perde();
				
				//Se atingiu, quero que seja gerado um novo raio no lugar deste
				this.raios[i] = new Raio();
			}
		}
	}
	
	//Para referência sobre os métodos abaixo consulte o apêndice D do livro.

    public void unload(){}
    public void start(){}
    public void stop(){ }
 
}
