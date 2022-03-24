package league.stats;

import java.util.Objects;

public class Match {
    private String home_name,visitor_name;
    private int visitor_goals,home_goals;

    public Match(String home_name, int home_goals,String visitor_name, int visitor_goals ) {
        this.home_name = home_name;
        this.visitor_name = visitor_name;
        this.visitor_goals = visitor_goals;
        this.home_goals = home_goals;
    }
    public Match(){}

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public int getVisitor_goals() {
        return visitor_goals;
    }

    public void setVisitor_goals(int visitor_goals) {
        this.visitor_goals = visitor_goals;
    }

    public int getHome_goals() {
        return home_goals;
    }

    public void setHome_goals(int home_goals) {
        this.home_goals = home_goals;
    }

    @Override
    public String toString() {
        return  home_name  + " "+home_goals +
                " - "+ visitor_goals +" "+ visitor_name ;
    }
}
