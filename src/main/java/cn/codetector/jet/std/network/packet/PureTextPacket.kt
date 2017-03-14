package cn.codetector.jet.std.network.packet

import cn.codetector.jet.jetsimplejson.JSONObject

/**
 * Created by Codetector on 2017/3/12.
 * Project Jet
 */
class PureTextPacket(val stringContent: String){
    var headerObject = JSONObject().put("type","text")
    fun setHeaderObject(newHeader: JSONObject): PureTextPacket {
        this.headerObject = newHeader
        return this
    }
}