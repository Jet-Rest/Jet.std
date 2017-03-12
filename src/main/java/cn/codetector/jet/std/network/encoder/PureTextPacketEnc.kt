package cn.codetector.jet.std.network.encoder

import cn.codetector.jet.std.network.packet.PureTextPacket
import cn.codetector.jet.std.network.packet.RawPacket
import com.google.common.io.ByteArrayDataOutput
import com.google.common.io.ByteStreams
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import org.slf4j.LoggerFactory

/**
 * Created by Codetector on 2017/3/12.
 * Project Jet
 */
class PureTextPacketEnc: MessageToMessageEncoder<PureTextPacket>() {
    companion object {
        private val logger = LoggerFactory.getLogger(PureTextPacketEnc::class.java)
    }
    override fun encode(ctx: ChannelHandlerContext?, msg: PureTextPacket, out: MutableList<Any>) {
        val pOut: ByteArrayDataOutput = ByteStreams.newDataOutput()
        pOut.writeChars(msg.stringContent)
        out.add(RawPacket(header = ByteArray(0),content = pOut.toByteArray()))
    }
}