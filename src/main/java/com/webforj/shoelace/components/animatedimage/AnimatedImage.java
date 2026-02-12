package com.webforj.shoelace.components.animatedimage;

import com.webforj.component.element.Element;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.PropertyDescriptor;
import com.webforj.component.element.annotation.NodeName;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.concern.HasClassName;
import com.webforj.concern.HasStyle;
import com.webforj.concern.HasVisibility;
import com.webforj.dispatcher.EventListener;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.shoelace.event.ErrorEvent;
import com.webforj.shoelace.event.LoadEvent;

/**
 * Shoelace Animated Image component ({@code <sl-animated-image>}).
 *
 * <p>A component for displaying animated GIFs and WEBPs that play and pause on interaction. The
 * image is frozen on the first frame when paused, providing a play/pause toggle for the user.</p>
 *
 * @see <a href="https://shoelace.style/components/animated-image">Shoelace Animated Image</a>
 */
@NodeName("sl-animated-image")
public final class AnimatedImage extends ElementComposite
    implements HasElementClickListener<AnimatedImage>, HasClassName<AnimatedImage>, HasStyle<AnimatedImage>, HasVisibility<AnimatedImage> {

  private final PropertyDescriptor<String> srcProp =
      PropertyDescriptor.property("src", "");
  private final PropertyDescriptor<String> altProp =
      PropertyDescriptor.property("alt", "");
  private final PropertyDescriptor<Boolean> playProp =
      PropertyDescriptor.property("play", false);

  /**
   * Creates a new AnimatedImage.
   */
  public AnimatedImage() {
    super();
  }

  /**
   * Creates a new AnimatedImage with the given source URL.
   *
   * @param src the path to the image to load
   */
  public AnimatedImage(String src) {
    this();
    setSrc(src);
  }

  /**
   * Creates a new AnimatedImage with the given source URL and alt text.
   *
   * @param src the path to the image to load
   * @param alt the description of the image for assistive devices
   */
  public AnimatedImage(String src, String alt) {
    this();
    setSrc(src);
    setAlt(alt);
  }

  /**
   * Gets the path to the image.
   *
   * @return the image source URL
   */
  public String getSrc() {
    return get(srcProp);
  }

  /**
   * Sets the path to the image to load.
   *
   * @param src the image source URL
   * @return this component
   */
  public AnimatedImage setSrc(String src) {
    set(srcProp, src);
    return this;
  }

  /**
   * Gets the description of the image used by assistive devices.
   *
   * @return the alt text
   */
  public String getAlt() {
    return get(altProp);
  }

  /**
   * Sets a description of the image used by assistive devices.
   *
   * @param alt the alt text
   * @return this component
   */
  public AnimatedImage setAlt(String alt) {
    set(altProp, alt);
    return this;
  }

  /**
   * Returns whether the animation is playing.
   *
   * @return {@code true} if the animation is playing
   */
  public boolean isPlay() {
    return get(playProp);
  }

  /**
   * Sets whether the animation is playing. When this attribute is removed, the animation will
   * pause.
   *
   * @param play {@code true} to play the animation
   * @return this component
   */
  public AnimatedImage setPlay(boolean play) {
    set(playProp, play);
    return this;
  }

  /**
   * Adds a listener for the load event, fired when the image loads successfully.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LoadEvent<AnimatedImage>> addLoadListener(EventListener<LoadEvent<AnimatedImage>> listener) {
    return addEventListener(LoadEvent.class, listener);
  }

  /**
   * Adds a listener for the load event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LoadEvent<AnimatedImage>> onLoad(EventListener<LoadEvent<AnimatedImage>> listener) {
    return addLoadListener(listener);
  }

  /**
   * Adds a listener for the error event, fired when the image fails to load.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent<AnimatedImage>> addErrorListener(EventListener<ErrorEvent<AnimatedImage>> listener) {
    return addEventListener(ErrorEvent.class, listener);
  }

  /**
   * Adds a listener for the error event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ErrorEvent<AnimatedImage>> onError(EventListener<ErrorEvent<AnimatedImage>> listener) {
    return addErrorListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
