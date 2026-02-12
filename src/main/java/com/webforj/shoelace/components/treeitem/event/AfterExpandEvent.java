package com.webforj.shoelace.components.treeitem.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted after the tree item expands and all animations are complete.
 *
 * @param <T> the component type
 */
@EventName("sl-after-expand")
@EventOptions(filter = "event.target.isSameNode(component)")
public class AfterExpandEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public AfterExpandEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
