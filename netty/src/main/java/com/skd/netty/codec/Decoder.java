package com.skd.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/21 14:59
 */
@Slf4j
@Component
public class Decoder extends ByteToMessageDecoder {


    private static final Pattern pattern = Pattern.compile("\\$");

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        log.info("readableBytes:{}",readableBytes);
        if (readableBytes < 1){
            log.error("readableBytes:{}",readableBytes);
            return;
        }
        byte[] bytes = new byte[readableBytes];
        byteBuf.readBytes(bytes);
        String data = new String(bytes, Charset.forName("UTF-8"));
        log.info("data:{}",data);
        list.add(data);

    }
}
