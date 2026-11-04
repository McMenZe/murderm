package com.murderm.util;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class Assets {
    private static final Map<String, Image> cache = new HashMap<>();

    public static Image get(String name) {
        return cache.computeIfAbsent(name, n ->
            new Image(Assets.class.getResourceAsStream("/com/murderm/assets/" + n)));
    }
}

// cache
// Nur ein Variablenname. Ein Cache ist ein Zwischenspeicher:
// Was einmal geladen wurde, wird gemerkt, damit man es nicht nochmal von der Festplatte holen muss.

// computeIfAbsent(name, n -> ...)
// Bedeutung: “Gib mir den Wert zu name. Falls es ihn noch nicht gibt (absent),
// berechne ihn mit der Funktion, speichere ihn und gib ihn zurück.” Ablauf:
//     Erster Aufruf mit "player.png": nicht in der Map → Bild wird geladen, gespeichert, zurückgegeben.
//     Jeder weitere Aufruf: schon in der Map → sofort zurückgegeben, kein erneutes Laden.

// n -> new Image(...)