// The "MineSweeper" class.
// Name: Ioan and Tim
// Date: Due November 18, 2013
// ICS4U Project Management Unit
// Purpose: This is a version of Minesweeper that we designed


import java.awt.*;
import hsa.Console;
import java.io.*;
//import javax.media.*;
//import java.net.*;
//import java.io.*;
//import java.util.*;
// import javafx.scene.media.Media;
// import javafx.scene.media.MediaPlayer;

public class MineSweeperImprovedFinal
{
    static Console c;           // The output console
    static int hight;
    static int length;
    static boolean finish;
    static int wincount;
    static int[] [] ndgrid;
    static String[] [] dgrid;
    static String[] highname = new String [11];
    static int[] highscore = new int [11];
    static long start;
    static long end;
    static int time = 0;
    static int nummine;
    static String name;
    static int score;
    static File f;
    static File save;
    static int hslength = 0;
    static char level;
    static boolean back = true;
    static char cKey;
    static Font a;
    static File Save;
    static int timer = 0;
    static int timerhelper = 0;
    static Color Brown = new Color (139, 101, 8);
    static Color Fire = new Color (255, 127, 0);
    static Color ocean = new Color (113, 113, 198);
    static char restart;
    public static void main (String[] args) throws IOException
    {
	c = new Console ();
	do
	{
	    //Save = new File ("Save.txt");
	    // String bip = "bip.mp3";
	    // Media hit = new Media (bip);
	    // MediaPlayer mediaPlayer = new MediaPlayer (hit);
	    // mediaPlayer.play ();

	    // Menu Back Ground
	    c.setColor (Color.gray);
	    c.fillRect (0, 0, 640, 500);
	    c.setColor (Color.yellow);
	    c.fillOval (180, 80, 280, 150);

	    Font title;
	    c.setColor (Color.red);
	    c.setFont (title = new Font ("Times New Roman", Font.BOLD, 40));
	    c.drawString ("BombSweeper", 200, 160);

	    //Selections
	    Font button;
	    c.setFont (button = new Font ("Comic Sans MS", Font.BOLD, 20));
	    c.setColor (Color.orange); //Play
	    c.fillRect (120, 270, 150, 60);
	    c.setColor (Color.gray);
	    c.drawString ("Play (p)", 160, 305);

	    c.setColor (Color.orange); //High Score
	    c.fillRect (370, 270, 150, 60);
	    c.setColor (Color.gray);
	    c.drawString ("High Score(s)", 380, 305);

	    c.setColor (Color.orange); //Help
	    c.fillRect (120, 370, 150, 60);
	    c.setColor (Color.gray);
	    c.drawString ("Instruction (i)", 125, 405);

	    c.setColor (Color.orange); //Quit
	    c.fillRect (370, 370, 150, 60);
	    c.setColor (Color.gray);
	    c.drawString ("Quit (q)", 410, 405);

	    //User Input
	    do
	    {
		cKey = c.getChar ();

		if (cKey == 'p' || cKey == 'P')
		{
		    c.clear ();

		    c.setColor (Color.gray);
		    c.fillRect (0, 0, 640, 500);

		    //Bomb Background
		    c.setColor (Brown); // Bomb 1
		    c.fillRect (155, 305, 5, 30);
		    c.setColor (Color.black);
		    c.fillOval (100, 330, 120, 120);

		    c.setColor (Fire);
		    int[] K = {147, 158, 170};
		    int[] P = {305, 285, 305};
		    c.fillPolygon (K, P, 3);
		    c.setColor (Color.yellow);
		    int[] K1 = {150, 158, 166};
		    int[] P1 = {305, 290, 305};
		    c.fillPolygon (K1, P1, 3);
		    c.setColor (Color.red);
		    int[] K2 = {152, 158, 164};
		    int[] P2 = {305, 295, 305};
		    c.fillPolygon (K2, P2, 3);
		    c.setColor (Color.white);
		    c.fillOval (120, 370, 10, 25);

		    c.setColor (Brown); //Bomb 2
		    c.fillRect (355, 305, 5, 30);
		    c.setColor (Color.black);
		    c.fillOval (300, 330, 120, 120);

		    c.setColor (Fire);
		    int[] X = {347, 358, 370};
		    int[] Y = {305, 285, 305};
		    c.fillPolygon (X, Y, 3);
		    c.setColor (Color.yellow);
		    int[] X1 = {350, 358, 366};
		    int[] Y1 = {305, 290, 305};
		    c.fillPolygon (X1, Y1, 3);
		    c.setColor (Color.red);
		    int[] X2 = {352, 358, 364};
		    int[] Y2 = {305, 295, 305};
		    c.fillPolygon (X2, Y2, 3);
		    c.setColor (Color.white);
		    c.fillOval (320, 370, 10, 25);

		    c.setColor (Brown); // Bomb 3
		    c.fillRect (555, 255, 5, 30);
		    c.setColor (Color.black);
		    c.fillOval (500, 280, 120, 120);

		    c.setColor (Fire);
		    int[] A = {547, 558, 570};
		    int[] B = {255, 235, 255};
		    c.fillPolygon (A, B, 3);
		    c.setColor (Color.yellow);
		    int[] A1 = {550, 558, 566};
		    int[] B1 = {255, 240, 255};
		    c.fillPolygon (A1, B1, 3);
		    c.setColor (Color.red);
		    int[] A2 = {552, 558, 564};
		    int[] B2 = {255, 245, 255};
		    c.fillPolygon (A2, B2, 3);
		    c.setColor (Color.white);
		    c.fillOval (520, 320, 10, 25);

		    c.setColor (Color.orange); //High Score
		    c.fillRect (120, 200, 150, 60);
		    c.setColor (Color.gray);
		    c.drawString ("New Game(n)", 130, 235);

		    c.setColor (Color.orange); //High Score
		    c.fillRect (370, 200, 150, 60);
		    c.setColor (Color.gray);
		    c.drawString ("Load Game(l)", 380, 235);

		    //String answer;
		    c.setColor (Color.yellow);
		    c.setFont (title = new Font ("Times New Roman", Font.BOLD, 25));
		    c.drawString ("Press (N) for a new game or (L) to load a game", 80, 150);
		    cKey = c.getChar ();

		    while (cKey != 'N' && cKey != 'n' && cKey != 'L' && cKey != 'l')
		    {
			c.clear ();

			c.setColor (Color.gray);
			c.fillRect (0, 0, 640, 500);

			//Bomb Background
			c.setColor (Brown); // Bomb 1
			c.fillRect (155, 305, 5, 30);
			c.setColor (Color.black);
			c.fillOval (100, 330, 120, 120);
			c.setColor (Fire);
			c.fillPolygon (K, P, 3);
			c.setColor (Color.yellow);
			c.fillPolygon (K1, P1, 3);
			c.setColor (Color.red);
			c.fillPolygon (K2, P2, 3);
			c.setColor (Color.white);
			c.fillOval (120, 370, 10, 25);

			c.setColor (Brown); //Bomb 2
			c.fillRect (355, 305, 5, 30);
			c.setColor (Color.black);
			c.fillOval (300, 330, 120, 120);
			c.setColor (Fire);
			c.fillPolygon (X, Y, 3);
			c.setColor (Color.yellow);
			c.fillPolygon (X1, Y1, 3);
			c.setColor (Color.red);
			c.fillPolygon (X2, Y2, 3);
			c.setColor (Color.white);
			c.fillOval (320, 370, 10, 25);

			c.setColor (Brown); // Bomb 3
			c.fillRect (555, 255, 5, 30);
			c.setColor (Color.black);
			c.fillOval (500, 280, 120, 120);
			c.setColor (Fire);
			c.fillPolygon (A, B, 3);
			c.setColor (Color.yellow);
			c.fillPolygon (A1, B1, 3);
			c.setColor (Color.red);
			c.fillPolygon (A2, B2, 3);
			c.setColor (Color.white);
			c.fillOval (520, 320, 10, 25);

			c.setFont (button = new Font ("Comic Sans MS", Font.BOLD, 20));
			c.setColor (Color.orange);
			c.fillRect (120, 200, 150, 60);
			c.setColor (Color.gray);
			c.drawString ("New Game(n)", 130, 235);

			c.setColor (Color.orange);
			c.fillRect (370, 200, 150, 60);
			c.setColor (Color.gray);
			c.drawString ("Load Game(l)", 380, 235);

			c.setFont (title = new Font ("Times New Roman", Font.BOLD, 40));
			c.setColor (Color.red);
			c.drawString ("INVALID INPUT", 150, 100);
			c.setFont (title = new Font ("Times New Roman", Font.BOLD, 25));
			c.setColor (Color.yellow);
			c.drawString ("Please re-press (N) for a new game or (L) to load a game", 25, 150);
			cKey = c.getChar ();
		    }

		    if (cKey == 'N' || cKey == 'n')
		    {
			//User Name
			c.clear ();

			c.setColor (Color.gray);
			c.fillRect (0, 0, 640, 500);

			c.setColor (Color.orange);
			c.fillOval (140, 30, 350, 100);

			Font f;
			c.setColor (Color.gray);
			c.setFont (f = new Font ("Times New Roman", Font.BOLD, 40));
			c.drawString ("Enter Your Name", 170, 90);
			name = c.readLine ();

			try
			{
			    Thread.sleep (1000);
			}
			catch (InterruptedException error)
			{
			    c.println ("sorry couldn't delay");
			}

			//Explosion Background
			int a2 = 225, b2 = 195, d2 = 180, e2 = 195, g2 = 220, h2 = 250, k2 = 280, m2 = 295; //Small Explosion
			c.setColor (Color.red);
			c.fillRect (300, 400, 60, 150);
			for (int i = 0 ; i < 6 ; i++)
			{
			    c.fillOval (a2, 390, 50, 50);
			    a2 += 30;
			}
			for (int i = 0 ; i < 8 ; i++)
			{
			    c.fillOval (b2, 370, 50, 50);
			    b2 += 30;
			}
			for (int i = 0 ; i < 9 ; i++)
			{
			    c.fillOval (d2, 340, 50, 50);
			    d2 += 30;
			}
			for (int i = 0 ; i < 8 ; i++)
			{
			    c.fillOval (e2, 310, 50, 50);
			    e2 += 30;
			}
			for (int i = 0 ; i < 6 ; i++)
			{
			    c.fillOval (g2, 280, 50, 50);
			    g2 += 30;
			}
			for (int i = 0 ; i < 4 ; i++)
			{
			    c.fillOval (h2, 250, 50, 50);
			    h2 += 30;
			}
			for (int i = 0 ; i < 2 ; i++)
			{
			    c.fillOval (k2, 220, 50, 50);
			    k2 += 30;
			}
			c.fillOval (m2, 210, 50, 50);

			try
			{
			    Thread.sleep (1000);
			}
			catch (InterruptedException error)
			{
			    c.println ("sorry couldn't delay");
			}

			int a1 = 210, b1 = 180, d1 = 150, e1 = 160, g1 = 190, h1 = 220, k1 = 250, m1 = 280; //Medium Explosion
			c.setColor (Color.yellow);
			c.fillRect (290, 400, 80, 150);
			for (int i = 0 ; i < 7 ; i++)
			{
			    c.fillOval (a1, 390, 50, 50);
			    a1 += 30;
			}
			for (int i = 0 ; i < 9 ; i++)
			{
			    c.fillOval (b1, 370, 50, 50);
			    b1 += 30;
			}
			for (int i = 0 ; i < 11 ; i++)
			{
			    c.fillOval (d1, 340, 50, 50);
			    d1 += 30;
			}
			for (int i = 0 ; i < 10 ; i++)
			{
			    c.fillOval (e1, 310, 50, 50);
			    e1 += 30;
			}
			for (int i = 0 ; i < 8 ; i++)
			{
			    c.fillOval (g1, 280, 50, 50);
			    g1 += 30;
			}
			for (int i = 0 ; i < 6 ; i++)
			{
			    c.fillOval (h1, 250, 50, 50);
			    h1 += 30;
			}
			for (int i = 0 ; i < 4 ; i++)
			{
			    c.fillOval (k1, 220, 50, 50);
			    k1 += 30;
			}
			for (int i = 0 ; i < 2 ; i++)
			{
			    c.fillOval (m1, 200, 50, 50);
			    m1 += 30;
			}

			//Small Explosion
			int a3 = 225, b3 = 195, d3 = 180, e3 = 195, g3 = 220, h3 = 250, k3 = 280, m3 = 295;
			c.setColor (Color.red);
			c.fillRect (300, 400, 60, 150);
			for (int i = 0 ; i < 6 ; i++)
			{
			    c.fillOval (a3, 390, 50, 50);
			    a3 += 30;
			}
			for (int i = 0 ; i < 8 ; i++)
			{
			    c.fillOval (b3, 370, 50, 50);
			    b3 += 30;
			}
			for (int i = 0 ; i < 9 ; i++)
			{
			    c.fillOval (d3, 340, 50, 50);
			    d3 += 30;
			}
			for (int i = 0 ; i < 8 ; i++)
			{
			    c.fillOval (e3, 310, 50, 50);
			    e3 += 30;
			}
			for (int i = 0 ; i < 6 ; i++)
			{
			    c.fillOval (g3, 280, 50, 50);
			    g3 += 30;
			}
			for (int i = 0 ; i < 4 ; i++)
			{
			    c.fillOval (h3, 250, 50, 50);
			    h3 += 30;
			}
			for (int i = 0 ; i < 2 ; i++)
			{
			    c.fillOval (k3, 220, 50, 50);
			    k3 += 30;
			}
			c.fillOval (m3, 210, 50, 50);

			try
			{
			    Thread.sleep (1000);
			}
			catch (InterruptedException error)
			{
			    c.println ("sorry couldn't delay");
			}

			int a = 170, b = 120, d = 90, e = 100, g = 120, h = 150, k = 180, m = 210, n = 270; // Big Explosion
			c.setColor (Fire);
			c.fillRect (280, 400, 100, 150);
			for (int i = 0 ; i < 10 ; i++)
			{
			    c.fillOval (a, 390, 50, 50);
			    a += 30;
			}
			for (int i = 0 ; i < 13 ; i++)
			{
			    c.fillOval (b, 370, 50, 50);
			    b += 30;
			}
			for (int i = 0 ; i < 15 ; i++)
			{
			    c.fillOval (d, 340, 50, 50);
			    d += 30;
			}
			for (int i = 0 ; i < 14 ; i++)
			{
			    c.fillOval (e, 310, 50, 50);
			    e += 30;
			}
			for (int i = 0 ; i < 13 ; i++)
			{
			    c.fillOval (g, 270, 50, 50);
			    g += 30;
			}
			for (int i = 0 ; i < 11 ; i++)
			{
			    c.fillOval (h, 240, 50, 50);
			    h += 30;
			}
			for (int i = 0 ; i < 9 ; i++)
			{
			    c.fillOval (k, 210, 50, 50);
			    k += 30;
			}
			for (int i = 0 ; i < 7 ; i++)
			{
			    c.fillOval (m, 190, 50, 50);
			    m += 30;
			}
			for (int i = 0 ; i < 3 ; i++)
			{
			    c.fillOval (n, 170, 50, 50);
			    n += 30;
			}

			//Medium Explosion
			int a4 = 210, b4 = 180, d4 = 150, e4 = 160, g4 = 190, h4 = 220, k4 = 250, m4 = 280;
			c.setColor (Color.yellow);
			c.fillRect (290, 400, 80, 150);
			for (int i = 0 ; i < 7 ; i++)
			{
			    c.fillOval (a4, 390, 50, 50);
			    a4 += 30;
			}
			for (int i = 0 ; i < 9 ; i++)
			{
			    c.fillOval (b4, 370, 50, 50);
			    b4 += 30;
			}
			for (int i = 0 ; i < 11 ; i++)
			{
			    c.fillOval (d4, 340, 50, 50);
			    d4 += 30;
			}
			for (int i = 0 ; i < 10 ; i++)
			{
			    c.fillOval (e4, 310, 50, 50);
			    e4 += 30;
			}
			for (int i = 0 ; i < 8 ; i++)
			{
			    c.fillOval (g4, 280, 50, 50);
			    g4 += 30;
			}
			for (int i = 0 ; i < 6 ; i++)
			{
			    c.fillOval (h4, 250, 50, 50);
			    h4 += 30;
			}
			for (int i = 0 ; i < 4 ; i++)
			{
			    c.fillOval (k4, 220, 50, 50);
			    k4 += 30;
			}
			for (int i = 0 ; i < 2 ; i++)
			{
			    c.fillOval (m4, 200, 50, 50);
			    m4 += 30;
			}

			//Small Explosion
			int a5 = 225, b5 = 195, d5 = 180, e5 = 195, g5 = 220, h5 = 250, k5 = 280, m5 = 295;
			c.setColor (Color.red);
			c.fillRect (300, 400, 60, 150);
			for (int i = 0 ; i < 6 ; i++)
			{
			    c.fillOval (a5, 390, 50, 50);
			    a5 += 30;
			}
			for (int i = 0 ; i < 8 ; i++)
			{
			    c.fillOval (b5, 370, 50, 50);
			    b5 += 30;
			}
			for (int i = 0 ; i < 9 ; i++)
			{
			    c.fillOval (d5, 340, 50, 50);
			    d5 += 30;
			}
			for (int i = 0 ; i < 8 ; i++)
			{
			    c.fillOval (e5, 310, 50, 50);
			    e5 += 30;
			}
			for (int i = 0 ; i < 6 ; i++)
			{
			    c.fillOval (g5, 280, 50, 50);
			    g5 += 30;
			}
			for (int i = 0 ; i < 4 ; i++)
			{
			    c.fillOval (h5, 250, 50, 50);
			    h5 += 30;
			}
			for (int i = 0 ; i < 2 ; i++)
			{
			    c.fillOval (k5, 220, 50, 50);
			    k5 += 30;
			}
			c.fillOval (m2, 210, 50, 50);

			try
			{
			    Thread.sleep (500);
			}
			catch (InterruptedException error)
			{
			    c.println ("sorry couldn't delay");
			}

			c.setColor (Color.black);
			c.setFont (title = new Font ("Times New Roman", Font.BOLD, 50));
			c.drawString ("B    O   O   M!!!!", 150, 300);

			try
			{
			    Thread.sleep (1500);
			}
			catch (InterruptedException error)
			{
			    c.println ("sorry couldn't delay");
			}

			//Level of Difficulty
			c.clear ();
			c.setColor (Color.gray);
			c.fillRect (0, 0, 640, 500);

			c.setColor (Color.yellow);
			c.setFont (title = new Font ("Times New Roman", Font.BOLD, 30));
			c.drawString ("Press the level of difficulty:", 150, 180);

			c.setFont (title = new Font ("Comic Sans MS", Font.BOLD, 20));
			c.setColor (Color.orange);
			c.fillRect (30, 200, 150, 60);
			c.setColor (Color.gray);
			c.drawString ("Easy (e)", 65, 235);

			c.setColor (Color.orange);
			c.fillRect (235, 200, 170, 60);
			c.setColor (Color.gray);
			c.drawString ("Medium (m)", 260, 235);

			c.setColor (Color.orange);
			c.fillRect (455, 200, 150, 60);
			c.setColor (Color.gray);
			c.drawString ("Hard (h)", 490, 235);

			level = c.getChar ();

			while (level != 'e' && level != 'E' && level != 'm' && level != 'M' && level != 'h' && level != 'H')
			{
			    c.clear ();
			    c.setColor (Color.gray);
			    c.fillRect (0, 0, 640, 500);

			    c.setColor (Color.red);
			    c.setFont (title = new Font ("Times New Roman", Font.BOLD, 40));
			    c.drawString ("INVALID INPUT", 150, 140);

			    c.setColor (Color.yellow);
			    c.setFont (title = new Font ("Times New Roman", Font.BOLD, 30));
			    c.drawString ("Please re-press the level of difficulty: ", 100, 180);

			    c.setFont (title = new Font ("Comic Sans MS", Font.BOLD, 20));
			    c.setColor (Color.orange);
			    c.fillRect (30, 200, 150, 60);
			    c.setColor (Color.gray);
			    c.drawString ("Easy (e)", 65, 235);

			    c.setColor (Color.orange);
			    c.fillRect (235, 200, 170, 60);
			    c.setColor (Color.gray);
			    c.drawString ("Medium (m)", 260, 235);

			    c.setColor (Color.orange);
			    c.fillRect (455, 200, 150, 60);
			    c.setColor (Color.gray);
			    c.drawString ("Hard (h)", 490, 235);
			    level = c.getChar ();
			}
			if (level == 'e' || level == 'E')
			{
			    hight = 10;
			    length = 10;
			    nummine = 10;
			    score = 1000;

			    int spiral = 1;
			    int cswitch = 1;
			    for (int spin = 0 ; spin < 360 ; spin++)
			    {
				if (cswitch == 1)
				{
				    c.setColor (ocean);
				    cswitch = 2;
				}
				else if (cswitch == 2)
				{
				    c.setColor (Color.green);
				    cswitch = 1;
				}
				c.fillArc (-110, -125, 880, 750, spiral, 1);
				spiral++;

				try
				{
				    Thread.sleep (5);
				}
				catch (InterruptedException error)
				{
				    c.println ("sorry couldn't delay");
				}
			    }
			}
			else if (level == 'm' || level == 'M')
			{
			    hight = 15;
			    length = 15;
			    nummine = 45;
			    score = 2000;

			    int spiral = 1;
			    int cswitch = 1;
			    for (int spin = 0 ; spin < 360 ; spin++)
			    {
				if (cswitch == 1)
				{
				    c.setColor (ocean);
				    cswitch = 2;
				}
				else if (cswitch == 2)
				{
				    c.setColor (Color.green);
				    cswitch = 1;
				}
				c.fillArc (-110, -125, 880, 750, spiral, 1);
				spiral++;

				try
				{
				    Thread.sleep (5);
				}
				catch (InterruptedException error)
				{
				    c.println ("sorry couldn't delay");
				}
			    }
			}
			else
			{
			    hight = 20;
			    length = 20;
			    nummine = 120;
			    score = 3000;

			    int spiral = 1;
			    int cswitch = 1;
			    for (int spin = 0 ; spin < 360 ; spin++)
			    {
				if (cswitch == 1)
				{
				    c.setColor (ocean);
				    cswitch = 2;
				}
				else if (cswitch == 2)
				{
				    c.setColor (Color.green);
				    cswitch = 1;
				}
				c.fillArc (-110, -125, 880, 750, spiral, 1);
				spiral++;

				try
				{
				    Thread.sleep (5);
				}
				catch (InterruptedException error)
				{
				    c.println ("sorry couldn't delay");
				}
			    }
			}
			wincount = hight * length - nummine;
			ndgrid = new int [hight] [length]; //ndgrid stand for non-display grid
			dgrid = new String [hight] [length];
			InitializeDisplayGrid ();
			InitializeMine (nummine);
			CountMine ();

			int len, hei;
			boolean click;
			int x = 0;
			int y = 0;

			Play (x, y, cKey, level);

			time = (int) ((end - start) / 1000) + timerhelper;
			score = score - time;
			DisplayIntGrid ();
			if (wincount == 0)
			{
			    c.println ("You win");
			    c.println ("Your score is: " + (score));
			    HSStore ();
			}
			c.println ("It took you " + time + " seconds");
			break;
		    }
		    else if (cKey == 'l' || cKey == 'L')
		    {
			c.println ("Please enter the name of the file you wish to load (with the extension)");
			String load1 = c.readLine ();
			Save = new File (load1);
			if (Save.exists ())
			{
			    LoadGame (Save);
			    timerhelper = time;

			    int len, hei;
			    boolean click;
			    int x = 0;
			    int y = 0;

			    Play (x, y, cKey, level);
			    time += (int) ((end - start) / 1000);
			    score = score - time;
			    DisplayIntGrid ();
			    if (wincount == 0)
			    {
				c.println ("You win");
				c.println ("Your score is: " + (score));
				HSStore ();
			    }
			    c.println ("It took you " + time + " seconds");
			    break;
			}
			else
			{
			    c.clear ();

			    c.setColor (Color.gray);
			    c.fillRect (0, 0, 640, 500);

			    //Bomb Background
			    c.setColor (Brown); // Bomb 1
			    c.fillRect (155, 305, 5, 30);
			    c.setColor (Color.black);
			    c.fillOval (100, 330, 120, 120);
			    c.setColor (Fire);
			    c.fillPolygon (K, P, 3);
			    c.setColor (Color.yellow);
			    c.fillPolygon (K1, P1, 3);
			    c.setColor (Color.red);
			    c.fillPolygon (K2, P2, 3);
			    c.setColor (Color.white);
			    c.fillOval (120, 370, 10, 25);

			    c.setColor (Brown); //Bomb 2
			    c.fillRect (355, 305, 5, 30);
			    c.setColor (Color.black);
			    c.fillOval (300, 330, 120, 120);
			    c.setColor (Fire);
			    c.fillPolygon (X, Y, 3);
			    c.setColor (Color.yellow);
			    c.fillPolygon (X1, Y1, 3);
			    c.setColor (Color.red);
			    c.fillPolygon (X2, Y2, 3);
			    c.setColor (Color.white);
			    c.fillOval (320, 370, 10, 25);

			    c.setColor (Brown); // Bomb 3
			    c.fillRect (555, 255, 5, 30);
			    c.setColor (Color.black);
			    c.fillOval (500, 280, 120, 120);
			    c.setColor (Fire);
			    c.fillPolygon (A, B, 3);
			    c.setColor (Color.yellow);
			    c.fillPolygon (A1, B1, 3);
			    c.setColor (Color.red);
			    c.fillPolygon (A2, B2, 3);
			    c.setColor (Color.white);
			    c.fillOval (520, 320, 10, 25);


			    //Game Selection
			    c.setFont (button = new Font ("Comic Sans MS", Font.BOLD, 20));
			    c.setColor (Color.orange);
			    c.fillRect (120, 200, 150, 60);
			    c.setColor (Color.gray);
			    c.drawString ("New Game(n)", 130, 235);

			    c.setColor (Color.orange);
			    c.fillRect (370, 200, 150, 60);
			    c.setColor (Color.gray);
			    c.drawString ("Load Game(l)", 380, 235);

			    c.setFont (title = new Font ("Times New Roman", Font.BOLD, 40));
			    c.setColor (Color.red);
			    c.drawString ("No Saved Game Found", 120, 100);
			    c.setFont (title = new Font ("Times New Roman", Font.BOLD, 25));
			    c.setColor (Color.yellow);
			    c.drawString ("New Game will Start in 5 Seconds", 120, 150);

			    try
			    {
				Thread.sleep (5000);
			    }
			    catch (InterruptedException error)
			    {
				c.println ("sorry couldn't delay");
			    }

			    //User Name
			    c.clear ();

			    c.setColor (Color.gray);
			    c.fillRect (0, 0, 640, 500);

			    c.setColor (Color.orange);
			    c.fillOval (140, 30, 350, 100);

			    Font f;
			    c.setColor (Color.gray);
			    c.setFont (f = new Font ("Times New Roman", Font.BOLD, 40));
			    c.drawString ("Enter Your Name", 170, 90);
			    name = c.readLine ();

			    try
			    {
				Thread.sleep (1000);
			    }
			    catch (InterruptedException error)
			    {
				c.println ("sorry couldn't delay");
			    }

			    //Explosion Background
			    int a2 = 225, b2 = 195, d2 = 180, e2 = 195, g2 = 220, h2 = 250, k2 = 280, m2 = 295; //Small Explosion
			    c.setColor (Color.red);
			    c.fillRect (300, 400, 60, 150);
			    for (int i = 0 ; i < 6 ; i++)
			    {
				c.fillOval (a2, 390, 50, 50);
				a2 += 30;
			    }
			    for (int i = 0 ; i < 8 ; i++)
			    {
				c.fillOval (b2, 370, 50, 50);
				b2 += 30;
			    }
			    for (int i = 0 ; i < 9 ; i++)
			    {
				c.fillOval (d2, 340, 50, 50);
				d2 += 30;
			    }
			    for (int i = 0 ; i < 8 ; i++)
			    {
				c.fillOval (e2, 310, 50, 50);
				e2 += 30;
			    }
			    for (int i = 0 ; i < 6 ; i++)
			    {
				c.fillOval (g2, 280, 50, 50);
				g2 += 30;
			    }
			    for (int i = 0 ; i < 4 ; i++)
			    {
				c.fillOval (h2, 250, 50, 50);
				h2 += 30;
			    }
			    for (int i = 0 ; i < 2 ; i++)
			    {
				c.fillOval (k2, 220, 50, 50);
				k2 += 30;
			    }
			    c.fillOval (m2, 210, 50, 50);

			    try
			    {
				Thread.sleep (1000);
			    }
			    catch (InterruptedException error)
			    {
				c.println ("sorry couldn't delay");
			    }

			    int a1 = 210, b1 = 180, d1 = 150, e1 = 160, g1 = 190, h1 = 220, k1 = 250, m1 = 280; //Medium Explosion
			    c.setColor (Color.yellow);
			    c.fillRect (290, 400, 80, 150);
			    for (int i = 0 ; i < 7 ; i++)
			    {
				c.fillOval (a1, 390, 50, 50);
				a1 += 30;
			    }
			    for (int i = 0 ; i < 9 ; i++)
			    {
				c.fillOval (b1, 370, 50, 50);
				b1 += 30;
			    }
			    for (int i = 0 ; i < 11 ; i++)
			    {
				c.fillOval (d1, 340, 50, 50);
				d1 += 30;
			    }
			    for (int i = 0 ; i < 10 ; i++)
			    {
				c.fillOval (e1, 310, 50, 50);
				e1 += 30;
			    }
			    for (int i = 0 ; i < 8 ; i++)
			    {
				c.fillOval (g1, 280, 50, 50);
				g1 += 30;
			    }
			    for (int i = 0 ; i < 6 ; i++)
			    {
				c.fillOval (h1, 250, 50, 50);
				h1 += 30;
			    }
			    for (int i = 0 ; i < 4 ; i++)
			    {
				c.fillOval (k1, 220, 50, 50);
				k1 += 30;
			    }
			    for (int i = 0 ; i < 2 ; i++)
			    {
				c.fillOval (m1, 200, 50, 50);
				m1 += 30;
			    }

			    //Small Explosion
			    int a3 = 225, b3 = 195, d3 = 180, e3 = 195, g3 = 220, h3 = 250, k3 = 280, m3 = 295;
			    c.setColor (Color.red);
			    c.fillRect (300, 400, 60, 150);
			    for (int i = 0 ; i < 6 ; i++)
			    {
				c.fillOval (a3, 390, 50, 50);
				a3 += 30;
			    }
			    for (int i = 0 ; i < 8 ; i++)
			    {
				c.fillOval (b3, 370, 50, 50);
				b3 += 30;
			    }
			    for (int i = 0 ; i < 9 ; i++)
			    {
				c.fillOval (d3, 340, 50, 50);
				d3 += 30;
			    }
			    for (int i = 0 ; i < 8 ; i++)
			    {
				c.fillOval (e3, 310, 50, 50);
				e3 += 30;
			    }
			    for (int i = 0 ; i < 6 ; i++)
			    {
				c.fillOval (g3, 280, 50, 50);
				g3 += 30;
			    }
			    for (int i = 0 ; i < 4 ; i++)
			    {
				c.fillOval (h3, 250, 50, 50);
				h3 += 30;
			    }
			    for (int i = 0 ; i < 2 ; i++)
			    {
				c.fillOval (k3, 220, 50, 50);
				k3 += 30;
			    }
			    c.fillOval (m3, 210, 50, 50);

			    try
			    {
				Thread.sleep (1000);
			    }
			    catch (InterruptedException error)
			    {
				c.println ("sorry couldn't delay");
			    }

			    int a = 170, b = 120, d = 90, e = 100, g = 120, h = 150, k = 180, m = 210, n = 270; // Big Explosion
			    c.setColor (Fire);
			    c.fillRect (280, 400, 100, 150);
			    for (int i = 0 ; i < 10 ; i++)
			    {
				c.fillOval (a, 390, 50, 50);
				a += 30;
			    }
			    for (int i = 0 ; i < 13 ; i++)
			    {
				c.fillOval (b, 370, 50, 50);
				b += 30;
			    }
			    for (int i = 0 ; i < 15 ; i++)
			    {
				c.fillOval (d, 340, 50, 50);
				d += 30;
			    }
			    for (int i = 0 ; i < 14 ; i++)
			    {
				c.fillOval (e, 310, 50, 50);
				e += 30;
			    }
			    for (int i = 0 ; i < 13 ; i++)
			    {
				c.fillOval (g, 270, 50, 50);
				g += 30;
			    }
			    for (int i = 0 ; i < 11 ; i++)
			    {
				c.fillOval (h, 240, 50, 50);
				h += 30;
			    }
			    for (int i = 0 ; i < 9 ; i++)
			    {
				c.fillOval (k, 210, 50, 50);
				k += 30;
			    }
			    for (int i = 0 ; i < 7 ; i++)
			    {
				c.fillOval (m, 190, 50, 50);
				m += 30;
			    }
			    for (int i = 0 ; i < 3 ; i++)
			    {
				c.fillOval (n, 170, 50, 50);
				n += 30;
			    }

			    //Medium Explosion
			    int a4 = 210, b4 = 180, d4 = 150, e4 = 160, g4 = 190, h4 = 220, k4 = 250, m4 = 280;
			    c.setColor (Color.yellow);
			    c.fillRect (290, 400, 80, 150);
			    for (int i = 0 ; i < 7 ; i++)
			    {
				c.fillOval (a4, 390, 50, 50);
				a4 += 30;
			    }
			    for (int i = 0 ; i < 9 ; i++)
			    {
				c.fillOval (b4, 370, 50, 50);
				b4 += 30;
			    }
			    for (int i = 0 ; i < 11 ; i++)
			    {
				c.fillOval (d4, 340, 50, 50);
				d4 += 30;
			    }
			    for (int i = 0 ; i < 10 ; i++)
			    {
				c.fillOval (e4, 310, 50, 50);
				e4 += 30;
			    }
			    for (int i = 0 ; i < 8 ; i++)
			    {
				c.fillOval (g4, 280, 50, 50);
				g4 += 30;
			    }
			    for (int i = 0 ; i < 6 ; i++)
			    {
				c.fillOval (h4, 250, 50, 50);
				h4 += 30;
			    }
			    for (int i = 0 ; i < 4 ; i++)
			    {
				c.fillOval (k4, 220, 50, 50);
				k4 += 30;
			    }
			    for (int i = 0 ; i < 2 ; i++)
			    {
				c.fillOval (m4, 200, 50, 50);
				m4 += 30;
			    }

			    //Small Explosion
			    int a5 = 225, b5 = 195, d5 = 180, e5 = 195, g5 = 220, h5 = 250, k5 = 280, m5 = 295;
			    c.setColor (Color.red);
			    c.fillRect (300, 400, 60, 150);
			    for (int i = 0 ; i < 6 ; i++)
			    {
				c.fillOval (a5, 390, 50, 50);
				a5 += 30;
			    }
			    for (int i = 0 ; i < 8 ; i++)
			    {
				c.fillOval (b5, 370, 50, 50);
				b5 += 30;
			    }
			    for (int i = 0 ; i < 9 ; i++)
			    {
				c.fillOval (d5, 340, 50, 50);
				d5 += 30;
			    }
			    for (int i = 0 ; i < 8 ; i++)
			    {
				c.fillOval (e5, 310, 50, 50);
				e5 += 30;
			    }
			    for (int i = 0 ; i < 6 ; i++)
			    {
				c.fillOval (g5, 280, 50, 50);
				g5 += 30;
			    }
			    for (int i = 0 ; i < 4 ; i++)
			    {
				c.fillOval (h5, 250, 50, 50);
				h5 += 30;
			    }
			    for (int i = 0 ; i < 2 ; i++)
			    {
				c.fillOval (k5, 220, 50, 50);
				k5 += 30;
			    }
			    c.fillOval (m2, 210, 50, 50);

			    try
			    {
				Thread.sleep (500);
			    }
			    catch (InterruptedException error)
			    {
				c.println ("sorry couldn't delay");
			    }

			    c.setColor (Color.black);
			    c.setFont (title = new Font ("Times New Roman", Font.BOLD, 50));
			    c.drawString ("B    O   O   M!!!!", 150, 300);

			    try
			    {
				Thread.sleep (1500);
			    }
			    catch (InterruptedException error)
			    {
				c.println ("sorry couldn't delay");
			    }


			    //Level of Difficulty
			    c.clear ();
			    c.setColor (Color.gray);
			    c.fillRect (0, 0, 640, 500);

			    c.setColor (Color.yellow);
			    c.setFont (title = new Font ("Times New Roman", Font.BOLD, 30));
			    c.drawString ("Press the level of difficulty:", 150, 180);

			    c.setFont (title = new Font ("Comic Sans MS", Font.BOLD, 20));
			    c.setColor (Color.orange);
			    c.fillRect (30, 200, 150, 60);
			    c.setColor (Color.gray);
			    c.drawString ("Easy (e)", 65, 235);

			    c.setColor (Color.orange);
			    c.fillRect (235, 200, 170, 60);
			    c.setColor (Color.gray);
			    c.drawString ("Medium (m)", 260, 235);

			    c.setColor (Color.orange);
			    c.fillRect (455, 200, 150, 60);
			    c.setColor (Color.gray);
			    c.drawString ("Hard (h)", 490, 235);

			    level = c.getChar ();

			    while (level != 'e' && level != 'E' && level != 'm' && level != 'M' && level != 'h' && level != 'H')
			    {
				c.clear ();
				c.setColor (Color.gray);
				c.fillRect (0, 0, 640, 500);

				c.setColor (Color.red);
				c.setFont (title = new Font ("Times New Roman", Font.BOLD, 40));
				c.drawString ("INVALID INPUT", 150, 140);

				c.setColor (Color.yellow);
				c.setFont (title = new Font ("Times New Roman", Font.BOLD, 30));
				c.drawString ("Please re-press the level of difficulty: ", 100, 180);

				c.setFont (title = new Font ("Comic Sans MS", Font.BOLD, 20));
				c.setColor (Color.orange);
				c.fillRect (30, 200, 150, 60);
				c.setColor (Color.gray);
				c.drawString ("Easy (e)", 65, 235);

				c.setColor (Color.orange);
				c.fillRect (235, 200, 170, 60);
				c.setColor (Color.gray);
				c.drawString ("Medium (m)", 260, 235);

				c.setColor (Color.orange);
				c.fillRect (455, 200, 150, 60);
				c.setColor (Color.gray);
				c.drawString ("Hard (h)", 490, 235);
				level = c.getChar ();
			    }
			    if (level == 'e' || level == 'E')
			    {
				hight = 10;
				length = 10;
				nummine = 10;
				score = 1000;

				int spiral = 1;
				int cswitch = 1;
				for (int spin = 0 ; spin < 360 ; spin++)
				{
				    if (cswitch == 1)
				    {
					c.setColor (ocean);
					cswitch = 2;
				    }
				    else if (cswitch == 2)
				    {
					c.setColor (Color.green);
					cswitch = 1;
				    }
				    c.fillArc (-110, -125, 880, 750, spiral, 1);
				    spiral++;

				    try
				    {
					Thread.sleep (5);
				    }
				    catch (InterruptedException error)
				    {
					c.println ("sorry couldn't delay");
				    }
				}
			    }
			    else if (level == 'm' || level == 'M')
			    {
				hight = 15;
				length = 15;
				nummine = 45;
				score = 2000;

				int spiral = 1;
				int cswitch = 1;
				for (int spin = 0 ; spin < 360 ; spin++)
				{
				    if (cswitch == 1)
				    {
					c.setColor (ocean);
					cswitch = 2;
				    }
				    else if (cswitch == 2)
				    {
					c.setColor (Color.green);
					cswitch = 1;
				    }
				    c.fillArc (-110, -125, 880, 750, spiral, 1);
				    spiral++;

				    try
				    {
					Thread.sleep (5);
				    }
				    catch (InterruptedException error)
				    {
					c.println ("sorry couldn't delay");
				    }
				}
			    }
			    else
			    {
				hight = 20;
				length = 20;
				nummine = 120;
				score = 3000;

				int spiral = 1;
				int cswitch = 1;
				for (int spin = 0 ; spin < 360 ; spin++)
				{
				    if (cswitch == 1)
				    {
					c.setColor (ocean);
					cswitch = 2;
				    }
				    else if (cswitch == 2)
				    {
					c.setColor (Color.green);
					cswitch = 1;
				    }
				    c.fillArc (-110, -125, 880, 750, spiral, 1);
				    spiral++;

				    try
				    {
					Thread.sleep (5);
				    }
				    catch (InterruptedException error)
				    {
					c.println ("sorry couldn't delay");
				    }
				}
			    }
			    wincount = hight * length - nummine;
			    ndgrid = new int [hight] [length]; //ndgrid stand for non-display grid
			    dgrid = new String [hight] [length];
			    InitializeDisplayGrid ();
			    InitializeMine (nummine);
			    CountMine ();

			    int len, hei;
			    boolean click;
			    int x = 0;
			    int y = 0;
			    Play (x, y, cKey, level);
			    time = (int) ((end - start) / 1000);
			    score = score - time;
			    DisplayIntGrid ();
			    if (wincount == 0)
			    {
				c.println ("You win");
				c.println ("Your score is: " + (score));
				HSStore ();
			    }
			    c.println ("It took you " + time + " seconds");
			    break;
			}
		    }
		}

		else if (cKey == 's' || cKey == 'S')
		{
		    HSDisplay ();
		    c.setColor (Color.yellow);
		    c.setFont (a = new Font ("Times New Roman", Font.BOLD, 25));
		    c.drawString ("Enter (p) to play, (i) for instructions or (q) to quit", 110, 475);
		    c.setFont (a = new Font ("Comic Sans MS", Font.BOLD, 20));
		}

		else if (cKey == 'i' || cKey == 'I')
		{
		    Instruction ();
		    c.setColor (Color.yellow);
		    c.setFont (a = new Font ("Times New Roman", Font.BOLD, 25));
		    c.drawString ("Enter (p) to play, (s) for highscore or (q) to quit", 50, 450);
		    c.setFont (a = new Font ("Comic Sans MS", Font.BOLD, 20));
		}

		else if (cKey == 'q' || cKey == 'Q')
		{
		    c.close ();
		}
	    }
	    while (true);
	    c.println ("Do you wish to try again? Enter (y) for yes or (n) for no.");
	    restart = c.getChar ();
	    while (restart != 'y' && restart != 'n')
	    {
		c.println ("Invalid Input!");
		restart = c.getChar ();
	    }
	    if (restart == 'n')
	    {
		c.close ();
	    }
	    finish = false;
	}
	while (restart == 'y');
    } // main method


