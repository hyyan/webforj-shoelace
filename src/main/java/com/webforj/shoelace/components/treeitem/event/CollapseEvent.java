package com.webforj.shoelace.components.treeitem.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the tree item collapses.
 *
 * @param <T> the component type
 */
@EventName("sl-collapse")
@EventOptions(filter = "event.target.isSameNode(component)")
public class CollapseEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public CollapseEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
