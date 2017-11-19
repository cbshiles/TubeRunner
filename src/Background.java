package tubegame;

class Background
{

}2d1
< import static org.lwjgl.opengl.GL11.*;
4c3
< public class Background extends Thing
---
> class Background
6,10d4
<     public Background(int w, int h, CTex ct)
<     {
< 	super(ct, 0, 128);
< 	size = new Vector(w, h);
<     }
12,49d5
<     void setPos(int y)
<     {
< 	position.y = y;
<     }
< 
< 
<     void draw()
<     {
< 
< 	//Bind texture
< 	glBindTexture(GL_TEXTURE_2D, texture.id);
< 
< 	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
< 	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
< 
< 	//Set color to white
< 	glColor3f(255, 255, 255);
< 
< 	glBegin(GL_QUADS);
< 
<         // top-left of texture tied to top-left of box        
<         glTexCoord2f(0, 0);
<         glVertex2f(position.x, position.y);
< 
<         // top-right 
<         glTexCoord2f(4*texture.width, 0);
<         glVertex2f(position.x+size.x, position.y);
< 
<         // bottom-right
<         glTexCoord2f(4*texture.width, 6*texture.height);
<         glVertex2f(position.x+size.x, position.y-size.y);
< 
<         // bottom-left
< 	glTexCoord2f(0, 6*texture.height);
<         glVertex2f(position.x, position.y-size.y);
< 
< 	glEnd();
<     }
