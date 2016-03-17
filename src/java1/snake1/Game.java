package java1.snake1;

import java.awt.*;

public interface Game {

	void start();
    void pause();
    Dimension getScreenSize();//возвращает размер экрана
    Input getInput();//получает объект хранящий все пользоват. манипул-ии с контроллер.
    void setScene(Scene scene);//смена текущей сцены
	
}
