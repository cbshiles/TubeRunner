package tubegame;

class Pipe 
{

    static int margin = 10;
    static int speed = 4;

    Thing passenger;
    TopPart top;
    BottomPart bottom;
    int startStage, endStage;
    Color color;
    boolean empty, goingUp;

    Pipe(int x, int ss, int es, Color c)//x position, start stage, end stage
    {
	color = c;
	top = new TopPart(x, color, this);
	bottom = new BottomPart(x, color, this);
	GameEngine.transfer(top, es);
	GameEngine.transfer(bottom, ss);
	startStage = ss;
	endStage = es;
	empty = true;
    }

    void update()
    {
	if (! empty)
	    {
		if (goingUp)
		    {
			passenger.position.addy(speed);
			if (passenger.position.y >= top.position.y + top.size.y)
			    {empty = true; passenger.inPipe = false;}
		    }
		else
		    {
			passenger.position.addy(-speed);
			if (passenger.position.y <= bottom.position.y)
			    {empty = true; passenger.inPipe = false;}
		    }

	    }

    }

}starting old version:
package tubegame;

class Pipe 
{
    static Vector endSize = new Vector(60, Stage.platSize.y);
    static int margin = 10;

    Thing passenger;
    Part top, middle, bottom;
    int startStage, endStage;
    Color color;

    Pipe(int x, int ss, int es, Color c)//x position, start stage, end stage
    {
	color = c;
	top = new Part(new Vector(x, 0), endSize, Lib.ptopTex, color, this);
	middle = new Part(new Vector(x+margin, endSize.y), new Vector(endSize.x - 2*margin, Settings.stageHeight),
			   Lib.blank, color, this);
	bottom = new Part(new Vector(x, 0), endSize, Lib.pbotTex, color, this);
	GameEngine.transfer(top, es, 0);
	GameEngine.transfer(middle, ss, 1);
	GameEngine.transfer(bottom, ss, 1);
	passenger = null;
	startStage = ss;
	endStage = es;
    }

    boolean load(Thing t)
    {
	if (passenger == null)
	    {passenger = t; return true;}
	else {return false;}
    }

}2,3d1
< import static org.lwjgl.opengl.GL11.*;
< import java.util.Random;
5,7c3,4
< public class Pipe extends Thing
< {static Vector def_size = new Vector(450, 8);
<     static Color[] colors = {new Color(60, 180, 60), new Color(180, 20, 180)};
---
> class Pipe 
> {
9,10c6,7
<     PipeTop top;
<     PipeBottom bottom;
---
>     static int margin = 10;
>     static int speed = 4;
12,13c9,28
<     //have static vector of colors
<     public Pipe(CTex ct, CTex cb, int x, int start, int end)
---
>     Thing passenger;
>     TopPart top;
>     BottomPart bottom;
>     int startStage, endStage;
>     Color color;
>     boolean empty, goingUp;
> 
>     Pipe(int x, int ss, int es, Color c)//x position, start stage, end stage
>     {
> 	color = c;
> 	top = new TopPart(x, color, this);
> 	bottom = new BottomPart(x, color, this);
> 	GameEngine.transfer(top, es);
> 	GameEngine.transfer(bottom, ss);
> 	startStage = ss;
> 	endStage = es;
> 	empty = true;
>     }
> 
>     void update()
14a30,45
> 	if (! empty)
> 	    {
> 		if (goingUp)
> 		    {
> 			passenger.position.addy(speed);
> 			if (passenger.position.y >= top.position.y + top.size.y)
> 			    {empty = true; passenger.inPipe = false;}
> 		    }
> 		else
> 		    {
> 			passenger.position.addy(-speed);
> 			if (passenger.position.y <= bottom.position.y)
> 			    {empty = true; passenger.inPipe = false;}
> 		    }
> 
> 	    }
16,17d46
< 	super(blank, 0, y, colors[new Random().nextInt(colors.length)]);
< 	size = def_size;
18a48,83
> 
> }starting old version:
> package tubegame;
> 
> class Pipe 
> {
>     static Vector endSize = new Vector(60, Stage.platSize.y);
>     static int margin = 10;
> 
>     Thing passenger;
>     Part top, middle, bottom;
>     int startStage, endStage;
>     Color color;
> 
>     Pipe(int x, int ss, int es, Color c)//x position, start stage, end stage
>     {
> 	color = c;
> 	top = new Part(new Vector(x, 0), endSize, Lib.ptopTex, color, this);
> 	middle = new Part(new Vector(x+margin, endSize.y), new Vector(endSize.x - 2*margin, Settings.stageHeight),
> 			   Lib.blank, color, this);
> 	bottom = new Part(new Vector(x, 0), endSize, Lib.pbotTex, color, this);
> 	GameEngine.transfer(top, es, 0);
> 	GameEngine.transfer(middle, ss, 1);
> 	GameEngine.transfer(bottom, ss, 1);
> 	passenger = null;
> 	startStage = ss;
> 	endStage = es;
>     }
> 
>     boolean load(Thing t)
>     {
> 	if (passenger == null)
> 	    {passenger = t; return true;}
> 	else {return false;}
>     }
> 
