package exemplo2.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import javaPlay.GameObject;

public class Raio extends GameObject{

	private int velocidade = 3;

	public Raio(){
		Random sorteador = new Random();
		this.x = sorteador.nextInt(600);
		this.y = 600+sorteador.nextInt(400);
	}

	public void step(long timeElapsed) {
		this.y -= velocidade;

		if(this.y < -20){
			this.y = 620;
			Random sorteador = new Random();
			this.x = sorteador.nextInt(600);

			this.aumentaVelocidade();
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawLine(this.x, this.y, this.x,this.y+10);
	}

	public void aumentaVelocidade(){
		if(this.velocidade >15){
			this.velocidade -= 5;
		}
		Random sorteador = new Random();
		//Para aumentar a dificuldade mais lentamente,
		//Sorteia um número de 0 a 10. Se for divisível por 2, aumenta
		if(sorteador.nextInt(10) % 2 == 0){
			this.velocidade++;
		}
	}

	public Rectangle getRetangulo(){
		return new Rectangle(this.x, this.y, 1, 10);
	}

}
