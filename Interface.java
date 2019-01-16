import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {

    public static double dist = 0.0;
    public String faxString = Double.toString(dist);
    private JTextField value = new JTextField(String.valueOf(faxString));

    private Font font = new Font("Arial", Font.PLAIN, 40);
    private JButton buttonPull = new JButton("PULL");
    private JButton buttonPress = new JButton("PRESS");
    private JButton buttonStop = new JButton("STOP");
    private JButton buttonPlus = new JButton("▶");
    private JButton buttonMinus = new JButton("◀");

    private JLabel empty = new JLabel(" ");
    private JLabel empty1 = new JLabel(" ");


    public Interface() {
        //super("Magnitiko");

        this.setUndecorated(true); //окно без кнопок на весь экран
        this.setSize(500,200);
        this.setVisible(true);

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPull.setVisible(true);
        buttonPull.setLocation(250,50);
        buttonPull.setSize(300,300);
        buttonPull.setFont(font);
        buttonPull.addActionListener(new ButtonEventListener());
        this.add(buttonPull);
        buttonPress.setVisible(true);
        buttonPress.setLocation(600,50);
        buttonPress.setSize(300,300);
        buttonPress.setFont(font);
        buttonPress.addActionListener(new ButtonEventListener());
        this.add(buttonPress);
        buttonStop.setVisible(true);
        buttonStop.setLocation(950,50);
        buttonStop.setSize(300,300);
        buttonStop.setFont(font);
        buttonStop.addActionListener(new ButtonEventListener());
        this.add(buttonStop);
        buttonMinus.setVisible(true);
        buttonMinus.setLocation(500,400);
        buttonMinus.setSize(100,100);
        buttonMinus.setFont(font);
        buttonMinus.addActionListener(new MinusButtonListener());


        this.add(buttonMinus);
        value.setHorizontalAlignment(JTextField.CENTER);
        value.setLocation(650,400);
        value.setSize(200,100);
        value.setFont(font);
        value.setEnabled(false);
        this.add(value);
        buttonPlus.setVisible(true);
        buttonPlus.setLocation(900,400);
        buttonPlus.setSize(100,100);
        buttonPlus.setFont(font);
        buttonPlus.addActionListener(new PlusButtonListener());
        this.add(buttonPlus);

        this.add(empty);


    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";




            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
    class PlusButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {



            // String formattedDouble = String.format("%.2f", dist);
            dist += 0.1;

            value.setText(String.format("%.1f",dist));

        }
    }
    class MinusButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dist -= 0.1;
            if (dist < 0){
                dist = 0;
            }
            //value.getText();

            value.setText(String.format("%.1f",dist));;

        }
    }


    public static void main(String[] args) {
        Interface app = new Interface();
        app.setVisible(true);
       // app.setUndecorated(false);

    }
}

