package competitors;
import competitors.*;
public class Team {
    private Competitor[] competitors;

    public Competitor[] getCompetitors() {
        return this.competitors;
    }

    public Team(Competitor...competitors) {
        this.competitors = competitors;
    }

    public void showResults() {
        for (Competitor competitor: competitors) {
            competitor.info();
        }
    }
}
