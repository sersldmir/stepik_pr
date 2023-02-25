import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calc {

    public static String calcFunc(String input[]){
        double a = 0, b = 0;
        String res = "";
        try{
            a = Double.parseDouble(input[0]); b = Double.parseDouble(input[2]);
        }
        catch (Exception e){
            return "Error! Not number";
        }
        switch(input[1]){
            case "+": res = Double.toString(a+b); break;
            case "-": res = Double.toString(a-b); break;
            case "*": res = Double.toString(a*b); break;
            case "/":
                if (b==0){
                    return "Error! Division by zero";
                }
                else{
                    res = Double.toString(a/b); break;
                }
            default: return "Operation Error!";
        }
        return res;
    }
    public static void main(String[] args) {
        try {
            File fileObj = new File("test.txt");
            FileWriter output = new FileWriter("output.txt");
            Scanner reader = new Scanner(fileObj);
            while (reader.hasNextLine()){
                String input = reader.nextLine();
                String calc_args[] = input.split(" ");
                output.write(String.format("%s = %s\n", input, Calc.calcFunc(calc_args)));
                output.flush();
            }
            reader.close();
            output.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e){
            System.out.println("Smth went wrong!");
        }

    }
}
