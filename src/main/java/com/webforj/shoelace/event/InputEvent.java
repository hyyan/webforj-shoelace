package com.webforj.shoelace.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when a Shoelace component receives input.
 *
 * @param <T> the component type
 */
@EventName("sl-input")
@EventOptions(filter = "event.target.isSameNode(component)")
public class InputEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public InputEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
