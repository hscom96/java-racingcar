package racing.service;

import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;
import racing.domain.LineUp;
import racing.domain.RaceMachine;
import racing.resolver.SimpleAccelerateResolver;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class GranPrixServiceTest {
    private final GranPrixService granPrixService = new GranPrixService();

    @Test
    void testCreateGrandPrix() {
        GrandPrix grandPrix = granPrixService.createGrandPrix(new LineUp(Collections.singletonList(new RaceMachine(0, new SimpleAccelerateResolver(true)))), 5);
        assertThat(grandPrix).isNotNull();
        assertThat(grandPrix.getLineUp()).isNotNull();
        assertThat(grandPrix.getLineUp().getRaceMachines()).size().isEqualTo(1);
    }

    @Test
    void testGetGrandPrixById() {
        GrandPrix grandPrix = granPrixService.createGrandPrix(new LineUp(Collections.singletonList(new RaceMachine(0, new SimpleAccelerateResolver(true)))), 5);
        GrandPrix result = granPrixService.getGrandPrix(grandPrix.getId());

        assertThat(result).isEqualToComparingFieldByFieldRecursively(grandPrix);
    }
}