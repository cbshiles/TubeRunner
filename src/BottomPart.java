package tubegame;

class BottomPart extends Part{
    static int margin = 10;
    Thing middle;

    BottomPart (int x, Color c, Pipe p)
    {
	super(x, Lib.pbotTex, c, p);
	middle = new Thing(new Vector(x+margin, endSize.y), new Vector(endSize.x - 2*margin, Settings.stageHeight),
			   Lib.blank, color);
    }

    void draw()
    {
	super.draw();
	middle.draw();
    }

    boolean load(Thing t){return super.load(t, false);}
}