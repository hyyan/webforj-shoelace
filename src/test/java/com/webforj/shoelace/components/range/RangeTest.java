package com.webforj.shoelace.components.range;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RangeTest {

  Range component;

  @BeforeEach
  void setUp() {
    component = new Range();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Range.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      Range range = new Range(50.0);
      assertEquals(50.0, range.getValue());
    }

    @Test
    void shouldDefaultToZeroValue() {
      assertEquals(0.0, component.getValue());
    }

    @Test
    void shouldDefaultToMinZero() {
      assertEquals(0.0, component.getMin());
    }

    @Test
    void shouldDefaultToMaxHundred() {
      assertEquals(100.0, component.getMax());
    }

    @Test
    void shouldDefaultToStepOne() {
      assertEquals(1.0, component.getStep());
    }

    @Test
    void shouldDefaultToTooltipTop() {
      assertEquals(RangeTooltip.TOP, component.getTooltip());
    }

    @Test
    void shouldDefaultToNotDisabled() {
      assertFalse(component.isDisabled());
    }

    @Test
    void shouldDefaultToNotRequired() {
      assertFalse(component.isRequired());
    }

    @Test
    void shouldSetDisabled() {
      component.setDisabled(true);
      assertTrue(component.isDisabled());
    }

    @Test
    void shouldSetRequired() {
      component.setRequired(true);
      assertTrue(component.isRequired());
    }

    @Test
    void shouldChainSetters() {
      Range result = component
          .setName("volume")
          .setValue(50.0)
          .setLabel("Volume")
          .setHelpText("Adjust the volume")
          .setDisabled(false)
          .setMin(0.0)
          .setMax(100.0)
          .setStep(5.0)
          .setTooltip(RangeTooltip.BOTTOM)
          .setForm("myForm")
          .setRequired(false)
          .setThumbSize("20px")
          .setTooltipOffset("10px")
          .setTrackColorActive("blue")
          .setTrackColorInactive("gray")
          .setTrackActiveOffset("0%")
          .setTrackHeight("6px");

      assertEquals(component, result);
      assertEquals("volume", component.getName());
      assertEquals(50.0, component.getValue());
      assertEquals("Volume", component.getLabel());
      assertEquals("Adjust the volume", component.getHelpText());
      assertEquals(5.0, component.getStep());
      assertEquals(RangeTooltip.BOTTOM, component.getTooltip());
      assertEquals("myForm", component.getForm());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddBlurListener() {
      component.onBlur(event -> {});
      assertEquals(1, component.getEventListeners(BlurEvent.class).size());
    }

    @Test
    void shouldAddBlurListenerViaAdd() {
      component.addBlurListener(event -> {});
      assertEquals(1, component.getEventListeners(BlurEvent.class).size());
    }

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
    void shouldAddFocusListener() {
      component.onFocus(event -> {});
      assertEquals(1, component.getEventListeners(FocusEvent.class).size());
    }

    @Test
    void shouldAddFocusListenerViaAdd() {
      component.addFocusListener(event -> {});
      assertEquals(1, component.getEventListeners(FocusEvent.class).size());
    }

    @Test
    void shouldAddInputListener() {
      component.onInput(event -> {});
      assertEquals(1, component.getEventListeners(InputEvent.class).size());
    }

    @Test
    void shouldAddInputListenerViaAdd() {
      component.addInputListener(event -> {});
      assertEquals(1, component.getEventListeners(InputEvent.class).size());
    }

    @Test
    void shouldAddInvalidListener() {
      component.onInvalid(event -> {});
      assertEquals(1, component.getEventListeners(InvalidEvent.class).size());
    }

    @Test
    void shouldAddInvalidListenerViaAdd() {
      component.addInvalidListener(event -> {});
      assertEquals(1, component.getEventListeners(InvalidEvent.class).size());
    }
  }
}
