import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text

        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter the first no : ");
        int num1=scanner.nextInt();
        System.out.print("Enter the second no : ");
        int num2=scanner.nextInt();

        int result=num1+num2;
        System.out.println("Sum of two numbers are "+result);

        scanner.close();
    }
}