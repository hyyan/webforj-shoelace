package com.webforj.shoelace.components.tabgroup;

import com.google.gson.annotations.SerializedName;

/**
 * Placement options for the TabGroup component. Controls where tabs are positioned relative to
 * the tab panels.
 */
public enum Placement {
  @SerializedName("top")
  TOP,

  @SerializedName("bottom")
  BOTTOM,

  @SerializedName("start")
  START,

  @SerializedName("end")
  END;
}
