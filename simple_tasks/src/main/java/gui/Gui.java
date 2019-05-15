import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Gui extends JFrame {



    JLabel myLabelFio;
    public Gui() {
        super();
        this.setSize(300, 200);
        this.getContentPane().setLayout(null);
        myLabelFio = getJLabel();
        this.add(myLabelFio, null);
        this.add(getJButton(), null);
        this.setTitle("My first swing app");
    }

    private javax.swing.JLabel getJLabel() {
            JLabel jLabel = new javax.swing.JLabel();
            jLabel.setBounds(34, 49, 300, 18);
            jLabel.setText("ФИО");
        return jLabel;
    }

    private javax.swing.JButton getJButton() {
            JButton jButton = new javax.swing.JButton();
            jButton.setBounds(70, 110, 150, 27);
            jButton.setText("Ввести ФИО");
            jButton.addActionListener(new EnterFIOButton(myLabelFio));
        return jButton;
    }
}

class EnterFIOButton implements ActionListener {
    JLabel myLabelFio;
    public EnterFIOButton(JLabel label) {
        this.myLabelFio = label;
    }

    // Метод интерфейса для получения нажатий кнопки
    public void actionPerformed(ActionEvent e) {
        FIOFrame fioFrame = new FIOFrame(myLabelFio);
        fioFrame.setVisible(true);
    }
}

class FIOFrame extends JFrame {
    private JTextField f;
    private JTextField i;
    private JTextField o;
    JLabel label;


    public FIOFrame(JLabel label) {
        super();
        this.label = label;
        this.setSize(300, 200);
        this.getContentPane().setLayout(null);
        f = getJTextF();
        i = getJTextI();
        o = getJTextO();
        this.add(f, null);
        this.add(i, null);
        this.add(o, null);
        this.add(getJButton(), null);
        this.setTitle("Enter FIO");

    }
        private javax.swing.JTextField getJTextF() {
            JTextField jTextField = new javax.swing.JTextField();
            jTextField.setBounds(90, 50, 160, 20);
            jTextField.setName("Фамилия");
        return jTextField;
    }
    private javax.swing.JTextField getJTextI() {
        JTextField jTextField = new javax.swing.JTextField();
        jTextField.setBounds(90, 70, 160, 20);
        return jTextField;
    }
    private javax.swing.JTextField getJTextO() {
        JTextField jTextField = new javax.swing.JTextField();
        jTextField.setBounds(90, 90, 160, 20);
        return jTextField;
    }

    private javax.swing.JButton getJButton() {
        JButton jButton = new javax.swing.JButton();
        jButton.setBounds(103, 110, 71, 27);
        jButton.setText("Close and apply");
        jButton.addActionListener(new ApplyFIOButton(this, f, i , o, label));
        return jButton;
    }
}

class ApplyFIOButton implements ActionListener {
    // Метод интерфейса для получения нажатий кнопки
    private JFrame frame;
    private JTextField f;
    private JTextField i;
    private JTextField o;
    private JLabel label;

    public ApplyFIOButton(JFrame frame, JTextField f, JTextField i, JTextField o, JLabel label) {
        this.frame = frame;
        this.f = f;
        this.i = i;
        this.o = o;
        this.label = label;
    }

    public void actionPerformed(ActionEvent e) {
        String fioString = new StringBuilder(f.getText()).append(" ").
               append(i.getText()).append(" ").append(o.getText()).toString();
        label.setText(fioString);
        frame.dispose();

    }
}
