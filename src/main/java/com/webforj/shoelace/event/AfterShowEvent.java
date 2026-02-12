package com.webforj.shoelace.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted after a Shoelace component has fully opened and all animations are complete.
 *
 * @param <T> the component type
 */
@EventName("sl-after-show")
@EventOptions(filter = "event.target.isSameNode(component)")
public class AfterShowEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public AfterShowEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
