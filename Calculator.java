import java.util.Scanner;

class Calculator{
  public static void main(String[] args) {
    char operator;
    int number1, number2, result;
    Scanner input = new Scanner(System.in);
    System.out.println("Choose an operator: +, -, *, or /");
    operator = input.next().charAt(0);
    System.out.println("Enter first number");
    number1 = input.nextInt();
    System.out.println("Enter second number");
    number2 = input.nextInt();    
    switch (operator) {  
      case '+':
        result = number1 + number2;
        System.out.println(number1 + " + " + number2 + " = " + result);
        break;
        
      case '-':
        result = number1 - number2;
        System.out.println(number1 + " - " + number2 + " = " + result);
        break;
        
      case '*':
        result = number1 * number2;
        System.out.println(number1 + " * " + number2 + " = " + result);
        break;

      case '/':
      
        
      try{
        result = number1 / number2;
       System.out.println(number1 + " / " + number2 + " = " +result);
       
        }
        catch(ArithmeticException e){
        System.out.println("Divided by zero operation cannot possible");
        }
        break;
      default:
        System.out.println("Invalid operator!");
        break;
    }
    input.close();
  }
}


