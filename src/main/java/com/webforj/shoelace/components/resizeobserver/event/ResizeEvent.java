package com.webforj.shoelace.components.resizeobserver.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.EventOptions.EventData;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the element is resized in a ResizeObserver component.
 *
 * @param <T> the component type
 */
@EventName("sl-resize")
@EventOptions(
    filter = "event.target.isSameNode(component)",
    data = {
        @EventData(key = "entries", exp = "event.detail.entries")
    })
public class ResizeEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public ResizeEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }

  /**
   * Gets the list of resize observer entries.
   *
   * @return the entries from the event detail
   */
  public Object getEntries() {
    return getEventMap().get("entries");
  }
}
