package com.webforj.shoelace.components.dropdown;

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

class DropdownTest {

  Dropdown component;

  @BeforeEach
  void setUp() {
    component = new Dropdown();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Dropdown.class, component));
    }

    @Test
    void shouldChainSetters() {
      Dropdown result = component
          .setOpen(true)
          .setPlacement(Placement.TOP_END)
          .setDisabled(true)
          .setStayOpenOnSelect(true)
          .setDistance(10)
          .setSkidding(5)
          .setHoist(true)
          .setSync("width");

      assertEquals(component, result);
      assertEquals(true, component.isOpen());
      assertEquals(Placement.TOP_END, component.getPlacement());
      assertEquals(true, component.isDisabled());
      assertEquals(true, component.isStayOpenOnSelect());
      assertEquals(10, component.getDistance());
      assertEquals(5, component.getSkidding());
      assertEquals(true, component.isHoist());
      assertEquals("width", component.getSync());
    }

    @Test
    void shouldSetSyncWithEnum() {
      component.setSync(DropdownSync.BOTH);
      assertEquals("both", component.getSync());
    }

    @Test
    void shouldSetSyncWithNullEnum() {
      component.setSync((DropdownSync) null);
      assertEquals("", component.getSync());
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
