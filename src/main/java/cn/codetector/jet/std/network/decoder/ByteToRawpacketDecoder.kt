package cn.codetector.jet.std.network.decoder

import cn.codetector.jet.std.network.packet.RawPacket
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import org.slf4j.LoggerFactory

/**
 * Created by Codetector on 2017/3/14.
 * Project Jet
 */
class ByteToRawpacketDecoder : ByteToMessageDecoder() {
    companion object {
        private val logger = LoggerFactory.getLogger(ByteToRawpacketDecoder::class.java)
    }
    override fun decode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>) {
        try {
            val totalLength = msg.readInt()
            val headerLength = msg.readInt()
            val contentLength = totalLength - 4 - headerLength
            val headerByteArray = ByteArray(headerLength)
            msg.readBytes(headerByteArray)
            val contentByteArray = ByteArray(contentLength)
            msg.readBytes(contentByteArray)
            out.add(RawPacket(header = headerByteArray, content = contentByteArray))
        } catch (e: Throwable) {
            ctx.disconnect()
            logger.info("Exception caught during packet decode. Client IP: ${ctx.channel().remoteAddress()}", e)
        }
    }
}