package com.webforj.shoelace.components.alert;

import com.google.gson.annotations.SerializedName;

/**
 * Theme variants available for the Alert component.
 */
public enum AlertVariant {
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
