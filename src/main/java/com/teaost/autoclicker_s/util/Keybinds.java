package com.teaost.autoclicker_s.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final String Key_Category = "key.teost.autoclicker_s.clicker";
    public static final  String Start = "key.teost.autoclicker_s.start";
    public static final  String Input = "key.teost.autoclicker_s.input";


    public static final KeyMapping StratKey = new KeyMapping(Start, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,GLFW.GLFW_KEY_F6,Key_Category);
    public static final KeyMapping InputKey = new KeyMapping(Input, KeyConflictContext.IN_GAME,
            InputConstants.Type.MOUSE,GLFW.GLFW_MOUSE_BUTTON_1,Key_Category);

}
