package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GUI_QSO extends JFrame {

	private JPanel contentPane;
	protected JButton menu_principal;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QSO frame = new GUI_QSO();
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
	 
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI_QSO.class.getResource("/image/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 740);//resolucion estandar
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*barra inferior*/
		
		JPanel jpinferior = new JPanel();
		jpinferior.setBounds(0, 671, 1018, 40);
		contentPane.add(jpinferior);
		jpinferior.setLayout(null);
		
			menu_principal = new JButton("");
			menu_principal.setRolloverSelectedIcon(new ImageIcon(GUI_QSO.class.getResource("/image/menu_2.png")));
			menu_principal.setRolloverIcon(new ImageIcon(GUI_QSO.class.getResource("/image/menu_2.png")));
			menu_principal.setBounds(0, 0, 40, 40);
			menu_principal.setIconTextGap(-20);
			menu_principal.setIcon(new ImageIcon(GUI_QSO.class.getResource("/image/menu.png")));
			menu_principal.setFocusable(false);
			menu_principal.setContentAreaFilled(false);
			menu_principal.setBorderPainted(false);
			metodo_escuchas_globales(menu_principal);
			jpinferior.add(menu_principal);
		
			/*barra inferior*/
			
		JPanel jpspace = new JPanel();
		jpspace.setBackground(Color.WHITE);
		jpspace.setBounds(0, 0, 1018, 672);
		contentPane.add(jpspace);
	}
	
	public void metodo_escuchas_globales(Object objeto_entrante) {
		if(objeto_entrante instanceof JButton && objeto_entrante.equals(menu_principal)) {
			((JButton) objeto_entrante).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//Accion del boton!
				}
			});
		}//objeto menu_principal
	}
}
