package com.webforj.shoelace.components.carousel.event;

import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.EventName;
import com.webforj.component.element.annotation.EventOptions;
import com.webforj.component.element.annotation.EventOptions.EventData;
import com.webforj.component.event.ComponentEvent;
import java.util.Map;

/**
 * Emitted when the active slide changes in a Carousel component.
 *
 * @param <T> the component type
 */
@EventName("sl-slide-change")
@EventOptions(
    filter = "event.target.isSameNode(component)",
    data = {
        @EventData(key = "index", exp = "event.detail.index"),
        @EventData(key = "slide", exp = "event.detail.slide")
    })
public class SlideChangeEvent<T extends ElementComposite> extends ComponentEvent<T> {

  public SlideChangeEvent(T component, Map<String, Object> payload) {
    super(component, payload);
  }

  /**
   * Gets the index of the new active slide.
   *
   * @return the slide index
   */
  public int getIndex() {
    return ((Number) getEventMap().get("index")).intValue();
  }
}
