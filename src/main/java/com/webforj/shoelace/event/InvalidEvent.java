package com.webforj.shoelace.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when a Shoelace form control has been checked for validity and its constraints are not
 * satisfied.
 *
 * @param <T> the component type
 */
@EventName("sl-invalid")
@EventOptions(filter = "event.target.isSameNode(component)")
public class InvalidEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public InvalidEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
