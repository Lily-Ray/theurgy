// SPDX-FileCopyrightText: 2026 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.theurgy.content.gui.lib;

public record GeneratedGuiStyle(int fillColor, int lightEdgeColor, int darkEdgeColor, int outlineColor) {
    public static final GeneratedGuiStyle WINDOW = new GeneratedGuiStyle(0xFFC6C1B2, 0xFFF5F1E6, 0xFF5B5850, 0xFF2B2A27);
    public static final GeneratedGuiStyle INSET = new GeneratedGuiStyle(0xFF8B8B8B, 0xFFFFFFFF, 0xFF373737, 0xFF1E1E1E);
    public static final GeneratedGuiStyle SLOT = new GeneratedGuiStyle(0xFF8B8B8B, 0xFFFFFFFF, 0xFF373737, 0xFF1E1E1E);
    public static final GeneratedGuiStyle PREVIEW = new GeneratedGuiStyle(0xFF101010, 0xFFFFFFFF, 0xFF373737, 0xFF000000);

    public static final GeneratedGuiStyle BUTTON = new GeneratedGuiStyle(0xFFD7D2C5, 0xFFF8F4EA, 0xFF68635A, 0xFF2D2B28);
    public static final GeneratedGuiStyle BUTTON_HOVER = new GeneratedGuiStyle(0xFFE4DED2, 0xFFFFFBF2, 0xFF5F5B54, 0xFF2D2B28);
    public static final GeneratedGuiStyle BUTTON_SELECTED = new GeneratedGuiStyle(0xFFC8D8EC, 0xFFEAF3FF, 0xFF53657A, 0xFF243140);
    public static final GeneratedGuiStyle BUTTON_DISABLED = new GeneratedGuiStyle(0xFFAAA59A, 0xFFC3BEB2, 0xFF666259, 0xFF3B3936);
}
