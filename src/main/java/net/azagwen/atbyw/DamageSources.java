package net.azagwen.atbyw;

import net.minecraft.entity.damage.DamageSource;

public class DamageSources extends DamageSource {
    public static final DamageSource SPIKE_TRAP = new DamageSources("spike_trap");

    protected DamageSources(String name) {
        super(name);
    }
}
