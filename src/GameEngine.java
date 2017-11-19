package tubegame;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import java.util.ArrayList;

class GameEngine
{
    static int ns = 13; //# of stages
    static Stage[] stages = new Stage[ns];
    static ArrayList<Pipe> pipes = new ArrayList<Pipe>();
    static Protagonist you;

    static int halfY = Settings.displayHeight/2;

    public static void main(String[] args)
    {
	initDisplay();
	Lib.loadTextures();
	loadStages();
	loadPipes();
	while (!Display.isCloseRequested())
	    {loop();}
	Display.destroy();
    }

    static void loop()
    {
	Display.sync(Settings.fps);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	moveCam();
	for (Stage s: stages)
	    s.update();
	for (Pipe p: pipes)
	    p.update();
	for (Stage s: stages)
	    s.draw();
	Display.update();
    }

    static void moveCam()
    {
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	int youy = you.position.y + you.size.y/2;
	glOrtho(0, Settings.displayWidth, youy - halfY, youy + halfY, 1, -1);
	glMatrixMode(GL_MODELVIEW);
    }

    static void initDisplay() // and GL
    {
	try {
	    Display.setDisplayMode(new DisplayMode(Settings.displayWidth, Settings.displayHeight));
	    Display.create();
	    Display.setVSyncEnabled(true);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	Display.setTitle(Settings.name);

	//Enable 2D textures
	glEnable(GL_TEXTURE_2D);

	// set "clear" color to black
	glClearColor(0.0f, 0.0f, 0.0f, 0.0f);         

	// enable alpha blending
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
         
	// set viewport to entire window
	glViewport(0,0,Settings.displayWidth, Settings.displayHeight);
         
	// set up orthographic projectionr
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	
	glOrtho(0, Settings.displayWidth, -halfY, halfY, 1, -1);
	glMatrixMode(GL_MODELVIEW);
    }

    static void loadStages() 
    {Stage stage;
	for(int i=0; i<ns; i++)
	    {
		stages[i] = stage = new Stage(i*Settings.stageHeight, (i % 2 == 0)?Lib.greenBackTex: Lib.blueBackTex);
		switch(i){
		    case 0:
			transfer(you = new Protagonist(0, 0), i, 0);
			transfer(new Asterisk(80, 0), i, 0);
			break;
		    case 1:
			transfer(new Asterisk(0, 0), i, 0);
			break;
		    case 2:
			break;
		    case 3:
			break;
		    case 4:
			break;
		    case 5:
			break;
		    case 6:
			break;
		    case 7:
			break;
		    case 8:
			break;
		    case 9:
			break;
		    case 10:
			break;
		    case 11:
			break;
		    case 12:
			stages[i] = stage = new Stage(i*Settings.stageHeight, Lib.tanisTex);
			break;
		    }}}

    static void loadPipes()
    {
	pipes.add(new Pipe(100, 0, 2, Lib.orange));
	pipes.add(new Pipe(200, 1, 2, Lib.lime));
	pipes.add(new Pipe(300, 0, 1, Lib.muck));
    }

    static void transfer(Thing t, int i){transfer(t, i, 0);}

    static void transfer(Thing t, int i, int flag) //flag has no use
    {Stage s = stages[i];

	if (t instanceof Part)
	    {
		if (t instanceof TopPart)
		    {
			s.place(t, false);
		    }
		if (t instanceof BottomPart)
		    {
			s.place(t);
			s.place(((BottomPart)t).middle);
		    }
		s.pipeParts.add((Part)t);
	    }
	else
	    {
		if (flag == 0)
		    {s.place(t);}
		s.things.add(t);
	    }
    }
}4a5
> import java.util.ArrayList;
6c7
< public class GameEngine
---
> class GameEngine
8,9c9,12
<     private int x, y, fps;
<     private TubeGame game;
---
>     static int ns = 13; //# of stages
>     static Stage[] stages = new Stage[ns];
>     static ArrayList<Pipe> pipes = new ArrayList<Pipe>();
>     static Protagonist you;
11,15c14
<     public GameEngine(int x, int y, int fps)
<     {
< 	this.x = x;
< 	this.y = y;
< 	this.fps = fps;
---
>     static int halfY = Settings.displayHeight/2;
16a16,17
>     public static void main(String[] args)
>     {
17a19,24
> 	Lib.loadTextures();
> 	loadStages();
> 	loadPipes();
> 	while (!Display.isCloseRequested())
> 	    {loop();}
> 	Display.destroy();
20c27
<     public void play(TubeGame g)
---
>     static void loop()
22,27c29,39
< 	game = g;
< 	game.loadEngineInfo(x, y, fps);
< 
< 	initGL();
< 
< 	Display.setTitle(game.name);
---
> 	Display.sync(Settings.fps);
> 	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
> 	moveCam();
> 	for (Stage s: stages)
> 	    s.update();
> 	for (Pipe p: pipes)
> 	    p.update();
> 	for (Stage s: stages)
> 	    s.draw();
> 	Display.update();
>     }
29c41,47
< 	mainLoop();
---
>     static void moveCam()
>     {
> 	glMatrixMode(GL_PROJECTION);
> 	glLoadIdentity();
> 	int youy = you.position.y + you.size.y/2;
> 	glOrtho(0, Settings.displayWidth, youy - halfY, youy + halfY, 1, -1);
> 	glMatrixMode(GL_MODELVIEW);
32,33c50,51
<     public void initDisplay()
<     {//Basic display initialization
---
>     static void initDisplay() // and GL
>     {
35c53
< 	    Display.setDisplayMode(new DisplayMode(x, y));
---
> 	    Display.setDisplayMode(new DisplayMode(Settings.displayWidth, Settings.displayHeight));
41c59
<     }
---
> 	Display.setTitle(Settings.name);
43,44d60
<     public void initGL()
<     {
56c72
< 	glViewport(0,0,x,y);
---
> 	glViewport(0,0,Settings.displayWidth, Settings.displayHeight);
61,63c77,78
< 	//Line 60 in game engine
< 	int youy = game.you.position.y + game.you.size.y/2;
< 	glOrtho(0, x, youy - y/2, youy + y/2, 1, -1);
---
> 	
> 	glOrtho(0, Settings.displayWidth, -halfY, halfY, 1, -1);
65d79
< 
68,69c82,84
<     public void mainLoop() {
< 	while (!Display.isCloseRequested())
---
>     static void loadStages() 
>     {Stage stage;
> 	for(int i=0; i<ns; i++)
71c86,118
< 		Display.sync(fps);
---
> 		stages[i] = stage = new Stage(i*Settings.stageHeight, (i % 2 == 0)?Lib.greenBackTex: Lib.blueBackTex);
> 		switch(i){
> 		    case 0:
> 			transfer(you = new Protagonist(0, 0), i, 0);
> 			transfer(new Asterisk(80, 0), i, 0);
> 			break;
> 		    case 1:
> 			transfer(new Asterisk(0, 0), i, 0);
> 			break;
> 		    case 2:
> 			break;
> 		    case 3:
> 			break;
> 		    case 4:
> 			break;
> 		    case 5:
> 			break;
> 		    case 6:
> 			break;
> 		    case 7:
> 			break;
> 		    case 8:
> 			break;
> 		    case 9:
> 			break;
> 		    case 10:
> 			break;
> 		    case 11:
> 			break;
> 		    case 12:
> 			stages[i] = stage = new Stage(i*Settings.stageHeight, Lib.tanisTex);
> 			break;
> 		    }}}
73,74c120,125
< 		//clear screen and depth buffer
< 		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
---
>     static void loadPipes()
>     {
> 	pipes.add(new Pipe(100, 0, 2, Lib.orange));
> 	pipes.add(new Pipe(200, 1, 2, Lib.lime));
> 	pipes.add(new Pipe(300, 0, 1, Lib.muck));
>     }
76c127
< 		game.loop();
---
>     static void transfer(Thing t, int i){transfer(t, i, 0);}
78c129,149
< 		Display.update();
---
>     static void transfer(Thing t, int i, int flag) //flag has no use
>     {Stage s = stages[i];
> 
> 	if (t instanceof Part)
> 	    {
> 		if (t instanceof TopPart)
> 		    {
> 			s.place(t, false);
> 		    }
> 		if (t instanceof BottomPart)
> 		    {
> 			s.place(t);
> 			s.place(((BottomPart)t).middle);
> 		    }
> 		s.pipeParts.add((Part)t);
> 	    }
> 	else
> 	    {
> 		if (flag == 0)
> 		    {s.place(t);}
> 		s.things.add(t);
80d150
< 	Display.destroy();
