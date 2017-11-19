package tubegame;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.opengl.Texture;

public abstract class Game
{
    private int nTextures = 0; // # of textures loaded
    public int displayWidth, displayHeight, fps;
    public String name;

    public abstract void loop();

    protected CTex addTexture(String type, String path)
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

    public void loadEngineInfo(int x, int y, int f)
    {
	displayWidth = x;
	displayHeight = y;
	fps = f;
	finish();
    }

    abstract void finish();
}