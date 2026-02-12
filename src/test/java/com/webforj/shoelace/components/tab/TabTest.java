package com.webforj.shoelace.components.tab;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.tab.event.CloseEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TabTest {

  Tab component;

  @BeforeEach
  void setUp() {
    component = new Tab();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Tab.class, component));
    }

    @Test
    void shouldDefaultToInactive() {
      assertFalse(component.isActive());
    }

    @Test
    void shouldDefaultToNotClosable() {
      assertFalse(component.isClosable());
    }

    @Test
    void shouldDefaultToNotDisabled() {
      assertFalse(component.isDisabled());
    }

    @Test
    void shouldChainSetters() {
      Tab result = component
          .setPanel("general")
          .setActive(true)
          .setClosable(true)
          .setDisabled(true);

      assertEquals(component, result);
      assertEquals("general", component.getPanel());
      assertTrue(component.isActive());
      assertTrue(component.isClosable());
      assertTrue(component.isDisabled());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddCloseListener() {
      component.onClose(event -> {});
      assertEquals(1, component.getEventListeners(CloseEvent.class).size());
    }

    @Test
    void shouldAddCloseListenerViaAdd() {
      component.addCloseListener(event -> {});
      assertEquals(1, component.getEventListeners(CloseEvent.class).size());
    }
  }
}
