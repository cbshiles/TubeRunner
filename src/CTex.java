package tubegame;
import static org.lwjgl.opengl.GL11.*;

class CTex
{//Class storing data for a texture
    int id;
    float height, width;
    Vector[] corners;
    Vector repeat;

    CTex(int id, float w, float h)
    {
	this.id = id;
	width = w;
	height = h;
	corners = new Vector[4];
	for(int i=0; i<4; i++)
	    {corners[i] = new Vector(!(i==1 || i==2)?(int)width:0, !(i > 1)?(int)height:0);}
	repeat = new Vector(1, 1);
    }

    void staple(int i)
    {Vector c = corners[i];
	glTexCoord2f(c.x*repeat.x, c.y*repeat.y);
    }

    CTex copy()
    {return new CTex(id, width, height);}

    void horizontalFlip()
    {
	swap(0, 1);
	swap(3, 2);
    }

    void verticalFlip()
    {
	swap(0, 2);
	swap(1, 3);
    }

    private void swap(int a, int b)
    {
	Vector tmp = corners[a];
	corners[a] = corners[b];
	corners[b] = tmp;
    }
}2c2,4
< public class CTex
---
> import static org.lwjgl.opengl.GL11.*;
> 
> class CTex
4,5c6,9
<     public int id;
<     public float height, width;
---
>     int id;
>     float height, width;
>     Vector[] corners;
>     Vector repeat;
7c11
<     public CTex(int i, float w, float h)
---
>     CTex(int id, float w, float h)
9c13
< 	id = i;
---
> 	this.id = id;
11a16,46
> 	corners = new Vector[4];
> 	for(int i=0; i<4; i++)
> 	    {corners[i] = new Vector(!(i==1 || i==2)?(int)width:0, !(i > 1)?(int)height:0);}
> 	repeat = new Vector(1, 1);
>     }
> 
>     void staple(int i)
>     {Vector c = corners[i];
> 	glTexCoord2f(c.x*repeat.x, c.y*repeat.y);
>     }
> 
>     CTex copy()
>     {return new CTex(id, width, height);}
> 
>     void horizontalFlip()
>     {
> 	swap(0, 1);
> 	swap(3, 2);
>     }
> 
>     void verticalFlip()
>     {
> 	swap(0, 2);
> 	swap(1, 3);
>     }
> 
>     private void swap(int a, int b)
>     {
> 	Vector tmp = corners[a];
> 	corners[a] = corners[b];
> 	corners[b] = tmp;
