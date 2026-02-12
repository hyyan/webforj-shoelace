package com.webforj.shoelace.components.tag;

import com.google.gson.annotations.SerializedName;

/**
 * Theme variants available for the Tag component.
 */
public enum TagVariant {
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
