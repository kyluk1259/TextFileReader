/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfilereader;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author kyluk1259
 */
public class TextFileReader {

    public static String studentName, studentFile;
    public static boolean option = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        input();
        try{
        BufferedReader readStudent = new BufferedReader(new FileReader(studentFile(studentName)));
        }catch(FileNotFoundException ex){
            System.out.println(studentFile);
            System.out.println("This student does not exist. Please input an existing student name.");
        }
    }

    public static void input() {
        studentName = JOptionPane.showInputDialog("Please input the name of your student.");
        check();
    }

    public static void check() {
        for (char val : studentName.toCharArray()) {
            if (!Character.isAlphabetic(val) && !Character.isSpaceChar(val)) {
                input();
            } else {
            }
        }
    }

    public static String studentFile(String studentName) {
        for(int i = 0; i < studentName.length(); i++){
            if(Character.isWhitespace(studentName.charAt(i))){
                char a = studentName.charAt(i+1);
                a = Character.toUpperCase(a);
                studentName.replace(studentName.charAt(i+1) , a);
            }
        }
        char a = studentName.charAt(0);
        a = Character.toUpperCase(a);
        studentName.replace(studentName.charAt(1) , a);
        studentName = studentName.replaceAll(" ", "");
        studentFile = "/Students/" + studentName + ".txt";
        return studentFile;
    }

}
