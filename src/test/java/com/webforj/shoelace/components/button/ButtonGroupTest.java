package com.webforj.shoelace.components.button;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ButtonGroupTest {

  ButtonGroup component;

  @BeforeEach
  void setUp() {
    component = new ButtonGroup();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(ButtonGroup.class, component));
    }

    @Test
    void shouldConstructWithLabel() {
      ButtonGroup group = new ButtonGroup("Actions");
      assertEquals("Actions", group.getLabel());
    }

    @Test
    void shouldChainSetters() {
      ButtonGroup result = component.setLabel("Alignment");

      assertEquals(component, result);
      assertEquals("Alignment", component.getLabel());
    }
  }

  @Nested
  @DisplayName("Slots API")
  class SlotsApi {

    @Test
    void shouldAddButtonsToDefaultSlot() {
      Button button1 = new Button("Left");
      Button button2 = new Button("Center");
      component.add(button1, button2);

      assertEquals(2, component.getComponentCount());
    }
  }
}
