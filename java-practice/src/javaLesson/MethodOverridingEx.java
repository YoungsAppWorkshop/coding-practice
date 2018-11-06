package javaLesson;

public class MethodOverridingEx {

	public static void main(String[] args) {
		DObject obj = new DObject();
		DObject l = new Line();
		DObject r = new Rectangle();
		DObject c = new Circle();
		
		obj.draw();
		l.draw();
		r.draw();
		c.draw();
		
		Line line = new Line();
		DObject p = line;
		
		p.draw();		

	}

}
