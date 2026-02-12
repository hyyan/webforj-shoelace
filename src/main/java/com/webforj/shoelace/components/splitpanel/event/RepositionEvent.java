package com.webforj.shoelace.components.splitpanel.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the divider's position changes in a SplitPanel component.
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
