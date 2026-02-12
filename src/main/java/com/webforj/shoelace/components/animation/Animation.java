package com.webforj.shoelace.components.animation;

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
import com.webforj.shoelace.components.animation.event.CancelEvent;
import com.webforj.shoelace.components.animation.event.FinishEvent;
import com.webforj.shoelace.components.animation.event.StartEvent;

/**
 * Shoelace Animation component ({@code <sl-animation>}).
 *
 * <p>Animate any element by wrapping it with this component. Animations are based on the Web
 * Animations API and use Shoelace's built-in animation registry. Custom keyframes can also be
 * provided.</p>
 *
 * @see <a href="https://shoelace.style/components/animation">Shoelace Animation</a>
 */
@NodeName("sl-animation")
public final class Animation extends ElementCompositeContainer
    implements HasElementClickListener<Animation>, HasClassName<Animation>, HasStyle<Animation>, HasVisibility<Animation> {

  private final PropertyDescriptor<String> nameProp =
      PropertyDescriptor.property("name", "none");
  private final PropertyDescriptor<Boolean> playProp =
      PropertyDescriptor.property("play", false);
  private final PropertyDescriptor<Integer> delayProp =
      PropertyDescriptor.property("delay", 0);
  private final PropertyDescriptor<PlaybackDirection> directionProp =
      PropertyDescriptor.property("direction", PlaybackDirection.NORMAL);
  private final PropertyDescriptor<Integer> durationProp =
      PropertyDescriptor.property("duration", 1000);
  private final PropertyDescriptor<String> easingProp =
      PropertyDescriptor.property("easing", "linear");
  private final PropertyDescriptor<Integer> endDelayProp =
      PropertyDescriptor.property("endDelay", 0);
  private final PropertyDescriptor<FillMode> fillProp =
      PropertyDescriptor.property("fill", FillMode.AUTO);
  private final PropertyDescriptor<String> iterationsProp =
      PropertyDescriptor.property("iterations", "Infinity");
  private final PropertyDescriptor<Double> iterationStartProp =
      PropertyDescriptor.property("iterationStart", 0.0);
  private final PropertyDescriptor<Double> playbackRateProp =
      PropertyDescriptor.property("playbackRate", 1.0);

  /**
   * Creates a new Animation.
   */
  public Animation() {
    super();
  }

  /**
   * Gets the name of the built-in animation to use.
   *
   * @return the animation name
   */
  public String getName() {
    return get(nameProp);
  }

  /**
   * Sets the name of the built-in animation to use. For custom animations, use keyframes.
   *
   * @param name the animation name
   * @return this component
   */
  public Animation setName(String name) {
    set(nameProp, name);
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
   * Sets whether the animation is playing. When omitted, the animation will be paused. This
   * attribute will be automatically removed when the animation finishes or gets canceled.
   *
   * @param play {@code true} to play the animation
   * @return this component
   */
  public Animation setPlay(boolean play) {
    set(playProp, play);
    return this;
  }

  /**
   * Gets the number of milliseconds to delay the start of the animation.
   *
   * @return the delay in milliseconds
   */
  public int getDelay() {
    return get(delayProp);
  }

  /**
   * Sets the number of milliseconds to delay the start of the animation.
   *
   * @param delay the delay in milliseconds
   * @return this component
   */
  public Animation setDelay(int delay) {
    set(delayProp, delay);
    return this;
  }

  /**
   * Gets the direction of playback.
   *
   * @return the playback direction
   */
  public PlaybackDirection getDirection() {
    return get(directionProp);
  }

  /**
   * Sets the direction of playback as well as the behavior when reaching the end of an iteration.
   *
   * @param direction the playback direction
   * @return this component
   */
  public Animation setDirection(PlaybackDirection direction) {
    set(directionProp, direction);
    return this;
  }

  /**
   * Gets the number of milliseconds each iteration of the animation takes to complete.
   *
   * @return the duration in milliseconds
   */
  public int getDuration() {
    return get(durationProp);
  }

  /**
   * Sets the number of milliseconds each iteration of the animation takes to complete.
   *
   * @param duration the duration in milliseconds
   * @return this component
   */
  public Animation setDuration(int duration) {
    set(durationProp, duration);
    return this;
  }

  /**
   * Gets the easing function used for the animation.
   *
   * @return the easing function
   */
  public String getEasing() {
    return get(easingProp);
  }

  /**
   * Sets the easing function to use for the animation. This can be a Shoelace easing function or
   * a custom easing function such as {@code cubic-bezier(0, 1, .76, 1.14)}.
   *
   * @param easing the easing function
   * @return this component
   */
  public Animation setEasing(String easing) {
    set(easingProp, easing);
    return this;
  }

  /**
   * Gets the number of milliseconds to delay after the active period of an animation sequence.
   *
   * @return the end delay in milliseconds
   */
  public int getEndDelay() {
    return get(endDelayProp);
  }

  /**
   * Sets the number of milliseconds to delay after the active period of an animation sequence.
   *
   * @param endDelay the end delay in milliseconds
   * @return this component
   */
  public Animation setEndDelay(int endDelay) {
    set(endDelayProp, endDelay);
    return this;
  }

  /**
   * Gets how the animation applies styles to its target before and after its execution.
   *
   * @return the fill mode
   */
  public FillMode getFill() {
    return get(fillProp);
  }

  /**
   * Sets how the animation applies styles to its target before and after its execution.
   *
   * @param fill the fill mode
   * @return this component
   */
  public Animation setFill(FillMode fill) {
    set(fillProp, fill);
    return this;
  }

  /**
   * Gets the number of iterations to run before the animation completes.
   *
   * @return the iterations value
   */
  public String getIterations() {
    return get(iterationsProp);
  }

  /**
   * Sets the number of iterations to run before the animation completes. Defaults to
   * {@code Infinity}, which loops.
   *
   * @param iterations the number of iterations
   * @return this component
   */
  public Animation setIterations(String iterations) {
    set(iterationsProp, iterations);
    return this;
  }

  /**
   * Gets the offset at which to start the animation.
   *
   * @return the iteration start offset
   */
  public double getIterationStart() {
    return get(iterationStartProp);
  }

  /**
   * Sets the offset at which to start the animation, usually between 0 (start) and 1 (end).
   *
   * @param iterationStart the iteration start offset
   * @return this component
   */
  public Animation setIterationStart(double iterationStart) {
    set(iterationStartProp, iterationStart);
    return this;
  }

  /**
   * Gets the animation's playback rate.
   *
   * @return the playback rate
   */
  public double getPlaybackRate() {
    return get(playbackRateProp);
  }

  /**
   * Sets the animation's playback rate. The default is {@code 1}, which plays the animation at a
   * normal speed. Setting this to {@code 2}, for example, will double the animation's speed. A
   * negative value can be used to reverse the animation.
   *
   * @param playbackRate the playback rate
   * @return this component
   */
  public Animation setPlaybackRate(double playbackRate) {
    set(playbackRateProp, playbackRate);
    return this;
  }

  /**
   * Clears all keyframe effects caused by this animation and aborts its playback.
   */
  public void cancel() {
    getOriginalElement().callJsFunctionVoidAsync("cancel");
  }

  /**
   * Sets the playback time to the end of the animation corresponding to the current playback
   * direction.
   */
  public void finish() {
    getOriginalElement().callJsFunctionVoidAsync("finish");
  }

  /**
   * Adds a listener for the cancel event, fired when the animation is canceled.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CancelEvent<Animation>> addCancelListener(
      EventListener<CancelEvent<Animation>> listener) {
    return addEventListener(CancelEvent.class, listener);
  }

  /**
   * Adds a listener for the cancel event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CancelEvent<Animation>> onCancel(EventListener<CancelEvent<Animation>> listener) {
    return addCancelListener(listener);
  }

  /**
   * Adds a listener for the finish event, fired when the animation finishes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FinishEvent<Animation>> addFinishListener(
      EventListener<FinishEvent<Animation>> listener) {
    return addEventListener(FinishEvent.class, listener);
  }

  /**
   * Adds a listener for the finish event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<FinishEvent<Animation>> onFinish(EventListener<FinishEvent<Animation>> listener) {
    return addFinishListener(listener);
  }

  /**
   * Adds a listener for the start event, fired when the animation starts or restarts.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<StartEvent<Animation>> addStartListener(
      EventListener<StartEvent<Animation>> listener) {
    return addEventListener(StartEvent.class, listener);
  }

  /**
   * Adds a listener for the start event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<StartEvent<Animation>> onStart(EventListener<StartEvent<Animation>> listener) {
    return addStartListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