    public static int HSlength () throws IOException //determine the length of the hs
    {
	int counter = 0;
	f = new File ("HighScore.txt");
	BufferedReader input = new BufferedReader (new FileReader (f));
	String line;
	line = input.readLine ();
	if (f.exists () == false)
	{
	    return 0;
	}
	else
	{
	    while (line != null)
	    {
		line = input.readLine ();
		line = input.readLine ();
		counter++;
	    }
	    return counter;
	}
    }


    public static void HS () throws IOException //helper method for the high score
    {
	f = new File ("HighScore.txt");
	if (f.exists ())
	{
	    BufferedReader input = new BufferedReader (new FileReader (f));
	    int counter = 0;
	    String line = input.readLine ();
	    while (counter < 11 && line != null)
	    {
		highname [counter] = line;
		line = input.readLine ();
		//c.println (line);
		if (line == null)
		{
		    break;
		}
		highscore [counter] = Integer.parseInt (line);
		counter++;
		line = input.readLine ();
	    }
	    InsertionSort (HSlength ());

	    PrintWriter Input = new PrintWriter (new FileWriter (f));
	    for (int i = 0 ; i < 10 ; i++)
	    {
		if (highname [i] != null && highscore [i] != 0)
		{
		    Input.println (highname [i]);
		    Input.println (highscore [i]);
		}
	    }
	    Input.close ();
	}
    }


