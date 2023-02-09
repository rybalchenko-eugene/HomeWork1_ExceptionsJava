package Models;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    public boolean checkAmount(String [] res){
        if (res.length == 6) return true;
        else {
            System.out.println("Неверный ввод количества данных, вводите: " +
                    "Фамилия Имя Отчество датарождения(дд.мм.гггг) номертелефона пол");
            return false;
        }
    }

    public String fio(String [] res){
        if (checkName(res[0]) && checkName(res[1]) && checkName(res[2])){
            return res[0] + " " + res[2] + " " + res[2];
        }
        System.out.println("Неправильно введено ФИО");
        return null;
    }

    public boolean checkName(String name){
        if (name.length() < 2 || name.length() > 20) return  false;
        for(char c : name.toCharArray())
            if(Character.isDigit(c)){
                System.out.println("Ошибка ввода: числа в ФИО");
                return  false;}
        return true;
    }
    public boolean checkDate(String res) throws NumberFormatException{

        String[] birth_array = res.split("\\.");
        System.out.println(Arrays.toString(birth_array));
        if (birth_array.length != 3) return false;
        // исключение NumberFormatException
        try {
            int day = Integer.parseInt(birth_array[0]);
            int month = Integer.parseInt(birth_array[1]);
            int year = Integer.parseInt(birth_array[2]);
            if (1 > day || day > 31) {
                System.out.println("Ошибка ввода: некорректное число");
                return false;
            }
            if (1 > month || month > 12) {
                System.out.println("Ошибка ввода: некорректный месяц");
                return false;
            }
            if (month == 2 && day > 29) {
                System.out.println("Ошибка ввода: некорректное число");
                return false;
            }
            if (year < 1900 || year > 2022) {
                System.out.println("Ошибка в дате - год, некорректно");
                return false;
            }
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("Ошибка в формате дат, введены дргуие символы");
            return false;
        }
    }
    public boolean checkPhone (String res){
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(res);
        if (matcher.matches()) return true;
        else if (res.length() == 11 && res.charAt(0) == '8') return true;
        else return false;
    }
    public boolean checkGender (String res){
        return res.equals("м") || res.equals("муж") || res.equals("ж") || res.equals("жен");
    }
}


