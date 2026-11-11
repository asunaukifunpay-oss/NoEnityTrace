# NoEntityTrace

A small client-side Fabric mod for Minecraft 1.21.4.

Press `] ` (right bracket) to toggle the player attack filter.

- When enabled, your attack input is cancelled if the target is another player.
- Mobs and other non-player entities can still be attacked normally.
- When disabled, attacks work normally.
- The mod does not change reach, hitboxes, aim, attack speed, or automate combat.

This is a client-side safeguard to help avoid accidentally attacking players. Server rules still apply; use it only where client-side mods are permitted.

## Build

Requires Java 21.

```sh
gradle build
```

The built mod jar will be in `build/libs/`.
