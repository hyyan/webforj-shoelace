package com.webforj.shoelace.components.dialog;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.InitialFocusEvent;
import com.webforj.shoelace.event.RequestCloseEvent;
import com.webforj.shoelace.event.ShowEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DialogTest {

  Dialog component;

  @BeforeEach
  void setUp() {
    component = new Dialog();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Dialog.class, component));
    }

    @Test
    void shouldConstructWithLabel() {
      Dialog dialog = new Dialog("Confirm");
      assertEquals("Confirm", dialog.getLabel());
    }

    @Test
    void shouldDefaultToClosed() {
      assertFalse(component.isOpen());
    }

    @Test
    void shouldDefaultToShowHeader() {
      assertFalse(component.isNoHeader());
    }

    @Test
    void shouldChainSetters() {
      Dialog result = component
          .setOpen(true)
          .setLabel("My Dialog")
          .setNoHeader(true);

      assertEquals(component, result);
      assertTrue(component.isOpen());
      assertEquals("My Dialog", component.getLabel());
      assertTrue(component.isNoHeader());
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

    @Test
    void shouldAddInitialFocusListener() {
      component.onInitialFocus(event -> {});
      assertEquals(1, component.getEventListeners(InitialFocusEvent.class).size());
    }

    @Test
    void shouldAddInitialFocusListenerViaAdd() {
      component.addInitialFocusListener(event -> {});
      assertEquals(1, component.getEventListeners(InitialFocusEvent.class).size());
    }

    @Test
    void shouldAddRequestCloseListener() {
      component.onRequestClose(event -> {});
      assertEquals(1, component.getEventListeners(RequestCloseEvent.class).size());
    }

    @Test
    void shouldAddRequestCloseListenerViaAdd() {
      component.addRequestCloseListener(event -> {});
      assertEquals(1, component.getEventListeners(RequestCloseEvent.class).size());
    }
  }
}
