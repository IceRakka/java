public class NBody{
	public static double readRadius(String fname){
		In in = new In(fname);

		int N = in.readInt();
		double R = in.readDouble();

		return R;
	}

	public static Planet[] readPlanets(String fname){
		In in = new In(fname);

		int N = in.readInt();
		double R = in.readDouble();
		Planet[] ret = new Planet[N];
		int i;

		for (i=0; i<N; i++){
			double xp = in.readDouble();
			double yp = in.readDouble();
			double xv = in.readDouble();
			double yv = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			ret[i] = new Planet(xp,yp,xv,yv,m,img);
		}

		return ret;
	}

	public static void main(String[] args){
		String sT = args[0];
		String sdt = args[1];
		String filename = args[2];

		double T = Double.parseDouble(sT);
		double dt = Double.parseDouble(sdt);

		double R = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		double t = 0;
		int i;
		int N = planets.length;

		StdDraw.enableDoubleBuffering();
		StdAudio.play("audio/2001.mid");

		while (t<T){
			double[] xForces = new double[N];
			double[] yForces = new double[N];
			for (i=0; i<N; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (i=0; i<N; i++){
				planets[i].update(dt,xForces[i],yForces[i]);
			}

			StdDraw.setXscale(-R, R);
			StdDraw.setYscale(-R, R);
			StdDraw.picture(0,0,"images/starfield.jpg");

			for (i=0; i<N; i++){
				planets[i].draw();
			}

			StdDraw.show();
			StdDraw.pause(10);

			t += dt;
		}

		StdOut.printf("%d\n", N);
		StdOut.printf("%.2e\n", R);
		for (i=0; i<N; i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %12s\n",
						  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
						  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}
}