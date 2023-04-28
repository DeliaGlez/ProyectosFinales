import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	//private JFrame frame;
	public int x,y;
	public int ultima_Presionada;
	//public boolean colision;
	public Ventana() {
		this.setSize(640,480);
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
				int codigo= e.getKeyCode();
				System.out.println("Tecla:");
				System.out.println(e.getKeyChar());
				System.out.println("Codigo:");
				System.out.println(e.getKeyCode());
				
				ultima_Presionada=codigo;
				switch(codigo) {
				case 65:
					if(x>0) {
					x-=10;
					}
				break;
				case 87:
					if(y>0) {
					y-=10;
					}
				break;
				case 83:
					if(y<380) {
						y+=10;
					}
				break;
				case 68:
					if(x<480) {
						x+=10;
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
			
			Rect r = new Rect(x,y,20,20,Color.blue);
			g.setColor(Color.blue);
			g.fillRect(r.x,r.y,r.w,r.h);
			
			Rect p=new Rect(300,60,40,200,Color.red);
			g.setColor(p.c);
			g.fillRect(p.x, p.y, p.w, p.h);
			
			System.out.println(r.colision(p));
			
			
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