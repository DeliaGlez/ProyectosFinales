import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	public int x=10,y=10;
	public int ultima_Presionada;
	public int largo=600,ancho=600;
	ArrayList<Rect> rectangulos;
	Rect win;
	Rect player ;
	Timer timer ;
    int segundos = 0;
    String tiempoFormateado;
    JLabel lblTiempo= new JLabel("00:00:00");
	int[][] laberinto = {
			{1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	1,	1,	0,	0,	1,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	1,	1,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	1,	1,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	1,	1,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	1,	0,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	1,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	0,	1,	1,	1,	1,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	1,	1,	1,	1,	1,	0,	0,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	1,	1,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	1,	1,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	1,	1,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0,	0,	1,	1,	1,	1},
			{1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	0,	1,	1,	1,	1,	0,	1,	0,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	1,	1,	0,	0,	0,	1,	1,	1,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	1,	0,	0,	1,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	1,	0,	0,	1,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	0,	0,	1,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1},
			{1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	0,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	1,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	1,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	1,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	1,	1,	1,	1,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1,	0,	0,	1},
			{1,	0,	1,	1,	1,	1,	1,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	0,	0,	1,	1,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	0,	1},
			{1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1}

			};
	
	public Ventana() {
		
		timer = new Timer();
		segundos = 0;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                segundos++;
                repaint();
            }
        }, 0, 1000);
        
		rectangulos= new ArrayList<Rect>();;
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setTitle("Laberinto");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(true);
		
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
					if(y<ancho-10) {
						y+=10;
					}
				break;
				case 68:
				case 39:
					if(x<largo-10 ) {
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
				
				if (win.colision(new Rect(x, y, 10, 10, Color.blue))) {
					timer.cancel();
					JOptionPane.showMessageDialog(null, "Has finalizado el laberinto en " + tiempoFormateado, "Felicidades!", 1, null);
					
					/*timer = new Timer(); // nuevo timer para nuevo mapa
					segundos = 0;
			        timer.scheduleAtFixedRate(new TimerTask() {
			            public void run() {
			                segundos++;
			                repaint();
			            }
			        }, 0, 1000);*/
					repaint();
					
				}
				juego.repaint();	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.add(juego,BorderLayout.CENTER);
		
		
		JPanel panel= new JPanel();
		panel.setBackground(Color.decode("#0665c0"));
		panel.setLayout(new FlowLayout());
		
		JButton btn1= new JButton("Reiniciar");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				segundos=0;
				x=10;
				y=10;		
				long tiempoEnSegundos = segundos;
		        long horas = TimeUnit.SECONDS.toHours(tiempoEnSegundos);
		        tiempoEnSegundos -= TimeUnit.HOURS.toSeconds(horas);
		        long minutos = TimeUnit.SECONDS.toMinutes(tiempoEnSegundos);
		        tiempoEnSegundos -= TimeUnit.MINUTES.toSeconds(minutos);
		        long segundosRestantes = tiempoEnSegundos;
				
		        tiempoFormateado = String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes);
		        lblTiempo.setText(tiempoFormateado);
		        juego.setFocusable(true);
				juego.requestFocus();
				repaint();
			}
			
		});
		
		panel.add(btn1);
		this.add(panel,BorderLayout.SOUTH);
		panel.add(lblTiempo);
		
		juego.setFocusable(true);
		juego.requestFocus();
		
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}
	
	public class MyGraphics extends JComponent{
		MyGraphics(){
			setPreferredSize(new Dimension(ancho,largo)); 
		}
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			//
			long tiempoEnSegundos = segundos;
	        long horas = TimeUnit.SECONDS.toHours(tiempoEnSegundos);
	        tiempoEnSegundos -= TimeUnit.HOURS.toSeconds(horas);
	        long minutos = TimeUnit.SECONDS.toMinutes(tiempoEnSegundos);
	        tiempoEnSegundos -= TimeUnit.MINUTES.toSeconds(minutos);
	        long segundosRestantes = tiempoEnSegundos;

	        tiempoFormateado = String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes);
	        lblTiempo.setText(tiempoFormateado);
	        
	        
			g.setColor(Color.white);
			g.fillRect(0,0,ancho,largo);
			
			player= new Rect(x,y,10,10,Color.orange);
			g.setColor(Color.orange);
			g.fillRect(player.x,player.y,player.w,player.h);
			
			 win=new Rect(580,580,10,10,Color.green);
			g.setColor(win.c);
			g.fillRect(win.x, win.y, win.w, win.h);
			
			/*
			Rect p3=new Rect(210,60);
			g.setColor(p3.c);
			g.fillRect(p3.x, p3.y, p3.w, p3.h);
			rectangulos.add(p3);
			
			Rect p2=new Rect(200,60,10,200,Color.green);
			g.setColor(p2.c);
			g.fillRect(p2.x, p2.y, p2.w, p2.h);
			rectangulos.add(p2);*/
			
			for (int fila=0;fila<60;fila++) {
				for(int columna=0;columna<60;columna++) {
					if (laberinto[fila][columna]==1) {
						g.setColor(Color.DARK_GRAY);
						//g.fillRect(columna*10, fila*10, 10, 10);
						Rect prueba=new Rect(columna*10,fila*10);
						g.fillRect(prueba.x, prueba.y, prueba.w,prueba.h);
						rectangulos.add(prueba);
					}
				}
			}	
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