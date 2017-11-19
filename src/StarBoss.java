package tubegame;

public class StarBoss extends Thing
{static Vector def_size = new Vector(128, 128);
    public StarBoss(CTex ct, int x, int y)
    {
	super(ct, x, y);
	size = def_size;
    }
}