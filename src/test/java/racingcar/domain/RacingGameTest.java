package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.strategy.RandomMoveStrategy;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"true:3", "false:0"}, delimiter = ':')
    void 모든차앞으로전진(boolean moveNum, int expectedPosition) {
        // given
        RacingGame racingGame = new RacingGame(Cars.of(Arrays.asList("qwe", "asdf", "zx")), new TryRaceCount(3),
            () -> moveNum);

        // when
        List<Cars> carLog = racingGame.race();

        // then
        assertThat(carLog).hasSize(3);
        List<Car> racingCars = racingGame.getCars().getCars();
        assertThat(racingCars.get(0).getPosition()).isEqualTo(expectedPosition);
        assertThat(racingCars.get(1).getPosition()).isEqualTo(expectedPosition);
        assertThat(racingCars.get(2).getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:true", "0:false"}, delimiter = ':')
    void 진행가능여부조회(int tryRaceCount, boolean isOngoing) {
        // given
        RacingGame racingGame = new RacingGame(Cars.of(Arrays.asList("qwe", "asdf", "zx")),
            new TryRaceCount(tryRaceCount),
            new RandomMoveStrategy());

        // then
        assertThat(racingGame.isOngoing()).isEqualTo(isOngoing);
    }
}
