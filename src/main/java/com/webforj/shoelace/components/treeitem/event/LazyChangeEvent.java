package com.webforj.shoelace.components.treeitem.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the tree item's lazy state changes.
 *
 * @param <T> the component type
 */
@EventName("sl-lazy-change")
@EventOptions(filter = "event.target.isSameNode(component)")
public class LazyChangeEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public LazyChangeEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
