package com.webforj.shoelace.components.formatnumber;

import com.google.gson.annotations.SerializedName;

/**
 * How to display the currency for the FormatNumber component.
 */
public enum CurrencyDisplay {
  @SerializedName("symbol")
  SYMBOL,

  @SerializedName("narrowSymbol")
  NARROW_SYMBOL,

  @SerializedName("code")
  CODE,

  @SerializedName("name")
  NAME;
}
