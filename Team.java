package league.stats;

import java.util.Objects;

public class Team implements Comparable<Team>{
    private String team_name;
    private int points;

    public Team(String team_name) {
        this.team_name = team_name;
        points=0;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return  team_name + ';' +
                 points ;
    }

    @Override
    public boolean equals(Object o) {
        Team f=(Team)o;
        return this.getTeam_name().equals(f.getTeam_name());
    }

    @Override
    public int hashCode() {
        int hash=5;
        hash=23*hash+Objects.hashCode(this.getTeam_name());
        return hash;
    }

    @Override
    public int compareTo(Team o) {
       return Integer.compare(o.getPoints(),this.getPoints());
    }
}
