package com.webforj.shoelace.components.tree.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when a tree item is selected or deselected in a Tree component.
 *
 * @param <T> the component type
 */
@EventName("sl-selection-change")
@EventOptions(filter = "event.target.isSameNode(component)")
public class SelectionChangeEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public SelectionChangeEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
