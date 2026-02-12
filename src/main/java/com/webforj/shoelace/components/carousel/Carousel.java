package com.webforj.shoelace.components.carousel;

import com.webforj.component.Component;
import com.webforj.component.element.Element;
import com.webforj.component.element.ElementCompositeContainer;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.shoelace.components.carousel.event.SlideChangeEvent;

/**
 * Shoelace Carousel component ({@code <sl-carousel>}).
 *
 * <p>Carousels display an arbitrary number of content slides along a horizontal or vertical axis.
 * They support navigation, pagination, autoplay, and mouse dragging.</p>
 *
 * @see <a href="https://shoelace.style/components/carousel">Shoelace Carousel</a>
 */
@NodeName("sl-carousel")
public final class Carousel extends ElementCompositeContainer
    implements HasElementClickListener<Carousel>, HasClassName<Carousel>, HasStyle<Carousel> {

  // Slot constants
  private static final String NEXT_ICON_SLOT = "next-icon";
  private static final String PREVIOUS_ICON_SLOT = "previous-icon";

  // Property descriptors
  private final PropertyDescriptor<Boolean> loopProp =
      PropertyDescriptor.property("loop", false);
  private final PropertyDescriptor<Boolean> navigationProp =
      PropertyDescriptor.property("navigation", false);
  private final PropertyDescriptor<Boolean> paginationProp =
      PropertyDescriptor.property("pagination", false);
  private final PropertyDescriptor<Boolean> autoplayProp =
      PropertyDescriptor.property("autoplay", false);
  private final PropertyDescriptor<Integer> autoplayIntervalProp =
      PropertyDescriptor.property("autoplayInterval", 3000);
  private final PropertyDescriptor<Integer> slidesPerPageProp =
      PropertyDescriptor.property("slidesPerPage", 1);
  private final PropertyDescriptor<Integer> slidesPerMoveProp =
      PropertyDescriptor.property("slidesPerMove", 1);
  private final PropertyDescriptor<CarouselOrientation> orientationProp =
      PropertyDescriptor.property("orientation", CarouselOrientation.HORIZONTAL);
  private final PropertyDescriptor<Boolean> mouseDraggingProp =
      PropertyDescriptor.property("mouseDragging", false);

  /**
   * Creates a new Carousel.
   */
  public Carousel() {
    super();
  }

  /**
   * Returns whether the carousel loops indefinitely.
   *
   * @return {@code true} if the carousel loops
   */
  public boolean isLoop() {
    return get(loopProp);
  }

  /**
   * Sets whether the user can navigate the carousel in the same direction indefinitely.
   *
   * @param loop {@code true} to enable looping
   * @return this component
   */
  public Carousel setLoop(boolean loop) {
    set(loopProp, loop);
    return this;
  }

  /**
   * Returns whether the carousel navigation is shown.
   *
   * @return {@code true} if navigation is shown
   */
  public boolean isNavigation() {
    return get(navigationProp);
  }

  /**
   * Sets whether to show the carousel's navigation.
   *
   * @param navigation {@code true} to show navigation
   * @return this component
   */
  public Carousel setNavigation(boolean navigation) {
    set(navigationProp, navigation);
    return this;
  }

  /**
   * Returns whether the carousel pagination indicators are shown.
   *
   * @return {@code true} if pagination is shown
   */
  public boolean isPagination() {
    return get(paginationProp);
  }

  /**
   * Sets whether to show the carousel's pagination indicators.
   *
   * @param pagination {@code true} to show pagination
   * @return this component
   */
  public Carousel setPagination(boolean pagination) {
    set(paginationProp, pagination);
    return this;
  }

  /**
   * Returns whether autoplay is enabled.
   *
   * @return {@code true} if autoplay is enabled
   */
  public boolean isAutoplay() {
    return get(autoplayProp);
  }

  /**
   * Sets whether the slides will scroll automatically when the user is not interacting with them.
   *
   * @param autoplay {@code true} to enable autoplay
   * @return this component
   */
  public Carousel setAutoplay(boolean autoplay) {
    set(autoplayProp, autoplay);
    return this;
  }

  /**
   * Gets the autoplay interval in milliseconds.
   *
   * @return the autoplay interval
   */
  public Integer getAutoplayInterval() {
    return get(autoplayIntervalProp);
  }

  /**
   * Sets the amount of time, in milliseconds, between each automatic scroll.
   *
   * @param autoplayInterval the autoplay interval in milliseconds
   * @return this component
   */
  public Carousel setAutoplayInterval(Integer autoplayInterval) {
    set(autoplayIntervalProp, autoplayInterval);
    return this;
  }

  /**
   * Gets the number of slides shown at a given time.
   *
   * @return the number of slides per page
   */
  public Integer getSlidesPerPage() {
    return get(slidesPerPageProp);
  }

  /**
   * Sets how many slides should be shown at a given time.
   *
   * @param slidesPerPage the number of slides per page
   * @return this component
   */
  public Carousel setSlidesPerPage(Integer slidesPerPage) {
    set(slidesPerPageProp, slidesPerPage);
    return this;
  }

  /**
   * Gets the number of slides the carousel advances when scrolling.
   *
   * @return the number of slides per move
   */
  public Integer getSlidesPerMove() {
    return get(slidesPerMoveProp);
  }

  /**
   * Sets the number of slides the carousel will advance when scrolling. Useful when specifying a
   * {@code slidesPerPage} greater than one. It cannot be higher than {@code slidesPerPage}.
   *
   * @param slidesPerMove the number of slides per move
   * @return this component
   */
  public Carousel setSlidesPerMove(Integer slidesPerMove) {
    set(slidesPerMoveProp, slidesPerMove);
    return this;
  }

  /**
   * Gets the carousel orientation.
   *
   * @return the orientation
   */
  public CarouselOrientation getOrientation() {
    return get(orientationProp);
  }

  /**
   * Sets the orientation in which the carousel will lay out.
   *
   * @param orientation the orientation
   * @return this component
   */
  public Carousel setOrientation(CarouselOrientation orientation) {
    set(orientationProp, orientation);
    return this;
  }

  /**
   * Returns whether mouse dragging is enabled.
   *
   * @return {@code true} if mouse dragging is enabled
   */
  public boolean isMouseDragging() {
    return get(mouseDraggingProp);
  }

  /**
   * Sets whether it is possible to scroll through the slides by dragging them with the mouse.
   *
   * @param mouseDragging {@code true} to enable mouse dragging
   * @return this component
   */
  public Carousel setMouseDragging(boolean mouseDragging) {
    set(mouseDraggingProp, mouseDragging);
    return this;
  }

  /**
   * Adds components to the next-icon slot.
   *
   * @param components the components to add to the next-icon slot
   * @return this component
   */
  public Carousel addToNextIcon(Component... components) {
    getElement().add(NEXT_ICON_SLOT, components);
    return this;
  }

  /**
   * Adds components to the previous-icon slot.
   *
   * @param components the components to add to the previous-icon slot
   * @return this component
   */
  public Carousel addToPreviousIcon(Component... components) {
    getElement().add(PREVIOUS_ICON_SLOT, components);
    return this;
  }

  /**
   * Moves the carousel backward by {@code slides-per-move} slides.
   */
  public void previous() {
    getOriginalElement().callJsFunctionVoidAsync("previous");
  }

  /**
   * Moves the carousel forward by {@code slides-per-move} slides.
   */
  public void next() {
    getOriginalElement().callJsFunctionVoidAsync("next");
  }

  /**
   * Scrolls the carousel to the slide specified by the given index.
   *
   * @param index the zero-based index of the slide to navigate to
   */
  public void goToSlide(int index) {
    getOriginalElement().callJsFunctionVoidAsync("goToSlide", index);
  }

  /**
   * Adds a listener for the slide change event, fired when the active slide changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<SlideChangeEvent<Carousel>> addSlideChangeListener(
      EventListener<SlideChangeEvent<Carousel>> listener) {
    return addEventListener(SlideChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the slide change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<SlideChangeEvent<Carousel>> onSlideChange(
      EventListener<SlideChangeEvent<Carousel>> listener) {
    return addSlideChangeListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
