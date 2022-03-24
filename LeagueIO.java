package league.io;

import league.stats.Match;
import league.stats.Team;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeagueIO {

    public static List<Match> loadMatches(String file)  {
        List<Match> League1=new ArrayList<>();
        if(!(new File(file)).exists()){
            return League1;
        }
        else{
            try(BufferedReader inputFile=new BufferedReader(new FileReader(file)))
            {
                String line;
                while((line=inputFile.readLine())!=null){
                    String[]value=line.split("#");
                    League1.add(new Match(value[0],Integer.parseInt(value[1]),value[2],Integer.parseInt(value[3] )));
                }
            }
            catch(IOException e){
                System.err.println("Error reading file: "+e.getMessage());
            }
            catch(Exception e){
                System.err.println("Error : "+e.getMessage());
            }
             return League1;
        }

    }
    public static void saveRanking(Team[]AllTeams,String file){
        try{
            PrintWriter inputFile=new PrintWriter(file);
            for (Team g:AllTeams
                 ) {
                inputFile.println(g.getTeam_name()+";"+g.getPoints());
            }
            inputFile.close();
        }
        catch(IOException e){
            System.err.println("Error writing file: "+e.getMessage());
        }
        catch(Exception e){
            System.err.println("Error : "+e.getMessage());
        }
    }
}
