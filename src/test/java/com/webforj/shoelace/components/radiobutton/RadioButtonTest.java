package com.webforj.shoelace.components.radiobutton;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.FocusEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RadioButtonTest {

  RadioButton component;

  @BeforeEach
  void setUp() {
    component = new RadioButton();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(RadioButton.class, component));
    }

    @Test
    void shouldConstructWithValue() {
      RadioButton radioButton = new RadioButton("option1");
      assertEquals("option1", radioButton.getValue());
    }

    @Test
    void shouldChainSetters() {
      RadioButton result = component
          .setValue("option1")
          .setDisabled(true)
          .setSize(Size.SMALL)
          .setPill(true);

      assertEquals(component, result);
      assertEquals("option1", component.getValue());
      assertEquals(true, component.isDisabled());
      assertEquals(Size.SMALL, component.getSize());
      assertEquals(true, component.isPill());
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
  }
}
