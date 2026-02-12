package com.webforj.shoelace.components.radiogroup;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RadioGroupTest {

  RadioGroup component;

  @BeforeEach
  void setUp() {
    component = new RadioGroup();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(RadioGroup.class, component));
    }

    @Test
    void shouldConstructWithLabel() {
      RadioGroup group = new RadioGroup("Choose an option");
      assertEquals("Choose an option", group.getLabel());
    }

    @Test
    void shouldChainSetters() {
      RadioGroup result = component
          .setLabel("Options")
          .setHelpText("Select one")
          .setName("myGroup")
          .setValue("opt1")
          .setSize(Size.LARGE)
          .setForm("myForm")
          .setRequired(true);

      assertEquals(component, result);
      assertEquals("Options", component.getLabel());
      assertEquals("Select one", component.getHelpText());
      assertEquals("myGroup", component.getName());
      assertEquals("opt1", component.getValue());
      assertEquals(Size.LARGE, component.getSize());
      assertEquals("myForm", component.getForm());
      assertEquals(true, component.isRequired());
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
