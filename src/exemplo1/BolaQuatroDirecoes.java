/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo1;

/**
 *
 * @author kaleu.caminha
 */
public class BolaQuatroDirecoes extends Bola {

    public int velocidadeVertical;

    public BolaQuatroDirecoes() {                
        super();
        this.velocidadeVertical = 0;        
    }

    @Override
    public void step(long ellapsedTime) {
        super.step(ellapsedTime);
        this.y += this.velocidadeVertical;
        
        if (this.tocaParedeCima()) {
          this.inverteDirecaoVertical();
          this.y = 0; 
        }

        if (this.tocaParedeBaixo()) {
          this.inverteDirecaoVertical();
          this.y = 600 - this.getDiametro();
        }
    }

    public void aumentaVelocidadeVertical() {
        this.velocidadeVertical += 1;
    }

    public void diminuiVelocidadeVertical() {
        this.velocidadeVertical -= 1;
    }
    
    public boolean tocaParedeBaixo() {
        return (this.y + this.getDiametro() > 600);
    }

    public boolean tocaParedeCima() {
        return (this.y <= 0);
    }

    private void inverteDirecaoVertical() {
        this.velocidadeVertical *= -1;
    }
}
