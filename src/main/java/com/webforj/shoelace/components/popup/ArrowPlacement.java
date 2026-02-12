package com.webforj.shoelace.components.popup;

import com.google.gson.annotations.SerializedName;

/**
 * Arrow placement options for the Popup component.
 */
public enum ArrowPlacement {
  @SerializedName("start")
  START,

  @SerializedName("end")
  END,

  @SerializedName("center")
  CENTER,

  @SerializedName("anchor")
  ANCHOR;
}
