package com.github.fabiodelabruna.citiesapi.utils;

public class StringLocationUtils {

    public static Double[] transform(final String geolocation) {
        final String result = geolocation.replace("(", "").replace(")", "");
        final String[] strings = result.trim().split(",");
        return new Double[]{Double.valueOf(strings[0]), Double.valueOf(strings[1])};
    }

}