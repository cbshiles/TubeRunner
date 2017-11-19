package tubegame;
import static org.lwjgl.opengl.GL11.*;

public class TubeGame extends Game
{
    StarBoss star;
    Background background;
    TubeRunner you;
    CTex runnerTex, starTex, greenBack, ptopTex, pbotTex;
    Stage[] stages;
    public TubeGame()
    {
	name = "Tube Runner";

	stages = new Stage[10];

	//Load up all textures here
	runnerTex = addTexture("PNG", "tube-runner.png");
	starTex = addTexture("PNG", "star.png");
	greenBack = addTexture("PNG", "back-wave.png");
	ptopTex = addTexture("PNG", "pipe-top.png");
	pbotTex = addTexture("PNG", "pipe-door.png");

	star = new StarBoss(starTex, 0, 0);
	you = new TubeRunner(runnerTex, displayWidth/2, 0);
	for (int i=0; i<stages.length; i++)
	    {
		stages[i] = new Stage(200*i);
	    }
    }

    void finish(){background = new Background(displayWidth, displayHeight, greenBack);}

    public void loop()
    {
	//Background & ortho: Layer 1
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	int y = displayHeight;
	int youy = you.position.y + you.size.y/2;
	glOrtho(0, displayWidth, youy - y/2, youy + y/2, 1, -1);
	glMatrixMode(GL_MODELVIEW);
	background.setPos(youy + y/2);




	you.update();

	background.draw();

	//Stages: Layer 3
	for (Stage s:stages)
	    s.draw();

	you.draw();
	star.draw();
    }
}