import java.util.List;

public class Subscriber implements Observer{
    String name;
    String surname;

    public Subscriber(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public void handleEvent(String vacancies){
        System.out.println("Dear " + name + " " + surname + "\nWe have some changes in vacancies:\n" + vacancies);;
        System.out.println("=============================================");
    }

}
