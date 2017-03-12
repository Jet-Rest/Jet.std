package cn.codetector.jet.std.network.encoder

import cn.codetector.jet.std.network.packet.PureTextPacket
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder

/**
 * Created by Codetector on 2017/3/12.
 * Project Jet
 */
class StringToPureTextPacketTranscoder : MessageToMessageEncoder<String>() {
    override fun encode(ctx: ChannelHandlerContext, msg: String, out: MutableList<Any>) {
        out.add(PureTextPacket(msg))
    }
}