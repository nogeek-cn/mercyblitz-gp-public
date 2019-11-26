package com.darian.java.lambda;

import java.util.prefs.Preferences;

public class PreferencesTest {
    public static void main(String[] args) {
        // 很像 ZK Node
        Preferences preferences = Preferences.userRoot();
        preferences.put("Hello", "world");
        preferences.get("Hello", "");

        System.out.println(preferences.get("Hello", ""));
    }
}
