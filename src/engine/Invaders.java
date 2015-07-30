package engine;

import screen.*;

import java.util.List;

/**
 * Created by Ryan on 7/28/2015.
 */
public class Invaders {

    /**
     * Start running the game
     */
    public static void run() {

        // Get a list of levels to play
        List<GameSettings> levelSettings = Levels.getLevels();

        // Hold on to all of the game's information
        GameState gameState = new GameState(1, 0, Constants.MAX_LIVES, 0, 0);
        
        // Show Title Screen below this line
        Screen screen = new TitleScreen();
        screen.show();
        ScreenType nextScreenType = screen.getNextScreenType();

        while(nextScreenType != ScreenType.EndGame) {
            if(nextScreenType == ScreenType.TitleScreen) {
                screen = new TitleScreen();
                screen.show();
                nextScreenType = screen.getNextScreenType();
            }
            else if(nextScreenType == ScreenType.GameScreen) {
                screen = new GameScreen(gameState, levelSettings);
                screen.show();
                nextScreenType = screen.getNextScreenType();
            }
            else if (nextScreenType == ScreenType.ScoreScreen) {
                screen = new ScoreScreen(gameState);
                screen.show();
                nextScreenType = screen.getNextScreenType();
            }
            else if (nextScreenType == ScreenType.HighScoreScreen) {
                screen = new HighScoreScreen();
                screen.show();
                nextScreenType = screen.getNextScreenType();
            }
        }
    }
}
