package com.webforj.shoelace.components.tabgroup.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.EventOptions.EventData;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when a tab is hidden in a TabGroup component.
 *
 * @param <T> the component type
 */
@EventName("sl-tab-hide")
@EventOptions(
    filter = "event.target.isSameNode(component)",
    data = {@EventData(key = "name", exp = "event.detail.name")})
public class TabHideEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public TabHideEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }

  /**
   * Gets the name of the tab panel that was hidden.
   *
   * @return the tab panel name
   */
  public String getName() {
    return (String) getEventMap().get("name");
  }
}
