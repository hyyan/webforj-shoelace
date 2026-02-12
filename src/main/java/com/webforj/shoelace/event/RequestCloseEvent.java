package com.webforj.shoelace.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.EventOptions.EventData;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the user attempts to close a Shoelace component by clicking the close button,
 * clicking the overlay, or pressing escape.
 *
 * <p>Calling {@code event.preventDefault()} will keep the component open. Avoid using this unless
 * closing the component will result in destructive behavior such as data loss.</p>
 *
 * @param <T> the component type
 */
@EventName("sl-request-close")
@EventOptions(
    filter = "event.target.isSameNode(component)",
    data = {@EventData(key = "source", exp = "event.detail.source")})
public class RequestCloseEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public RequestCloseEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }

  /**
   * Gets the source of the close request.
   *
   * @return the source, such as "close-button", "keyboard", or "overlay"
   */
  public String getSource() {
    return (String) getEventMap().get("source");
  }
}
