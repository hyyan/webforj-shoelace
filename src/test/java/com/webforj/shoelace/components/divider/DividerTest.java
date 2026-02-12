package com.webforj.shoelace.components.divider;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DividerTest {

  Divider component;

  @BeforeEach
  void setUp() {
    component = new Divider();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Divider.class, component));
    }

    @Test
    void shouldDefaultToHorizontal() {
      assertFalse(component.isVertical());
    }

    @Test
    void shouldSetVertical() {
      component.setVertical(true);
      assertTrue(component.isVertical());
    }

    @Test
    void shouldChainSetters() {
      Divider result = component.setVertical(true);
      assertEquals(component, result);
    }
  }
}
