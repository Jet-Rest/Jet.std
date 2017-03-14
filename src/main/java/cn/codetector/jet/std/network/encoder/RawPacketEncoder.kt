package cn.codetector.jet.std.network.encoder

import cn.codetector.jet.std.network.packet.RawPacket
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder

/**
 * Created by Codetector on 2017/3/14.
 * Project Jet
 */
class RawPacketEncoder: MessageToByteEncoder<RawPacket>() {
    override fun encode(ctx: ChannelHandlerContext?, msg: RawPacket, out: ByteBuf) {
        var totalLength = 4 + msg.header.size + msg.content.size
        out.writeInt(totalLength)
        out.writeInt(msg.header.size)
        out.writeBytes(msg.header)
        out.writeBytes(msg.content)
    }

}