package com.webforj.shoelace.components.formatnumber;

import com.google.gson.annotations.SerializedName;

/**
 * The formatting style to use for the FormatNumber component.
 */
public enum NumberType {
  @SerializedName("currency")
  CURRENCY,

  @SerializedName("decimal")
  DECIMAL,

  @SerializedName("percent")
  PERCENT;
}
