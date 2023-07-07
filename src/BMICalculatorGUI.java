import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculatorGUI extends JFrame {

    private JButton calculateButton;
    private ButtonGroup weightUnitGroup, heightUnitGroup;
    private JPanel BMI;
    private JTextField heightfield;
    private JTextField weightfield;
    private JRadioButton meterRadioButton;
    private JRadioButton KGRadioButton1;
    private JRadioButton inchersRadioButton1;
    private JRadioButton poundsRadioButton;
    private JButton clearButton;
    private JLabel BMIlable;

    public BMICalculatorGUI() {
        setVisible(true);
        setSize(500,300);
        setTitle("BMI Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(BMI);

        weightUnitGroup = new ButtonGroup();
        heightUnitGroup = new ButtonGroup();

        weightUnitGroup.add(poundsRadioButton);
        weightUnitGroup.add(KGRadioButton1);
        heightUnitGroup.add(meterRadioButton);
        heightUnitGroup.add(inchersRadioButton1);

        KGRadioButton1.setSelected(true);
        meterRadioButton.setSelected(true);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightfield.getText());
                double height = Double.parseDouble(heightfield.getText());

                if (poundsRadioButton.isSelected()) {
                    weight *= 0.453592;
                }
                if (inchersRadioButton1.isSelected()) {
                    height *= 0.0254;
                }

                double bmi = weight / (height * height);
                BMIlable.setText("Your BMI is: " + bmi);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heightfield.setText(" ");
                weightfield.setText(" ");
                BMIlable.setText(" ");


            }
        });
    }

    public static void main(String[] args) {
       BMICalculatorGUI bmiCalculator = new BMICalculatorGUI();
    }
}

