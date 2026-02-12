package com.webforj.shoelace.components.button;

import com.google.gson.annotations.SerializedName;

/**
 * The target attribute for buttons rendered as links.
 */
public enum Target {
  @SerializedName("_blank")
  BLANK,

  @SerializedName("_parent")
  PARENT,

  @SerializedName("_self")
  SELF,

  @SerializedName("_top")
  TOP;
}
