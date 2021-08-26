package fr.zeamateis.mff.geckolib;

import fr.zeamateis.mff.geckolib.proxy.ClientProxy;
import fr.zeamateis.mff.geckolib.proxy.CommonProxy;
import fr.zeamateis.mff.geckolib.proxy.IProxy;
import fr.zeamateis.mff.geckolib.proxy.ServerProxy;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static fr.zeamateis.mff.geckolib.MFFGeckolib.MODID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MODID)
public class MFFGeckolib
{
public static final String MODID = "mff_geckolib";

    public static final CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public MFFGeckolib() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::construct);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    }

    private void construct(final FMLConstructModEvent event) {
        PROXY.onConstruct(event);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        PROXY.onSetup(event);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        PROXY.onClientSetup(event);
    }

}