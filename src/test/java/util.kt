import com.google.common.io.BaseEncoding
import java.security.SecureRandom

/**
 * Created by Codetector on 2017/3/12.
 * Project Jet
 */
fun String.Companion.randomString(): String {
    val random = SecureRandom() // or SecureRandom

    val buffer = ByteArray(5)
    random.nextBytes(buffer)
    return BaseEncoding.base64Url().omitPadding().encode(buffer) // or base32()
}