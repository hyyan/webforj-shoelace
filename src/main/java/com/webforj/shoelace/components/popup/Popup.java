package com.webforj.shoelace.components.popup;

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
import com.webforj.shoelace.Placement;
import com.webforj.shoelace.components.popup.event.RepositionEvent;

/**
 * Shoelace Popup component ({@code <sl-popup>}).
 *
 * <p>Popup is a utility component that lets you declaratively anchor "popup" containers to another
 * element. It uses the Floating UI library for positioning and can be used as a building block for
 * tooltips, dropdowns, and similar components.</p>
 *
 * @see <a href="https://shoelace.style/components/popup">Shoelace Popup</a>
 */
@NodeName("sl-popup")
public final class Popup extends ElementCompositeContainer
    implements HasElementClickListener<Popup>, HasClassName<Popup>, HasStyle<Popup>, HasVisibility<Popup> {

  private static final String ANCHOR_SLOT = "anchor";

  private final PropertyDescriptor<String> anchorProp =
      PropertyDescriptor.property("anchor", "");
  private final PropertyDescriptor<Boolean> activeProp =
      PropertyDescriptor.property("active", false);
  private final PropertyDescriptor<Placement> placementProp =
      PropertyDescriptor.property("placement", Placement.TOP);
  private final PropertyDescriptor<PopupStrategy> strategyProp =
      PropertyDescriptor.property("strategy", PopupStrategy.ABSOLUTE);
  private final PropertyDescriptor<Integer> distanceProp =
      PropertyDescriptor.property("distance", 0);
  private final PropertyDescriptor<Integer> skiddingProp =
      PropertyDescriptor.property("skidding", 0);
  private final PropertyDescriptor<Boolean> arrowProp =
      PropertyDescriptor.property("arrow", false);
  private final PropertyDescriptor<ArrowPlacement> arrowPlacementProp =
      PropertyDescriptor.property("arrowPlacement", ArrowPlacement.ANCHOR);
  private final PropertyDescriptor<Integer> arrowPaddingProp =
      PropertyDescriptor.property("arrowPadding", 10);
  private final PropertyDescriptor<Boolean> flipProp =
      PropertyDescriptor.property("flip", false);
  private final PropertyDescriptor<String> flipFallbackPlacementsProp =
      PropertyDescriptor.property("flipFallbackPlacements", "");
  private final PropertyDescriptor<FlipFallbackStrategy> flipFallbackStrategyProp =
      PropertyDescriptor.property("flipFallbackStrategy", FlipFallbackStrategy.BEST_FIT);
  private final PropertyDescriptor<Integer> flipPaddingProp =
      PropertyDescriptor.property("flipPadding", 0);
  private final PropertyDescriptor<Boolean> shiftProp =
      PropertyDescriptor.property("shift", false);
  private final PropertyDescriptor<Integer> shiftPaddingProp =
      PropertyDescriptor.property("shiftPadding", 0);
  private final PropertyDescriptor<String> autoSizeProp =
      PropertyDescriptor.property("autoSize", "");
  private final PropertyDescriptor<String> syncProp =
      PropertyDescriptor.property("sync", "");
  private final PropertyDescriptor<Integer> autoSizePaddingProp =
      PropertyDescriptor.property("autoSizePadding", 0);
  private final PropertyDescriptor<Boolean> hoverBridgeProp =
      PropertyDescriptor.property("hoverBridge", false);

  /**
   * Creates a new Popup.
   */
  public Popup() {
    super();
  }

  /**
   * Gets the anchor element ID or reference.
   *
   * @return the anchor
   */
  public String getAnchor() {
    return get(anchorProp);
  }

  /**
   * Sets the element the popup will be anchored to. If the anchor lives outside of the popup, you
   * can provide the anchor element {@code id}. If the anchor lives inside the popup, use the
   * {@code anchor} slot instead.
   *
   * @param anchor the anchor element ID
   * @return this component
   */
  public Popup setAnchor(String anchor) {
    set(anchorProp, anchor);
    return this;
  }

  /**
   * Returns whether the popup is active.
   *
   * @return {@code true} if the popup is active
   */
  public boolean isActive() {
    return get(activeProp);
  }

  /**
   * Sets whether the popup is active. Activates the positioning logic and shows the popup. When
   * this attribute is removed, the positioning logic is torn down and the popup will be hidden.
   *
   * @param active {@code true} to activate the popup
   * @return this component
   */
  public Popup setActive(boolean active) {
    set(activeProp, active);
    return this;
  }

  /**
   * Gets the preferred placement of the popup.
   *
   * @return the placement
   */
  public Placement getPlacement() {
    return get(placementProp);
  }

  /**
   * Sets the preferred placement of the popup. Note that the actual placement will vary as
   * configured to keep the panel inside of the viewport.
   *
   * @param placement the placement
   * @return this component
   */
  public Popup setPlacement(Placement placement) {
    set(placementProp, placement);
    return this;
  }

  /**
   * Gets the positioning strategy.
   *
   * @return the strategy
   */
  public PopupStrategy getStrategy() {
    return get(strategyProp);
  }

  /**
   * Sets the positioning strategy. The {@code absolute} strategy works well in most cases, but if
   * overflow is clipped, using a {@code fixed} position strategy can often workaround it.
   *
   * @param strategy the strategy
   * @return this component
   */
  public Popup setStrategy(PopupStrategy strategy) {
    set(strategyProp, strategy);
    return this;
  }

  /**
   * Gets the distance in pixels from which to offset the panel away from its anchor.
   *
   * @return the distance in pixels
   */
  public int getDistance() {
    return get(distanceProp);
  }

  /**
   * Sets the distance in pixels from which to offset the panel away from its anchor.
   *
   * @param distance the distance in pixels
   * @return this component
   */
  public Popup setDistance(int distance) {
    set(distanceProp, distance);
    return this;
  }

  /**
   * Gets the distance in pixels from which to offset the panel along its anchor.
   *
   * @return the skidding in pixels
   */
  public int getSkidding() {
    return get(skiddingProp);
  }

  /**
   * Sets the distance in pixels from which to offset the panel along its anchor.
   *
   * @param skidding the skidding in pixels
   * @return this component
   */
  public Popup setSkidding(int skidding) {
    set(skiddingProp, skidding);
    return this;
  }

  /**
   * Returns whether the arrow is shown.
   *
   * @return {@code true} if the arrow is shown
   */
  public boolean isArrow() {
    return get(arrowProp);
  }

  /**
   * Sets whether to attach an arrow to the popup. The arrow's size and color can be customized
   * using the {@code --arrow-size} and {@code --arrow-color} custom properties.
   *
   * @param arrow {@code true} to show the arrow
   * @return this component
   */
  public Popup setArrow(boolean arrow) {
    set(arrowProp, arrow);
    return this;
  }

  /**
   * Gets the arrow placement.
   *
   * @return the arrow placement
   */
  public ArrowPlacement getArrowPlacement() {
    return get(arrowPlacementProp);
  }

  /**
   * Sets the placement of the arrow. The default is {@code anchor}, which will align the arrow as
   * close to the center of the anchor as possible. A value of {@code start}, {@code end}, or
   * {@code center} will align the arrow to the start, end, or center of the popover instead.
   *
   * @param arrowPlacement the arrow placement
   * @return this component
   */
  public Popup setArrowPlacement(ArrowPlacement arrowPlacement) {
    set(arrowPlacementProp, arrowPlacement);
    return this;
  }

  /**
   * Gets the arrow padding in pixels.
   *
   * @return the arrow padding
   */
  public int getArrowPadding() {
    return get(arrowPaddingProp);
  }

  /**
   * Sets the amount of padding between the arrow and the edges of the popup. If the popup has a
   * border-radius, this will prevent it from overflowing the corners.
   *
   * @param arrowPadding the arrow padding in pixels
   * @return this component
   */
  public Popup setArrowPadding(int arrowPadding) {
    set(arrowPaddingProp, arrowPadding);
    return this;
  }

  /**
   * Returns whether flip is enabled.
   *
   * @return {@code true} if flip is enabled
   */
  public boolean isFlip() {
    return get(flipProp);
  }

  /**
   * Sets whether to flip the placement to the opposite site to keep it in view. You can use
   * {@link #setFlipFallbackPlacements(String)} to further configure the fallback placement.
   *
   * @param flip {@code true} to enable flipping
   * @return this component
   */
  public Popup setFlip(boolean flip) {
    set(flipProp, flip);
    return this;
  }

  /**
   * Gets the flip fallback placements.
   *
   * @return the flip fallback placements
   */
  public String getFlipFallbackPlacements() {
    return get(flipFallbackPlacementsProp);
  }

  /**
   * Sets the fallback placements to try if the preferred placement doesn't fit. Must be a string
   * of any number of placements separated by a space, e.g. "top bottom left".
   *
   * @param flipFallbackPlacements the fallback placements
   * @return this component
   */
  public Popup setFlipFallbackPlacements(String flipFallbackPlacements) {
    set(flipFallbackPlacementsProp, flipFallbackPlacements);
    return this;
  }

  /**
   * Gets the flip fallback strategy.
   *
   * @return the flip fallback strategy
   */
  public FlipFallbackStrategy getFlipFallbackStrategy() {
    return get(flipFallbackStrategyProp);
  }

  /**
   * Sets the flip fallback strategy. When neither the preferred placement nor the fallback
   * placements fit, this value determines whether the popup should be positioned using the best
   * available fit or as it was initially preferred.
   *
   * @param flipFallbackStrategy the flip fallback strategy
   * @return this component
   */
  public Popup setFlipFallbackStrategy(FlipFallbackStrategy flipFallbackStrategy) {
    set(flipFallbackStrategyProp, flipFallbackStrategy);
    return this;
  }

  /**
   * Gets the flip padding in pixels.
   *
   * @return the flip padding
   */
  public int getFlipPadding() {
    return get(flipPaddingProp);
  }

  /**
   * Sets the amount of padding, in pixels, to exceed before the flip behavior will occur.
   *
   * @param flipPadding the flip padding in pixels
   * @return this component
   */
  public Popup setFlipPadding(int flipPadding) {
    set(flipPaddingProp, flipPadding);
    return this;
  }

  /**
   * Returns whether shift is enabled.
   *
   * @return {@code true} if shift is enabled
   */
  public boolean isShift() {
    return get(shiftProp);
  }

  /**
   * Sets whether to move the popup along the axis to keep it in view when clipped.
   *
   * @param shift {@code true} to enable shifting
   * @return this component
   */
  public Popup setShift(boolean shift) {
    set(shiftProp, shift);
    return this;
  }

  /**
   * Gets the shift padding in pixels.
   *
   * @return the shift padding
   */
  public int getShiftPadding() {
    return get(shiftPaddingProp);
  }

  /**
   * Sets the amount of padding, in pixels, to exceed before the shift behavior will occur.
   *
   * @param shiftPadding the shift padding in pixels
   * @return this component
   */
  public Popup setShiftPadding(int shiftPadding) {
    set(shiftPaddingProp, shiftPadding);
    return this;
  }

  /**
   * Gets the auto-size mode.
   *
   * @return the auto-size value
   */
  public String getAutoSize() {
    return get(autoSizeProp);
  }

  /**
   * Sets the auto-size mode. When set, this will cause the popup to automatically resize itself to
   * prevent it from overflowing.
   *
   * @param autoSize the auto-size value (e.g. "horizontal", "vertical", "both", or empty string
   *     for none)
   * @return this component
   */
  public Popup setAutoSize(String autoSize) {
    set(autoSizeProp, autoSize);
    return this;
  }

  /**
   * Sets the auto-size mode using a typed enum value.
   *
   * @param autoSize the auto-size option
   * @return this component
   */
  public Popup setAutoSize(AutoSize autoSize) {
    if (autoSize == null) {
      return setAutoSize("");
    }
    return setAutoSize(autoSize.name().toLowerCase().replace("_", "-"));
  }

  /**
   * Gets the sync mode.
   *
   * @return the sync value
   */
  public String getSync() {
    return get(syncProp);
  }

  /**
   * Sets the sync mode. Syncs the popup's width or height to that of the anchor element.
   *
   * @param sync the sync value (e.g. "width", "height", "both", or empty string for none)
   * @return this component
   */
  public Popup setSync(String sync) {
    set(syncProp, sync);
    return this;
  }

  /**
   * Gets the auto-size padding in pixels.
   *
   * @return the auto-size padding
   */
  public int getAutoSizePadding() {
    return get(autoSizePaddingProp);
  }

  /**
   * Sets the amount of padding, in pixels, to exceed before the auto-size behavior will occur.
   *
   * @param autoSizePadding the auto-size padding in pixels
   * @return this component
   */
  public Popup setAutoSizePadding(int autoSizePadding) {
    set(autoSizePaddingProp, autoSizePadding);
    return this;
  }

  /**
   * Returns whether the hover bridge is enabled.
   *
   * @return {@code true} if hover bridge is enabled
   */
  public boolean isHoverBridge() {
    return get(hoverBridgeProp);
  }

  /**
   * Sets whether to enable the hover bridge. When a gap exists between the anchor and the popup
   * element, this option will add a "hover bridge" that fills the gap using an invisible element.
   * This makes listening for events such as {@code mouseenter} and {@code mouseleave} more sane
   * because the pointer never technically leaves the element.
   *
   * @param hoverBridge {@code true} to enable the hover bridge
   * @return this component
   */
  public Popup setHoverBridge(boolean hoverBridge) {
    set(hoverBridgeProp, hoverBridge);
    return this;
  }

  /**
   * Adds components to the anchor slot. When the anchor is slotted inside the popup, the
   * {@code anchor} attribute is not required.
   *
   * @param components the components to add to the anchor slot
   * @return this component
   */
  public Popup addToAnchor(Component... components) {
    getElement().add(ANCHOR_SLOT, components);
    return this;
  }

  /**
   * Forces the popup to recalculate and reposition itself.
   */
  public void reposition() {
    getOriginalElement().callJsFunctionVoidAsync("reposition");
  }

  /**
   * Adds a listener for the reposition event, fired when the popup is repositioned.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RepositionEvent<Popup>> addRepositionListener(
      EventListener<RepositionEvent<Popup>> listener) {
    return addEventListener(RepositionEvent.class, listener);
  }

  /**
   * Adds a listener for the reposition event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<RepositionEvent<Popup>> onReposition(
      EventListener<RepositionEvent<Popup>> listener) {
    return addRepositionListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
