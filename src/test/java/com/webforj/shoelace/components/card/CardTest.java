package com.webforj.shoelace.components.card;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CardTest {

  Card component;

  @BeforeEach
  void setUp() {
    component = new Card();
  }

  @Nested
  @DisplayName("Construction")
  class Construction {

    @Test
    void shouldCreateDefaultCard() {
      assertNotNull(component);
    }
  }

  @Nested
  @DisplayName("Slots API")
  class SlotsApi {

    @Test
    void shouldAddToHeader() {
      Card result = component.addToHeader();
      assertNotNull(result);
    }

    @Test
    void shouldAddToFooter() {
      Card result = component.addToFooter();
      assertNotNull(result);
    }

    @Test
    void shouldAddToImage() {
      Card result = component.addToImage();
      assertNotNull(result);
    }
  }
}
