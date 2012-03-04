
package exemplo2.controles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javaPlay.GameStateController;

public class FimControle implements GameStateController {

	public void load() {}

	public void unload() {}

	public void start() {}

	public void step(long timeElapsed) {}

	public void draw(Graphics g) {

		Font f = new Font("Arial", Font.BOLD, 32);
		g.setFont(f);
		g.setColor(new Color(50, 200, 50));
		g.drawString("Fim do Jogo.", 280, 280);
	}

	public void stop() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
