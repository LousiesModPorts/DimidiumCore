package net.dimidium.dimidiumcore.api.util;

public class ParticleUtil
{
    private static long MakeRgb(byte red, byte green, byte blue)
    {
        return ((red*0x10000) + (green*0x100) + blue);
    }

    private static byte GetRed(long color)
    {
        return (byte)((color & 0xFF0000) / 0x10000);
    }

    private static byte GetGreen(long color)
    {
        return (byte)((color & 0x00FF00) / 0x100);
    }

    private static byte GetBlue(long color)
    {
        return (byte)((color & 0x0000FF));
    }

    long color = MakeRgb((byte) 255, (byte) 255, (byte) 0);

    byte red = GetRed(color);
    byte green = GetGreen(color);
    byte blue = GetBlue(color);
}
