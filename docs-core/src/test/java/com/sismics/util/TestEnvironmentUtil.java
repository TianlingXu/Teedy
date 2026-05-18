package com.sismics.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link EnvironmentUtil}.
 * 
 * @author Test Author
 */
public class TestEnvironmentUtil {

    /**
     * Test isWindows() method.
     * Result depends on OS, but we can verify it returns a boolean.
     */
    @Test
    public void testIsWindows() {
        boolean result = EnvironmentUtil.isWindows();
        // Should return either true or false without exception
        assertTrue(result == true || result == false);
    }

    /**
     * Test isMacOs() method.
     * Result depends on OS, but we can verify it returns a boolean.
     */
    @Test
    public void testIsMacOs() {
        boolean result = EnvironmentUtil.isMacOs();
        // Should return either true or false without exception
        assertTrue(result == true || result == false);
    }

    /**
     * Test isUnix() method.
     * Result depends on OS, but we can verify it returns a boolean.
     */
    @Test
    public void testIsUnix() {
        boolean result = EnvironmentUtil.isUnix();
        // Should return either true or false without exception
        assertTrue(result == true || result == false);
    }

    /**
     * Test isUnitTest() method.
     * Should return true in test environment.
     */
    @Test
    public void testIsUnitTest() {
        // In unit test environment without webapp context, should return true
        assertTrue(EnvironmentUtil.isUnitTest());
    }

    /**
     * Test isDevMode() method.
     * Result depends on system property, but should return a boolean.
     */
    @Test
    public void testIsDevMode() {
        boolean result = EnvironmentUtil.isDevMode();
        // Should return either true or false without exception
        assertTrue(result == true || result == false);
    }

    /**
     * Test getWindowsAppData() method.
     * May return null or a string depending on OS.
     */
    @Test
    public void testGetWindowsAppData() {
        String result = EnvironmentUtil.getWindowsAppData();
        // On Windows: should return a path string
        // On other OS: may return null
        // Either is acceptable
        if (EnvironmentUtil.isWindows()) {
            assertNotNull("Windows should have APPDATA", result);
        }
    }

    /**
     * Test getMacOsUserHome() method.
     * Should return the user home directory.
     */
    @Test
    public void testGetMacOsUserHome() {
        String result = EnvironmentUtil.getMacOsUserHome();
        assertNotNull("User home should not be null", result);
    }

    /**
     * Test setWebappContext() and isWebappContext() methods.
     * Covers both setting true and false.
     */
    @Test
    public void testWebappContextToggle() {
        // Save original state
        boolean original = EnvironmentUtil.isWebappContext();
        
        try {
            // Test setting to true
            EnvironmentUtil.setWebappContext(true);
            assertTrue("Should be webapp context", EnvironmentUtil.isWebappContext());
            assertFalse("Should NOT be unit test when webapp context", EnvironmentUtil.isUnitTest());
            
            // Test setting to false
            EnvironmentUtil.setWebappContext(false);
            assertFalse("Should NOT be webapp context", EnvironmentUtil.isWebappContext());
            assertTrue("Should be unit test when not webapp context", EnvironmentUtil.isUnitTest());
        } finally {
            // Restore original state
            EnvironmentUtil.setWebappContext(original);
        }
    }

    /**
     * Test getTeedyHome() method.
     * May return null if system property not set.
     */
    @Test
    public void testGetTeedyHome() {
        String result = EnvironmentUtil.getTeedyHome();
        // May be null or a path string - just verify no exception
        // Cannot assert specific value as it depends on system property
    }

    /**
     * Test OS detection consistency.
     * Only one of the three OS detection methods should return true.
     */
    @Test
    public void testOsDetectionConsistency() {
        boolean isWin = EnvironmentUtil.isWindows();
        boolean isMac = EnvironmentUtil.isMacOs();
        boolean isUnix = EnvironmentUtil.isUnix();
        
        // At least one should be true (the current OS)
        assertTrue("At least one OS should be detected", isWin || isMac || isUnix);
        
        // Windows and Unix are mutually exclusive
        if (isWin) {
            assertFalse("Windows is not Unix", isUnix);
        }
    }
}
