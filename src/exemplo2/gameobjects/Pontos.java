package exemplo2.gameobjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javaPlay.GameObject;

/**
 * Registra a pontuação do jogador.
 */
public class Pontos extends GameObject {

	public int pontos;

	public void step(long timeElapsed) {
		//Soma 1 ponto a cada etapa sobrevivida;
		this.pontos += 1;
	}

	public void draw(Graphics g) {
		Font f = new Font("Arial", Font.BOLD, 18);		
		g.setFont(f);
		g.setColor(new Color(200, 50, 50));
		g.drawString("Pontos: "+this.pontos, 620, 50);
	}

	public void perde(int numPontos){
		this.pontos -= numPontos;
	}



}
