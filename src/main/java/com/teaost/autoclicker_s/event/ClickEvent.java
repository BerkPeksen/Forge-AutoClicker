package com.teaost.autoclicker_s.event;

import net.minecraft.client.Minecraft;
import com.teaost.autoclicker_s.AutoClickerS;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.client.KeyMapping;
import org.jline.keymap.KeyMap;
import org.lwjgl.glfw.GLFW;
import com.teaost.autoclicker_s.util.Keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;


import javax.swing.text.JTextComponent;
import java.util.concurrent.TimeUnit;


public class ClickEvent {

    @Mod.EventBusSubscriber(modid = AutoClickerS.MODID, value = Dist.CLIENT)
    public static class ClientEvents{
        static int Flag = 0;
        static int TickCount = 1;

        @SubscribeEvent
        public static void onTick(TickEvent.PlayerTickEvent event ) throws InterruptedException {

            if(Flag % 2 == 1 && TickCount == 20){
                KeyMapping.click(Keybinds.InputKey.getKey());
                TickCount = 0;

            }
            if(Keybinds.StratKey.consumeClick()){
                Flag = Flag + 1 - 2*(Flag-1);
                TickCount = 0;
            }
            TickCount = TickCount + 1;
        }


    }
    @Mod.EventBusSubscriber(modid = AutoClickerS.MODID, value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvent{
        @SubscribeEvent
        public static void OnKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(Keybinds.InputKey);
            event.register(Keybinds.StratKey);



        }

    }

}
