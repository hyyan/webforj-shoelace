package com.webforj.shoelace.components.splitpanel;

import com.webforj.component.Component;
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
import com.webforj.shoelace.components.splitpanel.event.RepositionEvent;

/**
 * Shoelace SplitPanel component ({@code <sl-split-panel>}).
 *
 * <p>Split panels display two adjacent panels, allowing the user to reposition them by dragging
 * a divider between them. The component supports horizontal and vertical orientations, snap
 * points, and customizable divider styling.</p>
 *
 * @see <a href="https://shoelace.style/components/split-panel">Shoelace Split Panel</a>
 */
@NodeName("sl-split-panel")
public final class SplitPanel extends ElementCompositeContainer
    implements HasElementClickListener<SplitPanel>, HasClassName<SplitPanel>, HasStyle<SplitPanel>, HasVisibility<SplitPanel> {

  private static final String START_SLOT = "start";
  private static final String END_SLOT = "end";
  private static final String DIVIDER_SLOT = "divider";

  private final PropertyDescriptor<Integer> positionProp =
      PropertyDescriptor.property("position", 50);
  private final PropertyDescriptor<Integer> positionInPixelsProp =
      PropertyDescriptor.property("positionInPixels", 0);
  private final PropertyDescriptor<Boolean> verticalProp =
      PropertyDescriptor.property("vertical", false);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Primary> primaryProp =
      PropertyDescriptor.property("primary", Primary.START);
  private final PropertyDescriptor<String> snapProp =
      PropertyDescriptor.property("snap", "");
  private final PropertyDescriptor<Integer> snapThresholdProp =
      PropertyDescriptor.property("snapThreshold", 12);

  /**
   * Creates a new SplitPanel.
   */
  public SplitPanel() {
    super();
  }

  /**
   * Gets the current position of the divider from the primary panel's edge as a percentage
   * (0-100).
   *
   * @return the position percentage
   */
  public Integer getPosition() {
    return get(positionProp);
  }

  /**
   * Sets the position of the divider from the primary panel's edge as a percentage (0-100).
   * Defaults to 50% of the container's initial size.
   *
   * @param position the position percentage
   * @return this component
   */
  public SplitPanel setPosition(Integer position) {
    set(positionProp, position);
    return this;
  }

  /**
   * Gets the current position of the divider from the primary panel's edge in pixels.
   *
   * @return the position in pixels
   */
  public Integer getPositionInPixels() {
    return get(positionInPixelsProp);
  }

  /**
   * Sets the position of the divider from the primary panel's edge in pixels.
   *
   * @param positionInPixels the position in pixels
   * @return this component
   */
  public SplitPanel setPositionInPixels(Integer positionInPixels) {
    set(positionInPixelsProp, positionInPixels);
    return this;
  }

  /**
   * Returns whether the split panel is drawn in a vertical orientation.
   *
   * @return {@code true} if the split panel is vertical
   */
  public boolean isVertical() {
    return get(verticalProp);
  }

  /**
   * Sets whether the split panel is drawn in a vertical orientation with the start and end panels
   * stacked.
   *
   * @param vertical {@code true} to draw the split panel vertically
   * @return this component
   */
  public SplitPanel setVertical(boolean vertical) {
    set(verticalProp, vertical);
    return this;
  }

  /**
   * Returns whether resizing is disabled.
   *
   * @return {@code true} if resizing is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether resizing is disabled. Note that the position may still change as a result of
   * resizing the host element.
   *
   * @param disabled {@code true} to disable resizing
   * @return this component
   */
  public SplitPanel setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Gets the designated primary panel.
   *
   * @return the primary panel, or {@code null} if not set
   */
  public Primary getPrimary() {
    return get(primaryProp);
  }

  /**
   * Sets the primary panel. If no primary panel is designated, both panels will resize
   * proportionally when the host element is resized. If a primary panel is designated, it will
   * maintain its size and the other panel will grow or shrink as needed.
   *
   * @param primary the primary panel, or {@code null} to unset
   * @return this component
   */
  public SplitPanel setPrimary(Primary primary) {
    set(primaryProp, primary);
    return this;
  }

  /**
   * Gets the snap expression.
   *
   * @return the snap expression
   */
  public String getSnap() {
    return get(snapProp);
  }

  /**
   * Sets one or more space-separated values at which the divider should snap, in pixels,
   * percentages, or repeat expressions (e.g. {@code "100px 50% 500px"} or
   * {@code "repeat(50%) 10px"}).
   *
   * @param snap the snap expression
   * @return this component
   */
  public SplitPanel setSnap(String snap) {
    set(snapProp, snap);
    return this;
  }

  /**
   * Gets the snap threshold.
   *
   * @return the snap threshold in pixels
   */
  public Integer getSnapThreshold() {
    return get(snapThresholdProp);
  }

  /**
   * Sets how close the divider must be to a snap point until snapping occurs.
   *
   * @param snapThreshold the snap threshold in pixels
   * @return this component
   */
  public SplitPanel setSnapThreshold(Integer snapThreshold) {
    set(snapThresholdProp, snapThreshold);
    return this;
  }

  /**
   * Adds components to the start panel slot.
   *
   * @param components the components to add to the start panel
   * @return this component
   */
  public SplitPanel addToStart(Component... components) {
    getElement().add(START_SLOT, components);
    return this;
  }

  /**
   * Adds components to the end panel slot.
   *
   * @param components the components to add to the end panel
   * @return this component
   */
  public SplitPanel addToEnd(Component... components) {
    getElement().add(END_SLOT, components);
    return this;
  }

  /**
   * Adds components to the divider slot. Use this to customize the divider's appearance with
   * custom icons or other content.
   *
   * @param components the components to add to the divider
   * @return this component
   */
  public SplitPanel addToDivider(Component... components) {
    getElement().add(DIVIDER_SLOT, components);
    return this;
  }

  /**
   * Sets the width of the visible divider.
   *
   * @param value the CSS width value
   * @return this component
   */
  public SplitPanel setDividerWidth(String value) {
    setStyle("--divider-width", value);
    return this;
  }

  /**
   * Sets the invisible region around the divider where dragging can occur.
   *
   * @param value the CSS size value
   * @return this component
   */
  public SplitPanel setDividerHitArea(String value) {
    setStyle("--divider-hit-area", value);
    return this;
  }

  /**
   * Sets the minimum allowed size of the primary panel.
   *
   * @param value the CSS size value
   * @return this component
   */
  public SplitPanel setMin(String value) {
    setStyle("--min", value);
    return this;
  }

  /**
   * Sets the maximum allowed size of the primary panel.
   *
   * @param value the CSS size value
   * @return this component
   */
  public SplitPanel setMax(String value) {
    setStyle("--max", value);
    return this;
  }

  /**
   * Adds a listener for the reposition event, fired when the divider's position changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RepositionEvent<SplitPanel>> addRepositionListener(
      EventListener<RepositionEvent<SplitPanel>> listener) {
    return addEventListener(RepositionEvent.class, listener);
  }

  /**
   * Adds a listener for the reposition event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RepositionEvent<SplitPanel>> onReposition(
      EventListener<RepositionEvent<SplitPanel>> listener) {
    return addRepositionListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
