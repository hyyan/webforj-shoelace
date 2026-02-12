package com.webforj.shoelace.components.badge;

import com.google.gson.annotations.SerializedName;

/**
 * Theme variants available for the Badge component.
 */
public enum BadgeVariant {
  @SerializedName("primary")
  PRIMARY,

  @SerializedName("success")
  SUCCESS,

  @SerializedName("neutral")
  NEUTRAL,

  @SerializedName("warning")
  WARNING,

  @SerializedName("danger")
  DANGER;
}
