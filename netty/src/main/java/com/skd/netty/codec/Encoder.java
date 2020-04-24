package com.skd.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/21 14:59
 */
@Slf4j

@Component
public class Encoder extends MessageToByteEncoder {

    private  static final char DELEMITER = '$';

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {

    }


}
