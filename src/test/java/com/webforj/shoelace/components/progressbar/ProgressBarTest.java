package com.webforj.shoelace.components.progressbar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProgressBarTest {

  ProgressBar component;

  @BeforeEach
  void setUp() {
    component = new ProgressBar();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(ProgressBar.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      ProgressBar bar = new ProgressBar(75.0);
      assertEquals(75.0, bar.getValue());
    }

    @Test
    void shouldDefaultToZeroValue() {
      assertEquals(0.0, component.getValue());
    }

    @Test
    void shouldDefaultToNotIndeterminate() {
      assertFalse(component.isIndeterminate());
    }

    @Test
    void shouldSetIndeterminate() {
      component.setIndeterminate(true);
      assertTrue(component.isIndeterminate());
    }

    @Test
    void shouldChainSetters() {
      ProgressBar result = component
          .setValue(50.0)
          .setIndeterminate(false)
          .setLabel("Loading...")
          .setHeight("8px")
          .setTrackColor("gray")
          .setIndicatorColor("blue")
          .setLabelColor("white");

      assertEquals(component, result);
      assertEquals(50.0, component.getValue());
      assertEquals("Loading...", component.getLabel());
    }
  }
}
