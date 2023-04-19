package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job busDriver = new Job();
        Job teacher = new Job();
        assertNotEquals(busDriver, teacher);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Name of job is correct",productTester.getName(),"Product tester");
        assertEquals("employer of job is correct",productTester.getEmployer().toString(),"ACME");
        assertEquals("location of job is correct",productTester.getLocation().toString(),"Desert");
        assertEquals("position type of job is correct",productTester.getPositionType().toString(),"Quality control");
        assertEquals("core competency type of job is correct",productTester.getCoreCompetency().toString(),"Persistence");
        assertTrue(productTester instanceof Job);
        assertTrue(productTester.getEmployer() != null);
        assertTrue(productTester.getLocation() instanceof Location);
        assertTrue(productTester.getPositionType() instanceof PositionType);
        assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        Job photographer = new Job("Multimedia Coordinator",new Employer("STL City"), new Location("St.Louis"), new PositionType("photographer"), new CoreCompetency("Social Media"));
        Job photographer2 = new Job("Multimedia Coordinator",new Employer("STL City"), new Location("St.Louis"), new PositionType("photographer"), new CoreCompetency("Social Media"));
        assertFalse("jobs have different IDs", !photographer.equals(photographer2));
    }

}
