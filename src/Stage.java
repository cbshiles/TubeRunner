package tubegame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class Stage extends Thing
{//Class for each stage of the world.
    static Vector platSize = new Vector(Settings.displayWidth, Settings.stageHeight/10);
    Thing platform;
    ArrayList<Part> pipeParts;
    ArrayList<Thing> things;

    Stage(int y, CTex background)
    {
	super(new Vector(0, y), 
	      new Vector(Settings.displayWidth, Settings.stageHeight),
	      background, Lib.white);
	platform = new Thing(position.copy(), platSize,
			     Lib.blank, Lib.black);
	things = new ArrayList<Thing>();
	pipeParts = new ArrayList<Part>();
    }

    void update()
    {Thing t, toErase;
	Iterator<Thing> itr = things.iterator();
	while(itr.hasNext())
	    {t = itr.next();

		//Wrap-around
		if (t.position.x + t.size.x < this.position.x)
		    t.position.x = this.position.x + this.size.x;
		else if (t.position.x > this.position.x + this.size.x)
		    t.position.x = this.position.x - t.size.x;

		t.update();

		//Pipe entering code
		for(Part pp: pipeParts)
		    {if (t.xlaps(pp) && t.interacting && !t.inPipe)
			    {if (pp.load(t))
				    {t.inPipe=true; itr.remove();}}}
	    }
    }

    void place(Thing t) {place(t, true);}

    void place(Thing t, boolean plat) //Place thing in stage
    {
	t.position.add(this.position);
	if (plat)
	    t.position.addy(platform.size.y);
    }

    void draw()
    {
	super.draw();
	platform.draw();
	for (Thing t:pipeParts)
	    {t.draw();}
	for (Thing t:things)
	    {t.draw();}
    }
}2,3c2,4
< import static org.lwjgl.opengl.GL11.*;
< import java.util.Random;
---
> import java.util.ArrayList;
> import java.util.Iterator;
> import java.util.concurrent.CopyOnWriteArrayList;
5,7c6,11
< public class Stage extends Thing
< {static Vector def_size = new Vector(450, 8);
<     static Color black = new Color(0, 0, 0);
---
> class Stage extends Thing
> {//Class for each stage of the world.
>     static Vector platSize = new Vector(Settings.displayWidth, Settings.stageHeight/10);
>     Thing platform;
>     ArrayList<Part> pipeParts;
>     ArrayList<Thing> things;
9,10c13
<     //have static vector of colors
<     public Stage(int y)
---
>     Stage(int y, CTex background)
11a15,22
> 	super(new Vector(0, y), 
> 	      new Vector(Settings.displayWidth, Settings.stageHeight),
> 	      background, Lib.white);
> 	platform = new Thing(position.copy(), platSize,
> 			     Lib.blank, Lib.black);
> 	things = new ArrayList<Thing>();
> 	pipeParts = new ArrayList<Part>();
>     }
13,14c24,62
< 	super(blank, 0, y, black);
< 	size = def_size;
---
>     void update()
>     {Thing t, toErase;
> 	Iterator<Thing> itr = things.iterator();
> 	while(itr.hasNext())
> 	    {t = itr.next();
> 
> 		//Wrap-around
> 		if (t.position.x + t.size.x < this.position.x)
> 		    t.position.x = this.position.x + this.size.x;
> 		else if (t.position.x > this.position.x + this.size.x)
> 		    t.position.x = this.position.x - t.size.x;
> 
> 		t.update();
> 
> 		//Pipe entering code
> 		for(Part pp: pipeParts)
> 		    {if (t.xlaps(pp) && t.interacting && !t.inPipe)
> 			    {if (pp.load(t))
> 				    {t.inPipe=true; itr.remove();}}}
> 	    }
>     }
> 
>     void place(Thing t) {place(t, true);}
> 
>     void place(Thing t, boolean plat) //Place thing in stage
>     {
> 	t.position.add(this.position);
> 	if (plat)
> 	    t.position.addy(platform.size.y);
>     }
> 
>     void draw()
>     {
> 	super.draw();
> 	platform.draw();
> 	for (Thing t:pipeParts)
> 	    {t.draw();}
> 	for (Thing t:things)
> 	    {t.draw();}
