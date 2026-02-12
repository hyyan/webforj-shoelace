package com.webforj.shoelace.components.rating;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.rating.event.HoverEvent;
import com.webforj.shoelace.event.ChangeEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RatingTest {

  Rating component;

  @BeforeEach
  void setUp() {
    component = new Rating();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Rating.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      Rating rating = new Rating(3.5);
      assertEquals(3.5, rating.getValue());
    }

    @Test
    void shouldDefaultToZeroValue() {
      assertEquals(0.0, component.getValue());
    }

    @Test
    void shouldDefaultToMaxFive() {
      assertEquals(5, component.getMax());
    }

    @Test
    void shouldDefaultToNotReadonly() {
      assertFalse(component.isReadonly());
    }

    @Test
    void shouldDefaultToNotDisabled() {
      assertFalse(component.isDisabled());
    }

    @Test
    void shouldSetReadonly() {
      component.setReadonly(true);
      assertTrue(component.isReadonly());
    }

    @Test
    void shouldChainSetters() {
      Rating result = component
          .setLabel("Star rating")
          .setValue(4.0)
          .setMax(10)
          .setPrecision(0.5)
          .setReadonly(false)
          .setDisabled(false)
          .setSymbolColor("gray")
          .setSymbolColorActive("gold")
          .setSymbolSize("2rem")
          .setSymbolSpacing("4px");

      assertEquals(component, result);
      assertEquals("Star rating", component.getLabel());
      assertEquals(4.0, component.getValue());
      assertEquals(10, component.getMax());
      assertEquals(0.5, component.getPrecision());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddChangeListener() {
      component.onChange(event -> {});
      assertEquals(1, component.getEventListeners(ChangeEvent.class).size());
    }

    @Test
    void shouldAddChangeListenerViaAdd() {
      component.addChangeListener(event -> {});
      assertEquals(1, component.getEventListeners(ChangeEvent.class).size());
    }

    @Test
    void shouldAddHoverListener() {
      component.onHover(event -> {});
      assertEquals(1, component.getEventListeners(HoverEvent.class).size());
    }

    @Test
    void shouldAddHoverListenerViaAdd() {
      component.addHoverListener(event -> {});
      assertEquals(1, component.getEventListeners(HoverEvent.class).size());
    }
  }
}
