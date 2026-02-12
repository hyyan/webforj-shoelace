package com.webforj.shoelace.components.menu;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.shoelace.components.menu.event.SelectEvent;

/**
 * Shoelace Menu component ({@code <sl-menu>}).
 *
 * <p>Menus provide a list of options for the user to choose from. They can be used in dropdowns,
 * context menus, and other similar patterns. Menus contain menu items, menu labels, and
 * dividers.</p>
 *
 * @see <a href="https://shoelace.style/components/menu">Shoelace Menu</a>
 */
@NodeName("sl-menu")
public final class Menu extends ElementCompositeContainer
    implements HasElementClickListener<Menu>, HasClassName<Menu>, HasStyle<Menu>, HasVisibility<Menu> {

  /**
   * Creates a new Menu.
   */
  public Menu() {
    super();
  }

  /**
   * Adds a listener for the select event, fired when a menu item is selected.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<SelectEvent<Menu>> addSelectListener(
      EventListener<SelectEvent<Menu>> listener) {
    return addEventListener(SelectEvent.class, listener);
  }

  /**
   * Adds a listener for the select event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<SelectEvent<Menu>> onSelect(EventListener<SelectEvent<Menu>> listener) {
    return addSelectListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
