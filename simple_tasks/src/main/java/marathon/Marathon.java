package marathon;
import obstacles.*;
import competitors.*;

public class Marathon {
    public static void main(String[] args) {
        Team team = new Team(new Human("Petr"), new Cat("Barsik"), new Dog("Polkan"));
        Course course = new Course(new Wall(30), new Cross(100), new Water(3));
        course.doit(team);
        team.showResults();
    }
}
