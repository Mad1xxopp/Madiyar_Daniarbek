import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class JavaDeveloperJobSite implements Observed{
    DBFunctions db = new DBFunctions();
    Connection con = db.connect_to_db("postgres", "postgres", "w6Yh7OHK2lxxA");
    DBFunctions_JDJS dbj = new DBFunctions_JDJS();
    List<String> vacancies = new ArrayList<>();
    List<Observer> subscribers = new ArrayList<>();

    public void addVacancies(String vacancy){
        this.vacancies.add(vacancy);
        dbj.create_table_jdjs(con, "vacancy");
        dbj.saveVacancyToDatabase(con, "vacancy", vacancy);
        notifyObservers();
    }

    public void removeVacancies(String vacancy){
        this.vacancies.remove(vacancy);
        dbj.deleteVacancyFromDatabase(con, "vacancy", vacancy);
        notifyObservers();
    }


    public void addObserver(Observer observer){
        this.subscribers.add(observer);

    }

    public void removeObserver(Observer observer){
        this.subscribers.remove(observer);
    }

    public void notifyObservers(){
        String vacanciesString = String.join(", ", this.vacancies);

        for(Observer observer : subscribers){
            observer.handleEvent(vacanciesString);
        }
    }
}
