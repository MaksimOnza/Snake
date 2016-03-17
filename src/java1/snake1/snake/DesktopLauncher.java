package java1.snake1.snake;

import java.awt.*;

import java1.snake1.DesktopGameBuilder;
import java1.snake1.Game;
import java1.snake1.MainScene;
import static java1.snake1.snake.Constants.*;

public class DesktopLauncher {

	public static void main(String[] args) {
        int screenWidth = WORLD_WIDTH * CELL_SIZE;
        int screenHeight = WORLD_HEIGHT * CELL_SIZE;
        Dimension screenSize = new Dimension(screenWidth, screenHeight);
        
        Game game = DesktopGameBuilder.build(screenSize);
        game.setScene(new MainScene(game));
        game.start();
    }
	
}
