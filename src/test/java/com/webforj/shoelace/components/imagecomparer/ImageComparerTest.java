package com.webforj.shoelace.components.imagecomparer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.ChangeEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ImageComparerTest {

  ImageComparer component;

  @BeforeEach
  void setUp() {
    component = new ImageComparer();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(ImageComparer.class, component));
    }

    @Test
    void shouldDefaultPositionToFifty() {
      assertEquals(50, component.getPosition());
    }

    @Test
    void shouldChainSetters() {
      ImageComparer result = component
          .setPosition(75);

      assertEquals(component, result);
      assertEquals(75, component.getPosition());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddChangeListener() {
      component.onChange(event -> {});
      assertEquals(1, component.getEventListeners(ChangeEvent.class).size());
    }

    @Test
    void shouldAddChangeListenerViaAdd() {
      component.addChangeListener(event -> {});
      assertEquals(1, component.getEventListeners(ChangeEvent.class).size());
    }
  }
}
