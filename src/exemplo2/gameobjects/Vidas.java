package exemplo2.gameobjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javaPlay.GameObject;

public class Vidas extends GameObject {

	private int vidas = 10;

	public void step(long timeElapsed) {

	}

	public void draw(Graphics g) {
		Font f = new Font("Arial", Font.BOLD, 18);
		g.setFont(f);
		g.setColor(new Color(255, 0, 255));
		g.drawString("Vidas: "+this.vidas, 620, 150);
	}

	public int getVidas(){
		return this.vidas;
	}

	public void perde(){
		this.vidas--;
	}


}
