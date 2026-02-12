package com.webforj.shoelace.components.animation;

import com.google.gson.annotations.SerializedName;

/**
 * Fill mode options for the Animation component.
 */
public enum FillMode {
  @SerializedName("auto")
  AUTO,

  @SerializedName("none")
  NONE,

  @SerializedName("forwards")
  FORWARDS,

  @SerializedName("backwards")
  BACKWARDS,

  @SerializedName("both")
  BOTH;
}
