package com.webforj.shoelace.components.select;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.Size;
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.BlurEvent;
import com.webforj.shoelace.event.ChangeEvent;
import com.webforj.shoelace.event.ClearEvent;
import com.webforj.shoelace.event.FocusEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.InputEvent;
import com.webforj.shoelace.event.InvalidEvent;
import com.webforj.shoelace.event.ShowEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SelectTest {

  Select component;

  @BeforeEach
  void setUp() {
    component = new Select();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Select.class, component));
    }

    @Test
    void shouldConstructWithLabel() {
      Select select = new Select("Choose an option");
      assertEquals("Choose an option", select.getLabel());
    }

    @Test
    void shouldChainSetters() {
      Select result = component
          .setName("mySelect")
          .setValue("opt1")
          .setSize(Size.LARGE)
          .setPlaceholder("Pick one...")
          .setMultiple(true)
          .setMaxOptionsVisible(5)
          .setDisabled(true)
          .setClearable(true)
          .setOpen(true)
          .setHoist(true)
          .setFilled(true)
          .setPill(true)
          .setLabel("Options")
          .setPlacement(SelectPlacement.TOP)
          .setHelpText("Select an option")
          .setForm("myForm")
          .setRequired(true);

      assertEquals(component, result);
      assertEquals("mySelect", component.getName());
      assertEquals("opt1", component.getValue());
      assertEquals(Size.LARGE, component.getSize());
      assertEquals("Pick one...", component.getPlaceholder());
      assertEquals(true, component.isMultiple());
      assertEquals(5, component.getMaxOptionsVisible());
      assertEquals(true, component.isDisabled());
      assertEquals(true, component.isClearable());
      assertEquals(true, component.isOpen());
      assertEquals(true, component.isHoist());
      assertEquals(true, component.isFilled());
      assertEquals(true, component.isPill());
      assertEquals("Options", component.getLabel());
      assertEquals(SelectPlacement.TOP, component.getPlacement());
      assertEquals("Select an option", component.getHelpText());
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
    void shouldAddShowListener() {
      component.onShow(event -> {});
      assertEquals(1, component.getEventListeners(ShowEvent.class).size());
    }

    @Test
    void shouldAddShowListenerViaAdd() {
      component.addShowListener(event -> {});
      assertEquals(1, component.getEventListeners(ShowEvent.class).size());
    }

    @Test
    void shouldAddAfterShowListener() {
      component.onAfterShow(event -> {});
      assertEquals(1, component.getEventListeners(AfterShowEvent.class).size());
    }

    @Test
    void shouldAddAfterShowListenerViaAdd() {
      component.addAfterShowListener(event -> {});
      assertEquals(1, component.getEventListeners(AfterShowEvent.class).size());
    }

    @Test
    void shouldAddHideListener() {
      component.onHide(event -> {});
      assertEquals(1, component.getEventListeners(HideEvent.class).size());
    }

    @Test
    void shouldAddHideListenerViaAdd() {
      component.addHideListener(event -> {});
      assertEquals(1, component.getEventListeners(HideEvent.class).size());
    }

    @Test
    void shouldAddAfterHideListener() {
      component.onAfterHide(event -> {});
      assertEquals(1, component.getEventListeners(AfterHideEvent.class).size());
    }

    @Test
    void shouldAddAfterHideListenerViaAdd() {
      component.addAfterHideListener(event -> {});
      assertEquals(1, component.getEventListeners(AfterHideEvent.class).size());
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
