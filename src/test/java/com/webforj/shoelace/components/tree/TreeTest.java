package com.webforj.shoelace.components.tree;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.tree.event.SelectionChangeEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TreeTest {

  Tree component;

  @BeforeEach
  void setUp() {
    component = new Tree();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(Tree.class, component));
    }

    @Test
    void shouldChainSetters() {
      Tree result = component
          .setSelection(Selection.MULTIPLE);

      assertEquals(component, result);
      assertEquals(Selection.MULTIPLE, component.getSelection());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddSelectionChangeListener() {
      component.onSelectionChange(event -> {});
      assertEquals(1, component.getEventListeners(SelectionChangeEvent.class).size());
    }

    @Test
    void shouldAddSelectionChangeListenerViaAdd() {
      component.addSelectionChangeListener(event -> {});
      assertEquals(1, component.getEventListeners(SelectionChangeEvent.class).size());
    }
  }
}
