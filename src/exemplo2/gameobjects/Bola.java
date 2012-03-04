package exemplo2.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javaPlay.GameObject;

public class Bola extends GameObject {

	//Tamanho em pixals da Bola
	private int diametro;
	//Cor da bola
	private Color cor;
	//Velocidade da bolinha em pixels por step
	//Se a velocidade for negativa, a bolinha se moverá na direção contrária
	private int velocidadeHorizontal;	
	
	public Bola(){
		//Configura posição inicial e tamanho.
		//Lembre que x e y são atribtos herdados da classe GameObject.
		this.x = 0;
		this.y = 100;
		this.diametro = 30;
		//Cria a cor da bola em RGB. Os valores para cada cor devem estar entre 0 e 255
		this.cor = new Color(120, 250, 80);
		//Coemça com a bolinha parada
		this.velocidadeHorizontal = 0;
	}

    public void step(long timeElapsed){
		//Altera posição horizontal da bolinha. Se a velocidade for negativa a bolinha se moverá para trás
		this.x += this.velocidadeHorizontal;

		//Mas ops..e se ela passar do espaço da tela?
		if(this.tocaParedeDireita()){			
			this.x = 600 - this.diametro; //Volta para posição antes de bater na lateral
			this.velocidadeHorizontal = 0;
		}

		if(this.tocaParedeEsquerda()){			
			this.x = 0; //Volta para posição antes de bater na lateral
			this.velocidadeHorizontal = 0;
		}
    }
	
	public void draw(Graphics g) {
		g.setColor(this.cor);
		g.fillOval(this.x, this.y, this.diametro, this.diametro);
	}


	

	public void aumentaVelocidadeHorizontal(){
		this.velocidadeHorizontal += 1;
	}

	public void diminuiVelocidadeHorizontal(){
		this.velocidadeHorizontal -= 1;
	}

    public boolean tocaParedeDireita(){
		return (this.x + this.diametro >= 600);
	}

	public boolean tocaParedeEsquerda(){
		return (this.x <= 0);
	}

	public void inverteDirecaoHorizontal(){
		this.velocidadeHorizontal *= -1;		
	}

	public void mudaCor(){
		Random sorteador = new Random();		
		this.cor = new Color(sorteador.nextInt(255), sorteador.nextInt(255), sorteador.nextInt(255));
	}

	public void para(){
		this.velocidadeHorizontal = 0;
	}

	public void diminuiDiametro(){
		this.diametro -= 2;
	}

	public Ellipse2D getElipse(){
		return new Ellipse2D.Double(this.x, this.y, this.diametro, this.diametro);

	}

}
