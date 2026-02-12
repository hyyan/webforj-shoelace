package com.webforj.shoelace.components.mutationobserver.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.EventOptions.EventData;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when a mutation occurs in a MutationObserver component.
 *
 * @param <T> the component type
 */
@EventName("sl-mutation")
@EventOptions(
    filter = "event.target.isSameNode(component)",
    data = {
        @EventData(key = "mutationList", exp = "event.detail.mutationList")
    })
public class MutationEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public MutationEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }

  /**
   * Gets the list of mutation records.
   *
   * @return the mutation list from the event detail
   */
  public Object getMutationList() {
    return getEventMap().get("mutationList");
  }
}
