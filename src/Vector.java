package tubegame;

class Vector
{//Class representing vector on cartesian plane
    int x, y;

    Vector(){this(0, 0);}
    Vector(int x, int y) {this.x = x; this.y = y;}

    void addx(int n) {x += n;}
    void addy(int n) {y += n;}

    void add(Vector v){addx(v.x); addy(v.y);}
    void sub(Vector v){addx(-v.x); addy(-v.y);}

    void zero(){zeroX(); zeroY();};
    void zeroX(){x=0;}
    void zeroY(){y=0;}

    Vector copy(){return new Vector(x, y);}

    public String toString(){return "X: "+x+" Y: "+y+'\n';}
}4,5c4
< //Class representing vector on cartesian plane
< {
---
> {//Class representing vector on cartesian plane
8c7
<     Vector() {this(0, 0);}
---
>     Vector(){this(0, 0);}
16a16,19
>     void zero(){zeroX(); zeroY();};
>     void zeroX(){x=0;}
>     void zeroY(){y=0;}
> 
17a21,22
> 
>     public String toString(){return "X: "+x+" Y: "+y+'\n';}
