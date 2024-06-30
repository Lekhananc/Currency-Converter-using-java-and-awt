import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_AWT_CurrencyConverter {
    Frame frame;
    TextField tf1;
    TextField tf2;
    Choice from;
    Choice to;
    public GUI_AWT_CurrencyConverter(){
        frame = new Frame("Currency Converter");

        Label currencyConverter = new Label("Currency Converter");
//        currencyConverter.setBounds(50,50,200,50);

        Font myFont = new Font("Arial",Font.BOLD,25);
        currencyConverter.setBounds(75,50,200,50);
        currencyConverter.setFont(myFont);

        tf1 = new TextField("0",5);
        tf1.setBounds(20,120,30,30);

        Button plus = new Button("+");
        plus.setBounds(55,115,15,15);
        Button minus = new Button("-");
        minus.setBounds(55,135,15,15);

        from = new Choice();
        from.add("INR");
        from.add("USD");
        from.add("EUR");
        from.add("JPY");
        from.setBounds(80,120,100,30);

        Font myFont2 = new Font("Arial",Font.BOLD,15);
        Label convert = new Label("TO");
        convert.setBounds(185,115,30,30);
//        convert.setBackground(Color.lightGray);
        convert.setFont(myFont2);

        to = new Choice();
        to.add("INR");
        to.add("USD");
        to.add("EUR");
        to.add("JPY");
        to.setBounds(220,120,100,30);

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increaseValue();
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decreaseValue();
            }
        });

        Button convertButton = new Button("Convert");
        convertButton.setBounds(115,180,100,50);
        convertButton.setBackground(Color.lightGray);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fromCurrency = getFromCurrency();
                    String toCurrency = getToCurrency();
                    double value = convertStringToInt();
                    Currency cr = new Currency();
                    if(value>0) {
                        double convertedCurrency = cr.convert(fromCurrency, toCurrency, value);
                        tf2.setText(String.valueOf(convertedCurrency));
                    }
                    else{
                        tf2.setText("Negative number not allowed");
                    }

                }catch(Exception e1){
                    tf2.setText("Invalid Input");
                }
            }
        });

        tf2 = new TextField();
        tf2.setBounds(125,250,80,30);

        frame.add(tf2);
        frame.add(convertButton);
        frame.add(tf1);
        frame.add(plus);
        frame.add(minus);
        frame.add(convert);
        frame.add(from);
        frame.add(to);
        frame.add(currencyConverter);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setLayout(null);
        frame.setSize(350,400);
        frame.setVisible(true);
    }

    public void increaseValue(){
        String text = tf1.getText().trim();
        if(!text.isEmpty()){
            try{
                int value = Integer.parseInt(text);
                tf1.setText(String.valueOf(value+1));
            }
            catch(Exception e){
                tf1.setText("0");
            }
        }
    }

    public void decreaseValue(){
        String text = tf1.getText().trim();
        if(!text.isEmpty()){
            try{
                int value = Integer.parseInt(text);
                tf1.setText(String.valueOf(value-1));
            }
            catch(Exception e){
                tf1.setText("0");
            }
        }
    }

    public int convertStringToInt(){
        String text = tf1.getText().trim();
        int value = Integer.parseInt(text);
        return value;
    }

    public String getFromCurrency(){
       String text = from.getSelectedItem().trim();
       return text;
    }

    public String getToCurrency(){
        String text = to.getSelectedItem().trim();
        return text;
    }

}
