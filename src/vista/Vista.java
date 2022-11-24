package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class Vista extends JFrame {

	public JPanel contentPane;
	public JLabel lblLogo,lblMapa,lblFiltro;
	public JComboBox comboBoxSegundoFiltro,comboBoxPrimerFiltro;
	public JTextPane txtpninformacionDelElemento;
	public JList listListaParques;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Controlador controlador= new Controlador(frame);
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
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setForeground(Color.PINK);
		lblLogo.setBackground(Color.PINK);
		lblLogo.setBounds(10, 10, 220, 64);
		lblLogo.setIcon(new ImageIcon("img/bandera.png"));
		contentPane.add(lblLogo);
		
		lblMapa = new JLabel("");
		lblMapa.setBounds(272, 10, 450, 369);
		lblMapa.setIcon(new ImageIcon("img/mapa.jpg"));
		contentPane.add(lblMapa);
		
		comboBoxSegundoFiltro = new JComboBox();
		comboBoxSegundoFiltro.setModel(new DefaultComboBoxModel(new String[] {"(Seleccion Filtro)"}));
		comboBoxSegundoFiltro.setBounds(364, 401, 129, 21);
		contentPane.add(comboBoxSegundoFiltro);
		
		comboBoxPrimerFiltro = new JComboBox();
		comboBoxPrimerFiltro.setModel(new DefaultComboBoxModel(new String[] {"(Seleccion Filtro)", "Sin Filtros", "Por Provincia", "Por Tipo"}));
		comboBoxPrimerFiltro.setBounds(122, 401, 129, 21);
		contentPane.add(comboBoxPrimerFiltro);
		
		lblFiltro = new JLabel("Filtro: ");
		lblFiltro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiltro.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFiltro.setBounds(29, 403, 70, 13);
		contentPane.add(lblFiltro);
		
		txtpninformacionDelElemento = new JTextPane();
		txtpninformacionDelElemento.setEditable(false);
		txtpninformacionDelElemento.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		txtpninformacionDelElemento.setBounds(10, 102, 220, 244);
		contentPane.add(txtpninformacionDelElemento);
		
		listListaParques = new JList();
		listListaParques.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listListaParques.setBounds(0, 426, 683, 197);
		contentPane.add(listListaParques);
		
	}
}
