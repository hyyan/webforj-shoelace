package com.webforj.shoelace.components.input;

import com.google.gson.annotations.SerializedName;

/**
 * The type of input for the Shoelace Input component.
 */
public enum InputType {
  @SerializedName("date")
  DATE,

  @SerializedName("datetime-local")
  DATETIME_LOCAL,

  @SerializedName("email")
  EMAIL,

  @SerializedName("number")
  NUMBER,

  @SerializedName("password")
  PASSWORD,

  @SerializedName("search")
  SEARCH,

  @SerializedName("tel")
  TEL,

  @SerializedName("text")
  TEXT,

  @SerializedName("time")
  TIME,

  @SerializedName("url")
  URL;
}
