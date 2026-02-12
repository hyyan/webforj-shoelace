package com.webforj.shoelace.components.treeitem;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.webforj.component.element.PropertyDescriptorTester;
import com.webforj.shoelace.components.treeitem.event.AfterCollapseEvent;
import com.webforj.shoelace.components.treeitem.event.AfterExpandEvent;
import com.webforj.shoelace.components.treeitem.event.CollapseEvent;
import com.webforj.shoelace.components.treeitem.event.ExpandEvent;
import com.webforj.shoelace.components.treeitem.event.LazyChangeEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TreeItemTest {

  TreeItem component;

  @BeforeEach
  void setUp() {
    component = new TreeItem();
  }

  @Nested
  @DisplayName("Properties API")
  class PropertiesApi {

    @Test
    void shouldSetGetProperties() {
      assertDoesNotThrow(() -> PropertyDescriptorTester.run(TreeItem.class, component));
    }

    @Test
    void shouldDefaultToCollapsed() {
      assertFalse(component.isExpanded());
    }

    @Test
    void shouldDefaultToNotSelected() {
      assertFalse(component.isSelected());
    }

    @Test
    void shouldDefaultToEnabled() {
      assertFalse(component.isDisabled());
    }

    @Test
    void shouldDefaultToNotLazy() {
      assertFalse(component.isLazy());
    }

    @Test
    void shouldChainSetters() {
      TreeItem result = component
          .setExpanded(true)
          .setSelected(true)
          .setDisabled(true)
          .setLazy(true);

      assertEquals(component, result);
      assertEquals(true, component.isExpanded());
      assertEquals(true, component.isSelected());
      assertEquals(true, component.isDisabled());
      assertEquals(true, component.isLazy());
    }
  }

  @Nested
  @DisplayName("Events API")
  class EventsApi {

    @Test
    void shouldAddExpandListener() {
      component.onExpand(event -> {});
      assertEquals(1, component.getEventListeners(ExpandEvent.class).size());
    }

    @Test
    void shouldAddExpandListenerViaAdd() {
      component.addExpandListener(event -> {});
      assertEquals(1, component.getEventListeners(ExpandEvent.class).size());
    }

    @Test
    void shouldAddAfterExpandListener() {
      component.onAfterExpand(event -> {});
      assertEquals(1, component.getEventListeners(AfterExpandEvent.class).size());
    }

    @Test
    void shouldAddAfterExpandListenerViaAdd() {
      component.addAfterExpandListener(event -> {});
      assertEquals(1, component.getEventListeners(AfterExpandEvent.class).size());
    }

    @Test
    void shouldAddCollapseListener() {
      component.onCollapse(event -> {});
      assertEquals(1, component.getEventListeners(CollapseEvent.class).size());
    }

    @Test
    void shouldAddCollapseListenerViaAdd() {
      component.addCollapseListener(event -> {});
      assertEquals(1, component.getEventListeners(CollapseEvent.class).size());
    }

    @Test
    void shouldAddAfterCollapseListener() {
      component.onAfterCollapse(event -> {});
      assertEquals(1, component.getEventListeners(AfterCollapseEvent.class).size());
    }

    @Test
    void shouldAddAfterCollapseListenerViaAdd() {
      component.addAfterCollapseListener(event -> {});
      assertEquals(1, component.getEventListeners(AfterCollapseEvent.class).size());
    }

    @Test
    void shouldAddLazyChangeListener() {
      component.onLazyChange(event -> {});
      assertEquals(1, component.getEventListeners(LazyChangeEvent.class).size());
    }

    @Test
    void shouldAddLazyChangeListenerViaAdd() {
      component.addLazyChangeListener(event -> {});
      assertEquals(1, component.getEventListeners(LazyChangeEvent.class).size());
    }
  }
}
