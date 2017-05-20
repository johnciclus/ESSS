package ESSS3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

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
        PrintWriter out;
        StringBuilder sb;
        Random Random = new Random();

        int minRows = 100;
        int minCols = 80;
        char[][] data;
        int rand;
        int col;
        int row;


        try{
            out = new PrintWriter("sample.txt");

            for(int log=1; log<100; log++) {
                row = Random.nextInt(50);
                col = Random.nextInt(50);
                data = new char[minCols + col][minRows + row];

                for (int i = 0; i < minCols + col; i++) {
                    rand = Random.nextInt(minRows + row + 1);
                    for (int j = 0; j < minRows + row; j++) {
                        if (j == rand)
                            data[i][j] = '*';
                        else
                            data[i][j] = '.';
                    }
                }

                for (int j = 0; j < minRows + row; j++) {
                    sb = new StringBuilder();
                    for (int i = 0; i < minCols + col; i++) {
                        sb.append(data[i][j]);
                    }
                    out.println(sb.toString());
                }
                out.println();
            }

            out.close ();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found exception");
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
