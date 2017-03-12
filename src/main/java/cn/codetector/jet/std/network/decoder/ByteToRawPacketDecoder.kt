package cn.codetector.jet.std.network.decoder

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder
import io.netty.util.ReferenceCountUtil
import org.slf4j.LoggerFactory

/**
 * Created by Codetector on 2017/3/12.
 * Project Jet
 */
class ByteToRawPacketDecoder : ByteToMessageDecoder() {
    companion object {
        private val logger = LoggerFactory.getLogger(ByteToRawPacketDecoder::class.java)
    }
    override fun decode(ctx: ChannelHandlerContext, incom: ByteBuf, out: MutableList<Any>) {
        val headerLength = incom.readInt()
        logger.info("headerLength $headerLength")
        ReferenceCountUtil.release(incom)
    }

}