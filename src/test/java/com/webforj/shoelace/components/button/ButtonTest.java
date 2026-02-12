package com.webforj.shoelace.components.button;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.InvalidEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ButtonTest {

  Button component;

  @BeforeEach
  void setUp() {
    component = new Button();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Button.class, component));
    }

    @Test
    void shouldConstructWithText() {
      Button button = new Button("Click me");
      assertEquals("Click me", button.getText());
    }

    @Test
    void shouldConstructWithTextAndVariant() {
      Button button = new Button("Save", Variant.PRIMARY);
      assertEquals("Save", button.getText());
      assertEquals(Variant.PRIMARY, button.getVariant());
    }

    @Test
    void shouldChainSetters() {
      Button result = component
          .setVariant(Variant.DANGER)
          .setSize(Size.LARGE)
          .setCaret(true)
          .setDisabled(true)
          .setLoading(true)
          .setOutline(true)
          .setPill(true)
          .setCircle(true)
          .setType(ButtonType.SUBMIT)
          .setName("submit-btn")
          .setValue("submit")
          .setHref("https://example.com")
          .setTarget(Target.BLANK)
          .setRel("noopener")
          .setDownload("file.pdf")
          .setForm("my-form")
          .setFormAction("/submit")
          .setFormNoValidate(true);

      assertEquals(component, result);
      assertEquals(Variant.DANGER, component.getVariant());
      assertEquals(Size.LARGE, component.getSize());
      assertEquals(true, component.isCaret());
      assertEquals(true, component.isDisabled());
      assertEquals(true, component.isLoading());
      assertEquals(true, component.isOutline());
      assertEquals(true, component.isPill());
      assertEquals(true, component.isCircle());
      assertEquals(ButtonType.SUBMIT, component.getType());
      assertEquals("submit-btn", component.getName());
      assertEquals("submit", component.getValue());
      assertEquals("https://example.com", component.getHref());
      assertEquals(Target.BLANK, component.getTarget());
      assertEquals("noopener", component.getRel());
      assertEquals("file.pdf", component.getDownload());
      assertEquals("my-form", component.getForm());
      assertEquals("/submit", component.getFormAction());
      assertEquals(true, component.isFormNoValidate());
    }
  }

  @Nested
  @DisplayName("Slots API")
  class SlotsApi {

    @Test
    void shouldAddToPrefix() {
      Button other = new Button("icon");
      Button result = component.addToPrefix(other);
      assertEquals(component, result);
    }

    @Test
    void shouldAddToSuffix() {
      Button other = new Button("icon");
      Button result = component.addToSuffix(other);
      assertEquals(component, result);
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
