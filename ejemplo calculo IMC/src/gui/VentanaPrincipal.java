package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import clases.Logica;
import clases.PersonaVO;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class VentanaPrincipal  implements ActionListener{

      public JFrame frame;
      private JTextField txtDocumento;
      private JTextField txtNombre;
      private JTextField txtEdad;
      private JTextField txtPeso;
      private JTextField txtTalla;
      JLabel lblTitulo;
      JLabel lblDatosBasicos;
      JLabel lblDocumento;
      JLabel lblNombre;
      JTextArea txtArea;
      JButton btnCalcularPromedio;
      JButton btnConsultarLista;
      JButton btnRegistrar;
      
      Logica miLogica;
	

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 762, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miLogica=new Logica();
		frame.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("CALCULAR IMC");
		lblTitulo.setBounds(10, 10, 728, 32);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 22));
		frame.getContentPane().add(lblTitulo);
		
		lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setBounds(10, 52, 136, 32);
		lblDatosBasicos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.getContentPane().add(lblDatosBasicos);
		
		lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(10, 94, 94, 20);
		lblDocumento.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(114, 96, 136, 19);
		txtDocumento.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(txtDocumento);
		txtDocumento.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(260, 94, 56, 20);
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(326, 96, 218, 19);
		txtNombre.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		frame.getContentPane().add(txtNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(580, 94, 45, 20);
		lblEdad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(635, 96, 96, 19);
		txtEdad.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblDatosImc = new JLabel("Datos IMC");
		lblDatosImc.setBounds(10, 146, 136, 32);
		lblDatosImc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.getContentPane().add(lblDatosImc);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(10, 178, 45, 20);
		lblPeso.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(114, 180, 136, 19);
		txtPeso.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPeso.setColumns(10);
		frame.getContentPane().add(txtPeso);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setBounds(271, 178, 45, 20);
		lblTalla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTalla.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frame.getContentPane().add(lblTalla);
		
		txtTalla = new JTextField();
		txtTalla.setBounds(326, 180, 136, 19);
		txtTalla.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTalla.setColumns(10);
		frame.getContentPane().add(txtTalla);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(10, 208, 136, 32);
		lblResultado.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.getContentPane().add(lblResultado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 728, 165);
		frame.getContentPane().add(scrollPane);
		
		txtArea = new JTextArea();
		txtArea.setText("info");
		scrollPane.setViewportView(txtArea);
		
		btnCalcularPromedio = new JButton("CALCULAR PROMEDIO IMC");
		btnCalcularPromedio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnCalcularPromedio.setBounds(463, 431, 275, 32);
		btnCalcularPromedio.addActionListener(this);
		frame.getContentPane().add(btnCalcularPromedio);
		
		btnConsultarLista = new JButton("CONSULTAR LISTA");
		btnConsultarLista.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnConsultarLista.setBounds(220, 431, 233, 32);
		btnConsultarLista.addActionListener(this);
		frame.getContentPane().add(btnConsultarLista);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnRegistrar.setBounds(10, 431, 199, 32);
		btnRegistrar.addActionListener(this);
		frame.getContentPane().add(btnRegistrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {
			PersonaVO miPersona=new PersonaVO();
			miPersona.setDocumento(txtDocumento.getText());
			miPersona.setNombre(txtNombre.getText());
			miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
			miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			
		String res=miLogica.registrarPersona(miPersona);
		 txtArea.setText(res);
		}
		if (e.getSource()==btnConsultarLista) {
			String res=miLogica.consultarListaPersonas();
			txtArea.setText(res);
		}
		
		if (e.getSource()==btnCalcularPromedio) {
			String res=miLogica.consultarPromedio();
			txtArea.setText(res);

		}
	}
}
