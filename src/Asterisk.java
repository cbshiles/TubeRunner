package tubegame;

class Asterisk extends Thing
{static Vector defSize = new Vector(64, 64);
    static int speed = 4;

    Asterisk(int x, int y)
    {
	super(new Vector(x, y), defSize,
	      Lib.asterTex, Lib.white);
    }

    void update()
    {
	position.addx(speed);
    }
}