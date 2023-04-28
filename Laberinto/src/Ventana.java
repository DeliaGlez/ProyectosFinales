import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	public int x=10,y=10;
	public int ultima_Presionada;
	//Rect[] rectangulos;
	ArrayList<Rect> rectangulos;
	Rect player ;
	int[][] laberinto = {
			  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			  {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			  {1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1},
			  {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
			  {1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
			  {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			  {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
			  {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
			  {1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
			  {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			  {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			  {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
			  {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
			  {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			};
	public Ventana() {
		rectangulos= new ArrayList<Rect>();;
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setTitle("Ventana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(true);
		JPanel panel= new JPanel();
		panel.setSize(640,480);
		panel.setLocation(0,0);
		panel.setBackground(Color.decode("#0665c0"));
		panel.setLayout(new FlowLayout());
		
		JButton btn1= new JButton("Reiniciar");
		panel.add(btn1);
		this.add(panel,BorderLayout.SOUTH);
		
		JPanel juego= new JPanel();
		juego.setBackground(Color.orange);
		juego.add(new MyGraphics());
		juego.addKeyListener(new KeyListener() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int xAnterior = x;
		        int yAnterior = y;
		        
				int codigo= e.getKeyCode();
				System.out.println("Tecla:");
				System.out.println(e.getKeyChar());
				System.out.println("Codigo:");
				System.out.println(e.getKeyCode());
				
				ultima_Presionada=codigo;
				switch(codigo) {
				case 65:
				case 37:
					if(x>0) {
					x-=10;
					}
				break;
				case 87:
				case 38:
					if(y>0) {
					y-=10;
					}
				break;
				case 83:
				case 40:
					if(y<390) {
						y+=10;
					}
				break;
				case 68:
				case 39:
					if(x<490 ) {
						x+=10;
					}
					break;
				}
				
				for (int i=0;i<rectangulos.size();i++) {
					if (rectangulos.get(i).colision(new Rect(x, y, 10, 10, Color.blue))) {
			            // hay una colisión, restaurar las coordenadas del cuadrado
			            x = xAnterior;
			            y = yAnterior;
			        }
				}
				juego.repaint();	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.add(juego,BorderLayout.CENTER);
		
		juego.setFocusable(true);
		juego.requestFocus();
		
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}
	public class MyGraphics extends JComponent{
		MyGraphics(){
			setPreferredSize(new Dimension(500,400));
		}
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.gray);
			g.fillRect(0,0,600,400);
			
			player= new Rect(x,y,10,10,Color.blue);
			g.setColor(Color.blue);
			g.fillRect(player.x,player.y,player.w,player.h);
			
			/*Rect p=new Rect(300,60,10,200,Color.red);
			g.setColor(p.c);
			g.fillRect(p.x, p.y, p.w, p.h);
			rectangulos.add(p);
			
			Rect p3=new Rect(210,60);
			g.setColor(p3.c);
			g.fillRect(p3.x, p3.y, p3.w, p3.h);
			rectangulos.add(p3);
			
			Rect p2=new Rect(200,60,10,200,Color.green);
			g.setColor(p2.c);
			g.fillRect(p2.x, p2.y, p2.w, p2.h);
			rectangulos.add(p2);*/
			
			for (int fila=0;fila<15;fila++) {
				for(int columna=0;columna<15;columna++) {
					if (laberinto[fila][columna]==1) {
						g.setColor(Color.black);
						g.fillRect(columna*10, fila*10, 10, 10);
						Rect prueba=new Rect(columna*10,fila*10);
						rectangulos.add(prueba);
					}
				}
			}
			//System.out.println(player.colision(p));	
		}
	}
	
	public class Rect {
		int x=0;
		int y=0;
		int w=0;
		int h=0;
		Color c= Color.black;
		Rect(int x,int y, int w, int h, Color c){
			this.x=x;
			this.y=y;
			this.w=w;
			this.h=h;
			this.c=c;
		}
		Rect(int x,int y){
			this.x=x;
			this.y=y;
			this.w=10;
			this.h=10;
			this.c=Color.black;
		}
		
		public boolean colision(Rect target) {
			
			if(this.x<target.x + target.w &&
					this.x+this.w>target.x &&
					
					this.y<target.y+target.h &&
					this.y+this.h>target.y) {
				return true;
			}
			
			return false;
			
		}
	}
	
}