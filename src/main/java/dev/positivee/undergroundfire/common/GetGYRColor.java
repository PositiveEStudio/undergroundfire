package dev.positivee.undergroundfire.common;

import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public class GetGYRColor
{
	public static Vector3f getParticleColor(int targetConc)
	{
		int red, green;
		double half = (double) Constants.CONC_MAX / 2.0D;
		String color_s;


		if (targetConc < half)
		{
			red = (int) (255 * ((double) targetConc / half));
			color_s = Integer.toHexString(red) + "ff00";
		}

		else if (targetConc == half)
		{
			color_s = "ffff00";
		}

		else
		{
			green = 255 - (int) (255 * ((double) targetConc - half) / half);
			color_s = "ff" + Integer.toHexString(green) + "00";
		}


		int color = Integer.valueOf(color_s, 16);
		return Vec3.fromRGB24(color).toVector3f();
	}
}
