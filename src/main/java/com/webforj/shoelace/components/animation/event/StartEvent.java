package com.webforj.shoelace.components.animation.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the animation starts or restarts.
 *
 * @param <T> the component type
 */
@EventName("sl-start")
@EventOptions(filter = "event.target.isSameNode(component)")
public class StartEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public StartEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
