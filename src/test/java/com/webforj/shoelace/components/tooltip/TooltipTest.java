package com.webforj.shoelace.components.tooltip;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Placement;
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.ShowEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TooltipTest {

  Tooltip component;

  @BeforeEach
  void setUp() {
    component = new Tooltip();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Tooltip.class, component));
    }

    @Test
    void shouldConstructWithContent() {
      Tooltip tooltip = new Tooltip("Hello world");
      assertEquals("Hello world", tooltip.getContent());
    }

    @Test
    void shouldChainSetters() {
      Tooltip result = component
          .setContent("Tooltip text")
          .setPlacement(Placement.BOTTOM)
          .setDisabled(true)
          .setDistance(16)
          .setOpen(true)
          .setSkidding(4)
          .setTrigger("click")
          .setHoist(true);

      assertEquals(component, result);
      assertEquals("Tooltip text", component.getContent());
      assertEquals(Placement.BOTTOM, component.getPlacement());
      assertEquals(true, component.isDisabled());
      assertEquals(16, component.getDistance());
      assertEquals(true, component.isOpen());
      assertEquals(4, component.getSkidding());
      assertEquals("click", component.getTrigger());
      assertEquals(true, component.isHoist());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddShowListener() {
      component.onShow(event -> {});
      assertEquals(1, component.getEventListeners(ShowEvent.class).size());
    }

    @Test
    void shouldAddShowListenerViaAdd() {
      component.addShowListener(event -> {});
      assertEquals(1, component.getEventListeners(ShowEvent.class).size());
    }

    @Test
    void shouldAddAfterShowListener() {
      component.onAfterShow(event -> {});
      assertEquals(1, component.getEventListeners(AfterShowEvent.class).size());
    }

    @Test
    void shouldAddAfterShowListenerViaAdd() {
      component.addAfterShowListener(event -> {});
      assertEquals(1, component.getEventListeners(AfterShowEvent.class).size());
    }

    @Test
    void shouldAddHideListener() {
      component.onHide(event -> {});
      assertEquals(1, component.getEventListeners(HideEvent.class).size());
    }

    @Test
    void shouldAddHideListenerViaAdd() {
      component.addHideListener(event -> {});
      assertEquals(1, component.getEventListeners(HideEvent.class).size());
    }

    @Test
    void shouldAddAfterHideListener() {
      component.onAfterHide(event -> {});
      assertEquals(1, component.getEventListeners(AfterHideEvent.class).size());
    }

    @Test
    void shouldAddAfterHideListenerViaAdd() {
      component.addAfterHideListener(event -> {});
      assertEquals(1, component.getEventListeners(AfterHideEvent.class).size());
    }
  }
}
