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
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job babysitter = new Job("nanny",new Employer("The Carsons"), new Location("St.Louis"), new PositionType("part time babysitter"), new CoreCompetency("Energetic"));
        String jobListing = babysitter.toString();
        assertEquals("testing to string starts with new line","_", String.valueOf(jobListing.charAt(0)));
        assertEquals("testing to string ends with new line","_", String.valueOf(jobListing.charAt(jobListing.length()-1)));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job babysitter = new Job("nanny",new Employer("The Carsons"), new Location("St.Louis"), new PositionType("part time babysitter"), new CoreCompetency("Energetic"));
        String jobListing = babysitter.toString();
        String expected = "_" +
                "\nID: 0" +
                "\nName: nanny" +
                "\nEmployer: The Carsons"+
                "\nLocation: St.Louis"+
                "\nPosition Type: part time babysitter"+
                "\nCore Competency: Energetic" +
                "\n_";
        assertEquals("to string method prints correctly",expected, jobListing);

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job babysitter = new Job("nanny",new Employer("The Carsons"), new Location("St.Louis"), null, new CoreCompetency("Energetic"));
        String jobListing = babysitter.toString();
        String expected = "_" +
                "\nID: 0" +
                "\nName: nanny" +
                "\nEmployer: The Carsons"+
                "\nLocation: St.Louis"+
                "\nPosition Type: Data not available"+
                "\nCore Competency: Energetic" +
                "\n_";
        assertEquals("to string method prints data not available if field is blank", expected, jobListing);

    }

}
