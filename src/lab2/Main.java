package lab2;

import java.util.Scanner;

/**
 * Created by toktar.
 */
public class Main {

    public static void main(String[] args){
        MathParser parser = new MathParser();


        while(true){
            System.out.println("Input mathematical expression or 'stop'");
            Scanner in = new Scanner(System.in);
            String expression = in.nextLine();
            if (expression.contains("stop")) break;
            try{
                System.out.println(parser.Parse(expression));
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Programm has been completed");
    }
}
