package com.webforj.shoelace.components.tree;

import com.google.gson.annotations.SerializedName;

/**
 * The selection behavior of the Tree component.
 */
public enum Selection {
  @SerializedName("single")
  SINGLE,

  @SerializedName("multiple")
  MULTIPLE,

  @SerializedName("leaf")
  LEAF;
}
