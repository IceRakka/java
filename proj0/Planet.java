public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		double G = 6.67e-11;
		double r = this.calcDistance(p);
		double F = G * mass * p.mass / (r*r);
		return F;
	}

	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p)*(p.xxPos-xxPos)/this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p)*(p.yyPos-yyPos)/this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] plist){
		double Fx = 0;
		for (int i=0; i<plist.length; i++){
			if (this.equals(plist[i])){
				continue;
			}
			Fx += this.calcForceExertedByX(plist[i]);
		}
		return Fx;
	}

	public double calcNetForceExertedByY(Planet[] plist){
		double Fy = 0;
		for (int i=0; i<plist.length; i++){
			if (this.equals(plist[i])){
				continue;
			}
			Fy += this.calcForceExertedByY(plist[i]);
		}
		return Fy;
	} 

	public void update(double dt, double fx, double fy){
		double ax = fx/mass;
		double ay = fy/mass;
		xxVel += ax*dt;
		yyVel += ay*dt;
		xxPos += xxVel*dt;
		yyPos += yyVel*dt;
	}

	public void draw(){
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}
}

