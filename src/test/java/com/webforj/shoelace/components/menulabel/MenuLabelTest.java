package com.webforj.shoelace.components.menulabel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MenuLabelTest {

  MenuLabel component;

  @BeforeEach
  void setUp() {
    component = new MenuLabel();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldConstructWithText() {
      MenuLabel label = new MenuLabel("Section");
      assertEquals("Section", label.getText());
    }

    @Test
    void shouldSetAndGetText() {
      MenuLabel result = component.setText("Actions");
      assertEquals(component, result);
      assertEquals("Actions", component.getText());
    }
  }
}
