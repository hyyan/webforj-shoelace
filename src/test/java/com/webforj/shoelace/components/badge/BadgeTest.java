package com.webforj.shoelace.components.badge;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BadgeTest {

  Badge component;

  @BeforeEach
  void setUp() {
    component = new Badge();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Badge.class, component));
    }

    @Test
    void shouldChainSetters() {
      Badge result = component
          .setVariant(BadgeVariant.SUCCESS)
          .setPill(true)
          .setPulse(true);

      assertEquals(component, result);
      assertEquals(BadgeVariant.SUCCESS, component.getVariant());
      assertEquals(true, component.isPill());
      assertEquals(true, component.isPulse());
    }
  }
}
