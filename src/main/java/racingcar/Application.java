package racingcar;


import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.RacingCarInput;
import racingcar.view.RacingCarView;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = RacingCarInput.getCarName();
        int endRaceCount = RacingCarInput.getRaceCount();

        RacingGame racingGame = new RacingGame(Cars.of(carNames), endRaceCount, new RandomMoveStrategy());

        racingGame.race();

        StringBuilder gameLog = new StringBuilder();

        RacingCarView.printWinner(gameLog, racingGame.getCars());

        System.out.println(gameLog);
    }
}
