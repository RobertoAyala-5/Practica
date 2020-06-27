import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class MiVentana extends JFrame implements KeyListener{

	BufferedImage imagen;
	//BufferedImage imagen1;
	BufferedImage subImagen;
	//BufferedImage subImagen1;
	Monito monito;
	Monito1 monito1;
	Thread enemigo1;
	/*LamparaW lamparaW;
	LamparaA lamparaA;
	LamparaS lamparaS;
	LamparaD lamparaD;*/
	int indiceX;
	int indice = 0;
	int t;
	boolean posicion = true;
	JLabel pared;
	JLabel pared1;
	JLabel pared2;
	JPanel panel;
	JPanel panel2;
	JLabel fuego;
	JLabel portal;

	public MiVentana()
	{
		panel = new JPanel();
		panel.setLayout(null);

		/*panel2 = new JPanel();
		panel2.setLayout(null);*/

		try{
			imagen = ImageIO.read(new File("./imagenes/48389841_204443183824787_1483351678198480896_n.png"));
			//imagen1 = ImageIO.read(new File("./imagenes/png-sprite-generator-7.png"));

		}catch(Exception e)
		{
			System.out.println("Error al cargar la imagen");
		}

		pared = new JLabel();
		pared.setIcon(new ImageIcon("maxresdefault.jpg"));
		pared.setBounds(0,0,1280,25);

		pared1 = new JLabel();
		pared1.setIcon(new ImageIcon("maxresdefault.jpg"));
		pared1.setBounds(0,175,1000,25);

		pared2 = new JLabel();
		pared2.setIcon(new ImageIcon("maxresdefault.jpg"));
		pared2.setBounds(0,335,1280,25);

		fuego = new JLabel();
		fuego.setIcon(new ImageIcon("56079bda3325d326dc4307a9cc8aed63-silueta-de-dibujos-animados-de-fuego.png"));
		fuego.setBounds(0,335,1280,25);

		portal = new JLabel();
		portal.setIcon(new ImageIcon("magic-portal-png-3.png"));
		portal.setBounds(50,216,80,100);

		/*try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("./imagenes/d0299d3be0d151eb3baac4d899e68064.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }*/

		subImagen = imagen.getSubimage(0,0,48,48);
		//subImagen1 = imagen1.getSubimage(0,0,48,48);
		monito = new Monito(subImagen);
		//monito1 = new Monito1(subImagen1);

		/*lamparaW = new LamparaW();
		lamparaS = new LamparaS();
		lamparaD = new LamparaD();
		lamparaA = new LamparaA();*/

		panel.setOpaque(false);
		//panel2.setOpaque(false);
		panel.add(pared);
		panel.add(pared1);
		panel.add(pared2);
		panel.add(fuego);
		panel.add(portal);

		/*this.add(lamparaW);
		this.add(lamparaS);
		this.add(lamparaD);
		this.add(lamparaA);*/
		
		//this.add(monito1);
		this.add(panel);
		//this.add(monito);
		this.setTitle("Mi Ventana");
		this.setSize(1280, 400);
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);; 
		this.setVisible(true);
		this.addKeyListener(this);

		crearHilo1();
	}
	
	public void keyPressed(KeyEvent e)
	{
		//System.out.println("Tecla presionada = "+e.getKeyCode());
		t = e.getKeyCode();
		Point pos = monito.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		//System.out.println( (int) pos.getX() );

		if(t==68)
		{
			x = x + 5;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*2,48,48);
			/*lamparaW.setVisible(false);
			repaint();
			lamparaS.setVisible(false);
			repaint();
			lamparaD.setVisible(true);
			repaint();
			lamparaA.setVisible(false);
			repaint();*/			
		}

		else if(t==65)
		{
			x = x - 5;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48,48,48);
			/*lamparaW.setVisible(false);
			repaint();
			lamparaS.setVisible(false);
			repaint();
			lamparaD.setVisible(false);
			repaint();
			lamparaA.setVisible(true);
			repaint();*/				
		}

		else if(t==83)
		{
			y = y + 5;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*0,48,48);
			/*lamparaW.setVisible(false);
			repaint();
			lamparaS.setVisible(true);
			repaint();
			lamparaD.setVisible(false);
			repaint();
			lamparaA.setVisible(false);
			repaint();*/				
		}
		else if(t==87)
		{
			y = y - 5;
			indice = (indice + 1) % 4;
			indiceX = 48 * indice;
			if (indiceX == 48*3) {
				indiceX = 48;
			}
			monito.imagen = imagen.getSubimage(indiceX,48*3,48,48);
			/*lamparaW.setVisible(true);
			repaint();
			lamparaS.setVisible(false);
			repaint();
			lamparaD.setVisible(false);
			repaint();
			lamparaA.setVisible(false);
			repaint();*/
		}
		monito.setLocation(x,y);
		/*lamparaW.setLocation(x,y);
		lamparaS.setLocation(x,y);
		lamparaD.setLocation(x,y);
		lamparaA.setLocation(x,y);*/
	}

	public void keyReleased(KeyEvent e)
	{
		//System.out.println("Tecla liberada.");
	}

	public void keyTyped(KeyEvent e)
	{
		//System.out.println("Tecla en el buffer.")

	}

	public void crearHilo1()
	{
		Enemigo1 e1 = new Enemigo1(fuego);
		enemigo1 = new Thread(e1);
		enemigo1.start();
	}

}
