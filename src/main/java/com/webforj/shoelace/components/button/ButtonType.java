package com.webforj.shoelace.components.button;

import com.google.gson.annotations.SerializedName;

/**
 * The type of button. Note that the default value is {@code button} instead of {@code submit},
 * which is opposite of how native {@code <button>} elements behave.
 */
public enum ButtonType {
  @SerializedName("button")
  BUTTON,

  @SerializedName("submit")
  SUBMIT,

  @SerializedName("reset")
  RESET;
}
