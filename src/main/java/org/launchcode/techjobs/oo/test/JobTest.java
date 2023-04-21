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
        assertEquals(productTester.getName(),"Product tester");
        assertEquals(productTester.getEmployer().toString(),"ACME");
        assertEquals(productTester.getLocation().toString(),"Desert");
        assertEquals(productTester.getPositionType().toString(),"Quality control");
        assertEquals(productTester.getCoreCompetency().toString(),"Persistence");
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
        assertFalse(photographer.equals(photographer2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job babysitter = new Job("nanny",new Employer("The Carsons"), new Location("St.Louis"), new PositionType("part time babysitter"), new CoreCompetency("Energetic"));
        String jobListing = babysitter.toString();
        char beginning = jobListing.charAt(0);
        char end = jobListing.charAt(jobListing.length()-1);
        System.out.println("this"+beginning+"something");
        System.out.println("\n"+"ok");
        assertEquals('\n', beginning);
        assertEquals('\n', end);
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job babysitter = new Job("nanny",new Employer("The Carsons"), new Location("St.Louis"), new PositionType("part time babysitter"), new CoreCompetency("Energetic"));
        String jobListing = babysitter.toString();
        String expected = "\nID: " +babysitter.getId()+
                "\nName: nanny" +
                "\nEmployer: The Carsons"+
                "\nLocation: St.Louis"+
                "\nPosition Type: part time babysitter"+
                "\nCore Competency: Energetic" +
                "\n";
        assertEquals(expected, jobListing);

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job babysitter = new Job("nanny",new Employer("The Carsons"), new Location("St.Louis"), new PositionType(""), new CoreCompetency("Energetic"));
        String jobListing = babysitter.toString();
        String expected = "\nID: " +babysitter.getId()+
                "\nName: nanny" +
                "\nEmployer: The Carsons"+
                "\nLocation: St.Louis"+
                "\nPosition Type: Data not available"+
                "\nCore Competency: Energetic" +
                "\n";
        assertEquals(expected, jobListing);

    }

}
