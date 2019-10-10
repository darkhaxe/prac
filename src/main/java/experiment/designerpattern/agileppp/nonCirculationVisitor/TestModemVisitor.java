package com.designerpattern.agileppp.nonCirculationVisitor;

import junit.framework.TestCase;
import com.designerpattern.agileppp.nonCirculationVisitor.UnixModemConfigurator;
/**
 * Created by simjunbo on 2018-04-19.
 */
public class TestModemVisitor extends TestCase {
    public TestModemVisitor(String name) {
        super(name);
    }

    private UnixModemConfigurator v;
    private HayesModem h;
    private ZoomModem z;
    private ErnieModem e;

    @Override
    public void setUp() {
        v = new UnixModemConfigurator();
        h = new HayesModem();
        z = new ZoomModem();
        e = new ErnieModem();
    }

    public void testHayesForUnix() {
        h.accept(v);
        assertEquals("&s1=4&D=3", h.configurationString);
    }

    public void testZoomForUnix() {
        z.accept(v);
        assertEquals(42, z.configurationValue);
    }

    public void testErnieForUnix() {
        e.accept(v);
        assertEquals("C is too slow", e.internalPattern);
    }
}