    public static void HSStore () throws IOException //stores a new high score
    {
	HS ();
	if (f.exists () == false)
	{
	    String FileIn = "HighScore.txt";
	    PrintWriter Input = new PrintWriter (new FileWriter (FileIn));
	    Input.println (name);
	    Input.println (score);
	    Input.close ();
	}


	else
	{
	    PrintWriter Input = new PrintWriter (new FileWriter (f));
	    Input.println (name);
	    Input.println (score);
	    for (int i = 0 ; i < 10 ; i++)
	    {
		if (highname [i] != null && highscore [i] != 0)
		{
		    Input.println (highname [i]);
		    Input.println (highscore [i]);
		}
	    }
	    Input.close ();
	}
	HS ();
    }


    public static void HSDisplay () throws IOException //displayes the top 10 high scores
    {
	HS ();
	c.clear ();
	int x = 80, y = 80;
	c.setColor (Color.gray);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.orange);
	c.setFont (a = new Font ("Comic Sans MS", Font.BOLD, 30));
	c.drawString ("Rank         Name        Score", 20, 40);
	for (int i = 0 ; i < 10 ; i++)
	{
	    if (highname [i] != null && highscore [i] != 0)
	    {
		c.setFont (a = new Font ("Comic Sans MS", Font.BOLD, 20));
		c.drawString ((i + 1) + "                   " + highname [i], 40, y);
		c.drawString ("                        " + highscore [i], 200, x);
		x = x + 25;
		y = y + 25;
	    }
	}

