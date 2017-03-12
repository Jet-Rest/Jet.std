package cn.codetector.jet.std.network.encoder

import cn.codetector.jet.std.network.packet.JsonPacket
import cn.codetector.jet.std.network.packet.PureTextPacket
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import org.slf4j.LoggerFactory

/**
 * Created by Codetector on 2017/3/12.
 * Project Jet
 */
class JsonPacketEncoder : MessageToMessageEncoder<JsonPacket>() {
    companion object {
        private val logger = LoggerFactory.getLogger(JsonPacketEncoder::class.java)
    }
    public override fun encode(ctx: ChannelHandlerContext, msg: JsonPacket, out: MutableList<Any>) {
        out.add(PureTextPacket(msg.jsonObject.encode()))
    }
}