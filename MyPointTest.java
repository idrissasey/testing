import static java.lang.Math.atan;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 */

/**
 * @author idrissa.seydou-issak
 *
 */
public class MyPointTest {

	/**
	 * @throws java.lang.Exception
	 */
	MyPoint point, point2; 
	@Before
	public void setUp() throws Exception {
		 point2 = new MyPoint(2,5);
		 point = new MyPoint();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		point2 = null;
		point = null;
	}

	/**
	 *Test constructeur MyPoint()
	 */
	@Test
	public void testMyPoint() {
		//fail("Not yet implemented");
		assertEquals (0d, point.getX(), 0.0001);
	}
	
	/**
	 * Test constructeur MyPoint(double, double)
	 */
	@Test
	public void testMyPointDoubleDouble() {
		assertEquals (2, point2.getX(), 0.0001);
		assertEquals (5, point2.getY(), 0.0001);

	}
	
	/**
	 * Test Test constructeur MyPoint(point)
	 */
	@Test
	public void testMyPointMyPoint() {
		MyPoint point3 = new MyPoint(point2);
		assertEquals (point2.getX(), point3.getX(), 0.0001);
		assertEquals (point2.getY(), point3.getY(), 0.0001);

	}
	




	/**
	 * Test method setX et getX
	 */
	@Test
	public void testSetX() {
	//	fail("Not yet implemented");
		point.setX(9);
		assertEquals (9, point.getX(), 0.0001);
		
	}
	
	/**
	 * Test method setXNaN
	 */
	@Test
	public void testSetXNaN() {
	
		point.setX(Double.NaN);
		assertEquals (Double.NaN, point.getX(), 0.0001);
		
	}
	


	/**
	 * Test method setY et getY
	 */
	@Test
	public void testSetY() {
		
		point.setY(8);
		assertEquals (8, point.getY(), 0.0001);
	}
	
	/**
	 * Test method setYNaN
	 */
	@Test
	public void testSetYNaN() {

		point.setY(Double.NaN);
		assertEquals (Double.NaN, point.getY(), 0.0001);
		
	}
	

	/**
	 * voir setX
	 */
	@Test
	public void testGetX() {
		
		//assertEquals (8, point.getY(), 0.0001);
	}

	/**
	 * voir setY
	 */
	@Test
	public void testGetY() {
		
		//assertEquals (8, point.getY(), 0.0001);
	}

	/**
	 * Test method Scale
	 */
	@Test
	public void testScale() {
		
		MyPoint point3 = new MyPoint(point2.scale(2));
		assertEquals (2 * point2.getX(), point3.getX(), 0.0001);
		assertEquals (2 * point2.getY(), point3.getY(), 0.0001);	
	}

	/**
	 * Test method horizontalSymmetry(MyPoint)
	 */
	@Test (expected =  IllegalArgumentException.class)
	public void testHorizontalSymmetry  () {
		
		MyPoint point3 = point2.horizontalSymmetry(point2);
		assertEquals (2d * point2.getX() - point3.getX()  , point3.getX(), 0.0001);
		assertEquals (point2.getY(), point3.getY(), 0.0001);
	}

	/**
	 * Test method computeAngle(MyPoint)
	 */
	@Test
	public void testComputeAngle() {
		
		final double x2 = point2.getX() - point.getX();
		final double y2 = point2.getY() - point.getY();
		Double angle = point.computeAngle(point2);
		assertNotEquals (angle, Math.PI / 3d , 0.0001);
		assertNotEquals (angle, Math.PI - atan(-y2 / x2) , 0.0001);
		assertEquals (angle, atan(y2 / x2) , 0.0001);
		
	}

	/**
	 * Test method for {@link MyPoint#rotatePoint(MyPoint, double)}.
	 */
	@Test
	public void testRotatePoint() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link MyPoint#centralSymmetry(MyPoint)}.
	 */
	@Test
	public void testCentralSymmetry() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method getMiddlePoint(MyPoint)
	 */
	@Test
	public void testGetMiddlePoint() {
		//fail("Not yet implemented");
		MyPoint point3 = point.getMiddlePoint(point2);
		assertEquals (point.getX() + point2.getX() / 2d, point3.getX(), 0.0001);
		assertEquals (point.getY() + point2.getY() / 2d, point3.getY(), 0.0001);
		
	}

	/**
	 * Test method for translate(double, double)
	 */
	@Test
	public void testTranslateDoubleDouble() {
		//fail("Not yet implemented");
		MyPoint point3 = point2;
		point2.translate(2d,3d);
		assertEquals (4d, point2.getX(), 0.0001);
		assertEquals (8d, point2.getY(), 0.0001);
	}

	/**
	 * Test method for {@link MyPoint#setPoint(java.util.Random, java.util.Random)}.
	 */
	@Test
	public void testSetPoint() {
		//fail("Not yet implemented");
		
	}

	/**
	 * Test method for {@link MyPoint#translate(ITranslation)}.
	 */
	@Test
	public void testTranslateITranslation() {
		//fail("Not yet implemented");
	}
	

	@Test (expected =  IllegalArgumentException.class)
	public void testCentralSymmetryNULL ( ) {
	    new MyPoint ( 10 , 20 ).centralSymmetry( null ) ;
	}
}
