package cn.codetector.jet.std.network.encoder

import cn.codetector.jet.jetsimplejson.JSONObject
import cn.codetector.jet.std.network.packet.JsonPacket
import cn.codetector.jet.std.network.packet.PureTextPacket
import io.netty.channel.ChannelHandlerContext
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.*
import randomString

/**
 * Created by Codetector on 2017/3/12.
 * Project Jet
 */
internal class JsonPacketEncoderTest {
    lateinit var packetToEncode: JsonPacket
    var targetValue = "testValue"
    var targetKey = "testKey"

    var outputChain = ArrayList<Any>()
    @BeforeEach
    fun setUp() {
        targetValue = String.randomString()
        assertNotEquals("testValue", targetValue)
        targetKey = String.randomString()
        assertNotEquals("targetKey", targetKey)
        packetToEncode = JsonPacket(JSONObject().put(targetKey, targetValue))
        assertNotNull(packetToEncode)
        outputChain.clear()
        assertTrue(outputChain.isEmpty())
    }

    @Test
    fun testEncode() {
        val ctx = mock(ChannelHandlerContext::class.java)
        JsonPacketEncoder().encode(ctx, packetToEncode, outputChain)
        assertTrue(outputChain.isNotEmpty())
        assertTrue(outputChain[0] is PureTextPacket)
        assertEquals(packetToEncode.jsonObject.encode(), (outputChain[0] as PureTextPacket).stringContent)
    }

}