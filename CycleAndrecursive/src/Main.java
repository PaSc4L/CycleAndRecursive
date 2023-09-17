import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //printNumbersCycle(1,50);
        //printNumbersRecursive(1,50);
        //System.out.println("The sum is: "+ sumCycle(3));
        //System.out.println("The sum is: "+ sumRecursive(3));
        //fibonacciNumbersCycle(6);
        //fibonacciNumbersRecursive(6);
        //int[] array = {1,4,2,64,25,4444,2,111};
        //printArrayCycle(array);
        //printArrayRecursive(array);
        //System.out.println("The number is "+ digitCounterCycle(3321) + " digit(s) long.");
        //System.out.println("The number is "+ digitCounterRecursive(3321) + " digit(s) long.");
        //System.out.println("The sum of the number's digitsis: " + digitSumcycle(2301));
        //System.out.println("The sum of the number's digitsis: " + digitSumRecursive(2301));
        //System.out.println("The factorial for the number is: " + factorialCycle(5));
        //System.out.println("The factorial for the number is: " + factorialRecursive(5));
        //System.out.println("The result is: " + powerCycle(2,4));
        //System.out.println("The result is: " + powerRecursive(2,4));
        System.out.println("The reversed text is: " + reverseStringCycle("text"));
        System.out.println("The reversed text is: " + reverseStringRecursive("text"));

    }

    /**
     * print numbers cycle
     * @param first number (from when to start the count)
     * @param second number (what is the last counted number
     */
    public static void printNumbersCycle(int first, int second){
        for(int i = first; i<=second; i++){ //for loop going trough the numbers
            System.out.println(i);  //printing the numbers out
        }
    }

    /**
     * print numbers recursive
     * @param first number (from when to start the count)
     * @param second number (what is the last counted number
     */
    public static void printNumbersRecursive(int first, int second){
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
    public static int sumCycle(int number){
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
    public static int sumRecursive(Integer number){
        int sum = 0;    //Initializing sum
        if(number != 0){    //check if number is not zero
            sum += number + sumRecursive(number-1); //if not zero add it to sum, and call the function with a decreased number (we already added the number so we need to add the one below it)
        }
        return sum; //return sum
    }

    /**
     * fibonacci numbers cycle
     * @param number  tells how many fibonacci numbers we want to print out
     */
    public static void fibonacciNumbersCycle(int number){
        int i = 2;  //the first two fibonacci numbers are 1's
        int[] fibonacciNumbers = new int[number+1]; //the size is larger than the number since we aute set the 0th element
        fibonacciNumbers[0]=0;  //0th element is 0

        if(number<0){   //checking if value is correct
            System.out.println("Incorrect value: " + number);
            return; //return if it is incorrect
        }else if(number>=1){    //else setting the first element to one
            fibonacciNumbers[1]=1;
        }
        while(i <=number){
            fibonacciNumbers[i] = fibonacciNumbers[i-2] + fibonacciNumbers[i-1];    //counting the current fibonacci number
            i++; //increment i to go to count the next element until we reach number
        }
        for(int j = 1; j<number+1; j++){    //printing out result
            System.out.println(j+". Fibonacci number is: " + fibonacciNumbers[j]);
        }

    }

    /**
     * fibonacci recursive
     * @param  number tells how many fibonacci numbers we want to print out
     */
    public static void fibonacciNumbersRecursive(int number){
        if(number<0){   //checking if value is correct
            System.out.println("Incorrect value: " + number);
            return; //return if it is incorrect
        }
        int number1 = 1;    //first fibonacci number
        int number0 = 0;    //0th fibonacci number
        int counter = 1;    //counter that will count which fibonacci number we are printing out
        fibonacciNumbersRecursive(number, number0, number1, counter);   //call the functions with more parameters

    }

    /**
     * fibonacci recursive
     * @param number tells how many fibonacci numbers we want to print out
     *
     * @param number0 and
     * @param number1 added together will be the next fibonacci number's value
     *
     * @param counter is counting which fibonacci number we are counting (needed for printing out the result)
     */
    public static void fibonacciNumbersRecursive(int number, int number0, int number1, int counter){    //overloaded function to pass more values

        int fibonacciNumber;
        if(number-1 > 0) {  //decrementing by 1 the number (without it we will print one more value out unnecesarry)
            fibonacciNumber = number1 + number0;    //getting the current fibonacci number
            if(number0 == 0){   //printing out first and second element
                System.out.println(counter + ". Fibonacci number is: " + number1);
                counter++;
                System.out.println(counter + ". Fibonacci number is: " + fibonacciNumber);
                counter++;
            }else{
                System.out.println(counter + ". Fibonacci number is: " + fibonacciNumber);  //print out current element
                counter++;
            }
            number0 = number1;  //giving the number1's value to the number so when we call the function again, we have the next two values added together
            number1 = fibonacciNumber;  //setting number1 to the new fibonacci number

            fibonacciNumbersRecursive(number-1, number0, number1, counter); //calculate the next fibonacci value
        }
    }

    /**
     * print array cicle
     * @param numbers array of numbers to print out
     */
    public static void printArrayCycle(int[] numbers){
        for(int i = 0; i<numbers.length; i++){
            System.out.println("The array's "+ (i+1) + ". value is: " + numbers[i]);
        }
    }

    /**
     * print array recursive
     * @param numbers array of numbers to print out
     */
    public static void printArrayRecursive(int[] numbers){
        printArrayRecursive(numbers,1); //calling the function with counter parameter
    }
    /**
     * print array recursive
     * @param numbers array of numbers to print out
     * @param counter counts which number is printed
     */
    public static void printArrayRecursive(int[] numbers, int counter){
        if(numbers.length != 0){
            System.out.println("The array's "+ counter + ". value is: " + numbers[0]);
            counter++;
            printArrayRecursive(Arrays.copyOfRange(numbers,1, numbers.length),counter); // recursive call (only the array without the first number will be passed, so the array's length is smaller by every call)
        }
    }

    /**
     * digit counter cycle
     * @param number the number whose digits will be counted
     * @return the number of digits the number has
     */
    public static int digitCounterCycle(int number){
        int counter = 0;
        do{
            number /= 10;   //decrementing the digits
            counter++;  //counting the digit
        }while(number != 0);    //if number is not zero count than there is still more diits to count
        return counter;
    }

    /**
     * digit counter recursive
     * @param number the number whose digits will be counted
     * @return the number of digits the number has
     */
    public static int digitCounterRecursive(int number){
        int counter = 0;
        return digitCounterRecursive(number, counter);
    }
    /**
     * digit counter recursive
     * @param number the number whose digits will be counted
     * @param counter counts how many digits the number has
     * @return the number of digits the number has
     */
    public static int digitCounterRecursive(int number, int counter){

        if(number != 0){
            number /= 10;
            counter++;  //counting number's digit
            counter = digitCounterRecursive(number, counter);   //storing the counter's value from the called function
        }
        return counter;
    }

    /**
     * digit sum cycle
     * @param number
     * @return number's digits added together
     */
    public static int digitSumcycle(int number){
        int remainder = 0;
        do{
            remainder += (number%10);   //add the last digit of the number
            number /= 10;   //decrease the number by one digit
        }while(number != 0);
        return remainder;
    }

    /**
     * digit sum recursive
     * @param number
     * @return number's digits added together
     */
    public static int digitSumRecursive(int number){
        int sum = 0;
        if(number != 0){    //check if number has no more digits
            sum = (number%10);  //add digit to sum
            number /= 10;   //decrease the number by one digit
            sum += digitSumRecursive(number);   //recursive call on the remaining number
        }
        return sum;
    }

    /**
     * factorial cycle
     * @param number
     * @return number's factorial
     */
    public static int factorialCycle(int number){
        int factorial = 1;
        for(int i =1; i<=number; i++){  //counting factorial
            factorial = factorial*i;
        }
        return factorial;
    }

    /**
     * factorial recursive
     * @param number
     * @return number's factorial
     */
    public static int factorialRecursive(int number){
        int factorial = 1;
        if(number!=0){
            factorial = number * factorialRecursive(number-1); //counting factorial and call the function again with decreased number
        }
        return factorial;
    }

    /**
     * power cycle
     * @param number
     * @param power
     * @return the nummber on the power
     */
    public static int powerCycle(int number, int power){
        int result = 1;
        for(int i=0; i<power; i++){ //counting the result with cycle
            result = result*number;
        }
        return result;
    }

    /**
     * power recursive
     * @param number
     * @param power
     * @return the nummber on the power
     */
    public static int powerRecursive(int number, int power){
        int result = 1;
        if(power != 0) {    //multiplicating until power is zero
            result = number*powerRecursive(number,power-1);
        }else{
            return 1;
        }
        return result;
    }

    public static String reverseStringCycle(String text){
        StringBuilder reversed = new StringBuilder();
        for(int i = text.length()-1;i>=0; i--){
            reversed.append(text.charAt(i));
        }
        return reversed.toString();
    }

    public static String reverseStringRecursive(String text){
        String reversed = "";
        return reverseStringRecursive(text, reversed);
    }
    public static String reverseStringRecursive(String text, String reversed){

        if(text.length()!=0){
            reversed += reverseStringRecursive(text.substring(1), reversed);
            reversed += text.charAt(0);
        }
        return reversed;
    }
}