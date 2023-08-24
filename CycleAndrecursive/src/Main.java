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
        //System.out.println("The number is "+ digitCounterCycle(3321) + " digit(s) long.");
        //System.out.println("The number is "+ digitCounterRecursive(3321) + " digit(s) long.");
        //System.out.println("The sum of the number's digitsis: " + digitSumcycle(2301));
        //System.out.println("The sum of the number's digitsis: " + digitSumRecursive(2301));
        System.out.println("The factorial for the number is: " + factorialCycle(5));
        System.out.println("The factorial for the number is: " + factorialRecursive(5));

    }

    /**
     * print numbers cycle
     * @param first number (from when to start the count)
     * @param second number (what is the last counted number
     */
    public static void printNumbersCycle(Integer first, Integer second){
        for(int i = first; i<=second; i++){ //for loop going trough the numbers
            System.out.println(i);  //printing the numbers out
        }
    }
    /**
     * print numbers recursive
     * @param first number (from when to start the count)
     * @param second number (what is the last counted number
     */
    public static void printNumbersRecursive(Integer first, Integer second){
        System.out.println(first);  //printing the first element
        first++;    //incrementing the first element
        if(first <= second){    //checking if it is out of bounds
            printNumbersRecursive(first, second);   //if not, call the function again with the new first value
        }
    }

    /**
     * Sum cycle
     * @param number a number that will be the last in the sum
     * @return every number added until number
     */
    public static Integer sumCycle(Integer number){
        Integer sum = 0;    //initializing the sum
        for(int i = 0; i<=number; i++){ //for loop until we reach the last number
            sum += i;   //add to sum the current number
        }
        return sum; //return the sum
    }
    /**
     * Sum recursive
     * @param number a number that will be the last in the sum
     * @return every number added until number
     */
    public static Integer sumRecursive(Integer number){
        Integer sum = 0;    //Initializing sum
        if(number != 0){    //check if number is not zero
            sum += number + sumRecursive(number-1); //if not zero add it to sum, and call the function with a decreased number (we already added the number so we need to add the one below it)
        }
        return sum; //return sum
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

    public static Integer digitSumcycle(Integer number){
        Integer remainder = 0;
        do{
            remainder += (number%10);
            number /= 10;
        }while(number != 0);
        return remainder;
    }
    public static Integer digitSumRecursive(Integer number){
        Integer sum = 0;
        if(number != 0){
            sum = (number%10);
            number /= 10;
            sum += digitSumRecursive(number);
        }
        return sum;
    }
    public static Integer factorialCycle(Integer number){
        Integer factorial = 1;
        for(int i =1; i<=number; i++){
            factorial = factorial*i;
        }
        return factorial;
    }
    public static Integer factorialRecursive(Integer number){
        Integer factorial = 1;
        if(number!=0){
            factorial = number * factorialRecursive(number-1);
        }
        return factorial;
    }
}