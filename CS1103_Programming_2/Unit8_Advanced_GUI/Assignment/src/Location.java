/**
 * A place on Earth that weather can be looked up for.
 *
 * @param name      the place name, e.g. "Nairobi"
 * @param region    the state, county, or province (may be empty)
 * @param country   the country name (may be empty)
 * @param latitude  degrees north (negative for south), -90 to 90
 * @param longitude degrees east (negative for west), -180 to 180
 */
public record Location(String name, String region, String country,
                       double latitude, double longitude) {

    /**
     * Returns a readable label such as "Nairobi, Nairobi County, Kenya".
     *
     * @return the place name followed by the non-empty region and country
     */
    public String label() {
        StringBuilder sb = new StringBuilder(name);
        for (String part : new String[] {region, country}) {
            if (part != null && !part.isBlank() && !part.equals(name)) {
                sb.append(", ").append(part);
            }
        }
        return sb.toString();
    }
}
