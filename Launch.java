package Main;

import java.io.*;

public class Launch {

    private File file;
    private int matrix[][];

    public void start(){

        String filePath = "matrix.csv";
        file = new File(filePath);

        try {
            transposition(readFile(file).split("\n"));

            System.out.println("Исходная матрица:");
            printMatrix(matrix);

            matrix = transposeMatrix(matrix);
            System.out.println("Выходная матрица:");
            printMatrix(matrix);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void transposition(String[] str){

        matrix = new int[str.length][str.length];

        for (int i = 0; i < str.length; i++){
            String[] sl = str[i].split(" ");
            for (int j = 0; j < sl.length; j++)
                matrix[i][j] = Integer.parseInt(sl[j]);
        }

    }

    private void printMatrix(int m[][]){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] transposeMatrix(int[][] m){
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    /**
     * Метод читает текст из файла построчно
     * @param txtfile файл, который будет прочитан
     * @return текст из файла
     * @throws IOException
     */
    private String readFile(File txtfile) throws IOException{
        String textFile = "";
        BufferedReader reader =new BufferedReader(new FileReader(txtfile));
        textFile = "";
        String line;
        while((line = reader.readLine()) != null){
            textFile += line + "\n";
        }
        reader.close();
        return textFile;
    }
}
