package com.github.javadojo.advanced.version;

/**
 * This class represents a version.
 */
public class Version implements Comparable<Version> {

    /**
     * Hide the constructor because classes should be generated with the
     * factory method {@link #parse(java.lang.String)}.
     */
    private Version() {
    }

    /**
     * Parses the given {@code String} and creates a Version out of it.
     *
     * @param toParse the {@code String} to parse.
     * @return the created version.
     */
    public static Version parse(String toParse) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(Version other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
