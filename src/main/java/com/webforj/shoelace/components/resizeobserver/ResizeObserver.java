package com.webforj.shoelace.components.resizeobserver;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.shoelace.components.resizeobserver.event.ResizeEvent;

/**
 * Shoelace Resize Observer component ({@code <sl-resize-observer>}).
 *
 * <p>The resize observer component offers a thin, declarative interface to the
 * {@code ResizeObserver API}. It allows you to detect when slotted elements are resized.</p>
 *
 * @see <a href="https://shoelace.style/components/resize-observer">Shoelace Resize Observer</a>
 */
@NodeName("sl-resize-observer")
public final class ResizeObserver extends ElementCompositeContainer
    implements HasElementClickListener<ResizeObserver>, HasClassName<ResizeObserver>, HasStyle<ResizeObserver>,
    HasVisibility<ResizeObserver> {

  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);

  /**
   * Creates a new ResizeObserver.
   */
  public ResizeObserver() {
    super();
  }

  /**
   * Returns whether the observer is disabled.
   *
   * @return {@code true} if the observer is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the observer is disabled.
   *
   * @param disabled {@code true} to disable the observer
   * @return this component
   */
  public ResizeObserver setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Adds a listener for the resize event, fired when the element is resized.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ResizeEvent<ResizeObserver>> addResizeListener(
      EventListener<ResizeEvent<ResizeObserver>> listener) {
    return addEventListener(ResizeEvent.class, listener);
  }

  /**
   * Adds a listener for the resize event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ResizeEvent<ResizeObserver>> onResize(EventListener<ResizeEvent<ResizeObserver>> listener) {
    return addResizeListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
