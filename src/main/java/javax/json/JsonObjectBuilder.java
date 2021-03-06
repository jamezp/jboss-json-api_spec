package javax.json;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A builder for creating {@link JsonObject} models from scratch. This
 * interface initializes an empty JSON object model and provides methods to add
 * name/value pairs to the object model and to return the resulting object.
 * The methods in this class can be chained to add multiple name/value pairs
 * to the object.
 *
 * <p>The class {@link javax.json.Json} contains methods to create the builder
 * object. The example code below shows how to build an empty {@code JsonObject}
 * instance.
 * <pre>
 * <code>
 * JsonObject object = Json.createObjectBuilder().build();
 * </code>
 * </pre>
 *
 * <p>The class {@link JsonBuilderFactory} also contains methods to create
 * {@code JsonObjectBuilder} instances. A factory instance can be used to create
 * multiple builder instances with the same configuration. This the preferred
 * way to create multiple instances.
 *
 * <a id="JsonObjectBuilderExample1"/>
 * The example code below shows how to build a {@code JsonObject} model that
 * represents the following JSON object:
 *
 * <pre>
 * <code>
 * {
 *     "firstName": "John", "lastName": "Smith", "age": 25,
 *     "address" : {
 *         "streetAddress": "21 2nd Street",
 *         "city": "New York",
 *         "state": "NY",
 *         "postalCode": "10021"
 *     },
 *     "phoneNumber": [
 *         { "type": "home", "number": "212 555-1234" },
 *         { "type": "fax", "number": "646 555-4567" }
 *     ]
 * }
 * </code>
 * </pre>
 *
 * <p>The code to create the object shown above is the following:
 *
 * <pre>
 * <code>
 * JsonBuilderFactory factory = Json.createBuilderFactory(config);
 * JsonObject value = factory.createObjectBuilder()
 *     .add("firstName", "John")
 *     .add("lastName", "Smith")
 *     .add("age", 25)
 *     .add("address", factory.createObjectBuilder()
 *         .add("streetAddress", "21 2nd Street")
 *         .add("city", "New York")
 *         .add("state", "NY")
 *         .add("postalCode", "10021"))
 *     .add("phoneNumber", factory.createArrayBuilder()
 *         .add(factory.createObjectBuilder()
 *             .add("type", "home")
 *             .add("number", "212 555-1234"))
 *         .add(factory.createObjectBuilder()
 *             .add("type", "fax")
 *             .add("number", "646 555-4567")))
 *     .build();
 * </code>
 * </pre>
 *
 * <p>This class does <em>not</em> allow <tt>null</tt> to be used as a name or
 * value while building the JSON object
 *
 * @see JsonArrayBuilder
 */
public interface JsonObjectBuilder {

    /**
     * Adds a name/{@code JsonValue} pair to the JSON object associated with
     * this object builder. If the object contains a mapping for the specified
     * name, this method replaces the old value with the specified value.
     *
     * @param name name in the name/value pair
     * @param value value in the name/value pair
     * @return this object builder
     * @throws NullPointerException if the specified name or value is null
     */
    JsonObjectBuilder add(String name, JsonValue value);

    /**
     * Adds a name/{@code JsonString} pair to the JSON object associated with
     * this object builder. If the object contains a mapping for the specified
     * name, this method replaces the old value with the specified value.
     *
     * @param name name in the name/value pair
     * @param value value in the name/value pair
     * @return this object builder
     * @throws NullPointerException if the specified name or value is null
     */
    JsonObjectBuilder add(String name, String value);

    /**
     * Adds a name/{@code JsonNumber} pair to the JSON object associated with
     * this object builder. If the object contains a mapping for the specified
     * name, this method replaces the old value with the specified value.
     *
     * @param name name in the name/value pair
     * @param value value in the name/value pair
     * @return this object builder
     * @throws NullPointerException if the specified name or value is null
     *
     * @see JsonNumber
     */
    JsonObjectBuilder add(String name, BigInteger value);

