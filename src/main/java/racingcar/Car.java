package racingcar;

public class Car {
    private static final int DEFAULT_POSITION = 0;

    private int position;
    private MovableStrategy movableStrategy;

    public Car(int position, MovableStrategy movableStrategy) {
        this.position = position;
        this.movableStrategy = movableStrategy;
    }

    public int getPosition() {
        return position;
    }

    public MovableStrategy getMovableStrategy() {
        return movableStrategy;
    }

    public int move() {
        this.position += movableStrategy.move();
        return position;
    }

    public static Car makeDefaultInstance(){
        return new Car(DEFAULT_POSITION, new RandomMovableStrategy());
    }
}