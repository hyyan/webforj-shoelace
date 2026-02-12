package com.webforj.shoelace.components.popup;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Placement;
import com.webforj.shoelace.components.popup.event.RepositionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PopupTest {

  Popup component;

  @BeforeEach
  void setUp() {
    component = new Popup();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Popup.class, component));
    }

    @Test
    void shouldChainSetters() {
      Popup result = component
          .setAnchor("my-anchor")
          .setActive(true)
          .setPlacement(Placement.BOTTOM_START)
          .setStrategy(PopupStrategy.FIXED)
          .setDistance(10)
          .setSkidding(5)
          .setArrow(true)
          .setArrowPlacement(ArrowPlacement.CENTER)
          .setArrowPadding(20)
          .setFlip(true)
          .setFlipFallbackPlacements("top bottom")
          .setFlipFallbackStrategy(FlipFallbackStrategy.INITIAL)
          .setFlipPadding(8)
          .setShift(true)
          .setShiftPadding(12)
          .setAutoSize("vertical")
          .setSync("width")
          .setAutoSizePadding(16)
          .setHoverBridge(true);

      assertEquals(component, result);
      assertEquals("my-anchor", component.getAnchor());
      assertEquals(true, component.isActive());
      assertEquals(Placement.BOTTOM_START, component.getPlacement());
      assertEquals(PopupStrategy.FIXED, component.getStrategy());
      assertEquals(10, component.getDistance());
      assertEquals(5, component.getSkidding());
      assertEquals(true, component.isArrow());
      assertEquals(ArrowPlacement.CENTER, component.getArrowPlacement());
      assertEquals(20, component.getArrowPadding());
      assertEquals(true, component.isFlip());
      assertEquals("top bottom", component.getFlipFallbackPlacements());
      assertEquals(FlipFallbackStrategy.INITIAL, component.getFlipFallbackStrategy());
      assertEquals(8, component.getFlipPadding());
      assertEquals(true, component.isShift());
      assertEquals(12, component.getShiftPadding());
      assertEquals("vertical", component.getAutoSize());
      assertEquals("width", component.getSync());
      assertEquals(16, component.getAutoSizePadding());
      assertEquals(true, component.isHoverBridge());
    }

    @Test
    void shouldSetAutoSizeWithEnum() {
      component.setAutoSize(AutoSize.BOTH);
      assertEquals("both", component.getAutoSize());
    }

    @Test
    void shouldSetAutoSizeWithNullEnum() {
      component.setAutoSize((AutoSize) null);
      assertEquals("", component.getAutoSize());
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
