package ESSS2;

public class Main {

    public static void main(String[] args) {
        Integer value;
        if (validations(args)) {
            value = Integer.valueOf(args[0]);

            System.out.println(value);

        }
    }

    public static boolean validations(String[] args){
        if(args.length == 1){
            Integer value = Integer.valueOf(args[0]);
            if(value >= 1000 && value <= 1000000000 ){
                return true;
            }
            else{
                System.out.println("An error has occurred");
                System.out.println("The value value should be between 10^3 and 10^9");
            }
        }
        else{
            System.out.println("An error has occurred");
            System.out.println("Please enter a number as argument");
        }
        System.exit(1);
        return false;
    }
}
