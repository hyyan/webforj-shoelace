package com.webforj.shoelace.components.drawer;

import com.google.gson.annotations.SerializedName;

/**
 * Placement options for the Drawer component, indicating the direction from which the drawer will
 * open.
 */
public enum DrawerPlacement {
  @SerializedName("top")
  TOP,

  @SerializedName("end")
  END,

  @SerializedName("bottom")
  BOTTOM,

  @SerializedName("start")
  START;
}
