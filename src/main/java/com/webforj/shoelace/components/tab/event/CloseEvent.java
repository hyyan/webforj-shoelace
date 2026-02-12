package com.webforj.shoelace.components.tab.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the tab is closable and the close button is activated.
 *
 * @param <T> the component type
 */
@EventName("sl-close")
@EventOptions(filter = "event.target.isSameNode(component)")
public class CloseEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public CloseEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
