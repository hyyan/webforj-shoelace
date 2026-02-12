package com.webforj.shoelace.components.menu.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.EventOptions.EventData;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when a menu item is selected.
 *
 * @param <T> the component type
 */
@EventName("sl-select")
@EventOptions(
    filter = "event.target.isSameNode(component)",
    data = {@EventData(key = "item.value", exp = "event.detail.item.value")})
public class SelectEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public SelectEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }

  /**
   * Gets the value of the selected menu item.
   *
   * @return the value of the selected item
   */
  public String getItemValue() {
    return (String) getEventMap().get("item.value");
  }
}
