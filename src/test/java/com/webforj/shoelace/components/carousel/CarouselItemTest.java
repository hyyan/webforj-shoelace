package com.webforj.shoelace.components.carousel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarouselItemTest {

  CarouselItem component;

  @BeforeEach
  void setUp() {
    component = new CarouselItem();
  }

  @Nested
  @DisplayName("Construction")
  class Construction {

    @Test
    void shouldCreateDefaultCarouselItem() {
      assertNotNull(component);
    }
  }

  @Nested
  @DisplayName("CSS Custom Properties")
  class CssCustomProperties {

    @Test
    void shouldSetAspectRatio() {
      CarouselItem result = component.setAspectRatio("4/3");
      assertNotNull(result);
    }
  }
}
