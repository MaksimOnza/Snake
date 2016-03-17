package java1.snake1.snake;

public class Delay {
	
	private long delayNanos;
    private long passedNanos;
    public Delay(long delayMillis) {
        this.delayNanos = TimeConverter.millisToNanos(delayMillis);
    }
    public boolean updateAndCheck(long deltaNanos) {
        passedNanos += deltaNanos;
        if (passedNanos > delayNanos) {
            passedNanos = 0;
            return true;
        } else {
            return false;
        }
    }

}
