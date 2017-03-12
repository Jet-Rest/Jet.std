package cn.codetector.jet.std.network.packet

import cn.codetector.jet.std.network.packet.PureTextPacket
import cn.codetector.jet.jetsimplejson.JSONObject

/**
 * Created by Codetector on 2017/3/12.
 * Project Jet
 */
class JsonPacket{
    val jsonObject: JSONObject
    constructor() {
        jsonObject = JSONObject()
    }
    constructor(jsonObject: JSONObject) {
        this.jsonObject = jsonObject
    }
    constructor(string: String) {
        jsonObject = JSONObject(string)
    }
    constructor(pureTextPacket: PureTextPacket) : this(pureTextPacket.stringContent)
}