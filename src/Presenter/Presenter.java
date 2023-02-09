package Presenter;
import Models.Model;
import Models.Note;
import Models.Saver;
import Viewer.View;

import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Presenter {
    private View view = new View();
    private Model model = new Model();
    private  Saver saver = new Saver();
    public void start(){

        String ui;
        String [] res;
        // check for 6 entries
        while (true) {
            try {
                ui = view.userInput();
                res = ui.split(" ");
                System.out.println(Arrays.toString(res));
                if (!model.checkAmount(res)) throw new RuntimeException();
                ;
                System.out.println("Количество данных ок");

                // check name
                String name = model.fio(res);
                if (name == null) throw new RuntimeException();
                System.out.println("Имя ок");

                // check date
                String date = res[3];
                if (!model.checkDate(date)) {
                    System.out.println("Неверный формат даты, вводите корректно дд.мм.гггг");
                    throw new RuntimeException();
                }
                System.out.println("Дата рожд. ок");

                // check phone
                String phone = res[4];
                if (!model.checkPhone(phone)) {
                    System.out.println("Неверный формат тел.номера");
                    throw new RuntimeException();
                }
                System.out.println("Телефон ок");

                // Check gender
                String gend = res[5];
                if (!model.checkGender(gend)) {
                    System.out.println("Неверный формат пола, вводите корректно м или ж");
                    throw new RuntimeException();
                }
                System.out.println("Пол ок");
                System.out.println("Все проверки пройдены");
                Note note = new Note(name, date, phone, gend);
                saver.save(name, date, phone, gend);
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
