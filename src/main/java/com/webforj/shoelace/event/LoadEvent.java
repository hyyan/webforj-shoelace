package com.webforj.shoelace.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when a Shoelace component has loaded its resource successfully.
 *
 * @param <T> the component type
 */
@EventName("sl-load")
@EventOptions(filter = "event.target.isSameNode(component)")
public class LoadEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public LoadEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
