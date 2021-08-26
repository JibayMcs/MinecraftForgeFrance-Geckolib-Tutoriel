package fr.zeamateis.mff.geckolib.proxy;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

public interface IProxy {

    void onConstruct(FMLConstructModEvent event);

    void onSetup(FMLCommonSetupEvent event);

    void onClientSetup(FMLClientSetupEvent event);
}