package com.skd.netty.manager;

import com.skd.netty.codec.Decoder;
import com.skd.netty.codec.Encoder;
import com.skd.netty.handler.MessageHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.ResourceLeakDetector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;


/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2020/4/21 18:15
 */
@Slf4j
@Component
public class MsgManager {

    @Autowired
    private Decoder decoder;

    @Autowired
    private Encoder encoder;

    @Autowired
    private MessageHandler messageHandler;

    private Bootstrap bootstrap;

    private Channel channel;

    private Integer port = 8888;


    /**
     * 启动服务端
     */
    public void startServer() {
        ServerBootstrap baseBootstrap = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup(32);
        baseBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 8192)
                .option(ChannelOption.SO_REUSEADDR, true)
                .childHandler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("$".getBytes())));
                        ch.pipeline().addLast("decoder", decoder);
                        ch.pipeline().addLast("encoder", encoder);
                        ch.pipeline().addLast("timer", new IdleStateHandler(
                                3000, 3000, 3000));
                        ch.pipeline().addLast(messageHandler);
                    }
                });
        /**DISABLED 完全关闭内存泄露检测、SIMPLE 以1%的抽样率检测是否泄露，默认级别、ADVANCED 抽样率同SIMPLE，但显示详细的泄露报告、PARANOID 抽样率为100%，显示报告信息同ADVANCED*/
        ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.ADVANCED);
        baseBootstrap.bind(port);
    }

    /**
     * 启动客户端
     */
    public void startClient(){
        try {
            EventLoopGroup group = new NioEventLoopGroup();
            bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_SNDBUF, 4 * 1024)
                    .option(ChannelOption.SO_RCVBUF, 4 * 1024)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        socketChannel.pipeline().addLast(new DeviceDecoder());
//                        socketChannel.pipeline().addLast(new DeviceEncoder());
//                        socketChannel.pipeline().addLast("timer", new IdleStateHandler(120000, 120000, 120000));
//                        socketChannel.pipeline().addLast(new DeviceChannelHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress("127.0.0.1",port)).sync();
            channel = channelFuture.channel();
           log.info("get connect channel success:{}", channel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息
     * @param data 消息内容
     */
    public void send(String data){
        try {
            System.out.println("data:"+ data);
            ByteBuf byteBuf = Unpooled.copiedBuffer(data.getBytes("UTF-8"));

            channel.writeAndFlush(byteBuf).addListener(future->{
                if (future.isDone()){
                    log.info("async execute result:{}",future.isSuccess());
                }
            });
        } catch (Exception e) {
           log.error("channel writeAndFlush error",e);
        }
    }
}
