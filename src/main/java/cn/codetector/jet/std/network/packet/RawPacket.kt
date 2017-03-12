package cn.codetector.jet.std.network.packet

import java.util.*

/**
 * Created by Codetector on 2017/3/10.
 * Project Jet
 */
data class RawPacket (val header: ByteArray, val content: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (other is RawPacket) {
            return Arrays.equals(this.header, other.header) && Arrays.equals(this.content, other.content)
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}