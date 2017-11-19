package tubegame;

class TopPart extends Part{
    TopPart (int x, Color c, Pipe p)
    {
	super(x, Lib.ptopTex, c, p);
    }

    boolean load(Thing t){return super.load(t, true);}
}