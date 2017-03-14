package cn.codetector.jet.std.network.encoder

import cn.codetector.jet.std.network.packet.JsonPacket
import cn.codetector.jet.std.network.packet.PureTextPacket
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder

/**
 * Created by Codetector on 2017/3/14.
 * Project Jet
 */
class JsonPacketEncoder: MessageToMessageEncoder<JsonPacket>() {
    public override fun encode(ctx: ChannelHandlerContext?, msg: JsonPacket, out: MutableList<Any>) {
        val textPacket = PureTextPacket(msg.jsonObject.encode())
        textPacket.headerObject.put("type", "json")
        out.add(textPacket)
    }

}