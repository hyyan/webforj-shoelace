package com.webforj.shoelace.components.spinner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SpinnerTest {

  Spinner component;

  @BeforeEach
  void setUp() {
    component = new Spinner();
  }

  @Nested
  @DisplayName("CSS Custom Properties API")
  class CssCustomPropertiesApi {

    @Test
    void shouldChainSetters() {
      Spinner result = component
          .setTrackWidth("4px")
          .setTrackColor("gray")
          .setIndicatorColor("blue")
          .setSpeed("1s");

      assertEquals(component, result);
    }
  }
}
