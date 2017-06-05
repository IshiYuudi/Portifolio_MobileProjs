package androidstudio.yudi.tictactoev2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ishikawa on 27/03/2017.
 */

public class Games {
    private List<Game> games = new ArrayList<>();

    public Games(Game...games){
        for (Game g : games)
            this.games.add(g);
    }
    public Game gamesAddSerie(int player){
        Game g;
        for (Game game : games){
            g = game.addSerie(player);
            if (g != null) return g;
        }
        return null;
    }

}
