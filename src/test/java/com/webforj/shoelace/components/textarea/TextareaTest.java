package com.webforj.shoelace.components.textarea;

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

class TextareaTest {

  Textarea component;

  @BeforeEach
  void setUp() {
    component = new Textarea();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Textarea.class, component));
    }

    @Test
    void shouldChainSetters() {
      Textarea result = component
          .setName("description")
          .setValue("Hello world")
          .setSize(Size.LARGE)
          .setFilled(true)
          .setLabel("Description")
          .setHelpText("Enter a description")
          .setPlaceholder("Type here...")
          .setRows(6)
          .setResize(Resize.AUTO)
          .setDisabled(true)
          .setReadonly(true)
          .setForm("my-form")
          .setRequired(true)
          .setMinlength(10)
          .setMaxlength(500)
          .setAutocomplete("off")
          .setAutofocus(true)
          .setSpellcheck(true)
          .setEnterkeyhint("send")
          .setInputmode("text");

      assertEquals(component, result);
      assertEquals("description", component.getName());
      assertEquals("Hello world", component.getValue());
      assertEquals(Size.LARGE, component.getSize());
      assertEquals(true, component.isFilled());
      assertEquals("Description", component.getLabel());
      assertEquals("Enter a description", component.getHelpText());
      assertEquals("Type here...", component.getPlaceholder());
      assertEquals(6, component.getRows());
      assertEquals(Resize.AUTO, component.getResize());
      assertEquals(true, component.isDisabled());
      assertEquals(true, component.isReadonly());
      assertEquals("my-form", component.getForm());
      assertEquals(true, component.isRequired());
      assertEquals(10, component.getMinlength());
      assertEquals(500, component.getMaxlength());
      assertEquals("off", component.getAutocomplete());
      assertEquals(true, component.isAutofocus());
      assertEquals(true, component.isSpellcheck());
      assertEquals("send", component.getEnterkeyhint());
      assertEquals("text", component.getInputmode());
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
