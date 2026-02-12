package com.webforj.shoelace.components.popup.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the Popup component is repositioned. This event can fire a lot, so avoid putting
 * expensive operations in your listener or consider debouncing it.
 *
 * @param <T> the component type
 */
@EventName("sl-reposition")
@EventOptions(filter = "event.target.isSameNode(component)")
public class RepositionEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public RepositionEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
