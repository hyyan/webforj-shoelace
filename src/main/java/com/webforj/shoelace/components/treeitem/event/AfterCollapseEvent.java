package com.webforj.shoelace.components.treeitem.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted after the tree item collapses and all animations are complete.
 *
 * @param <T> the component type
 */
@EventName("sl-after-collapse")
@EventOptions(filter = "event.target.isSameNode(component)")
public class AfterCollapseEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public AfterCollapseEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }
}
