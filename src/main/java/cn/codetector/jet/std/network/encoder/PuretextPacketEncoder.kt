package cn.codetector.jet.std.network.encoder

import cn.codetector.jet.std.network.packet.PureTextPacket
import cn.codetector.jet.std.network.packet.RawPacket
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder

/**
 * Created by Codetector on 2017/3/14.
 * Project Jet
 */
class PuretextPacketEncoder: MessageToMessageEncoder<PureTextPacket>() {
    override fun encode(ctx: ChannelHandlerContext, msg: PureTextPacket, out: MutableList<Any>) {
        out.add(RawPacket(msg.headerObject.encode().toByteArray(), msg.stringContent.toByteArray()))
    }
}