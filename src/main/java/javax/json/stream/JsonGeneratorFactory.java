package javax.json.stream;

import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Factory to create {@link JsonGenerator} instances. If a factory
 * instance is configured with some configuration, the configuration applies
 * to all generator instances created using that factory instance.
 *
 * <p>
 * The class {@link javax.json.Json Json} also provides methods to create
 * {@link JsonGenerator} instances, but using {@code JsonGeneratorFactory} is
 * preferred when creating multiple generator instances as shown in the
 * following example:
 *
 * <pre>
 * <code>
 * JsonGeneratorFactory factory = Json.createGeneratorFactory();
 * JsonGenerator generator1 = factory.createGenerator(...);
 * JsonGenerator generator2 = factory.createGenerator(...);
 * </code>
 * </pre>
 *
 * <p> All the methods in this class are safe for use by multiple concurrent
 * threads.
 *
 * @author Jitendra Kotamraju
 */
public interface JsonGeneratorFactory {

    /**
     * Creates a JSON generator to write JSON text to a character stream.
     * The generator is configured with the factory configuration.
     *
     * @param writer i/o writer to which JSON is written
     */
    JsonGenerator createGenerator(Writer writer);

    /**
     * Creates a JSON generator to write JSON text to a byte stream. Characters
     * written to the stream are encoded into bytes using UTF-8 encoding.
     * The generator is configured with the factory's configuration.
     *
     * @param out i/o stream to which JSON is written
     */
    JsonGenerator createGenerator(OutputStream out);

    /**
     * Creates a JSON generator to write JSON text to a byte stream. Characters
     * written to the stream are encoded into bytes using the specified charset.
     * The generator is configured with the factory's configuration.
     *
     * @param out i/o stream to which JSON is written
     * @param charset a charset
     */
    JsonGenerator createGenerator(OutputStream out, Charset charset);

    /**
     * Returns a read-only map of supported provider specific configuration
     * properties that are used to configure the JSON generators.
     * If there are any specified configuration properties that are not
     * supported by the provider, they won't be part of the returned map.
     *
     * @return a map of supported provider specific properties that are used
     * to configure the created generators. The map may be empty but not null
     */
    Map<String, ?> getConfigInUse();

}