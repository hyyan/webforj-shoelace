package com.webforj.shoelace.components.button;

import com.google.gson.annotations.SerializedName;

/**
 * The button's theme variant.
 */
public enum Variant {
  @SerializedName("default")
  DEFAULT,

  @SerializedName("primary")
  PRIMARY,

  @SerializedName("success")
  SUCCESS,

  @SerializedName("neutral")
  NEUTRAL,

  @SerializedName("warning")
  WARNING,

  @SerializedName("danger")
  DANGER,

  @SerializedName("text")
  TEXT;
}
