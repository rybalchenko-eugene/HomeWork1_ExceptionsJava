package Viewer;

import java.util.Scanner;

public class View {


    public String userInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите одной строкой данные пользователя");
        System.out.println("Данные должны включать: ФИО, дату рождения, номер телефона, пол");
        String user_input = in.nextLine();
        return user_input;
    }
}

