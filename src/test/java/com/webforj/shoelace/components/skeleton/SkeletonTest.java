package com.webforj.shoelace.components.skeleton;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SkeletonTest {

  Skeleton component;

  @BeforeEach
  void setUp() {
    component = new Skeleton();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Skeleton.class, component));
    }

    @Test
    void shouldDefaultToNoneEffect() {
      assertEquals(SkeletonEffect.NONE, component.getEffect());
    }

    @Test
    void shouldSetEffect() {
      component.setEffect(SkeletonEffect.PULSE);
      assertEquals(SkeletonEffect.PULSE, component.getEffect());
    }

    @Test
    void shouldChainSetters() {
      Skeleton result = component
          .setEffect(SkeletonEffect.SHEEN)
          .setBorderRadius("8px")
          .setColor("gray")
          .setSheenColor("white");

      assertEquals(component, result);
      assertEquals(SkeletonEffect.SHEEN, component.getEffect());
    }
  }
}
