package ESSS3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        Scanner file;

        if (validations(args)) {
            String path = new File(args[0]).getAbsolutePath();
            //String path = Thread.currentThread().getContextClassLoader().getResource("resources/sample1.txt").getPath();

            try {
                file = new Scanner(new File(path));

                while(file.hasNext()){
                    line = file.nextLine();
                    if(line.length() == 0){
                        printMatrix(processingMatrix(lines));
                        lines = new ArrayList<String>();
                    }else{
                        lines.add(line);
                    }
                }
                printMatrix(processingMatrix(lines));
            }
            catch (FileNotFoundException e){
                System.out.println("File not found exception");
            }
        }
    }

    public static ArrayList<String> processingMatrix(ArrayList<String> lines){
        StringBuilder sb;
        char[][] cols;
        int[] heights;
        char c;
        int width = lines.get(0).length();
        int height = lines.size();

        //System.out.println(width);
        //System.out.println(height);

        cols = new char[width][height];
        heights = new int[width];

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++) {
                c = lines.get(height-i-1).charAt(j);
                if(c == '*')
                    heights[j] = i;
                cols[j][i] = c;
            }
        }

        Arrays.sort(heights);

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++) {
                if(j == heights[i])
                    cols[i][j] = '*';
                else
                    cols[i][j] = '.';
            }
        }

        for(int j=0; j<height; j++) {
            sb = new StringBuilder();
            for(int i=0; i<width; i++) {
                sb.append(cols[i][height-j-1]);
            }
            lines.set(j, sb.toString());
        }

        return lines;
    }

    public static void printMatrix(ArrayList<String> matrix){
        for(int i=0; i<matrix.size(); i++){
            System.out.println(matrix.get(i));
        }
        System.out.println();
    }

    public static void generateFile(){
        int minRows = 100;
        int minCols = 80;

        for(int i=0; i<minRows; i++){

        }

        System.out.println();
    }

    public static boolean validations(String[] args){
        if(args.length == 1){
                return true;
        }
        else{
            System.out.println("An error has occurred");
            System.out.println("Please enter a filename as argument");
        }
        System.exit(1);
        return false;
    }
}
