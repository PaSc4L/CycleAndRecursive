
public class Main {
    public static void main(String[] args) {

        //printNumbersCycle(1,50);
        //printNumbersRecursive(1,50);
        System.out.println("The sum is: "+ sumCycle(3));
        System.out.println("The sum is: "+ sumRecursive(3));

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
}