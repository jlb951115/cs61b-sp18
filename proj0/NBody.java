public class NBody
{
	public static double readRadius(String filename)
	{
		In in = new In(filename);
		in.readInt();
		return in.readDouble();
	}

	public static Planet[] readPlanets(String filename)
	{
		In in = new In(filename);
		int Planet_number = in.readInt();
		in.readDouble();
		Planet[] P = new Planet[Planet_number];
		for (int i = 0; i < Planet_number; i++)
			P[i] = new Planet(in.readDouble(), in.readDouble(),
					in.readDouble(), in.readDouble(),
					in.readDouble(), in.readString());
		return P;
	}

	public static void main(String[] args)
	{
		StdDraw.enableDoubleBuffering();
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		Planet[] P = readPlanets(args[2]);
		double universe_radius = readRadius(args[2]);
		StdDraw.setScale(-universe_radius, universe_radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for (Planet p : P)
			p.draw();
		StdDraw.show();
		double t = 0;
		while (t < T)
		{
			double[] xForce = new double[P.length];
			double[] yForce = new double[P.length];
			for (int i = 0; i < P.length; i++)
			{
				xForce[i] = P[i].calcNetForceExertedByX(P);
				yForce[i] = P[i].calcNetForceExertedByY(P);
			}
			for (int i = 0; i < P.length; i++)
				P[i].update(dt, xForce[i], yForce[i]);
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for(Planet p : P)
				p.draw();
			StdDraw.show();
			StdDraw.pause(10);
			t += dt;
		}
		StdOut.printf("%d\n", P.length);
		StdOut.printf("%.2e\n", universe_radius);
		for (int i = 0; i < P.length; i++)
		{
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					P[i].xxPos, P[i].yyPos, P[i].xxVel,
					P[i].yyVel, P[i].mass, P[i].imgFileName);
		}
	}
}
