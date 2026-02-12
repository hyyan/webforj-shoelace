package com.webforj.shoelace.components.rating.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.EventOptions.EventData;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the user hovers over a value on a Rating component.
 *
 * <p>The {@code phase} property indicates when hovering starts, moves to a new value, or ends.
 * The {@code value} property tells what the rating's value would be if the user were to commit
 * to the hovered value.</p>
 *
 * @param <T> the component type
 */
@EventName("sl-hover")
@EventOptions(
    filter = "event.target.isSameNode(component)",
    data = {
        @EventData(key = "phase", exp = "event.detail.phase"),
        @EventData(key = "value", exp = "event.detail.value")
    })
public class HoverEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public HoverEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }

  /**
   * Gets the hover phase.
   *
   * @return the phase ("start", "move", or "end")
   */
  public String getPhase() {
    return (String) getEventMap().get("phase");
  }

  /**
   * Gets the hovered value.
   *
   * @return the value the rating would be if the user committed to the hovered value
   */
  public double getValue() {
    Object val = getEventMap().get("value");
    if (val instanceof Number) {
      return ((Number) val).doubleValue();
    }
    return 0.0;
  }
}
