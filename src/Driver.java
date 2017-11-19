package tubegame;
public class Driver
{
    public static void main (String[] args)
    {
	//Parameters are displayWidth, displayHeight, fps
	GameEngine ge = new GameEngine(450, 800, 60);

	TubeGame g = new TubeGame();

	ge.play(g);
    }
}