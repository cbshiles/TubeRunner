package tubegame;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.opengl.Texture;

class Lib
{//Holds environmental variables
    static Color white = new Color(255, 255, 255);
    static Color black = new Color(0, 0, 0);
    static Color orange = new Color(255, 103, 51);
    static Color lime = new Color(51, 255, 51);
    static Color muck = new Color(0, 103, 103);

    static CTex blank = new CTex(0, 1f, 1f);
    static CTex greenBackTex, blueBackTex, runnerTex, starTex, asterTex, ptopTex, pbotTex, bombTex, tanisTex, bagTex, shieldTex, trampTex;

    static int nTextures = 0;

    static void loadTextures()
    {
	greenBackTex = addTexture("PNG", "back-green.png");
	greenBackTex.repeat = new Vector(4, 1);
	blueBackTex = addTexture("PNG", "back-wave.png");
	blueBackTex.repeat = new Vector(4, 1);

	runnerTex = addTexture("PNG", "tube-runner.png");
	starTex = addTexture("PNG", "star.png");
	asterTex = addTexture("PNG", "ast.png");

	ptopTex = addTexture("PNG", "pipe-top.png");
	pbotTex = addTexture("PNG", "pipe-door.png");
	bombTex = addTexture("PNG", "bomb.png");
	tanisTex = addTexture("PNG", "tanis.png");

	bagTex = addTexture("PNG", "bag.png");
	shieldTex = addTexture("PNG", "shield.png");
	trampTex = addTexture("PNG", "trampoline.png");
    }

    static CTex addTexture(String type, String path)
    { // Path is relative to the res directory
	try {
	    Texture t = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream("res/" + path));
	    float width = (float)t.getImageWidth() / t.getTextureWidth();
	    float height = (float)t.getImageHeight() / t.getTextureHeight();
	    return new CTex(++nTextures, width, height);
	} catch (Exception e)  {
	    e.printStackTrace();
	    return null;
	}
    }
}1,8c1,51
< public class Lib
< {
<     //Wierd little class, just holds environmental variables
<     public static int displayWidth = 450;
<     public static int displayHeight = 800;
<     public static int fps = 60;
<     public static Color white = new Color(255, 255, 255);
<     public static Color black = new Color(0, 0, 0);
---
> package tubegame;
> import org.newdawn.slick.opengl.TextureLoader;
> import org.newdawn.slick.util.ResourceLoader;
> import org.newdawn.slick.opengl.Texture;
> 
> class Lib
> {//Holds environmental variables
>     static Color white = new Color(255, 255, 255);
>     static Color black = new Color(0, 0, 0);
>     static Color orange = new Color(255, 103, 51);
>     static Color lime = new Color(51, 255, 51);
>     static Color muck = new Color(0, 103, 103);
> 
>     static CTex blank = new CTex(0, 1f, 1f);
>     static CTex greenBackTex, blueBackTex, runnerTex, starTex, asterTex, ptopTex, pbotTex, bombTex, tanisTex, bagTex, shieldTex, trampTex;
> 
>     static int nTextures = 0;
> 
>     static void loadTextures()
>     {
> 	greenBackTex = addTexture("PNG", "back-green.png");
> 	greenBackTex.repeat = new Vector(4, 1);
> 	blueBackTex = addTexture("PNG", "back-wave.png");
> 	blueBackTex.repeat = new Vector(4, 1);
> 
> 	runnerTex = addTexture("PNG", "tube-runner.png");
> 	starTex = addTexture("PNG", "star.png");
> 	asterTex = addTexture("PNG", "ast.png");
> 
> 	ptopTex = addTexture("PNG", "pipe-top.png");
> 	pbotTex = addTexture("PNG", "pipe-door.png");
> 	bombTex = addTexture("PNG", "bomb.png");
> 	tanisTex = addTexture("PNG", "tanis.png");
> 
> 	bagTex = addTexture("PNG", "bag.png");
> 	shieldTex = addTexture("PNG", "shield.png");
> 	trampTex = addTexture("PNG", "trampoline.png");
>     }
> 
>     static CTex addTexture(String type, String path)
>     { // Path is relative to the res directory
> 	try {
> 	    Texture t = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream("res/" + path));
> 	    float width = (float)t.getImageWidth() / t.getTextureWidth();
> 	    float height = (float)t.getImageHeight() / t.getTextureHeight();
> 	    return new CTex(++nTextures, width, height);
> 	} catch (Exception e)  {
> 	    e.printStackTrace();
> 	    return null;
> 	}
>     }
