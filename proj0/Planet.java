public class Planet
{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	
	// consturctor//
	public Planet(double xP, double yP, double xV,
			double yV, double m, String img)
	{
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	// constructor 2)//
	public Planet(Planet p)
	{
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	//calculate the distance//
	public double calcDistance(Planet p)
	{
		return Math.sqrt((p.xxPos - this.xxPos) * (p.xxPos - this.xxPos) + 
			(p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));
	}

	//calculate the Force//
	public double calcForceExertedBy(Planet p)
	{
		double G = 6.67e-11;
		return G * this.mass * p.mass/this.calcDistance(p)/this.calcDistance(p);
	}

	//calculate the x force//
	public double calcForceExertedByX(Planet p)
	{
		return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos)/this.calcDistance(p);
	}

	//calculate the y force//
	public double calcForceExertedByY(Planet p)
	{
		return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos)/this.calcDistance(p);
	}

	//calculate the toltalx force//
	public double calcNetForceExertedByX(Planet[] all)
	{
		double sum = 0;
		for (Planet p : all)
		{
			if (this.equals(p))
				continue;
			else
				sum += this.calcForceExertedByX(p);
		}
		return sum;
	}

	//calculate the toltalx force//
	public double calcNetForceExertedByY(Planet[] all)
	{
		double sum = 0;
		for (Planet p : all)
		{
			if (this.equals(p))
				continue;
			else
				sum += this.calcForceExertedByY(p);
		}
		return sum;
	}

        //update the variable//
	public void update(double dt, double xForce, double yForce)
	{
		double x_a = xForce / this.mass;
		double y_a = yForce / this.mass;
		this.xxVel += dt * x_a;
		this.yyVel += dt * y_a;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}

	public void draw()
	{
		String s = "images/" + this.imgFileName;
		StdDraw.picture(this.xxPos, this.yyPos,s);
	}
}
