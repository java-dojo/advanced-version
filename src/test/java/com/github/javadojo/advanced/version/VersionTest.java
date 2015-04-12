package com.github.javadojo.advanced.version;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VersionTest {

    @Test(enabled = false)
    public void testParse() {
        Assert.assertNotNull(Version.parse("1"),
            "Expected a version to be created.");
    }

    @Test(enabled = false)
    public void testParseQualifier() {
        Assert.assertNotNull(Version.parse("1-SNAPSHOT"),
            "Expected a version to be created.");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, enabled = false)
    public void testParseFailed() {
        Version.parse("abc");
    }

    @Test(enabled = false)
    public void testToString() {
        Version v = Version.parse("1");
        Assert.assertNotNull(v.toString(),
            "Expected a String of the version to be created.");
    }

    @Test(enabled = false)
    public void testToStringEqualsNewVersion() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse(v1.toString());
        Assert.assertEquals(v2, v1,
            "Expected the version from toString to be equal to the newly " +
                "parsed version.");
    }

    @Test(enabled = false)
    public void testToStringEqualsNewVersionMinor() {
        Version v1 = Version.parse("1.1");
        Version v2 = Version.parse(v1.toString());
        Assert.assertEquals(v2, v1,
            "Expected the version from toString to be equal to the newly " +
                "parsed version.");
    }

    @Test(enabled = false)
    public void testToStringEqualsNewVersionQualifier() {
        Version v1 = Version.parse("1.1-SNAPSHOT");
        Version v2 = Version.parse(v1.toString());
        Assert.assertEquals(v2, v1,
            "Expected the version from toString to be equal to the newly " +
                "parsed version.");
    }

    @Test(enabled = false)
    public void testEqualsIgnoresMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.0.0");
        Assert.assertEquals(v2, v1,
            "Expected the version \"1\" to be equal to \"1.0.0\".");
    }

    @Test(enabled = false)
    public void testHashCodeIgnoresMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.0.0");
        Assert.assertEquals(v2.hashCode(), v1.hashCode(),
            "Expected the hash codes of version \"1\" and \"1.0.0\" to be " +
                "equal to.");
    }

    @Test(enabled = false)
    public void testEqualsRespectedMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.1.0");
        Assert.assertNotEquals(v2, v1,
            "Expected the version \"1\" not to be equal to \"1.1.0\".");
    }

    @Test(enabled = false)
    public void testEqualsRespecedBugfix() {
        Version v1 = Version.parse("1.2.3");
        Version v2 = Version.parse("1.2.3");
        Assert.assertEquals(v1, v2, "Expected the versions to be equal.");
    }

    @Test(enabled = false)
    public void testHashCodeRespecedBugfix() {
        Version v1 = Version.parse("1.2.3");
        Version v2 = Version.parse("1.2.3");
        Assert.assertEquals(v1.hashCode(), v2.hashCode(),
            "Expected the hash codes to be equal.");
    }

    @Test(enabled = false)
    public void testEqualsRespectedQualifierCaseInsensitive() {
        Version v1 = Version.parse("1.2.3-alpha");
        Version v2 = Version.parse("1.2.3-ALPHA");
        Assert.assertEquals(v2, v1, "Expected the versions to be equal.");
    }

    @Test(enabled = false)
    public void testHashCodeRespectedQualifierCaseInsensitive() {
        Version v1 = Version.parse("1.2.3-alpha");
        Version v2 = Version.parse("1.2.3-ALPHA");
        Assert.assertEquals(v2.hashCode(), v1.hashCode(),
            "Expected the hash codes of the versions to be equal.");
    }

    @Test(enabled = false)
    public void testEqualsRespectedSnapshotCaseSensitive() {
        Version v1 = Version.parse("1.2.3-snapshot");
        Version v2 = Version.parse("1.2.3-SNAPSHOT");
        Assert.assertNotEquals(v2, v1,
            "Expected the versions not to be equal.");
    }

    @Test(enabled = false)
    public void testComparesToIgnoresMinor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1.0.0");
        Assert.assertTrue(v2.compareTo(v1) == 0,
            "Expected the version \"1\" to be equal to \"1.0.0\".");
    }

    @Test(enabled = false)
    public void testComparesEqualMajor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("1");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1\" to be equal than \"1\".");
    }

    @Test(enabled = false)
    public void testComparesLessMajor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("2");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1\" to be less than \"2\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterMajor() {
        Version v1 = Version.parse("1");
        Version v2 = Version.parse("2");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"2\" to be greater than \"1\".");
    }

    @Test(enabled = false)
    public void testComparesEqualMinor() {
        Version v1 = Version.parse("1.1");
        Version v2 = Version.parse("1.1");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1.1\" to be equal to \"1.1\".");
    }

    @Test(enabled = false)
    public void testComparesLessMinor() {
        Version v1 = Version.parse("1.1");
        Version v2 = Version.parse("1.2");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1\" to be less than \"1.2\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterMinor() {
        Version v1 = Version.parse("1.1");
        Version v2 = Version.parse("1.2");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.2\" to be greater than \"1.1\".");
    }

    @Test(enabled = false)
    public void testComparesEqualBugfix() {
        Version v1 = Version.parse("1.1.1");
        Version v2 = Version.parse("1.1.1");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1.1.1\" to be equal to \"1.1.1\".");
    }

    @Test(enabled = false)
    public void testComparesLessBugfix() {
        Version v1 = Version.parse("1.1.1");
        Version v2 = Version.parse("1.1.2");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1.1\" to be less than \"1.1.2\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterBugfix() {
        Version v1 = Version.parse("1.1.1");
        Version v2 = Version.parse("1.1.2");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.1.2\" to be greater than \"1.1.1\".");
    }

    @Test(enabled = false)
    public void testComparesEqualP4() {
        Version v1 = Version.parse("1.1.1.1");
        Version v2 = Version.parse("1.1.1.1");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1.1.1.1\" to be equal to \"1.1.1.1\".");
    }

    @Test(enabled = false)
    public void testComparesLessP4() {
        Version v1 = Version.parse("1.1.1.1");
        Version v2 = Version.parse("1.1.1.2");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1.1.1\" to be less than \"1.1.1.2\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterP4() {
        Version v1 = Version.parse("1.1.1.1");
        Version v2 = Version.parse("1.1.1.2");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.1.1.2\" to be greater than \"1.1.1.1\".");
    }

    @Test(enabled = false)
    public void testComparesEqualP5() {
        Version v1 = Version.parse("1.1.1.1.1");
        Version v2 = Version.parse("1.1.1.1.1");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1.1.1.1.1\" to be equal to \"1.1.1.1.1\".");
    }

    @Test(enabled = false)
    public void testComparesLessP5() {
        Version v1 = Version.parse("1.1.1.1.1");
        Version v2 = Version.parse("1.1.1.1.2");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1.1.1.1\" to be less than " +
                "\"1.1.1.1.2\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterP5() {
        Version v1 = Version.parse("1.1.1.1.1");
        Version v2 = Version.parse("1.1.1.1.2");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.1.1.1.2\" to be greater than " +
                "\"1.1.1.1.1\".");
    }

    @Test(enabled = false)
    public void testComparesEqualQualifier() {
        Version v1 = Version.parse("1.1.1-SNAPSHOT");
        Version v2 = Version.parse("1.1.1-SNAPSHOT");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1.1.1-SNAPSHOT\" to be equal to " +
                "\"1.1.1-SNAPSHOT\".");
    }

    @Test(enabled = false)
    public void testComparesEqualQualifierCaseInsensitive() {
        Version v1 = Version.parse("1.1.1-alpha");
        Version v2 = Version.parse("1.1.1-ALPHA");
        Assert.assertTrue(v1.compareTo(v2) == 0,
            "Expected the version \"1.1.1-SNAPSHOT\" to be equal to " +
                "\"1.1.1-SNAPSHOT\".");
    }

    @Test(enabled = false)
    public void testComparesEqualSnapshotCaseSensitive() {
        Version v1 = Version.parse("1.1.1-snapshot");
        Version v2 = Version.parse("1.1.1-SNAPSHOT");
        Assert.assertTrue(v1.compareTo(v2) > 0,
            "Expected the version \"1.1.1-snapshot\" to be greater than " +
                "\"1.1.1-SNAPSHOT\".");
    }

    @Test(enabled = false)
    public void testComparesLessSnapshot() {
        Version v1 = Version.parse("1.1.1-SNAPSHOT");
        Version v2 = Version.parse("1.1.1-alpha");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1.1-SNAPSHOT\" to be less than " +
                "\"1.1.1-alpha\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterSnapshot() {
        Version v1 = Version.parse("1.1.1-SNAPSHOT");
        Version v2 = Version.parse("1.1.1-alpha");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.1.1-alpha\" to be greater than " +
                "\"1.1.1-SNAPSHOT\".");
    }

    @Test(enabled = false)
    public void testComparesLessQualifier() {
        Version v1 = Version.parse("1.1.1-alpha");
        Version v2 = Version.parse("1.1.1-beta");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1.1-alpha\" to be less than " +
                "\"1.1.1-beta\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterQualifier() {
        Version v1 = Version.parse("1.1.1-alpha");
        Version v2 = Version.parse("1.1.1-beta");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.1.1-beta\" to be greater than " +
                "\"1.1.1-alpha\".");
    }

    @Test(enabled = false)
    public void testComparesLessQualifierFinal() {
        Version v1 = Version.parse("1.1.1-alpha");
        Version v2 = Version.parse("1.1.1");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1.1-alpha\" to be less than " +
                "\"1.1.1\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterQualifierFinal() {
        Version v1 = Version.parse("1.1.1-alpha");
        Version v2 = Version.parse("1.1.1");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.1.1\" to be greater than " +
                "\"1.1.1-alpha\".");
    }

    @Test(enabled = false)
    public void testComparesLessQualifierNextVersion() {
        Version v1 = Version.parse("1.1.1");
        Version v2 = Version.parse("1.1.2-SNAPSHOT");
        Assert.assertTrue(v1.compareTo(v2) < 0,
            "Expected the version \"1.1.1\" to be less than " +
                "\"1.1.2-SNAPSHOT\".");
    }

    @Test(enabled = false)
    public void testComparesGreaterQualifierNextVersion() {
        Version v1 = Version.parse("1.1.1");
        Version v2 = Version.parse("1.1.2-SNAPSHOT");
        Assert.assertTrue(v2.compareTo(v1) > 0,
            "Expected the version \"1.1.2-SNAPSHOT\" to be greater than " +
                "\"1.1.1\".");
    }

}