	c.setColor (Color.yellow);
    }


    public static void InsertionSort (int hslength)  //sorts the high scores in descending order
    {
	for (int i = 1 ; i < hslength ; i++)
	{
	    int valueToSort = highscore [i];
	    String temp = highname [i];
	    int j = i;
	    while (j > 0 && highscore [j - 1] < valueToSort)
	    {
		highscore [j] = highscore [j - 1];
		highname [j] = highname [j - 1];
		j--;
	    }
	    highscore [j] = valueToSort;
	    highname [j] = temp;
	}
    }


    public static void Play (int x, int y, char C, char level) throws IOException //this method allows the user to play the actual game
    {
	start = System.currentTimeMillis ();
	do
	{
	    timer = (int) (System.currentTimeMillis () - start) / 1000;
	    Display (x, y);
	    c.println ("Number of boxes you still have to open in order to win: " + wincount);
	    c.println ("Time (in second) elapsed until now: " + (timerhelper + timer));
	    while (true)
	    {

		C = c.getChar ();
		if (C == 32) //if space (flag)
		{
		    if (dgrid [x] [y].equals ("X "))
		    {
			dgrid [x] [y] = "F ";
		    }
		    break;
		}
		else if (C == 10) //if enter (click)
		{

		    if (dgrid [x] [y].equals ("X ")) //Open it
		    {

			if (ndgrid [x] [y] == -1)
			{
			    c.println ("You lose");
			    score = 0;
			    finish = true;
			}
			else if (ndgrid [x] [y] == 0)
			{
			    //wincount--;
			    RecursiveEmpty (x, y);
			}
			else
			{
			    wincount--;
			    dgrid [x] [y] = Integer.toString (ndgrid [x] [y]) + " ";
			}
			break;
		    }
		    else if (dgrid [x] [y].equals ("F "))
		    {
			dgrid [x] [y] = "X ";
		    }
		    break;
		}
		else if (C == 'w' || C == 'W' || C == '8')
		{
		    x--;
		    if (x < 0)
		    {
			x += hight;
		    }
		    break;
		}
		else if (C == 's' || C == 'S' || C == '5')
		{
		    x++;
		    if (x >= hight)
		    {
			x -= hight;
		    }
		    break;
		}
		else if (C == 'a' || C == 'A' || C == '4')
		{
		    y--;
		    if (y < 0)
		    {
			y += length;
		    }
		    break;
		}
		else if (C == 'd' || C == 'D' || C == '6')
		{
		    y++;
		    if (y >= length)
		    {
			y -= length;
		    }
		    break;
		}
		else if (C == 'K' || C == 'k')
		{
		    end = System.currentTimeMillis ();
		    time = (int) ((end - start) / 1000) + timerhelper;
		    SaveGame (level);
		}
		else if (C == 'Q' || C == 'q')
		{
		    c.close ();
		}

	    }
	}
	while (finish == false && wincount > 0);
	end = System.currentTimeMillis ();
    }


    public static void RecursiveEmpty (int h, int l)  //method used to recursively open empty boxes
    {
	if (l >= 0 && l < length && h >= 0 && h < hight)
	{
	    if (ndgrid [h] [l] == 0 && dgrid [h] [l].equals ("X "))
	    {
		dgrid [h] [l] = Integer.toString (ndgrid [h] [l]) + " ";
		wincount--;
		RecursiveEmpty (h - 1, l);
		RecursiveEmpty (h + 1, l);
		RecursiveEmpty (h, l + 1);
		RecursiveEmpty (h, l - 1);
		RecursiveEmpty (h - 1, l + 1);
		RecursiveEmpty (h + 1, l + 1);
		RecursiveEmpty (h - 1, l - 1);
		RecursiveEmpty (h + 1, l - 1);
	    }
	    else if (ndgrid [h] [l] > 0 && dgrid [h] [l].equals ("X ")) //if cell is adj to mines and it's not opened and not flagged
	    {
		dgrid [h] [l] = Integer.toString (ndgrid [h] [l]) + " ";
		wincount--;

	    }
	}
    }


    public static void DisplayIntGrid ()  //this desplayes the answer grid when the user loses
    {
	for (int i = 0 ; i < length ; i++)
	{
	    c.print (i);
	    if (i < 10)
	    {
		c.print (" ");
	    }
	}

	c.println ();
	for (int i = 0 ; i < hight ; i++)
	{
	    for (int q = 0 ; q < length ; q++)
	    {
		if (ndgrid [i] [q] == -1)
		{
		    c.setTextBackgroundColor (Color.red);
		    c.print ("B ");
		    c.setTextBackgroundColor (Color.white);
		}
		else
		{
		    c.print (ndgrid [i] [q] + " ");
		}
	    }
	    c.println (" " + i);
	}
    }


    public static void Display (int x, int y)  //this method keeps displaying the grid when the user plays
    {
	c.clear ();
	c.println (name + ":  |WASD - Move| |Enter - Open| |Space Bar - Flag| |K - Save| |Q - Quit|  ");
	if (level == 'e' || level == 'E' || level == 'm' || level == 'M')
	{
	    c.println ();
	}
	for (int i = 0 ; i < length ; i++)
	{
	    c.print (i);
	    if (i < 10)
	    {
		c.print (" ");
	    }
	}


	c.println ();
	for (int i = 0 ; i < hight ; i++)
	{
	    for (int q = 0 ; q < length ; q++)
	    {
		if (dgrid [i] [q].equals ("F "))
		{
		    c.setTextBackgroundColor (Color.red);
		}
		else if (dgrid [i] [q].equals ("0 ") || dgrid [i] [q].equals ("1 ") || dgrid [i] [q].equals ("2 ") || dgrid [i] [q].equals ("3 ") || dgrid [i] [q].equals ("4 ") || dgrid [i] [q].equals ("5 ") || dgrid [i] [q].equals ("6 ") || dgrid [i] [q].equals ("7 ") || dgrid [i] [q].equals ("8 "))
		{
		    c.setTextBackgroundColor (Color.yellow);
		}
		if (i == x && q == y)
		{
		    c.setTextBackgroundColor (Color.green);
		}
		c.print (dgrid [i] [q]);
		c.setTextBackgroundColor (Color.white);
	    }
	    c.println (" " + i);
	}
    }


    public static void CountMine ()  //this method adds hints
    {
	for (int h = 0 ; h < hight ; h++)
	{
	    for (int l = 0 ; l < length ; l++)
	    {
		if (ndgrid [h] [l] == -1)
		{
		    if (h != 0 && l != 0 && ndgrid [h - 1] [l - 1] != -1) //up left
		    {
			ndgrid [h - 1] [l - 1]++;
		    }
		    if (h != 0 && l != length - 1 && ndgrid [h - 1] [l + 1] != -1) //up right
		    {
			ndgrid [h - 1] [l + 1]++;
		    }
		    if (h != hight - 1 && l != 0 && ndgrid [h + 1] [l - 1] != -1) //down left
		    {
			ndgrid [h + 1] [l - 1]++;
		    }
		    if (h != hight - 1 && l != length - 1 && ndgrid [h + 1] [l + 1] != -1) //down right
		    {
			ndgrid [h + 1] [l + 1]++;
		    }
		    if (l != 0 && ndgrid [h] [l - 1] != -1) //left
		    {
			ndgrid [h] [l - 1]++;
		    }
		    if (l != length - 1 && ndgrid [h] [l + 1] != -1) //right
		    {
			ndgrid [h] [l + 1]++;
		    }
		    if (h != 0 && ndgrid [h - 1] [l] != -1) //up
		    {
			ndgrid [h - 1] [l]++;
		    }
		    if (h != hight - 1 && ndgrid [h + 1] [l] != -1) //down
		    {
			ndgrid [h + 1] [l]++;
		    }

		}
	    }
	}
    }


    public static void InitializeMine (int n)  //this method randomly places a number n of mines on the grid
    {
	int counter = 0;
	int high;
	int len;
	while (counter < n)
	{
	    high = (int) (Math.random () * (hight));
	    len = (int) (Math.random () * (length));
	    if (ndgrid [high] [len] != -1)
	    {
		ndgrid [high] [len] = -1;
		counter++;
	    }
	}
    }


    public static void InitializeDisplayGrid ()  //this method initializes the diaplyable grid and prints it
    {
	for (int i = 0 ; i < length ; i++)
	{
	    c.print (i);
	    if (i < 10)
	    {
		c.print (" ");
	    }
	}


	c.println ();
	for (int i = 0 ; i < hight ; i++)
	{
	    for (int q = 0 ; q < length ; q++)
	    {
		dgrid [i] [q] = "X ";
		c.print (dgrid [i] [q]);
	    }
	    c.println (" " + i);
	}
    }


    public static void Instruction ()  //this method displayes the instructions
    {
	Font h;
	char k;
	c.setColor (Color.gray);
	c.fillRect (0, 0, 640, 500);

	c.setColor (Color.yellow);
	c.setFont (h = new Font ("Times New Roman", Font.BOLD, 40));
	c.drawString ("Instruction", 220, 40);

	c.setFont (h = new Font ("Comic Sans MS", Font.BOLD, 15));
	c.setColor (Color.orange);
	c.drawString ("The goal of the game is to find and detonate all mines.", 0, 80);
	c.drawString ("The game is dividided into 3 levels: Easy, Medium, Hard. Higher the level, the larger ", 0, 120);
	c.drawString ("the grid size, greater number of mines and points will be.", 0, 140);
	c.drawString ("In the beginning, you can either start a new game or load a game that you have", 0, 180);
	c.drawString ("left off from your previous gameplay. If you begin a new game, you will be asekd to", 0, 200);
	c.drawString ("enter your name, and select the level of difficulty.", 0, 220);
	c.drawString ("During the game, you will be able to move up, down, left, and right using keys from", 0, 260);
	c.drawString ("keyboard, WASD. Also, you will have 3 options. You can open a cell, flag a cell", 0, 280);
	c.drawString ("or save the game. If you open a cell by pressing enter, it will show a number which", 0, 300);
	c.drawString ("will tell you how many mines there are near by that cell. Otherwise, if you know a", 0, 320);
	c.drawString ("certain cell contains a mine, you can flag it by pressing spacebar.", 0, 340);
	c.drawString ("Once a game finishes, it will show how much time it took you to finish, and it will", 0, 380);
	c.drawString ("save your score in the game.", 0, 400);
    }


    public static void SaveGame (char level) throws IOException //this method allows the user to save the game
    {
	c.println ("Enter the name of the file (with the extension)");
	String FileIn = c.readLine ();
	PrintWriter Input = new PrintWriter (new FileWriter (FileIn));
	Input.println (time); //time in seconds
	Input.println (name);
	Input.println (level);
	Input.println (wincount);
	for (int i = 0 ; i < hight ; i++)
	{
	    for (int q = 0 ; q < length ; q++)
	    {
		Input.println (dgrid [i] [q]);
	    }
	}


	for (int i = 0 ; i < hight ; i++)
	{
	    for (int q = 0 ; q < length ; q++)
	    {
		if (ndgrid [i] [q] == -1)
		{
		    Input.println ("-1");

		}
		else
		{
		    Input.println (ndgrid [i] [q]);
		}
	    }
	}
	Input.close ();
    }


    public static void LoadGame (File Save) throws IOException //this method allows the user to load a game
    {
	InitializeDisplayGrid ();

	if (Save.exists ())
	{
	    BufferedReader input = new BufferedReader (new FileReader (Save));
	    String line;
	    line = input.readLine ();
	    time = Integer.parseInt (line);
	    line = input.readLine ();
	    name = line;
	    line = input.readLine ();
	    if (line.equals ("e"))
	    {
		hight = 10;
		length = 10;
		nummine = 10;
		score = 1000;
		level = 'e';

	    }
	    else if (line.equals ("m"))
	    {
		hight = 15;
		length = 15;
		nummine = 45;
		score = 2000;
		level = 'm';
	    }
	    else
	    {
		hight = 20;
		length = 20;
		nummine = 120;
		score = 3000;
		level = 'h';
	    }
	    ndgrid = new int [hight] [length]; //ndgrid stand for non-display grid
	    dgrid = new String [hight] [length];
	    line = input.readLine ();
	    wincount = Integer.parseInt (line);
	    for (int i = 0 ; i < hight ; i++)
	    {
		for (int q = 0 ; q < length ; q++)
		{
		    line = input.readLine ();
		    dgrid [i] [q] = line;
		}
	    }
	    for (int i = 0 ; i < hight ; i++)
	    {
		for (int q = 0 ; q < length ; q++)
		{
		    line = input.readLine ();
		    ndgrid [i] [q] = Integer.parseInt (line);

		}
	    }
	    input.close ();
	}
    }
} // MineSweeper class


