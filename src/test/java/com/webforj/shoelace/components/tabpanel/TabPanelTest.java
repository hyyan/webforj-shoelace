package com.webforj.shoelace.components.tabpanel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TabPanelTest {

  TabPanel component;

  @BeforeEach
  void setUp() {
    component = new TabPanel();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(TabPanel.class, component));
    }

    @Test
    void shouldConstructWithName() {
      TabPanel panel = new TabPanel("general");
      assertEquals("general", panel.getName());
    }

    @Test
    void shouldDefaultToInactive() {
      assertFalse(component.isActive());
    }

    @Test
    void shouldChainSetters() {
      TabPanel result = component
          .setName("general")
          .setActive(true);

      assertEquals(component, result);
      assertEquals("general", component.getName());
      assertTrue(component.isActive());
    }
  }
}
