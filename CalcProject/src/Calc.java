import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calc {

    public static double calcFunc(String input[]){
        double a = 0, b = 0;
        double res = 0;
        try{
            a = Double.parseDouble(input[0]); b = Double.parseDouble(input[2]);
        }
        catch (Exception e){
            System.out.println("Error! Not number");
            System.exit(0);
        }
        switch(input[1]){
            case "+": res = a+b; break;
            case "-": res = a-b; break;
            case "*": res = a*b; break;
            case "/":
                if (b==0){
                    System.out.println("Error! Division by zero");
                    System.exit(0);
                }
                else{
                    res = a/b; break;
                }
                break;
            default: System.out.println("Operation Error!"); System.exit(0);
        }
        return res;
    }
    public static void main(String[] args) {
        try {
            File fileObj = new File("test.txt");
            Scanner reader = new Scanner(fileObj);
            while (reader.hasNextLine()){
                String input[] = reader.nextLine().split(" ");
                System.out.println(Calc.calcFunc(input));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
