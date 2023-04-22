
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
	
	private int i, j;
	private  JButton botones[];
	private  JButton matrizBotones[][];	
	private String arregloNum[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"," "};
	List<String> values= Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"," ");
	boolean gano;
	Color gris=Color.decode("#5a5f69");
	
	public RompecabezasNum() {
		gano=false;
		this.setSize(640,480);
		this.setLocationRelativeTo(null);
		this.setTitle("Rompecabezas numerico");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(true);

		
		botones = new JButton[16];
		matrizBotones= new JButton[4][4];
		
		this.setSize(640,480);
		this.setLocation(0,0);
		JPanel panelBotones= new JPanel();
		JPanel marcoArriba= new JPanel();
		JPanel marcoAbajo=new JPanel();
		JPanel marcoDerecha=new JPanel();
		JPanel marcoIzquierda=new JPanel();

		this.setBackground(Color.decode("#042745"));
		this.setLayout(new BorderLayout());
		
		panelBotones.setLayout(new GridLayout(4,4));
		panelBotones.setOpaque(true);
		panelBotones.setBackground(Color.decode("#042745"));
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
			}
			
		}

		Collections.shuffle(values);
		aux=0;
		for (int i = 0; i < 4; i++) {
			for(int j=0; j<4; j++) {
				matrizBotones[i][j].setFocusPainted(false);
				matrizBotones[i][j].setText(values.get(aux));
				matrizBotones[i][j].setFont(new Font("Cooper Black", Font.BOLD, 35));
				matrizBotones[i][j].setForeground(Color.white);
				aux++;
			}
			
		}
		actualizarColores();
		
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
		
		marcoArriba.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		marcoArriba.setBackground(Color.decode("#042745"));
		
		marcoAbajo.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		marcoAbajo.setBackground(Color.decode("#042745"));
		
		JButton btnReinicio= new JButton("Reiniciar");
		btnReinicio.setFont(new Font("Segoe UI Black",Font.BOLD,20));
		btnReinicio.setBackground(Color.decode("#9836bf"));
		btnReinicio.setForeground(Color.white);
		btnReinicio.setFocusPainted(false);
		
		btnReinicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reiniciar();
				actualizarColores();
				
			}
			
		});
		
		marcoDerecha.setLayout(new GridLayout(0,1,0,0));
		marcoDerecha.setBackground(Color.decode("#042745"));
		marcoIzquierda.setLayout(new GridLayout(0,1,0,0));
		marcoIzquierda.setBackground(Color.decode("#042745"));
		
		JLabel j1=new JLabel("Rompecabezas numerico");
		j1.setForeground(Color.decode("#faef75"));
		j1.setFont(new Font("Cooper Black", Font.BOLD, 40));
		JLabel j2=new JLabel("hola");
		j2.setForeground(Color.decode("#042745"));
		JLabel j3=new JLabel("hola");
		j3.setForeground(Color.decode("#042745"));
		JLabel j4=new JLabel("hola");
		j4.setForeground(Color.decode("#042745"));
		
		marcoArriba.add(j1);
		marcoAbajo.add(btnReinicio);
		marcoDerecha.add(j3);
		marcoIzquierda.add(j4);
		
		
		this.add(panelBotones,BorderLayout.CENTER);
		this.add(marcoArriba,BorderLayout.NORTH);
		this.add(marcoAbajo,BorderLayout.SOUTH);
		this.add(marcoDerecha,BorderLayout.EAST);
		this.add(marcoIzquierda,BorderLayout.WEST);
	
		this.repaint();
		this.revalidate();
		this.setVisible(true);
		
	}
	
	private void agregarAccion(final JButton boton,final int fila, final int columna) {
		boton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e);
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
				
				gano=validarGane(botones);
				if(gano==true) {
					Object[] opciones = {"Volver a jugar"};
					int seleccion = JOptionPane.showOptionDialog(null, "Haz ganado", "FELICIDADES!", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones,opciones[0]);
					
			        if (seleccion == JOptionPane.YES_OPTION) {
			        	reiniciar();
			        	actualizarColores();
			        } 
				}
			}
			
		});
	}
	
	public void reiniciar(){
		gano=false;
		Collections.shuffle(values);
		
		int aux=0;
		for (int i = 0; i < 4; i++) {
			for(int j=0; j<4; j++) {
				matrizBotones[i][j].setText(values.get(aux));
				aux++;
			}
			
		}
		
	}
	public void verificarAbajo(int fila, int columna) {
		if(matrizBotones[fila+1][columna].getText()==" ") { //abajo
			matrizBotones[fila+1][columna].setText(matrizBotones[fila][columna].getText());
			matrizBotones[fila+1][columna].setBackground(matrizBotones[fila][columna].getBackground());
			matrizBotones[fila][columna].setBackground(gris);
			matrizBotones[fila][columna].setText(" ");
			//color=matrizBotones[fila][columna].getBackground();
		}
	}
	
	public void verificarDerecha(int fila, int columna) {
		if(matrizBotones[fila][columna+1].getText()==" ") { //derecha
			matrizBotones[fila][columna+1].setText(matrizBotones[fila][columna].getText());
			matrizBotones[fila][columna+1].setBackground(matrizBotones[fila][columna].getBackground());
			matrizBotones[fila][columna].setBackground(gris);
			matrizBotones[fila][columna].setText(" ");
		}
	}
	
	public void verificarIzquierda(int fila, int columna) {
		if(matrizBotones[fila][columna-1].getText()==" ") { //izquierda
			matrizBotones[fila][columna-1].setText(matrizBotones[fila][columna].getText());
			matrizBotones[fila][columna-1].setBackground(matrizBotones[fila][columna].getBackground());
			matrizBotones[fila][columna].setBackground(gris);
			matrizBotones[fila][columna].setText(" ");
		}
	}
	
	public void verificarArriba(int fila, int columna) {
		if(matrizBotones[fila-1][columna].getText()==" ") { //arriba
			matrizBotones[fila-1][columna].setText(matrizBotones[fila][columna].getText());
			matrizBotones[fila-1][columna].setBackground(matrizBotones[fila][columna].getBackground());
			matrizBotones[fila][columna].setBackground(gris);
			matrizBotones[fila][columna].setText(" ");
		}
	}
	
	public boolean validarGane(JButton botones[]) {
		boolean gano;
		String[] textoBotones = new String[botones.length];
		
		for(int i=0;i<botones.length;i++) {
			textoBotones[i] = botones[i].getText();
		}
		
		gano=Arrays.equals(arregloNum, textoBotones);
		
		return gano;
	}
	public void actualizarColores() {
		for (int k = 0; k < botones.length; k++) {
				if(botones[k].getText()=="1"||botones[k].getText()=="2" ||botones[k].getText()=="3"||botones[k].getText()=="4") {
					botones[k].setBackground(Color.decode("#e50064"));
					
				}
				if(botones[k].getText()=="5"||botones[k].getText()=="6" ||botones[k].getText()=="7"||botones[k].getText()=="8") {
					botones[k].setBackground(Color.decode("#4285f4"));
				}
				if(botones[k].getText()=="9"||botones[k].getText()=="10" ||botones[k].getText()=="11"||botones[k].getText()=="12") {
					botones[k].setBackground(Color.decode("#6e2585"));
				}
				if(botones[k].getText()=="13"||botones[k].getText()=="14" ||botones[k].getText()=="15") {
					botones[k].setBackground(Color.decode("#ffa000"));
				}
				if(botones[k].getText()==" ") {
					botones[k].setBackground(Color.decode("#5a5f69"));
				}
			
		}
	}
	
}