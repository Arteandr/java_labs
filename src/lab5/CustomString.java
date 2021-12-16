package lab5;

import lab6.CustomException;

import java.util.Arrays;
import java.util.Scanner;

public class CustomString {
    Scanner scanner;
    public CustomString() {
        this.scanner = new Scanner(System.in);
    }

    public void Start() {
        try {
            this.Input();
        } catch (CustomException e){
            System.out.println(e);
            this.Start();
        }
    }

    public void Input() throws CustomException {
        String str = "";
        System.out.println("Введите исходную строку: ");
        str = this.scanner.nextLine();
        if(str.split(" ").length < 2 || !this.IsValid(str.trim()))
            throw new CustomException("Количество слов должно быть больше двух!");

        str = this.Sort(str);
        System.out.println("Выходная строка: ");
        System.out.println(str);
    }

    public boolean IsValid(String str) {
        boolean state = true;
        if(str.length() <= 0)
            return false;
        for(int i = 0; i < str.split(" ").length; i++) {
            String el = str.split(" ")[i];
            if(el.isEmpty())
                state = false;
        }

        return state;
    }

    public String Sort(String str) {
        String[] arr = str.split(" ");
        Arrays.sort(arr);
        return String.join(" ",arr);
    }
}
