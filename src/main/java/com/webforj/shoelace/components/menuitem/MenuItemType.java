package com.webforj.shoelace.components.menuitem;

import com.google.gson.annotations.SerializedName;

/**
 * The type of menu item to render.
 */
public enum MenuItemType {
  @SerializedName("normal")
  NORMAL,

  @SerializedName("checkbox")
  CHECKBOX;
}
