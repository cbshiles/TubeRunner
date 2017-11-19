package tubegame;
import java.lang.Math;

class Color
{
    public static Color random()
    {return new Color(rand(), rand(), rand());}

    private static float rand()
    {return (float)Math.random();}

    public float r, g, b;

    public Color(int r, int g, int b)
    {
	this.r = (float)r / 255;
	this.g = (float)g / 255;
	this.b = (float)b / 255;
    }

    public Color(float r, float g, float b)
    {
	this.r = r;
	this.g = g;
	this.b = b;
    }
}4c4
< public class Color
---
> class Color
27c27
< }
---
> }
\ No newline at end of file
