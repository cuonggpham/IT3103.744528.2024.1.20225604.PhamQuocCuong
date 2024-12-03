package Exercise.JavaBasics.src;

import javax.swing.JOptionPane;

public class ChoosingOptionCustom {
    public static void main(String[] args){
        String[] options = {"I do", "I don't"};
        
        int option = JOptionPane.showOptionDialog(
                null, 
                "Pham Quoc Cuong - 5604 - Do you want to change to the first class ticket?", 
                "Choose an option", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);

        JOptionPane.showMessageDialog(
                null, 
                "Pham Quoc Cuong - 5604 - You've chosen: " + 
                (option == 0 ? "I do" : "I don't"));

        System.exit(0);
    }
}

