package com.webforj.shoelace.components.tag.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the remove button of a Tag component is activated.
 *
 * @param <T> the component type
 */
@EventName("sl-remove")
@EventOptions(filter = "event.target.isSameNode(component)")
public class RemoveEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public RemoveEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
