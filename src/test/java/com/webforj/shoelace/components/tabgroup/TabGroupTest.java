package com.webforj.shoelace.components.tabgroup;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.tabgroup.event.TabHideEvent;
import com.webforj.shoelace.components.tabgroup.event.TabShowEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TabGroupTest {

  TabGroup component;

  @BeforeEach
  void setUp() {
    component = new TabGroup();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(TabGroup.class, component));
    }

    @Test
    void shouldDefaultPlacementToTop() {
      assertEquals(Placement.TOP, component.getPlacement());
    }

    @Test
    void shouldDefaultActivationToAuto() {
      assertEquals(Activation.AUTO, component.getActivation());
    }

    @Test
    void shouldDefaultNoScrollControlsToFalse() {
      assertFalse(component.isNoScrollControls());
    }

    @Test
    void shouldDefaultFixedScrollControlsToFalse() {
      assertFalse(component.isFixedScrollControls());
    }

    @Test
    void shouldChainSetters() {
      TabGroup result = component
          .setPlacement(Placement.BOTTOM)
          .setActivation(Activation.MANUAL)
          .setNoScrollControls(true)
          .setFixedScrollControls(true);

      assertEquals(component, result);
      assertEquals(Placement.BOTTOM, component.getPlacement());
      assertEquals(Activation.MANUAL, component.getActivation());
      assertTrue(component.isNoScrollControls());
      assertTrue(component.isFixedScrollControls());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddTabShowListener() {
      component.onTabShow(event -> {});
      assertEquals(1, component.getEventListeners(TabShowEvent.class).size());
    }

    @Test
    void shouldAddTabShowListenerViaAdd() {
      component.addTabShowListener(event -> {});
      assertEquals(1, component.getEventListeners(TabShowEvent.class).size());
    }

    @Test
    void shouldAddTabHideListener() {
      component.onTabHide(event -> {});
      assertEquals(1, component.getEventListeners(TabHideEvent.class).size());
    }

    @Test
    void shouldAddTabHideListenerViaAdd() {
      component.addTabHideListener(event -> {});
      assertEquals(1, component.getEventListeners(TabHideEvent.class).size());
    }
  }
}
