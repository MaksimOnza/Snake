package java1.snake1;

import java.awt.*;

public interface Game {

	void start();
    void pause();
    Dimension getScreenSize();//���������� ������ ������
    Input getInput();//�������� ������ �������� ��� ���������. �������-�� � ����������.
    void setScene(Scene scene);//����� ������� �����
	
}
