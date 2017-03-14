package cn.codetector.jet.std.network.decoder

import cn.codetector.jet.jetsimplejson.JSONObject
import cn.codetector.jet.std.network.packet.JsonPacket
import cn.codetector.jet.std.network.packet.PureTextPacket
import cn.codetector.jet.std.network.packet.RawPacket
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder

/**
 * Created by Codetector on 2017/3/14.
 * Project Jet
 */
class RawPacketClassifier: MessageToMessageDecoder<RawPacket>(){
    override fun decode(ctx: ChannelHandlerContext, msg: RawPacket, out: MutableList<Any>) {
        val packetHeaderJson = JSONObject(String(msg.header))
        when(packetHeaderJson.getString("type")) {
            "json" -> {
                out.add(JsonPacket(String(msg.content)))
            }
            "text" -> {
                out.add(PureTextPacket(String(msg.content)).setHeaderObject(packetHeaderJson))
            }
        }
    }
}