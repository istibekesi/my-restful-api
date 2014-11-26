package myrest;

import model.Assistant;
import model.Manager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import static java.util.Arrays.asList;

@ComponentScan
@EnableAutoConfiguration
public class MyRestfulApp {

    public static InMemoryModelRepository repo;

    public static void main(String[] args) {

        initManagers();

        SpringApplication.run(MyRestfulApp.class, args);
    }

    private static void initManagers() {

        repo = new InMemoryModelRepository();

        // Bayern Munich
        Assistant a1 = new Assistant(1, "Robben", "9201", "Midfielder", "Available");
        Assistant a2 = new Assistant(2, "Ribery", "9202", "Midfielder", "Available");
        Assistant a3 = new Assistant(3, "Schweinsteiger", "9203", "Midfielder", "Injured");
        Assistant a4 = new Assistant(4, "Neuer", "9204", "Goalkeeper", "Available");

        // Real Madrid
        Assistant a5 = new Assistant(5, "Ronaldo", "9301", "Striker", "Available");
        Assistant a6 = new Assistant(6, "Bale", "9302", "Midfielder", "Injured");
        Assistant a7 = new Assistant(7, "Di Maria", "9303", "Midfielder", "Available"); // Note: Di Maria belongs to both Real and MU at the same time

        // Manchester United
        Assistant a8 = new Assistant(8, "Rooney", "9401", "Striker", "Available");
        Assistant a9 = new Assistant(9, "Van Persie", "9402", "Striker", "Available");

        repo.addAssistants( asList(a1,a2,a3,a4,a5,a6,a7,a8,a9));

        // Managers
        repo.addManager( new Manager(1, "9200", "Pep Guardiola", "", "", true, asList(a1, a2, a3, a4)));
        repo.addManager( new Manager(2, "9300", "Carlo Ancelotti", "", "", true, asList(a5, a6, a7)));
        repo.addManager( new Manager(3, "9400", "Louis Van Gaal", "", "", true, asList(a7, a8, a9)));

    }

}
