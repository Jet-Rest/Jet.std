package cn.codetector.jet.std.network.decoder

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import org.slf4j.LoggerFactory

/**
 * Created by Codetector on 2017/3/11.
 * Project Jet
 */
class PacketLengthBasedDecoder(maxLength: Int) : LengthFieldBasedFrameDecoder(maxLength, 0, 4, 0, 0) {
    companion object {
        private val logger = LoggerFactory.getLogger(PacketLengthBasedDecoder::class.java)
    }
    override fun decode(ctx: ChannelHandlerContext?, `in`: ByteBuf?): Any? {
        try {
            return super.decode(ctx, `in`)
        } catch (e: Throwable) {
            ctx!!.disconnect()
            logger.info("Exception caught during packet decode. Client IP: ${ctx.channel().remoteAddress()}", e)
            return null
        }
    }
}