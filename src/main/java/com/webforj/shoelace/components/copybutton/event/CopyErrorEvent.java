package com.webforj.shoelace.components.copybutton.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when data could not be copied by the CopyButton component.
 *
 * @param <T> the component type
 */
@EventName("sl-error")
@EventOptions(filter = "event.target.isSameNode(component)")
public class CopyErrorEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public CopyErrorEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
