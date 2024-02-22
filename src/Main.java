import java.lang.invoke.SwitchPoint;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== JAVA DEVELOPER JOB SITE =====");
        Scanner sc = new Scanner(System.in);
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();
        String name;
        String surname;
        int index = 0;

        while (true) {
            System.out.println("===== CHOOSE ROLE =====");
            System.out.println("1.Admin");
            System.out.println("2.Client");
            System.out.print("Choice: ");
            String choice = sc.next();

            switch (choice) {
                case "1":
                    index = 1;
                    System.out.println("===== NAME SURNAME =====");
                    name = sc.next();
                    surname = sc.next();
                    Admin adm = new Admin();
                    adm.admins(name, surname);
                    System.out.println("========================");
                    System.out.println("\n");

                    break;
                case "2":
                    index = 2;
                    System.out.println("===== NAME SURNAME =====");
                    name = sc.next();
                    surname = sc.next();
                    Client cl = new Client();
                    cl.clients(name, surname);
                    System.out.println("========================");
                    System.out.println("\n");
                    Observer obs = new Subscriber(name, surname);
                    jobSite.addObserver(obs);

                    break;
                case "3":
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            if (index == 1) {
                while (true) {
                    System.out.println("===== ADMIN MENU =====");
                    System.out.println("1.Add vacancy");
                    System.out.println("2.Remove vacancy");
                    System.out.println("3.View vacancies");
                    System.out.println("4.Back");
                    System.out.print("Choose: ");
                    String choice1 = sc.next();

                    switch (choice1) {
                        case "1":
                            sc.nextLine();
                            String addVacancy = sc.nextLine();
                            jobSite.addVacancies(addVacancy);
                            break;
                        case "2":
                            System.out.println("===== VACANCIES =====");
                            for (String vacancy : jobSite.vacancies) {
                                System.out.println(vacancy);
                            }
                            System.out.println("=====================");
                            sc.nextLine();
                            String removeVacancy = sc.nextLine();
                            jobSite.removeVacancies(removeVacancy);
                            break;
                        case "3":
                            System.out.println("===== VACANCIES =====");
                            for (String vacancy : jobSite.vacancies) {
                                System.out.println(vacancy);
                            }
                            System.out.println("=====================");
                            break;
                        case "4":
                            index = 10;
                            break;
                        default:
                            System.out.println("Error");
                    }
                    if (index == 10) {
                        break;
                    }
                }
            }
            if (index == 2) {
                while (true) {
                    System.out.println("===== CLIENT MENU =====");
                    System.out.println("1.Notification");
                    System.out.println("2.View vacancy");
                    System.out.println("3.Back");
                    System.out.print("Choose: ");
                    String choice1 = sc.next();

                    switch (choice1) {
                        case "1":
                            jobSite.notifyObservers();
                            break;
                        case "2":
                            System.out.println("===== VACANCIES =====");
                            for (String vacancy : jobSite.vacancies) {
                                System.out.println(vacancy);
                            }
                            System.out.println("=====================");
                            sc.nextLine();
                            String removeVacancy = sc.nextLine();
                            jobSite.removeVacancies(removeVacancy);
                            break;
                        case "3":
                            index = 10;
                            break;
                        default:
                            System.out.println("Error");
                    }
                    if (index == 10) {
                        break;
                    }
                }
            }
        }
    }
}