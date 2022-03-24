package league.main;

import league.stats.Match;
import league.stats.Team;
import java.util.*;

import static league.io.LeagueIO.loadMatches;
import static league.io.LeagueIO.saveRanking;

public class Main {
    public static void main(String[]args){
        List<Match>League1= loadMatches("matches.txt");
        ShowMatches(League1);
        Set<Team> Teams=CreateTeams(League1);
        Team[]AllTeams=ArrTeams(Teams);
        //calculate point
        Points(League1,Teams);
        //Save data
        Arrays.sort(AllTeams);
        saveRanking(AllTeams,"ranking.txt");
        //Show additional stats
        System.out.println("Total  number of Teams in the competition: "+Teams.size());
        System.out.println("Teams that have scored 4 goals or more in a match :");
        FourGoals(League1,Teams);
        System.out.println("Teams that haven't won any match :");
        ZeroPoints(Teams);
    }
    //create map
    private static Set<Team> CreateTeams(List<Match>League1){
        Set<Team> Teams=new HashSet<>();
        for (Match m:League1
        ) {
            Teams.add(new Team(m.getHome_name()));
        }
        return Teams;
    }
    //array of teams
    private static Team[] ArrTeams( Set<Team> Teams){
        Team[]AllTeams=new Team[Teams.size()];
        for (Team m:Teams
        ) {
            AllTeams=Teams.toArray(new Team[0]);
        }
        return AllTeams;
    }
    //additional stats
    private static void ZeroPoints(Set<Team> teams) {
        for (Team t:teams
             ) {
            if(t.getPoints()==0)
                System.out.println(t.getTeam_name());
        }
    }

    private static void FourGoals(List<Match> league1,Set<Team>Teams) {
        Set<Team>MaxGoals=new HashSet<>();
        for (Match m:league1)
        {
            if(m.getVisitor_goals()>=4||m.getHome_goals()>=4)
            {
                for (Team t:Teams.toArray(new Team[0])
                     ) {
                    if (m.getHome_name().equals(t.getTeam_name()))
                        MaxGoals.add(t);
                }
            }
        }
        for (Team x:MaxGoals
             ) {
            System.out.println(x.getTeam_name());
        }
    }

    //Show Matches
    private static void ShowMatches(List<Match> league1) {
        for (Match m:league1
             ) {
            System.out.println(m);
        }
    }
    //calculate point
    private static void Points(List<Match>League1,Set<Team>Teams){

        for (Match t:League1
        ) {
            for (Team l:Teams
            ) {
                if(t.getHome_goals()>t.getVisitor_goals()&&l.getTeam_name().equals(t.getHome_name())){
                    l.setPoints(l.getPoints()+3);
                }
                if(t.getHome_goals()<t.getVisitor_goals()&&l.getTeam_name().equals(t.getVisitor_name())){
                    l.setPoints(l.getPoints()+3);
                }

               if(t.getHome_goals()==t.getVisitor_goals()&&l.getTeam_name().equals(t.getHome_name()))
                   l.setPoints(l.getPoints()+1);
               if(t.getHome_goals()==t.getVisitor_goals()&&l.getTeam_name().equals(t.getVisitor_name()))
                   l.setPoints(l.getPoints()+1);
            }
        }
    }

}
