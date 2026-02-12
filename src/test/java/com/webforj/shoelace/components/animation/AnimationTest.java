package com.webforj.shoelace.components.animation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.animation.event.CancelEvent;
import com.webforj.shoelace.components.animation.event.FinishEvent;
import com.webforj.shoelace.components.animation.event.StartEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnimationTest {

  Animation component;

  @BeforeEach
  void setUp() {
    component = new Animation();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Animation.class, component));
    }

    @Test
    void shouldChainSetters() {
      Animation result = component
          .setName("bounce")
          .setPlay(true)
          .setDelay(100)
          .setDirection(PlaybackDirection.ALTERNATE)
          .setDuration(2000)
          .setEasing("ease-in-out")
          .setEndDelay(50)
          .setFill(FillMode.BOTH)
          .setIterations("3")
          .setIterationStart(0.5)
          .setPlaybackRate(2.0);

      assertEquals(component, result);
      assertEquals("bounce", component.getName());
      assertEquals(true, component.isPlay());
      assertEquals(100, component.getDelay());
      assertEquals(PlaybackDirection.ALTERNATE, component.getDirection());
      assertEquals(2000, component.getDuration());
      assertEquals("ease-in-out", component.getEasing());
      assertEquals(50, component.getEndDelay());
      assertEquals(FillMode.BOTH, component.getFill());
      assertEquals("3", component.getIterations());
      assertEquals(0.5, component.getIterationStart());
      assertEquals(2.0, component.getPlaybackRate());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddCancelListener() {
      component.onCancel(event -> {});
      assertEquals(1, component.getEventListeners(CancelEvent.class).size());
    }

    @Test
    void shouldAddCancelListenerViaAdd() {
      component.addCancelListener(event -> {});
      assertEquals(1, component.getEventListeners(CancelEvent.class).size());
    }

    @Test
    void shouldAddFinishListener() {
      component.onFinish(event -> {});
      assertEquals(1, component.getEventListeners(FinishEvent.class).size());
    }

    @Test
    void shouldAddFinishListenerViaAdd() {
      component.addFinishListener(event -> {});
      assertEquals(1, component.getEventListeners(FinishEvent.class).size());
    }

    @Test
    void shouldAddStartListener() {
      component.onStart(event -> {});
      assertEquals(1, component.getEventListeners(StartEvent.class).size());
    }

    @Test
    void shouldAddStartListenerViaAdd() {
      component.addStartListener(event -> {});
      assertEquals(1, component.getEventListeners(StartEvent.class).size());
    }
  }
}
