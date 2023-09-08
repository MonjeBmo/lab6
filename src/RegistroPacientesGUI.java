import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroPacientesGUI extends JFrame {
    private JTextField codigoTextField, nombresTextField, apellidosTextField, dpiTextField,
            direccionTextField, ciudadTextField, fechaNacimientoTextField, edadTextField, pesoTextField;
    private JComboBox<String> sexoComboBox;
    private JTextArea ayudaTextArea;

    public RegistroPacientesGUI() {
        // Configurar la ventana principal
        setTitle("Registro de Pacientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear pestañas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Pestaña 1 - Bienvenida e imagen
        JPanel panel1 = new JPanel();
        JLabel bienvenidaLabel = new JLabel("Bienvenido al Registro de Pacientes");
        ImageIcon logoIcon = new ImageIcon("logo_clinica.png"); // Reemplaza "logo_clinica.png" con la ubicación de tu imagen
        JLabel logoLabel = new JLabel(logoIcon);

        panel1.setLayout(new BorderLayout());
        panel1.add(bienvenidaLabel, BorderLayout.NORTH);
        panel1.add(logoLabel, BorderLayout.CENTER);
        tabbedPane.addTab("Inicio", panel1);

        // Pestaña 2 - Formulario de registro
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6, 4));

        JLabel codigoLabel = new JLabel("Código del Paciente:");
        codigoTextField = new JTextField();
        JLabel nombresLabel = new JLabel("Nombres:");
        nombresTextField = new JTextField();
        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosTextField = new JTextField();
        JLabel dpiLabel = new JLabel("DPI:");
        dpiTextField = new JTextField();
        JLabel direccionLabel = new JLabel("Dirección:");
        direccionTextField = new JTextField();
        JLabel ciudadLabel = new JLabel("Ciudad:");
        ciudadTextField = new JTextField();
        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento:");
        fechaNacimientoTextField = new JTextField();
        JLabel sexoLabel = new JLabel("Sexo:");
        String[] sexoOptions = {"Masculino", "Femenino"};
        sexoComboBox = new JComboBox<>(sexoOptions);
        JLabel edadLabel = new JLabel("Edad:");
        edadTextField = new JTextField();
        JLabel pesoLabel = new JLabel("Peso:");
        pesoTextField = new JTextField();

        panel2.add(codigoLabel);
        panel2.add(codigoTextField);
        panel2.add(nombresLabel);
        panel2.add(nombresTextField);
        panel2.add(apellidosLabel);
        panel2.add(apellidosTextField);
        panel2.add(dpiLabel);
        panel2.add(dpiTextField);
        panel2.add(direccionLabel);
        panel2.add(direccionTextField);
        panel2.add(ciudadLabel);
        panel2.add(ciudadTextField);
        panel2.add(fechaNacimientoLabel);
        panel2.add(fechaNacimientoTextField);
        panel2.add(sexoLabel);
        panel2.add(sexoComboBox);
        panel2.add(edadLabel);
        panel2.add(edadTextField);
        panel2.add(pesoLabel);
        panel2.add(pesoTextField);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarInformacion();
            }
        });

        JButton nuevoButton = new JButton("Limpiar");
        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        panel2.add(guardarButton);
        panel2.add(nuevoButton);
        tabbedPane.addTab("Registro de Pacientes", panel2);

        // Pestaña 3 - Información de ayuda
        JPanel panel3 = new JPanel();
        ayudaTextArea = new JTextArea(10, 40);
        ayudaTextArea.setEditable(false);
        ayudaTextArea.setText("Instrucciones:\n\n1. Complete todos los campos.\n2. Haga clic en Guardar para registrar al paciente.\n3. Haga clic en Nuevo para limpiar los campos.");

        panel3.add(ayudaTextArea);
        tabbedPane.addTab("Ayuda", panel3);

        // Agregar las pestañas a la ventana principal
        add(tabbedPane);
    }

    private void guardarInformacion() {
        // Validar campos vacíos
        if (codigoTextField.getText().isEmpty() || nombresTextField.getText().isEmpty()
                || apellidosTextField.getText().isEmpty() || dpiTextField.getText().isEmpty()
                || direccionTextField.getText().isEmpty() || ciudadTextField.getText().isEmpty()
                || fechaNacimientoTextField.getText().isEmpty() || edadTextField.getText().isEmpty()
                || pesoTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Guardar la información en variables y mostrar en consola
            String codigo = codigoTextField.getText();
            String nombres = nombresTextField.getText();
            String apellidos = apellidosTextField.getText();
            String dpi = dpiTextField.getText();
            String direccion = direccionTextField.getText();
            String ciudad = ciudadTextField.getText();
            String fechaNacimiento = fechaNacimientoTextField.getText();
            String sexo = (String) sexoComboBox.getSelectedItem();
            String edad = edadTextField.getText();
            String peso = pesoTextField.getText();

            // Imprimir en consola
            System.out.println("Código: " + codigo);
            System.out.println("Nombres: " + nombres);
            System.out.println("Apellidos: " + apellidos);
            System.out.println("DPI: " + dpi);
            System.out.println("Dirección: " + direccion);
            System.out.println("Ciudad: " + ciudad);
            System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
            System.out.println("Sexo: " + sexo);
            System.out.println("Edad: " + edad);
            System.out.println("Peso: " + peso);
        }
    }

    private void limpiarCampos() {
        codigoTextField.setText("");
        nombresTextField.setText("");
        apellidosTextField.setText("");
        dpiTextField.setText("");
        direccionTextField.setText("");
        ciudadTextField.setText("");
        fechaNacimientoTextField.setText("");
        sexoComboBox.setSelectedIndex(0);
        edadTextField.setText("");
        pesoTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegistroPacientesGUI app = new RegistroPacientesGUI();
                app.setVisible(true);
            }
        });
    }
}
