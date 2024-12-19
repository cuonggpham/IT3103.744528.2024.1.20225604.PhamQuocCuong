//Pham Quoc Cuong - 20225604
package hust.soict.hedspi.swing;

import java.awt.Label;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AWTAccumulator extends Frame {
   private TextField tfInput;
   private TextField tfOutput;
   private int sum = 0;

   public AWTAccumulator() {
      setLayout(new GridLayout(2, 2));
      add(new Label("CuongPQ 5604 - Enter an Integer: "));
      tfInput = new TextField(10);
      add(this.tfInput);
      tfInput.addActionListener(new TFInputListener());
      add(new Label("CuongPQ 5604 - The Accumulated Sum is: "));
      tfOutput = new TextField(10);
      tfOutput.setEditable(false);
      add(tfOutput);
      setTitle("CuongPQ 5604 - AWT Accumulator");
      setSize(350, 120);
      setVisible(true);
   }

   public static void main(String[] args) {
      new AWTAccumulator();
   }
   private class TFInputListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ewt){
        int numberIn = Integer.parseInt(tfInput.getText());
        sum += numberIn;
        tfInput.setText("");
        tfOutput.setText(sum + "");
    }
}
}
