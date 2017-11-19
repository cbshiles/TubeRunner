package tubegame;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;

//Our hero, TubeRunner
//TODO: What if you could drop an object in a pipe & it would stay there?
class Protagonist extends Thing
{static Vector defSize = new Vector(64, 64);
    static int speed = 3;

    boolean facingLeft;

    Protagonist(int x, int y)
    {
	super(new Vector(x, y), defSize, Lib.runnerTex, Lib.white);
	facingLeft = false;
    }

    void update()
    {
	if (! inPipe)
	    {//Movement not allowed in pipe
		if (Keyboard.isKeyDown(Settings.rightKey))
		    {
			this.position.x += speed; 
			if (facingLeft)
			    texture.horizontalFlip();
			facingLeft = false;
		    }
		if (Keyboard.isKeyDown(Settings.leftKey))
		    {
			this.position.x -= speed; 
			if (! facingLeft)
			    texture.horizontalFlip();
			facingLeft = true;
		    }	

		if (Keyboard.isKeyDown(Settings.useKey)) {interacting = true;}
		else {interacting = false;}
	    }

	//Inventory arrangement is tho
    }

}