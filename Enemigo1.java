import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Enemigo1 implements Runnable{
	JLabel fuego;

	public Enemigo1(JLabel fuego)
	{
		this.fuego = fuego;
	}
	public void run()
	{
		
		while(true)
		{
			//System.out.println("Hola, soy un proceso paralelo");
			for (int y=25; y<100; y=y+5) 
			{
				this.fuego.setLocation(100,y);
				retorno(100);
			}

			for (int y=100; y>25; y=y-5) 
			{
				this.fuego.setLocation(100,y);
				retorno(100);
			}


		}

	}

	public void retorno(int duracion)
	{
		try{
		Thread.sleep(duracion);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}