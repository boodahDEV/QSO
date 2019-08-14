package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GUI_QSO extends JFrame {

	private JPanel contentPane;
	protected JButton menu_principal;
	protected GUI_QSO gui;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QSO frame = new GUI_QSO();
					frame.meForme(frame);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_QSO() {
	 /*barra inferior*/
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_QSO.class.getResource("/image/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 740);//resolucion estandar
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_principal = new JButton("");
		menu_principal.setIconTextGap(-20);
		menu_principal.setIcon(new ImageIcon(GUI_QSO.class.getResource("/image/menu.png")));
		menu_principal.setFocusable(false);
		menu_principal.setContentAreaFilled(false);
		menu_principal.setBorderPainted(false);
		menu_principal.setBounds(0, 671, 40, 40);
		/**/
		metodo_escuchas_globales(menu_principal);
		/**/
		contentPane.add(menu_principal);
		
		
	/*barra inferior*/
	}
	
	public void meForme(GUI_QSO gui) {
		this.gui = gui;
	}
	
	public void metodo_escuchas_globales(Object objeto_entrante) {
		if(objeto_entrante instanceof JButton) {
			((JButton) objeto_entrante).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
			         for(Field f : gui.getClass().getFields()) {
			          System.out.println("nombre: " + f.getName());
			         }
					System.out.println("Es un boton!");
				}
			});
		}
	}
}
