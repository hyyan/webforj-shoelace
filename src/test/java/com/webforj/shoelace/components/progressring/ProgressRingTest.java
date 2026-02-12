package com.webforj.shoelace.components.progressring;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProgressRingTest {

  ProgressRing component;

  @BeforeEach
  void setUp() {
    component = new ProgressRing();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(ProgressRing.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      ProgressRing ring = new ProgressRing(60.0);
      assertEquals(60.0, ring.getValue());
    }

    @Test
    void shouldDefaultToZeroValue() {
      assertEquals(0.0, component.getValue());
    }

    @Test
    void shouldChainSetters() {
      ProgressRing result = component
          .setValue(80.0)
          .setLabel("Progress")
          .setSize("128px")
          .setTrackWidth("4px")
          .setTrackColor("gray")
          .setIndicatorWidth("4px")
          .setIndicatorColor("blue")
          .setIndicatorTransitionDuration("0.3s");

      assertEquals(component, result);
      assertEquals(80.0, component.getValue());
      assertEquals("Progress", component.getLabel());
    }
  }
}
