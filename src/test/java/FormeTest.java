import static org.junit.Assert.*;
import org.junit.Test;

import Forme.Carre;
import Forme.Cercle;
import Forme.GroupeForme;
import Forme.Point;
import Forme.Rectangle;
import Forme.Triangle;

public class FormeTest {
	@Test
	public void CarreTest() {
		Point p = new Point (0,0);
		Carre c = new Carre ("c1",p,5);
		System.out.println(c.toString());
		assertEquals(c.toString(), "Carre (c1, (0,0), 5)");
	}
	
	@Test
	public void RectangleTest() {
		Point p = new Point (0,0);
		Rectangle r = new Rectangle("r1",p,5,10);
		assertEquals(r.toString(), "Rectangle (r1, (0,0), 5, 10)");
	}
	
	@Test
	public void CercleTest() {
		Point p = new Point (6,2);
		Cercle c = new Cercle("c1",p,3);
		assertEquals(c.toString(), "Cercle (c1, (6,2), 3)");
	}
	
	@Test
	public void TriangleTest() {
		Point p = new Point (6,2);
		Point p2 = new Point (8,4);
		Point p3 = new Point (5,5);
		Triangle t = new Triangle("t1",p,p2,p3);
		assertEquals(t.toString(), "Triangle (t1, (6,2), (8,4), (5,5))");
	}
	
	@Test
	public void GroupeFormeTest() {
		Point p = new Point (0,0);
		Carre c = new Carre ("c1",p,5);
		
		Point p2 = new Point (0,0);
		Rectangle r = new Rectangle("r1",p2,5,10);
		
		Point p3 = new Point (6,2);
		Cercle cer = new Cercle("c1",p3,3);
		
		Point a = new Point (6,2);
		Point b = new Point (8,4);
		Point d = new Point (5,5);
		Triangle t = new Triangle("t1",a,b,d);
		
		GroupeForme ensemble1 = new GroupeForme ("dessinTest");
		ensemble1.add(c);
		ensemble1.add(r);
		ensemble1.add(cer);
		ensemble1.add(t);
		System.out.println(ensemble1.toString());
		assertEquals (ensemble1.toString(), "dessinTest (\n\n\tCarre (c1, (0,0), 5)\n\tRectangle (r1, (0,0), 5, 10)\n\t"
				+ "Cercle (c1, (6,2), 3)\n\tTriangle (t1, (6,2), (8,4), (5,5))\n\t\n)");
		
	}
	
	@Test
	public void testContainTrueGroupe() {
		GroupeForme gp = new GroupeForme("test");
		
		Point p2 = new Point (0,0);
		Rectangle r = new Rectangle("r1",p2,5,10);
		
		gp.add(r);
		assertEquals(gp.contain("r1"),true);
	}
	@Test
	public void testContainFalseGroupe() {
		GroupeForme gp = new GroupeForme("test");
		
		Point p2 = new Point (0,0);
		Rectangle r = new Rectangle("r1",p2,5,10);
		
		gp.add(r);
		assertEquals(gp.contain("rmauvais"),false);
	}
	
	@Test 
	public void testGetFormeGroupe() {
		GroupeForme gp = new GroupeForme("test");
		
		Point p2 = new Point (0,0);
		Rectangle r = new Rectangle("r1",p2,5,10);
		
		Point p3 = new Point (0,0);
		Rectangle r2 = new Rectangle("r1",p2,5,10);
		
		Point p4 = new Point (0,0);
		Rectangle r4 = new Rectangle("r5",p2,5,10);
		
		gp.add(r);
		
		assertEquals(gp.getForme("r1").toString(),r2.toString());
		assertNotEquals(gp.getForme("r1").toString(),r4.toString());
		
	}
	
	@Test 
	public void testDeleteGroupeForme() {
		GroupeForme gp = new GroupeForme("test");
		
		Point p2 = new Point (0,0);
		Rectangle r = new Rectangle("r1",p2,5,10);
		
		gp.add(r);
		gp.delete("r1");
		assertEquals(gp.getForme("r1"),null);
	}
}
