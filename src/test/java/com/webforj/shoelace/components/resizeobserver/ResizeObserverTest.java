package com.webforj.shoelace.components.resizeobserver;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.resizeobserver.event.ResizeEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResizeObserverTest {

  ResizeObserver component;

  @BeforeEach
  void setUp() {
    component = new ResizeObserver();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(ResizeObserver.class, component));
    }

    @Test
    void shouldChainSetters() {
      ResizeObserver result = component
          .setDisabled(true);

      assertEquals(component, result);
      assertEquals(true, component.isDisabled());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddResizeListener() {
      component.onResize(event -> {});
      assertEquals(1, component.getEventListeners(ResizeEvent.class).size());
    }

    @Test
    void shouldAddResizeListenerViaAdd() {
      component.addResizeListener(event -> {});
      assertEquals(1, component.getEventListeners(ResizeEvent.class).size());
    }
  }
}
