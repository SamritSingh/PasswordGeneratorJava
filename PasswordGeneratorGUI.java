import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        // render frame and add title;
        super("Password Generator");

        // set size
        setSize(540, 580);

        // disable resizing
        setResizable(false);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // centre GUI
        setLocationRelativeTo(null);

        // initialize password generator
        passwordGenerator = new PasswordGenerator();
        // add GUI components
        addGUIComponents();
    }

    private void addGUIComponents(){
        // add title text
        JLabel titleLabel = new JLabel("Password Generator");

        // style the label
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        // move label to the centre
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // set coordinates and width/height
        titleLabel.setBounds(0,10,540,39);

        // add component to GUI
        add(titleLabel);

        // create result text area
        JTextArea passwordOutput = new JTextArea();

        // prevent editing
        passwordOutput.setEditable(false);

        // make output bold, set boundary and add
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));
        passwordOutput.setBounds(25,97,479,70);
        passwordOutput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutput);

        // create password length label
        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        // create password length input
        JTextArea passwordLengthInput = new JTextArea();
        passwordLengthInput.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInput.setBounds(310,215,192,39);
        passwordLengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordLengthInput);

        // create toggle buttons
        // uppercase toggle button
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 32));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        // lowercase toggle button
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 32));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        // numbers toggle button
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 32));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        // special characters toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 32));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

        //create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordLengthInput.getText().length() <= 0) return;
                boolean anyToggled = lowercaseToggle.isSelected() ||
                            uppercaseToggle.isSelected() ||
                            numbersToggle.isSelected() ||
                            symbolsToggle.isSelected();

                // generate password
                int passwordLength = Integer.parseInt(passwordLengthInput.getText());
                if(anyToggled){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected());

                    // display output
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}
