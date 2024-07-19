package Main;

import View.Banana_View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //giao diện người dùng phù hợp theo hệ điều hành
            new Banana_View();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}