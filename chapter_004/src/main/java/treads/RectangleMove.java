package treads;
import javafx.scene.shape.Rectangle;
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private boolean increaseX = true, increaseY = true;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }
    private void changeX() {
        if (increaseX) {
            this.rect.setX(this.rect.getX() + 1);
        } else {
            this.rect.setX(this.rect.getX() - 1);
        }
        checkIncreaseX();
    }
    private void checkIncreaseX() {
        if (this.rect.getX() >= PingPong.LIMITX) {
            increaseX = false;
        } else if (this.rect.getX() <= 0) {
            increaseX = true;
        }
    }
    private void changeY() {
        if (increaseY) {
            this.rect.setY(this.rect.getY() + 1);
        } else {
            this.rect.setY(this.rect.getY() - 1);
        }
        checkIncreaseY();
    }
    private void checkIncreaseY() {
        if (this.rect.getY() >= PingPong.LIMITY) {
            increaseY = false;
        } else if (this.rect.getY() <= 0) {
            increaseY = true;
        }
    }
    @Override
    public void run() {
        while (true) {
            changeX();
            changeY();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
