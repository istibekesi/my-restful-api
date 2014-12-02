package myrest;

import model.v1.Assistant;
import model.v1.Manager;
import myrest.repo.InMemoryModelRepository;
import myrest.repo.InMemoryModelRepositoryV2;
import myrest.repo.InMemoryModelRepositoryV3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import static java.util.Arrays.asList;

@ComponentScan
@EnableAutoConfiguration
public class MyRestfulApp {

    public static InMemoryModelRepository repo;
    public static InMemoryModelRepositoryV2 repoV2;
    public static InMemoryModelRepositoryV3 repoV3;

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


        // *****************************************************

        repoV2 = new InMemoryModelRepositoryV2();

        // Bayern Munich
        model.v2.Assistant a1v = new model.v2.Assistant(1, "Robben", "9201", "Midfielder", "Available");
        model.v2.Assistant a2v = new model.v2.Assistant(2, "Ribery", "9202", "Midfielder", "Available");
        model.v2.Assistant a3v = new model.v2.Assistant(3, "Schweinsteiger", "9203", "Midfielder", "Injured");
        model.v2.Assistant a4v = new model.v2.Assistant(4, "Neuer", "9204", "Goalkeeper", "Available");

        // Real Madrid
        model.v2.Assistant a5v = new model.v2.Assistant(5, "Ronaldo", "9301", "Striker", "Available");
        model.v2.Assistant a6v = new model.v2.Assistant(6, "Bale", "9302", "Midfielder", "Injured");
        model.v2.Assistant a7v = new model.v2.Assistant(7, "Di Maria", "9303", "Midfielder", "Available"); // Note: Di Maria belongs to both Real and MU at the same time

        // Manchester United
        model.v2.Assistant a8v = new model.v2.Assistant(8, "Rooney", "9401", "Striker", "Available");
        model.v2.Assistant a9v = new model.v2.Assistant(9, "Van Persie", "9402", "Striker", "Available");

        repoV2.addAssistants( asList(a1v,a2v,a3v,a4v,a5v,a6v,a7v,a8v,a9v));

        // Managers
        repoV2.addManager( new model.v2.Manager(1, "9200", "Pep Guardiola", "", "", true, asList(a1v, a2v, a3v, a4v)));
        repoV2.addManager( new model.v2.Manager(2, "9300", "Carlo Ancelotti", "", "", true, asList(a5v, a6v, a7v)));
        repoV2.addManager( new model.v2.Manager(3, "9400", "Louis Van Gaal", "", "", true, asList(a7v, a8v, a9v)));

        // *****************************************************

        repoV3 = new InMemoryModelRepositoryV3();

        // Bayern Munich
        model.v3.Assistant a1w = new model.v3.Assistant(1, "Robben", "9201", "Midfielder", "Available");
        model.v3.Assistant a2w = new model.v3.Assistant(2, "Ribery", "9202", "Midfielder", "Available");
        model.v3.Assistant a3w = new model.v3.Assistant(3, "Schweinsteiger", "9203", "Midfielder", "Injured");
        model.v3.Assistant a4w = new model.v3.Assistant(4, "Neuer", "9204", "Goalkeeper", "Available");

        // Real Madrid
        model.v3.Assistant a5w = new model.v3.Assistant(5, "Ronaldo", "9301", "Striker", "Available");
        model.v3.Assistant a6w = new model.v3.Assistant(6, "Bale", "9302", "Midfielder", "Injured");
        model.v3.Assistant a7w = new model.v3.Assistant(7, "Di Maria", "9303", "Midfielder", "Available"); // Note: Di Maria belongs to both Real and MU at the same time

        // Manchester United
        model.v3.Assistant a8w = new model.v3.Assistant(8, "Rooney", "9401", "Striker", "Available");
        model.v3.Assistant a9w = new model.v3.Assistant(9, "Van Persie", "9402", "Striker", "Available");

        repoV3.addAssistants( asList(a1w,a2w,a3w,a4w,a5w,a6w,a7w,a8w,a9w));


        // Managers
        repoV3.addManager( new model.v3.Manager(1, "9200", "Pep Guardiola", "", "", true, asList(a1w, a2w, a3w, a4w)));
        repoV3.addManager( new model.v3.Manager(2, "9300", "Carlo Ancelotti", "", "", true, asList(a5w, a6w, a7w)));
        repoV3.addManager( new model.v3.Manager(3, "9400", "Louis Van Gaal", "", "", true, asList(a7w, a8w, a9w)));

    }

}
