package ESSS4;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#0.000");
        double value;
        if (validations(args)) {
            value = Double.valueOf(args[0]);

            double S=0, M=0, E=value;
            double p = 0.00001;

            while((E-S)>p) {
                M = (E+S)/2;
                if ( (M * M) > value) {
                    E = M;
                } else {
                    S = M;
                }
            }

            System.out.println(formatter.format(M));

        }
    }

    public static boolean validations(String[] args){
        if(args.length == 1){
            Double value = Double.valueOf(args[0]);
            if(value >= 0 ){
                return true;
            }
            else{
                System.out.println("An error has occurred");
                System.out.println("The value value should be between 0");
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
