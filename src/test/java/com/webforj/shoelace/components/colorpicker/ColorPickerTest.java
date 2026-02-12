package com.webforj.shoelace.components.colorpicker;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ColorPickerTest {

  ColorPicker component;

  @BeforeEach
  void setUp() {
    component = new ColorPicker();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(ColorPicker.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      ColorPicker colorPicker = new ColorPicker("#ff0000");
      assertEquals("#ff0000", colorPicker.getValue());
    }

    @Test
    void shouldChainSetters() {
      ColorPicker result = component
          .setValue("#ff0000")
          .setLabel("Pick a color")
          .setFormat(ColorPickerFormat.RGB)
          .setInline(true)
          .setSize(Size.LARGE)
          .setNoFormatToggle(true)
          .setName("color")
          .setDisabled(true)
          .setHoist(true)
          .setOpacity(true)
          .setUppercase(true)
          .setSwatches("#ff0000;#00ff00;#0000ff")
          .setForm("my-form")
          .setRequired(true);

      assertEquals(component, result);
      assertEquals("#ff0000", component.getValue());
      assertEquals("Pick a color", component.getLabel());
      assertEquals(ColorPickerFormat.RGB, component.getFormat());
      assertEquals(true, component.isInline());
      assertEquals(Size.LARGE, component.getSize());
      assertEquals(true, component.isNoFormatToggle());
      assertEquals("color", component.getName());
      assertEquals(true, component.isDisabled());
      assertEquals(true, component.isHoist());
      assertEquals(true, component.isOpacity());
      assertEquals(true, component.isUppercase());
      assertEquals("#ff0000;#00ff00;#0000ff", component.getSwatches());
      assertEquals("my-form", component.getForm());
      assertEquals(true, component.isRequired());
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
