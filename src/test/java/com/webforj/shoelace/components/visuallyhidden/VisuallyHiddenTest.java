package com.webforj.shoelace.components.visuallyhidden;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class VisuallyHiddenTest {

  VisuallyHidden component;

  @BeforeEach
  void setUp() {
    component = new VisuallyHidden();
  }

  @Nested
  @DisplayName("Construction")
  class Construction {

    @Test
    void shouldCreateDefaultVisuallyHidden() {
      assertNotNull(component);
    }
  }
}
