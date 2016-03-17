package java1.snake1;

import java.awt.Dimension;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;




public class CanvasGame extends Canvas implements Game, Runnable {

	private Thread gameThread;
    private AtomicBoolean running;
    private Input input;
    private Scene scene;
	
    public CanvasGame(Dimension screenSize) {
        running = new AtomicBoolean(false);
        setSize(screenSize);
        initInput();
        initFocusListener();
    }

    private void initInput() {
        input = new Input();
        addKeyListener(input);
    }
    
    private void initFocusListener() {
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event) {
                start();
            }
            @Override
            public void focusLost(FocusEvent event) {
                pause();
            }
        });
    }
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long previousIterationTime = System.nanoTime();
        while (running.get()) {
            if (scene == null) {
                continue;
            }
            long now = System.nanoTime();
            long nanosPassed = now - previousIterationTime;
            previousIterationTime = now;
            Graphics2D g = (Graphics2D)getBufferStrategy().getDrawGraphics();
            scene.update(nanosPassed);
            scene.draw(g);
            getBufferStrategy().show();
        }
    }

	

	@Override
	public void start() {
		// TODO Auto-generated method stub
		if (running.compareAndSet(false, true)) {
            gameThread = new Thread(this);
            gameThread.start();
        }

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		if (running.compareAndSet(true, false)) {
            try {
                gameThread.join();
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }

	}

	@Override
	public Dimension getScreenSize() {
		// TODO Auto-generated method stub
		return getSize();
	}

	@Override
	public Input getInput() {
		// TODO Auto-generated method stub
		return input;
	}

	@Override
	public void setScene(Scene scene) {
		// TODO Auto-generated method stub
		this.scene = scene;

	}

}
