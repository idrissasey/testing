package testIntegration;
import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Random;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

				
/**
 * @author idrissa.seydou-issak
 *
 */
public class MyPointTest {

	/**
	 * @throws java.lang.Exception
	 */
	MyPoint point, point2, pointM; 
	Random random1, random2;
	


	/**
	 * initialise  les variables inialiser avant exécution des cas de tests 
	 */
    
	@Before
	public void setUp() throws Exception {
		 point2 = new MyPoint(2,5);
		 point = new MyPoint();
	}

	/**
	 * Vide toutes les variables aprèsexécution des cas de tests
	 */
	@After
	public void tearDown() throws Exception {
		point2 = null;
		point = null;
	}
	

	/**
	 * Test de la méthode setPoint en utilisant un mock pour simuler les valeur du random
	 */

	@Test// (expected =  IllegalArgumentException.class)
	public void testSetPoint() {
		//fail("Not yet implemented");
		  
		Random random5=  createNiceMock(Random.class);
		Random random6 =  createNiceMock(Random.class);
		expect(random5.nextInt()).andReturn(8);
		replay(random5);
		expect(random6.nextInt()).andReturn(9);
		replay(random6);
		point.setPoint(random5, random6);
		verify(random5);
		verify(random6);
		assertEquals(8, point.getX(),000.1);
		assertEquals(9, point.getY(),000.1);


	}

   
   

	/**
	 *Test constructeur par défault MyPoint() : test que le constructeur initiliase bien les points avec les coordonnées (0,0)
	 */
	@Test
	public void testMyPoint() {
		//fail("Not yet implemented");
		assertEquals (0d, point.getX(), 0.0001);
		assertEquals (0d, point.getY(), 0.0001);
	}
	
	/**
	 * Test constructeur MyPoint(double, double) : test que le constructeur initiliase bien les points avec les coordonnées du setUp()
	 */
	@Test
	public void testMyPointDoubleDouble() {
		assertEquals (2, point2.getX(), 0.0001);
		assertEquals (5, point2.getY(), 0.0001);

	}
	
	/**
	 * Création d'un nouveau point créer à partir d'un point et Test du constructeur MyPoint(point)
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
		
		assertEquals (2, point2.getX(), 0.0001);
	}

	/**
	 * voir setY
	 */
	@Test
	public void testGetY() {
		
		assertEquals (5, point2.getY(), 0.0001);
	}

	/**
	 * Test method Scale : on test la méthode scale avec la valeur 2 et on vérifie 
	 */
	@Test
	public void testScale() {
		
		MyPoint point3 = new MyPoint(point2.scale(2));
		assertEquals (2 * point2.getX(), point3.getX(), 0.0001);
		assertEquals (2 * point2.getY(), point3.getY(), 0.0001);	
	}

	/**
	 * Test method horizontalSymmetry(MyPoint) en l'appliquant sur le point2 
	 */
	@Test 
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
		point = new MyPoint(5,10);
		MyPoint point3 = point.rotatePoint(point2,90d);
		Double cosAng = calculCos(90d);
		Double sinAng = calculSin(90d);
		Double gx =point2.getX();
		Double x = point.getX();
		Double gy =point2.getY();
		Double y = point.getY();
		//cosTheta * (x - gx) - sinTheta * (y - gy) + gx
		//assertEquals(point3.getX(),point.getX(),0.01);
		//cosTheta * (x - gx) - sinTheta * (y - gy) + gx
		assertEquals(point3.getX(),cosAng* (x - gx) - sinAng * (y - gy) + gx,0.001);
		assertEquals(point3.getY(),sinAng* (x - gx) + cosAng * (y - gy) + gy,0.001);
	}
	
	@Test
	public void testRotatePointNulle() {
		//fail("Not yet implemented");
		point = new MyPoint(5,10);
		MyPoint point3 = point.rotatePoint(point2,0d);
		assertEquals(point3.getX(),point.getX(),0.01);
		assertEquals(point3.getY(),point.getY(),0.01);
	}
	
	/**
	 * Méthode pour calculer du sin selon la valeur de l'angle afin de tester la méthode rotatePoint
	 */
	public Double calculSin(Double ang) {
	
		double sinTheta;
		double angle = ang;
		if(angle < 0d) {
			angle = 2d * PI + angle;
		}
		angle = angle % (2d * PI);
		if(Double.compare(angle - PI / 2d, 0.) == 0) {
			sinTheta = 1d;
		}else if(Double.compare(angle - PI, 0d) == 0) {
			sinTheta = 0d;
		}else if(Double.compare(angle - (3d * PI / 2d), 0d) == 0) {
			sinTheta = -1d;
		}else {
			sinTheta = Math.sin(angle);
		}
		
		return sinTheta;
	}
	/**
	 *Méthode pour calculer du cos selon la valeur de l'angle afin de tester la méthode rotatePoint
	 *
	 */
	
	public Double calculCos(double ang) {
		
		double cosTheta;
		double angle = ang;
		if(angle < 0d) {
			angle = 2d * PI + angle;
		}
		angle = angle % (2d * PI);
		if(Double.compare(angle - PI / 2d, 0.) == 0) {
			cosTheta = 0d;

		}else if(Double.compare(angle - PI, 0d) == 0) {
			cosTheta = -1d;
	
		}else if(Double.compare(angle - (3d * PI / 2d), 0d) == 0) {
			cosTheta = 0d;
		
		}else {
			cosTheta = Math.cos(angle);

		}
		return cosTheta;
	}

	/**
	 * Test method for {@link MyPoint#centralSymmetry(MyPoint)}.
	 */
	@Test
	public void testCentralSymmetry() {
		point = new MyPoint(2,15);
		MyPoint point3 = point.centralSymmetry(point2);
		MyPoint point4 = point.rotatePoint(point2, 2d * Math.PI);
		assertEquals(point3.getX(), point4.getX(),0.01);
		
	}

	/**
	 * Test method getMiddlePoint(MyPoint)
	 */
	@Test
	public void testGetMiddlePoint() {
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
	 * Test method for {@link MyPoint#translate(ITranslation)}.
	 */
	@Test
	public void testTranslateITranslation() {
		ITranslation iTrans=  createNiceMock(ITranslation.class);
		expect(iTrans.getTx()).andReturn(8);
		expect(iTrans.getTy()).andReturn(5);
		replay(iTrans);
		double x = point.getX();
		double y = point.getY();
		point.translate(iTrans);
		assertEquals(x+8, point.getX(),000.1);
		assertEquals(y+5, point.getY(),000.1);
	}
	

	@Test (expected =  IllegalArgumentException.class)
	public void testCentralSymmetryNULL ( ) {
	    new MyPoint ( 10 , 20 ).centralSymmetry( null ) ;
	}
	

    
    
}
