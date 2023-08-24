import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //printNumbersCycle(1,50);
        //printNumbersRecursive(1,50);
        //System.out.println("The sum is: "+ sumCycle(3));
        //System.out.println("The sum is: "+ sumRecursive(3));
        //fibonacciNumbersCycle(6);
        //fibonacciNumbersRecursive(6);
        //Integer[] array = {1,4,2,64,25,4444,2,111};
        //printArrayCycle(array);
        //printArrayRecursive(array);
        System.out.println("The number is "+ digitCounterCycle(3321) + " digit(s) long.");
        System.out.println("The number is "+ digitCounterRecursive(3321) + " digit(s) long.");


    }

    public static void printNumbersCycle(Integer first, Integer second){
        for(int i = first; i<=second; i++){
            System.out.println(i);
        }
    }
    public static void printNumbersRecursive(Integer first, Integer second){
        System.out.println(first);
        first++;
        if(first <= second){
            printNumbersRecursive(first, second);
        }
    }
    public static Integer sumCycle(Integer number){
        Integer sum = 0;
        for(int i = 0; i<=number; i++){
            sum += i;
        }
        return sum;
    }
    public static Integer sumRecursive(Integer number){
        Integer sum = 0;
        if(number != 0){
            sum += number + sumRecursive(number-1);
        }
        return sum;
    }
    public static void fibonacciNumbersCycle(Integer number){
        Integer i = 2;
        Integer[] fibonacciNumbers = new Integer[number+1];

        fibonacciNumbers[0]=0;
        if(number<0){
            System.out.println("Incorrect value: " + number);
            return;
        }else if(number>=1){
            fibonacciNumbers[1]=1;
        }
        while(i <=number){
            fibonacciNumbers[i] = fibonacciNumbers[i-2] + fibonacciNumbers[i-1];
            i ++;
        }
        for(int j = 1; j<number+1; j++){
            System.out.println(j+". Fibonacci number is: " + fibonacciNumbers[j]);
        }

    }
    public static void fibonacciNumbersRecursive(Integer number){
        Integer number1 = 1;
        Integer number0 = 0;
        Integer counter = 1;
        fibonacciNumbersRecursive(number, number0, number1, counter);

    }
    public static void fibonacciNumbersRecursive(Integer number, Integer number0, Integer number1, Integer counter){

        Integer fibonacciNumber;
        if(number-1 > 0) {
            fibonacciNumber = number1 + number0;
            if(number0 == 0){
                System.out.println(counter + ". Fibonacci number is: " + number1);
                counter++;
                System.out.println(counter + ". Fibonacci number is: " + fibonacciNumber);
                counter++;
            }else{
                System.out.println(counter + ". Fibonacci number is: " + fibonacciNumber);
                counter++;
            }
            number0 = number1;
            number1 = fibonacciNumber;

            fibonacciNumbersRecursive(number-1, number0, number1, counter);
        }
    }

    public static void printArrayCycle(Integer[] numbers){
        for(int i = 0; i<numbers.length; i++){
            System.out.println("The array's "+ (i+1) + ". value is: " + numbers[i]);
        }
    }
    public static void printArrayRecursive(Integer[] numbers){
        printArrayRecursive(numbers,1);
    }
    public static void printArrayRecursive(Integer[] numbers, Integer counter){
        if(numbers.length != 0){
            System.out.println("The array's "+ counter + ". value is: " + numbers[0]);
            counter++;
            printArrayRecursive(Arrays.copyOfRange(numbers,1, numbers.length),counter);
        }
    }

    public static Integer digitCounterCycle(Integer number){
        Integer counter = 0;
        do{
            number /= 10;
            counter++;
        }while(number != 0);
        return counter;
    }
    public static Integer digitCounterRecursive(Integer number){
        Integer counter = 0;
        return digitCounterRecursive(number, counter);
    }
    public static Integer digitCounterRecursive(Integer number, Integer counter){

        if(number != 0){
            number /= 10;
            counter++;
            counter = digitCounterRecursive(number, counter);
        }
        return counter;
    }
    public static void digitSumcycle(Integer number){

    }
    public static void digitSumRecursive(Integer number){

    }
    public static void realNumberCycle(Integer number){

    }
    public static void realNumberRecursive(Integer number){

    }
}