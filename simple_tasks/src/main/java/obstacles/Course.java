package obstacles;

import competitors.*;


public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle...obstacles) {
        this.obstacles = obstacles;
    }

    public void doit(Team team) {
        for (Competitor competitor : team.getCompetitors()) {
            for (Obstacle obstacle: this.obstacles) {
                obstacle.doIt(competitor);
            }
        }

    }
}
