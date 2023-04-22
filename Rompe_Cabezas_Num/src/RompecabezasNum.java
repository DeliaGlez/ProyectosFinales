
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RompecabezasNum extends JFrame{
	int i, j;
	private  JButton botones[];
	private  JButton matrizBotones[][];	
	public RompecabezasNum() {
		this.setSize(640,480);
		this.setLocationRelativeTo(null);
		this.setTitle("Ventana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(true);
		
		List<String> values= Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"," ");
		Collections.shuffle(values);
	
		
		botones = new JButton[16];
		matrizBotones= new JButton[4][4];
		
		this.setSize(640,480);
		this.setLocation(0,0);
		JPanel panelBotones= new JPanel();
		JPanel marcoArriba= new JPanel();
		JPanel marcoAbajo=new JPanel();
		JPanel marcoDerecha=new JPanel();
		JPanel marcoIzquierda=new JPanel();

		this.setBackground(Color.decode("#0665c0"));
		this.setLayout(new BorderLayout());
		
		
		panelBotones.setLayout(new GridLayout(4,4));
		panelBotones.setOpaque(true);
		panelBotones.setBackground(Color.decode("#c99257"));
		JButton btn1= new JButton();
		JButton btn2= new JButton();
		JButton btn3= new JButton();
		JButton btn4= new JButton();
		JButton btn5= new JButton();
		JButton btn6= new JButton();
		JButton btn7= new JButton();
		JButton btn8= new JButton();
		JButton btn9= new JButton();
		JButton btn10= new JButton();
		JButton btn11= new JButton();
		JButton btn12= new JButton();
		JButton btn13= new JButton();
		JButton btn14= new JButton();
		JButton btn15= new JButton();
		JButton btn16= new JButton();
		
		
		
		
		for (int i = 0; i < 16; i++) {
			switch (i) {
			case 0:
				botones[i]=btn1;
				break;
			case 1:
				botones[i]=btn2;
				break;
			case 2:
				botones[i]=btn3;
				break;
			case 3:
				botones[i]=btn4;
				break;
			case 4:
				botones[i]=btn5;
				break;
			case 5:
				botones[i]=btn6;
				break;
			case 6:
				botones[i]=btn7;
				break;
			case 7:
				botones[i]=btn8;
				break;
			case 8:
				botones[i]=btn9;
				break;
			case 9:
				botones[i]=btn10;
				break;
			case 10:
				botones[i]=btn11;
				break;
			case 11:
				botones[i]=btn12;
				break;
			case 12:
				botones[i]=btn13;
				break;
			case 13:
				botones[i]=btn14;
				break;
			case 14:
				botones[i]=btn15;
				break;
			case 15:
				botones[i]=btn16;
				break;
				
				
			}
		}
		int aux=0;
		for (i = 0; i < 4; i++) {
			for( j=0; j<4; j++) {
				matrizBotones[i][j]=botones[aux];
				agregarAccion(matrizBotones[i][j],i,j);
				aux++;
				System.out.println(aux);
			}
			
		}
		aux=0;
		for (int i = 0; i < 4; i++) {
			for(int j=0; j<4; j++) {
				matrizBotones[i][j].setText(values.get(aux));
				aux++;
			}
			
		}
		/*for (int i = 0; i < 16; i++) {
			botones[i].setText(values.get(i));
		}*/
		
		
		
		panelBotones.add(btn1);
		panelBotones.add(btn2);
		panelBotones.add(btn3);
		panelBotones.add(btn4);
		panelBotones.add(btn5);
		panelBotones.add(btn6);
		panelBotones.add(btn7);
		panelBotones.add(btn8);
		panelBotones.add(btn9);
		panelBotones.add(btn10);
		panelBotones.add(btn11);
		panelBotones.add(btn12);
		panelBotones.add(btn13);
		panelBotones.add(btn14);
		panelBotones.add(btn15);
		panelBotones.add(btn16);
		
		
		
		marcoArriba.setLayout(new GridLayout(0,1,0,0));
		marcoArriba.setBackground(Color.decode("#c99257"));
		//marcoArriba.setBackground(getForeground());
		//marcoArriba.setLayout(new GridLayout(0,1,0,0));
		marcoAbajo.setLayout(new GridLayout(0,1,0,0));
		marcoAbajo.setBackground(Color.decode("#c99257"));
		
		JButton reinicio= new JButton("Reiniciar");
		reinicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Collections.shuffle(values);
				System.out.println(values);
				int aux=0;
				for (int i = 0; i < 4; i++) {
					for(int j=0; j<4; j++) {
						matrizBotones[i][j].setText(values.get(aux));
						aux++;
					}
					
				}
			}
			
		});
		
		marcoDerecha.setLayout(new GridLayout(0,1,0,0));
		marcoDerecha.setBackground(Color.decode("#c99257"));
		marcoIzquierda.setLayout(new GridLayout(0,1,0,0));
		marcoIzquierda.setBackground(Color.decode("#c99257"));
		
		JLabel j1=new JLabel("hola");
		j1.setForeground(Color.decode("#c99257"));
		JLabel j2=new JLabel("hola");
		j2.setForeground(Color.decode("#c99257"));
		JLabel j3=new JLabel("hola");
		j3.setForeground(Color.decode("#c99257"));
		JLabel j4=new JLabel("hola");
		j4.setForeground(Color.decode("#c99257"));
		
		marcoArriba.add(j1);
		marcoAbajo.add(reinicio);
		marcoDerecha.add(j3);
		marcoIzquierda.add(j4);
		
		
		
		this.add(panelBotones,BorderLayout.CENTER);
		this.add(marcoArriba,BorderLayout.NORTH);
		this.add(marcoAbajo,BorderLayout.SOUTH);
		this.add(marcoDerecha,BorderLayout.EAST);
		this.add(marcoIzquierda,BorderLayout.WEST);
		
		
		//this.add(principal);
		this.repaint();
		this.revalidate();
		this.setVisible(true);
		
	}
	
	private void agregarAccion(final JButton boton,final int fila, final int columna) {
		boton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				if(boton.getText() != " ") {
					// boton 0,0
					if(fila==0 && columna==0) {
						verificarAbajo( fila,columna);
						verificarDerecha( fila,columna);
						
					}
					 //botones 0,1 y 0,2
					if((fila==0 && columna==1) || (fila==0 && columna==2)) {
						verificarIzquierda( fila,columna); 
						verificarDerecha( fila,columna);
						verificarAbajo( fila,columna);
						
					}
					
					 //botones 1,0 y 2,0
					if((fila==1 && columna==0) || (fila==2 && columna==0)) {
						verificarArriba( fila,columna);
						verificarDerecha( fila,columna); 
						verificarAbajo( fila,columna);
						
					}
					 //botones 1,3 y 2,3
					if((fila==1 && columna==3) || (fila==2 && columna==3)) {
						verificarArriba( fila,columna);
						verificarIzquierda( fila,columna); 
						verificarAbajo( fila,columna);
						
					}
					 //botones 3,1 y 3,2
					if((fila==3 && columna==1) || (fila==3 && columna==2)) {
						verificarArriba( fila,columna);
						verificarIzquierda( fila,columna); 
						verificarDerecha( fila,columna);
						
					}
					
					//botones centro
					//
					if((fila==1 && columna==1) || (fila==1 && columna==2)|| (fila==2 && columna==1)|| (fila==2 && columna==2)) {
						verificarArriba( fila,columna);
						verificarAbajo(fila,columna);
						verificarIzquierda( fila,columna); 
						verificarDerecha( fila,columna);
						
					}

					// boton 0,3
					if(boton.equals(matrizBotones[0][3])) {
						verificarIzquierda( fila,columna);
						verificarAbajo( fila,columna);
					}
					// boton 3,0
					if(boton.equals(matrizBotones[3][0])) {
						verificarArriba( fila,columna);
						verificarDerecha( fila,columna);
					}
					// boton 3,3
					if(boton.equals(matrizBotones[3][3])) {
						verificarArriba( fila,columna);
						verificarIzquierda( fila,columna);
					}
					
				};
			}
			
		});
	}
	
	public void verificarAbajo(int fila, int columna) {
		if(matrizBotones[fila+1][columna].getText()==" ") { //abajo
			matrizBotones[fila+1][columna].setText(matrizBotones[fila][columna].getText());
			matrizBotones[fila][columna].setText(" ");
		}
	}
	
	public void verificarDerecha(int fila, int columna) {
		if(matrizBotones[fila][columna+1].getText()==" ") { //derecha
			matrizBotones[fila][columna+1].setText(matrizBotones[fila][columna].getText());
			matrizBotones[fila][columna].setText(" ");
		}
	}
	
	public void verificarIzquierda(int fila, int columna) {
		if(matrizBotones[fila][columna-1].getText()==" ") { //izquierda
			matrizBotones[fila][columna-1].setText(matrizBotones[fila][columna].getText());
			matrizBotones[fila][columna].setText(" ");
		}
	}
	
	public void verificarArriba(int fila, int columna) {
		if(matrizBotones[fila-1][columna].getText()==" ") { //arriba
			matrizBotones[fila-1][columna].setText(matrizBotones[fila][columna].getText());
			matrizBotones[fila][columna].setText(" ");
		}
	}
	
	
}