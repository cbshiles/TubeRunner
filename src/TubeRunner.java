package tubegame;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;

public class TubeRunner extends Thing
{static Vector def_size = new Vector(64, 64);
    static int speed = 3;
    Stage stage;
    boolean flipped;

    public TubeRunner(CTex ct, int x, int y)
    {
	super(ct, x, y);
	size = def_size;
	flipped = true;
    }

    void update()
    {
	if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
	    {this.position.x += speed; flipped = true;}
	if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
	    {this.position.x -= speed; flipped = false;}
	if (Keyboard.isKeyDown(Keyboard.KEY_UP))
	    this.position.y += speed;
    }

    public void draw()
    {
	if (! flipped)
	    super.draw();
	else
	    {
		//Bind texture
		glBindTexture(GL_TEXTURE_2D, texture.id);

		//Set color to white
		glColor3f(255, 255, 255);

		glBegin(GL_QUADS);

		// top-left of texture tied to top-left of box        
		glTexCoord2f(texture.width, 0);
		glVertex2f(position.x, position.y);

		// top-right 
		glTexCoord2f(0, 0);
		glVertex2f(position.x+size.x, position.y);

		// bottom-right
		glTexCoord2f(0, texture.height);
		glVertex2f(position.x+size.x, position.y-size.y);

		// bottom-left
		glTexCoord2f(texture.width, texture.height);
		glVertex2f(position.x, position.y-size.y);

		glEnd();
	    }
    }
}