package Model;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Banana_Model {
    private long counter = 145632;
    public int choseTheme = 0;
    //File lấy dữ liệu điểm cao nhất (System.getProperty("user.dir") : lấy địa chỉ của dự án)
    private final File highestPoint = new File(System.getProperty("user.dir") + "\\src\\Model\\highestPoint.txt");// lầy file từ src
    //private  final File highestPoint = new File(Banana_Model.class.getResource("highestPoint.txt").getFile()); //(lấy file từ class)

    //Constructor
    public Banana_Model() {
    }

    //Getter
    public long getCounter() {
        return counter;
    }

    //Method
    public void Up (){
        this.counter++;
    }

    public long getHighestPoint() {
        long res;
        try {
            Scanner scanner = new Scanner(highestPoint);
            res = scanner.nextLong();
            scanner.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  res;
    }
    public void updateHighetPoint (){
        try {
            FileWriter fileWriter = new FileWriter(highestPoint);
            fileWriter.write(counter + "");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void reset(){
        this.counter = 0;
    }
    public void resetHighestPoint(){
        try {
            FileWriter fileWriter = new FileWriter(highestPoint);
            fileWriter.write(0 + "");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
