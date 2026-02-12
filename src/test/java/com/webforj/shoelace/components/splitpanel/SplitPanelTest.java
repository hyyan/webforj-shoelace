package com.webforj.shoelace.components.splitpanel;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.splitpanel.event.RepositionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SplitPanelTest {

  SplitPanel component;

  @BeforeEach
  void setUp() {
    component = new SplitPanel();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(SplitPanel.class, component));
    }

    @Test
    void shouldDefaultPositionTo50() {
      assertEquals(50, component.getPosition());
    }

    @Test
    void shouldDefaultToHorizontal() {
      assertFalse(component.isVertical());
    }

    @Test
    void shouldDefaultToNotDisabled() {
      assertFalse(component.isDisabled());
    }

    @Test
    void shouldDefaultPrimaryToStart() {
      assertEquals(Primary.START, component.getPrimary());
    }

    @Test
    void shouldDefaultSnapThresholdTo12() {
      assertEquals(12, component.getSnapThreshold());
    }

    @Test
    void shouldChainSetters() {
      SplitPanel result = component
          .setPosition(30)
          .setVertical(true)
          .setDisabled(true)
          .setPrimary(Primary.START)
          .setSnap("50%")
          .setSnapThreshold(20);

      assertEquals(component, result);
      assertEquals(30, component.getPosition());
      assertTrue(component.isVertical());
      assertTrue(component.isDisabled());
      assertEquals(Primary.START, component.getPrimary());
      assertEquals("50%", component.getSnap());
      assertEquals(20, component.getSnapThreshold());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddRepositionListener() {
      component.onReposition(event -> {});
      assertEquals(1, component.getEventListeners(RepositionEvent.class).size());
    }

    @Test
    void shouldAddRepositionListenerViaAdd() {
      component.addRepositionListener(event -> {});
      assertEquals(1, component.getEventListeners(RepositionEvent.class).size());
    }
  }
}
