package com.webforj.shoelace.components.checkbox;

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

class CheckboxTest {

  Checkbox component;

  @BeforeEach
  void setUp() {
    component = new Checkbox();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Checkbox.class, component));
    }

    @Test
    void shouldChainSetters() {
      Checkbox result = component
          .setName("agree")
          .setValue("yes")
          .setSize(Size.LARGE)
          .setDisabled(true)
          .setChecked(true)
          .setIndeterminate(true)
          .setHelpText("You must agree to continue")
          .setForm("my-form")
          .setRequired(true);

      assertEquals(component, result);
      assertEquals("agree", component.getName());
      assertEquals("yes", component.getValue());
      assertEquals(Size.LARGE, component.getSize());
      assertEquals(true, component.isDisabled());
      assertEquals(true, component.isChecked());
      assertEquals(true, component.isIndeterminate());
      assertEquals("You must agree to continue", component.getHelpText());
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
