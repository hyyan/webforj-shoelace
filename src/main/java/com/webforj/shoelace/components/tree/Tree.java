package com.webforj.shoelace.components.tree;

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
import com.webforj.shoelace.components.tree.event.SelectionChangeEvent;

/**
 * Shoelace Tree component ({@code <sl-tree>}).
 *
 * <p>Trees allow you to display a hierarchical list of selectable tree items. Items with children
 * can be expanded and collapsed as desired by the user.</p>
 *
 * @see <a href="https://shoelace.style/components/tree">Shoelace Tree</a>
 */
@NodeName("sl-tree")
public final class Tree extends ElementCompositeContainer
    implements HasElementClickListener<Tree>, HasClassName<Tree>, HasStyle<Tree>, HasVisibility<Tree> {

  private static final String EXPAND_ICON_SLOT = "expand-icon";
  private static final String COLLAPSE_ICON_SLOT = "collapse-icon";

  private final PropertyDescriptor<Selection> selectionProp =
      PropertyDescriptor.property("selection", Selection.SINGLE);

  /**
   * Creates a new Tree.
   */
  public Tree() {
    super();
  }

  /**
   * Gets the selection behavior of the tree.
   *
   * @return the selection behavior
   */
  public Selection getSelection() {
    return get(selectionProp);
  }

  /**
   * Sets the selection behavior of the tree. Single selection allows only one node to be selected
   * at a time. Multiple displays checkboxes and allows more than one node to be selected. Leaf
   * allows only leaf nodes to be selected.
   *
   * @param selection the selection behavior
   * @return this component
   */
  public Tree setSelection(Selection selection) {
    set(selectionProp, selection);
    return this;
  }

  /**
   * Adds components to the expand-icon slot.
   *
   * @param components the components to add to the expand-icon slot
   * @return this component
   */
  public Tree addToExpandIcon(Component... components) {
    getElement().add(EXPAND_ICON_SLOT, components);
    return this;
  }

  /**
   * Adds components to the collapse-icon slot.
   *
   * @param components the components to add to the collapse-icon slot
   * @return this component
   */
  public Tree addToCollapseIcon(Component... components) {
    getElement().add(COLLAPSE_ICON_SLOT, components);
    return this;
  }

  /**
   * Adds a listener for the selection-change event, fired when a tree item is selected or
   * deselected.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<SelectionChangeEvent<Tree>> addSelectionChangeListener(
      EventListener<SelectionChangeEvent<Tree>> listener) {
    return addEventListener(SelectionChangeEvent.class, listener);
  }

  /**
   * Adds a listener for the selection-change event.
   *
   * @param listener the event listener
   * @return a registration for removing the listener
   */
  public ListenerRegistration<SelectionChangeEvent<Tree>> onSelectionChange(
      EventListener<SelectionChangeEvent<Tree>> listener) {
    return addSelectionChangeListener(listener);
  }

  Element getOriginalElement() {
    return getElement();
  }
}
