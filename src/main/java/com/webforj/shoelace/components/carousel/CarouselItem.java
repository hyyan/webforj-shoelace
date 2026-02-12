package com.webforj.shoelace.components.carousel;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;

/**
 * Shoelace CarouselItem component ({@code <sl-carousel-item>}).
 *
 * <p>A carousel item represents a single slide within a {@link Carousel}. Each item can contain
 * arbitrary content and supports a custom aspect ratio via the {@code --aspect-ratio} CSS custom
 * property.</p>
 *
 * @see <a href="https://shoelace.style/components/carousel-item">Shoelace Carousel Item</a>
 */
@NodeName("sl-carousel-item")
public final class CarouselItem extends ElementCompositeContainer
    implements HasElementClickListener<CarouselItem>, HasClassName<CarouselItem>, HasStyle<CarouselItem> {

  /**
   * Creates a new CarouselItem.
   */
  public CarouselItem() {
    super();
  }

  /**
   * Gets the aspect ratio CSS custom property value.
   *
   * @return the aspect ratio, or {@code null} if not set
   */
  public String getAspectRatio() {
    return getElement().getStyle("--aspect-ratio");
  }

  /**
   * Sets the aspect ratio CSS custom property. Inherited from the carousel by default.
   *
   * @param aspectRatio the aspect ratio value (e.g. "16/9", "4/3")
   * @return this component
   */
  public CarouselItem setAspectRatio(String aspectRatio) {
    getElement().setStyle("--aspect-ratio", aspectRatio);
    return this;
  }

  Element getOriginalElement() {
    return getElement();
  }
}
