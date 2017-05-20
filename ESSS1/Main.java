package ESSS1;

public class Main {

    public static void main(String[] args) {
        Integer X, Y;
        if (validations(args)) {
            X = Integer.valueOf(args[0]);
            Y = Integer.valueOf(args[1]);

            for (int i = X; i <= Y; i++) {
                String value = Integer.toString(i);
                if (i % 3 == 0 && i % 5 == 0) {
                    value = "FizzBuzz";
                } else if (i % 3 == 0) {
                    value = "Fizz";
                } else if (i % 5 == 0) {
                    value = "Buzz";
                }
                System.out.println(value);
            }
        }
    }

    public static boolean validations(String[] args){
        if(args.length == 2){
            Integer X = Integer.valueOf(args[0]);
            Integer Y = Integer.valueOf(args[1]);
            if( X>=1 && X <= 2000) {
                if( Y>=1 && Y <= 2000) {
                    if( Y > X) {
                        return true;
                    }
                    else{
                        System.out.println("An error has occurred");
                        System.out.println("The Y value should be greater than y");
                    }
                }
                else{
                    System.out.println("An error has occurred");
                    System.out.println("The Y value should be between 1 and 2000");
                }
            }
            else{
                System.out.println("An error has occurred");
                System.out.println("The X value should be between 1 and 2000");
            }
        }
        else{
            System.out.println("An error has occurred");
            System.out.println("Please enter two numbers as arguments");
        }
        System.exit(1);
        return false;
    }
}
