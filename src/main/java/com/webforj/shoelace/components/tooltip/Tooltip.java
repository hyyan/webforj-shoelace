package com.webforj.shoelace.components.tooltip;

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
import com.webforj.shoelace.Placement;
import com.webforj.shoelace.event.AfterHideEvent;
import com.webforj.shoelace.event.AfterShowEvent;
import com.webforj.shoelace.event.HideEvent;
import com.webforj.shoelace.event.ShowEvent;

/**
 * Shoelace Tooltip component ({@code <sl-tooltip>}).
 *
 * <p>Tooltips display additional information based on a specific action. They are used to provide
 * context and clarity to UI elements.</p>
 *
 * @see <a href="https://shoelace.style/components/tooltip">Shoelace Tooltip</a>
 */
@NodeName("sl-tooltip")
public final class Tooltip extends ElementCompositeContainer
    implements HasElementClickListener<Tooltip>, HasClassName<Tooltip>, HasStyle<Tooltip>, HasVisibility<Tooltip> {

  private final PropertyDescriptor<String> contentProp =
      PropertyDescriptor.property("content", "");
  private final PropertyDescriptor<Placement> placementProp =
      PropertyDescriptor.property("placement", Placement.TOP);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Integer> distanceProp =
      PropertyDescriptor.property("distance", 8);
  private final PropertyDescriptor<Boolean> openProp =
      PropertyDescriptor.property("open", false);
  private final PropertyDescriptor<Integer> skiddingProp =
      PropertyDescriptor.property("skidding", 0);
  private final PropertyDescriptor<String> triggerProp =
      PropertyDescriptor.property("trigger", "hover focus");
  private final PropertyDescriptor<Boolean> hoistProp =
      PropertyDescriptor.property("hoist", false);

  /**
   * Creates a new Tooltip.
   */
  public Tooltip() {
    super();
  }

  /**
   * Creates a new Tooltip with the given content text.
   *
   * @param content the tooltip content text
   */
  public Tooltip(String content) {
    this();
    setContent(content);
  }

  /**
   * Gets the tooltip's text content.
   *
   * @return the content text
   */
  public String getContent() {
    return get(contentProp);
  }

  /**
   * Sets the tooltip's content. If you need to display HTML, use the {@code content} slot instead.
   *
   * @param content the content text
   * @return this component
   */
  public Tooltip setContent(String content) {
    set(contentProp, content);
    return this;
  }

  /**
   * Gets the preferred placement of the tooltip.
   *
   * @return the placement
   */
  public Placement getPlacement() {
    return get(placementProp);
  }

  /**
   * Sets the preferred placement of the tooltip. Note that the actual placement may vary as needed
   * to keep the tooltip inside of the viewport.
   *
   * @param placement the placement
   * @return this component
   */
  public Tooltip setPlacement(Placement placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Returns whether the tooltip is disabled.
   *
   * @return {@code true} if the tooltip is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the tooltip is disabled so it won't show when triggered.
   *
   * @param disabled {@code true} to disable the tooltip
   * @return this component
   */
  public Tooltip setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets the distance in pixels from which to offset the tooltip away from its target.
   *
   * @return the distance in pixels
   */
  public int getDistance() {
    return get(distanceProp);
  }

  /**
   * Sets the distance in pixels from which to offset the tooltip away from its target.
   *
   * @param distance the distance in pixels
   * @return this component
   */
  public Tooltip setDistance(int distance) {
    set(distanceProp, distance);
    return this;
  }

  /**
   * Returns whether the tooltip is open.
   *
   * @return {@code true} if the tooltip is open
   */
  public boolean isOpen() {
    return get(openProp);
  }

  /**
   * Sets whether the tooltip is open. You can use this in lieu of the {@link #show()} and
   * {@link #hide()} methods.
   *
   * @param open {@code true} to open the tooltip
   * @return this component
   */
  public Tooltip setOpen(boolean open) {
    set(openProp, open);
    return this;
  }

  /**
   * Gets the distance in pixels from which to offset the tooltip along its target.
   *
   * @return the skidding in pixels
   */
  public int getSkidding() {
    return get(skiddingProp);
  }

  /**
   * Sets the distance in pixels from which to offset the tooltip along its target.
   *
   * @param skidding the skidding in pixels
   * @return this component
   */
  public Tooltip setSkidding(int skidding) {
    set(skiddingProp, skidding);
    return this;
  }

  /**
   * Gets the trigger mode.
   *
   * @return the trigger mode
   */
  public String getTrigger() {
    return get(triggerProp);
  }

  /**
   * Sets how the tooltip is activated. Possible options include {@code click}, {@code hover},
   * {@code focus}, and {@code manual}. Multiple options can be passed by separating them with a
   * space. When {@code manual} is used, the tooltip must be activated programmatically.
   *
   * @param trigger the trigger mode
   * @return this component
   */
  public Tooltip setTrigger(String trigger) {
    set(triggerProp, trigger);
    return this;
  }

  /**
   * Returns whether hoisting is enabled.
   *
   * @return {@code true} if hoisting is enabled
   */
  public boolean isHoist() {
    return get(hoistProp);
  }

  /**
   * Sets whether to hoist the tooltip. Enable this option to prevent the tooltip from being
   * clipped when the component is placed inside a container with
   * {@code overflow: auto|hidden|scroll}. Hoisting uses a fixed positioning strategy that works in
   * many, but not all, scenarios.
   *
   * @param hoist {@code true} to enable hoisting
   * @return this component
   */
  public Tooltip setHoist(boolean hoist) {
    set(hoistProp, hoist);
    return this;
  }

  /**
   * Sets the maximum width of the tooltip before its content will wrap.
   *
   * @param maxWidth the max width CSS value (e.g. "300px")
   * @return this component
   */
  public Tooltip setMaxWidth(String maxWidth) {
    setStyle("--max-width", maxWidth);
    return this;
  }

  /**
   * Sets the amount of time to wait before hiding the tooltip when hovering.
   *
   * @param hideDelay the hide delay CSS value (e.g. "0ms")
   * @return this component
   */
  public Tooltip setHideDelay(String hideDelay) {
    setStyle("--hide-delay", hideDelay);
    return this;
  }

  /**
   * Sets the amount of time to wait before showing the tooltip when hovering.
   *
   * @param showDelay the show delay CSS value (e.g. "150ms")
   * @return this component
   */
  public Tooltip setShowDelay(String showDelay) {
    setStyle("--show-delay", showDelay);
    return this;
  }

  /**
   * Shows the tooltip.
   */
  public void show() {
    getOriginalElement().callJsFunctionVoidAsync("show");
  }

  /**
   * Hides the tooltip.
   */
  public void hide() {
    getOriginalElement().callJsFunctionVoidAsync("hide");
  }

  /**
   * Adds a listener for the show event, fired when the tooltip begins to show.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Tooltip>> addShowListener(EventListener<ShowEvent<Tooltip>> listener) {
    return addEventListener(ShowEvent.class, listener);
  }

  /**
   * Adds a listener for the show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ShowEvent<Tooltip>> onShow(EventListener<ShowEvent<Tooltip>> listener) {
    return addShowListener(listener);
  }

  /**
   * Adds a listener for the after-show event, fired after the tooltip has shown and all animations
   * are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Tooltip>> addAfterShowListener(
      EventListener<AfterShowEvent<Tooltip>> listener) {
    return addEventListener(AfterShowEvent.class, listener);
  }

  /**
   * Adds a listener for the after-show event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterShowEvent<Tooltip>> onAfterShow(
      EventListener<AfterShowEvent<Tooltip>> listener) {
    return addAfterShowListener(listener);
  }

  /**
   * Adds a listener for the hide event, fired when the tooltip begins to hide.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Tooltip>> addHideListener(EventListener<HideEvent<Tooltip>> listener) {
    return addEventListener(HideEvent.class, listener);
  }

  /**
   * Adds a listener for the hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<HideEvent<Tooltip>> onHide(EventListener<HideEvent<Tooltip>> listener) {
    return addHideListener(listener);
  }

  /**
   * Adds a listener for the after-hide event, fired after the tooltip has hidden and all
   * animations are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Tooltip>> addAfterHideListener(
      EventListener<AfterHideEvent<Tooltip>> listener) {
    return addEventListener(AfterHideEvent.class, listener);
  }

  /**
   * Adds a listener for the after-hide event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterHideEvent<Tooltip>> onAfterHide(
      EventListener<AfterHideEvent<Tooltip>> listener) {
    return addAfterHideListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