    /**
     * Adds a name/{@code JsonNumber} pair to the JSON object associated with
     * this object builder. If the object contains a mapping for the specified
     * name, this method replaces the old value with the specified value.
     *
     * @param name name in the name/value pair
     * @param value value in the name/value pair
     * @return this object builder
     * @throws NullPointerException if the specified name or value is null
     *
     * @see JsonNumber
     */
    JsonObjectBuilder add(String name, BigDecimal value);

    /**
     * Adds a name/{@code JsonNumber} pair to the JSON object associated with
     * this object builder. If the object contains a mapping for the specified
     * name, this method replaces the old value with the specified value.
     *
     * @param name name in the name/value pair
     * @param value value in the name/value pair
     * @return this object builder
     * @throws NullPointerException if the specified name is null
     *
     * @see JsonNumber
     */
    JsonObjectBuilder add(String name, int value);

    /**
     * Adds a name/{@code JsonNumber} pair to the JSON object associated with
     * this object builder. If the object contains a mapping for the specified
     * name, this method replaces the old value with the specified value.
     *
     * @param name name in the name/value pair
     * @param value value in the name/value pair
     * @return this object builder
     * @throws NullPointerException if the specified name is null
     *
     * @see JsonNumber
     */
    JsonObjectBuilder add(String name, long value);

    /**
     * Adds a name/{@code JsonNumber} pair to the JSON object associated with
     * this object builder. If the object contains a mapping for the specified
     * name, this method replaces the old value with the specified value.
     *
     * @param name name in the name/value pair
     * @param value value in the name/value pair
     * @return this object builder
     * @throws NumberFormatException if the value is Not-a-Number(NaN) or
     * infinity
     * @throws NullPointerException if the specified name is null
     *
     * @see JsonNumber
     */
    JsonObjectBuilder add(String name, double value);

    /**
     * Adds a name/{@code JsonValue#TRUE} or name/{@code JsonValue#FALSE} pair
     * to the JSON object associated with this object builder. If the object
     * contains a mapping for the specified name, this method replaces the old
     * value with the specified value.
     *
     * @param name name in the name/value pair
     * @param value value in the name/value pair
     * @return this object builder
     * @throws NullPointerException if the specified name is null
     */
    JsonObjectBuilder add(String name, boolean value);

    /**
     * Adds a name/{@code JsonValue#NULL} pair to the JSON object associated
     * with this object builder where the value is {@code null}.
     * If the object contains a mapping for the specified name, this method
     * replaces the old value with {@code null}.
     *
     * @param name name in the name/value pair
     * @return this object builder
     * @throws NullPointerException if the specified name is null
     */
    JsonObjectBuilder addNull(String name);

    /**
     * Adds a name/{@code JsonObject} pair to the JSON object associated
     * with this object builder. The value {@code JsonObject} is built from the
     * specified object builder. If the object contains a mapping for the
     * specified name, this method replaces the old value with the
     * {@code JsonObject} from the specified object builder.
     *
     * @param name name in the name/value pair
     * @param builder the value is the object associated with this builder
     * @return this object builder
     * @throws NullPointerException if the specified name or builder is null
     */
    JsonObjectBuilder add(String name, JsonObjectBuilder builder);

    /**
     * Adds a name/{@code JsonArray} pair to the JSON object associated with
     * this object builder. The value {@code JsonArray} is built from the
     * specified array builder. If the object contains a mapping for the
     * specified name, this method replaces the old value with the
     * {@code JsonArray} from the specified array builder.
     *
     * @param name the name in the name/value pair
     * @param builder the value is the object array with this builder
     * @return this object builder
     * @throws NullPointerException if the specified name or builder is null
     */
    JsonObjectBuilder add(String name, JsonArrayBuilder builder);

    /**
     * Returns the JSON object associated with this object builder.
     * The iteration order for the {@code JsonObject} is based
     * on the order in which name/value pairs are added to the object using
     * this builder.
     *
     * @return JSON object that is being built
     */
    JsonObject build();

}