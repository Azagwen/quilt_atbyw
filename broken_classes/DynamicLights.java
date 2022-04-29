package net.azagwen.atbyw;

import dev.lambdaurora.lambdynlights.api.DynamicLightsInitializer;

import static dev.lambdaurora.lambdynlights.api.DynamicLightHandlers.registerDynamicLightHandler;

/**
 *  This class is using the LambDynamicLights API
 *  <a href="https://github.com/LambdAurora/LambDynamicLights">https://github.com/LambdAurora/LambDynamicLights</a>
 */
public class DynamicLights implements DynamicLightsInitializer {

    @Override
    public void onInitializeDynamicLights() {
        registerDynamicLightHandler(EntityTypeRegistry.SHROOMSTICK, entity -> 15);
    }
}
