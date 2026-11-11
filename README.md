# NoEntityTrace

A small client-side Fabric mod for Minecraft 1.21.4.

In singleplayer, press `]` to toggle player filtering in the crosshair entity raycast. You still aim manually; the mod does not move the camera or select targets for you. When enabled, player entities are skipped by crosshair targeting while mobs remain targetable.

**Scope:** the feature is deliberately limited to singleplayer. It does not change server-side hitboxes or combat rules, and it is not active on multiplayer servers.

## Build

Requires Java 21.

```sh
./gradlew build
```

The built mod jar will be in `build/libs/`.
