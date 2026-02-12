package com.webforj.shoelace.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when a Shoelace component opens and is ready to receive focus.
 *
 * <p>Calling {@code event.preventDefault()} will prevent focusing and allow you to set it on a
 * different element, such as an input.</p>
 *
 * @param <T> the component type
 */
@EventName("sl-initial-focus")
@EventOptions(filter = "event.target.isSameNode(component)")
public class InitialFocusEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public InitialFocusEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
