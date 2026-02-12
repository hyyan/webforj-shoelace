package com.webforj.shoelace.components.input;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.ClearEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputTest {

  Input component;

  @BeforeEach
  void setUp() {
    component = new Input();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Input.class, component));
    }

    @Test
    void shouldChainSetters() {
      Input result = component
          .setType(InputType.EMAIL)
          .setName("email")
          .setValue("test@example.com")
          .setSize(Size.LARGE)
          .setFilled(true)
          .setPill(true)
          .setLabel("Email")
          .setHelpText("Enter your email")
          .setClearable(true)
          .setDisabled(true)
          .setPlaceholder("you@example.com")
          .setReadonly(true)
          .setPasswordToggle(true)
          .setPasswordVisible(true)
          .setNoSpinButtons(true)
          .setForm("my-form")
          .setRequired(true)
          .setPattern("[a-z]+")
          .setMinlength(3)
          .setMaxlength(100)
          .setMin("0")
          .setMax("100")
          .setStep("5")
          .setAutocomplete("email")
          .setAutofocus(true)
          .setSpellcheck(true);

      assertEquals(component, result);
      assertEquals(InputType.EMAIL, component.getType());
      assertEquals("email", component.getName());
      assertEquals("test@example.com", component.getValue());
      assertEquals(Size.LARGE, component.getSize());
      assertEquals(true, component.isFilled());
      assertEquals(true, component.isPill());
      assertEquals("Email", component.getLabel());
      assertEquals("Enter your email", component.getHelpText());
      assertEquals(true, component.isClearable());
      assertEquals(true, component.isDisabled());
      assertEquals("you@example.com", component.getPlaceholder());
      assertEquals(true, component.isReadonly());
      assertEquals(true, component.isPasswordToggle());
      assertEquals(true, component.isPasswordVisible());
      assertEquals(true, component.isNoSpinButtons());
      assertEquals("my-form", component.getForm());
      assertEquals(true, component.isRequired());
      assertEquals("[a-z]+", component.getPattern());
      assertEquals(3, component.getMinlength());
      assertEquals(100, component.getMaxlength());
      assertEquals("0", component.getMin());
      assertEquals("100", component.getMax());
      assertEquals("5", component.getStep());
      assertEquals("email", component.getAutocomplete());
      assertEquals(true, component.isAutofocus());
      assertEquals(true, component.isSpellcheck());
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
    void shouldAddClearListener() {
      component.onClear(event -> {});
      assertEquals(1, component.getEventListeners(ClearEvent.class).size());
    }

    @Test
    void shouldAddClearListenerViaAdd() {
      component.addClearListener(event -> {});
      assertEquals(1, component.getEventListeners(ClearEvent.class).size());
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
