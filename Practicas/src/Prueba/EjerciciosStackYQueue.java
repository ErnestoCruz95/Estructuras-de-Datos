package Prueba;
import Queue.Queue;
import Stacks.Stack;

/**
 * Created by AntonioRang on 10/12/17.
 */
public class EjerciciosStackYQueue {
    public static void main(String[] args) {
        System.out.println("Testing balanced symbols");
        System.out.println(checkForBalance("t = arr[3] + a) - 4"));
        System.out.println(checkForBalance("if (arr(3] < 4)"));
        System.out.println(checkForBalance("System.out.println(std.charAt(3);"));
        System.out.println(checkForBalance("while (i > 100) { sum += i; i++; }"));
        System.out.println();

        System.out.println("Testing postfix evaluation");
        System.out.println("4 3 5 * + => " + postfixEval("4 3 5 * +"));
        System.out.println("1 2 * 3  4 / - => " + postfixEval("1 2 * 3 4 / -"));
        System.out.println("1 2 * 3 * 4 * 5 * 6 * => " + postfixEval("1 2 * 3 * 4 * 5 * 6 *"));
        System.out.println("1 2 3 * 4 + 5 / + => " + postfixEval("1 2 3 * 4 + 5 / +"));
        System.out.println("2 2 * 4 1 * 3 * - 2 1 * / => " + postfixEval("2 2 * 4 1 * 3 * - 2 1 * /"));
        System.out.println("3 8 + * 9 => " + postfixEval("3 8 + * 9"));
        System.out.println("9 8 + 7 => " + postfixEval("9 8 + 7"));
        System.out.println();

        System.out.println("Testing Fibonacci sequence");
        fibonacci(20);
        System.out.println();

        System.out.println("Testing the Printer class");
        Printer printer = new Printer();
        printer.printDocument("gato.jpg");
        printer.printDocument("tarea.docx");
        printer.printDocument("meme.png");
        try {
            printer.runPrinter();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println();


    }

    public static String checkForBalance(String cod){
        Stack<Character> check = new Stack<Character>();

        int k=0;
        boolean flag = false;
        String espacios = "";
        String result = " ";

        for (int j = 0; j < cod.length(); j++) {
            if(flag){
                break;
            }

            if (cod.charAt(j) == '(' || cod.charAt(j) == '{' || cod.charAt(j) == '['){
                check.push(cod.charAt(j));
            }

            k=j;

            if(cod.charAt(j) == ']' || cod.charAt(j) == '}' || cod.charAt(j) == ')'){

                if(check.empty()){
                    result += "Missing left simbol";
                    break;
                }

                switch (cod.charAt(j)){
                    case ']':
                        if('[' != check.pop()){
                            result += "Missing left simbol";
                            flag=true;
                        }
                        break;
                    case ')':
                        if('(' != check.pop()){
                            result += "Missing left simbol";
                            flag=true;
                        }
                        break;
                    case '}':
                        if('{' != check.pop()){
                            result += "Missing left simbol";
                            flag=true;
                        }
                        break;
                    default:
                        break;
                }
            }

        }

        if(check.empty() && result == " "){
            result += "Expression is balance";
        }else if(result == " "){
            result = "Missing Right simbol";
        }

        for (int i = 0; i < k; i++) {
            espacios += " ";
        }

        return cod+ "\n" + espacios + "^" + result;


    }

    public static String postfixEval(String ecu){
        Stack<Integer> numbers = new Stack<Integer>();
        char temp;
        Integer a;
        Integer b;
        Integer result;
        Integer finResult;
        String stR = "";
        boolean flag;
        for (int i = 0; i < ecu.length(); i++) {
            temp = ecu.charAt(i);

            switch (temp){
                case '+':
                    a= numbers.pop();
                    if(numbers.empty()){
                        return "The expression has too many operators";
                    }
                    b=numbers.pop();
                    result = a+b;
                    numbers.push(result);
                    break;
                case '-':
                    a= numbers.pop();
                    if(numbers.empty()){
                        return "The expression has too many operators";
                    }
                    b=numbers.pop();
                    result = b-a;
                    numbers.push(result);
                    break;
                case '/':
                    a= numbers.pop();
                    if(numbers.empty()){
                        return "The expression has too many operators";
                    }
                    b=numbers.pop();
                    result = b/a;
                    numbers.push(result);
                    break;
                case '*':
                    a= numbers.pop();
                    if(numbers.empty()){
                        return "The expression has too many operators";
                    }
                    b=numbers.pop();
                    result = a*b;
                    numbers.push(result);

                    break;

                default:
                    if(! (ecu.charAt(i) == ' ') ) {
                        numbers.push (Integer.valueOf(Character.getNumericValue(ecu.charAt(i))));
                    }
                    break;
            }

        }
        finResult = numbers.pop();

        if(! numbers.empty()){
            return "The expression has too many operands";
        }

        stR += String.valueOf(finResult);
        return stR;
    }

    public static void fibonacci(int n){
        Queue<Integer> fibonacci = new Queue <Integer>();
        String stFibo = "";
        fibonacci.offer(1);
        fibonacci.offer(1);

        for (int i = 0; i <n ; i++) {
            Integer a = fibonacci.remove();
            Integer b = fibonacci.remove();
            stFibo += a + " ";
            Integer nextNumber = a+b;
            fibonacci.offer(b);
            fibonacci.offer(nextNumber);
        }
        System.out.println(stFibo);

    }
}
