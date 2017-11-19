package tubegame;

abstract class Part extends Thing{
    static Vector endSize = new Vector(60, Stage.platSize.y);

    Pipe pipe;
    Part (int x, CTex ct, Color c, Pipe p)
    {
	super(new Vector(x, 0), endSize, ct, c);
	pipe = p;
    }

    abstract boolean load(Thing t);

    boolean load(Thing t, boolean top)
    {
	if (pipe.empty)
	    {
		pipe.passenger = t; 
		pipe.goingUp = !top;
		pipe.empty = false;
		GameEngine.transfer(t, ((pipe.goingUp)?pipe.endStage:pipe.startStage), 1);
		t.position.x = position.x - (t.size.x - size.x)/2;
		return true;
	    }
	else {return false;}
    }
}