package Models;
import java.io.*;
import java.util.Locale;

public class Saver  {
    public Saver()  {
    }
    public void save(String name, String date, String phone, String gend) {

        String [] temp_name = name.split(" ");
        String filename = temp_name[0].toLowerCase() + ".txt";
        try (FileWriter writer = new FileWriter(filename, true))
        {
            // запись всей строки

            String text = name + ";" + date + ";" + phone + ";" + gend + "\n";
            System.out.println(text);
            writer.write(text);
            writer.flush();
            System.out.println("Сохранение успешно выполнено");
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
//    public void load(){
//        try {
//            FileReader reader = new FileReader("notes3.txt");
//        }
//        catch(IOException ex){
//            System.out.println(ex.getMessage());
//            System.out.println("Файл записей не найден");
//        }
//    }


}


