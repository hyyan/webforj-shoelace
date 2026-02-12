package com.webforj.shoelace.components.treeitem;

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
import com.webforj.shoelace.components.treeitem.event.AfterCollapseEvent;
import com.webforj.shoelace.components.treeitem.event.AfterExpandEvent;
import com.webforj.shoelace.components.treeitem.event.CollapseEvent;
import com.webforj.shoelace.components.treeitem.event.ExpandEvent;
import com.webforj.shoelace.components.treeitem.event.LazyChangeEvent;

/**
 * Shoelace TreeItem component ({@code <sl-tree-item>}).
 *
 * <p>A tree item serves as a hierarchical node that lives inside a tree. Tree items can be nested
 * to create branches, and can optionally be expanded and collapsed.</p>
 *
 * @see <a href="https://shoelace.style/components/tree-item">Shoelace Tree Item</a>
 */
@NodeName("sl-tree-item")
public final class TreeItem extends ElementCompositeContainer
    implements HasElementClickListener<TreeItem>, HasClassName<TreeItem>, HasStyle<TreeItem>, HasVisibility<TreeItem> {

  private static final String EXPAND_ICON_SLOT = "expand-icon";
  private static final String COLLAPSE_ICON_SLOT = "collapse-icon";

  private final PropertyDescriptor<Boolean> expandedProp =
      PropertyDescriptor.property("expanded", false);
  private final PropertyDescriptor<Boolean> selectedProp =
      PropertyDescriptor.property("selected", false);
  private final PropertyDescriptor<Boolean> disabledProp =
      PropertyDescriptor.property("disabled", false);
  private final PropertyDescriptor<Boolean> lazyProp =
      PropertyDescriptor.property("lazy", false);

  /**
   * Creates a new TreeItem.
   */
  public TreeItem() {
    super();
  }

  /**
   * Returns whether the tree item is expanded.
   *
   * @return {@code true} if the tree item is expanded
   */
  public boolean isExpanded() {
    return get(expandedProp);
  }

  /**
   * Sets whether the tree item is expanded.
   *
   * @param expanded {@code true} to expand the tree item
   * @return this component
   */
  public TreeItem setExpanded(boolean expanded) {
    set(expandedProp, expanded);
    return this;
  }

  /**
   * Returns whether the tree item is selected.
   *
   * @return {@code true} if the tree item is selected
   */
  public boolean isSelected() {
    return get(selectedProp);
  }

  /**
   * Sets whether the tree item is drawn in a selected state.
   *
   * @param selected {@code true} to select the tree item
   * @return this component
   */
  public TreeItem setSelected(boolean selected) {
    set(selectedProp, selected);
    return this;
  }

  /**
   * Returns whether the tree item is disabled.
   *
   * @return {@code true} if the tree item is disabled
   */
  public boolean isDisabled() {
    return get(disabledProp);
  }

  /**
   * Sets whether the tree item is disabled.
   *
   * @param disabled {@code true} to disable the tree item
   * @return this component
   */
  public TreeItem setDisabled(boolean disabled) {
    set(disabledProp, disabled);
    return this;
  }

  /**
   * Returns whether lazy loading behavior is enabled.
   *
   * @return {@code true} if lazy loading is enabled
   */
  public boolean isLazy() {
    return get(lazyProp);
  }

  /**
   * Sets whether lazy loading behavior is enabled. When enabled, the tree item will display a
   * loading spinner when expanded and emit a lazy-load event.
   *
   * @param lazy {@code true} to enable lazy loading
   * @return this component
   */
  public TreeItem setLazy(boolean lazy) {
    set(lazyProp, lazy);
    return this;
  }

  /**
   * Adds components to the expand-icon slot.
   *
   * @param components the components to add to the expand-icon slot
   * @return this component
   */
  public TreeItem addToExpandIcon(Component... components) {
    getElement().add(EXPAND_ICON_SLOT, components);
    return this;
  }

  /**
   * Adds components to the collapse-icon slot.
   *
   * @param components the components to add to the collapse-icon slot
   * @return this component
   */
  public TreeItem addToCollapseIcon(Component... components) {
    getElement().add(COLLAPSE_ICON_SLOT, components);
    return this;
  }

  /**
   * Adds a listener for the expand event, fired when the tree item expands.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ExpandEvent<TreeItem>> addExpandListener(
      EventListener<ExpandEvent<TreeItem>> listener) {
    return addEventListener(ExpandEvent.class, listener);
  }

  /**
   * Adds a listener for the expand event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<ExpandEvent<TreeItem>> onExpand(EventListener<ExpandEvent<TreeItem>> listener) {
    return addExpandListener(listener);
  }

  /**
   * Adds a listener for the after-expand event, fired after the tree item expands and all
   * animations are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterExpandEvent<TreeItem>> addAfterExpandListener(
      EventListener<AfterExpandEvent<TreeItem>> listener) {
    return addEventListener(AfterExpandEvent.class, listener);
  }

  /**
   * Adds a listener for the after-expand event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterExpandEvent<TreeItem>> onAfterExpand(
      EventListener<AfterExpandEvent<TreeItem>> listener) {
    return addAfterExpandListener(listener);
  }

  /**
   * Adds a listener for the collapse event, fired when the tree item collapses.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CollapseEvent<TreeItem>> addCollapseListener(
      EventListener<CollapseEvent<TreeItem>> listener) {
    return addEventListener(CollapseEvent.class, listener);
  }

  /**
   * Adds a listener for the collapse event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<CollapseEvent<TreeItem>> onCollapse(EventListener<CollapseEvent<TreeItem>> listener) {
    return addCollapseListener(listener);
  }

  /**
   * Adds a listener for the after-collapse event, fired after the tree item collapses and all
   * animations are complete.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterCollapseEvent<TreeItem>> addAfterCollapseListener(
      EventListener<AfterCollapseEvent<TreeItem>> listener) {
    return addEventListener(AfterCollapseEvent.class, listener);
  }

  /**
   * Adds a listener for the after-collapse event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<AfterCollapseEvent<TreeItem>> onAfterCollapse(
      EventListener<AfterCollapseEvent<TreeItem>> listener) {
    return addAfterCollapseListener(listener);
  }

  /**
   * Adds a listener for the lazy-change event, fired when the tree item's lazy state changes.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LazyChangeEvent<TreeItem>> addLazyChangeListener(
      EventListener<LazyChangeEvent<TreeItem>> listener) {
    return addEventListener(LazyChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the lazy-change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<LazyChangeEvent<TreeItem>> onLazyChange(
      EventListener<LazyChangeEvent<TreeItem>> listener) {
    return addLazyChangeListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
