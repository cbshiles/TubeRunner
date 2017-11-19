package tubegame;
import static org.lwjgl.opengl.GL11.*;

class Thing
{//Represents anything you want to draw on the screen
    Vector position, size;
    CTex texture;
    Color color;
    boolean interacting;
    boolean inPipe;

    Thing(Vector p, Vector s, CTex t, Color c)
    {
	position = p;
	size = s;
	texture = t;
	color = c;
	interacting = inPipe = false;
    }

    void update(){;}

    void draw()
    {//Draw the 4 sides of the quad.
	glBindTexture(GL_TEXTURE_2D, texture.id);
	glColor3f(color.r, color.g, color.b);
	glBegin(GL_QUADS);
	for(int i=0; i<4; i++){
		texture.staple(i);
		glVertex2f(position.x + ((i==1 || i==2)?size.x:0),
			   position.y + ((i > 1)?size.y:0));}
	glEnd();
    }

    boolean overlaps(Thing t)
    {return ylaps(t) && xlaps(t);}

    boolean ylaps(Thing t)
    {return (t.position.y < position.y + size.y) && (position.y < t.position.y + t.size.y);}

    boolean xlaps(Thing t)
    {return (t.position.x < position.x + size.x) && (position.x < t.position.x + t.size.x);}
}4,6c4,5
< abstract class Thing
< {static Color white = new Color(255, 255, 255);
< static CTex blank = new CTex(0, 1.0f, 1.0f);
---
> class Thing
> {//Represents anything you want to draw on the screen
9a9,10
>     boolean interacting;
>     boolean inPipe;
11,12c12,19
<     public Thing(CTex tex, int x, int y)
<     {this(tex, x, y, white);}
---
>     Thing(Vector p, Vector s, CTex t, Color c)
>     {
> 	position = p;
> 	size = s;
> 	texture = t;
> 	color = c;
> 	interacting = inPipe = false;
>     }
14,15c21
<     public Thing(CTex tex, int x, int y, Color c)
<     {texture = tex; position = new Vector(x, y); color = c;}
---
>     void update(){;}
18,19c24
<     {
< 	//Bind texture
---
>     {//Draw the 4 sides of the quad.
21,22d25
< 
< 	//Set color to white
24d26
< 
26,42c28,31
< 
<         // top-left of texture tied to top-left of box        
<         glTexCoord2f(0, 0);
<         glVertex2f(position.x, position.y);
< 
<         // top-right 
<         glTexCoord2f(texture.width, 0);
<         glVertex2f(position.x+size.x, position.y);
< 
<         // bottom-right
<         glTexCoord2f(texture.width, texture.height);
<         glVertex2f(position.x+size.x, position.y-size.y);
< 
<         // bottom-left
< 	glTexCoord2f(0, texture.height);
<         glVertex2f(position.x, position.y-size.y);
< 
---
> 	for(int i=0; i<4; i++){
> 		texture.staple(i);
> 		glVertex2f(position.x + ((i==1 || i==2)?size.x:0),
> 			   position.y + ((i > 1)?size.y:0));}
46c35,36
<     public boolean overlaps(Thing v) {return shareX(v) && shareY(v);}
---
>     boolean overlaps(Thing t)
>     {return ylaps(t) && xlaps(t);}
48,54c38,39
<     private boolean shareX(Thing v)
<     {
< 	if (position.x >= v.position.x)
< 	    return (v.position.x + v.size.x) > position.x;
< 	else
< 	    return (position.x + size.x) > v.position.x;
<     }
---
>     boolean ylaps(Thing t)
>     {return (t.position.y < position.y + size.y) && (position.y < t.position.y + t.size.y);}
56,62c41,42
<     private boolean shareY(Thing v)
<     {
< 	if (position.y >= v.position.y)
< 	    return (v.position.y + v.size.y) > position.y;
< 	else
< 	    return (position.y + size.y) > v.position.y;
<     }
---
>     boolean xlaps(Thing t)
>     {return (t.position.x < position.x + size.x) && (position.x < t.position.x + t.size.x);}
