package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import vista.Vista;

public class Controlador implements MouseListener, ActionListener{
	
	Vista vista = new Vista();
	Connection conex=null;
	DefaultListModel modelo = new DefaultListModel();
	
	public Controlador(Vista vista) {
		this.vista.listListaParques.addMouseListener(this);
		this.vista.btnFiltrar.addActionListener(this);
		this.vista.btnConfirmar.addActionListener(this);

	}
	public Connection createConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARQUESCLM?serverTimezone=UTC","root", "victor21");
			//set autocommit false
			connection.setAutoCommit(false);			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		}

		return connection;
	}
	
	public void disconnect(Connection connection) throws SQLException {
		try {
			if (null != connection) {
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.vista.btnFiltrar) {
				try {
					createConnection();
				} catch (ClassNotFoundException |SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				if(this.vista.comboBoxPrimerFiltro.getSelectedIndex()==1) {
				//	this.vista.comboBoxSegundoFiltro.setModel(new ComboBoxModel(""));
				}
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

