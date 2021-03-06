package cn.cust.netty.simplenetty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.nio.Buffer;
import java.nio.charset.Charset;

public class SimpleHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		System.out.println("开始读取数据============");
		if(msg instanceof ByteBuf){
			ByteBuf reqMsg = (ByteBuf) msg;
			String encode = reqMsg.toString(Charset.defaultCharset());
			System.out.println(encode);
		}
		ctx.channel().writeAndFlush("lisi\r\n");
		
		
	}



	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx)
			throws Exception {
		super.channelWritabilityChanged(ctx);
	}



	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		
//		if(evt instanceof IdleStateEvent){
//			IdleStateEvent event = (IdleStateEvent)evt;
//			if(event.equals(IdleState.READER_IDLE)){
//				System.out.println("读空闲====");
//				ctx.close();
//			}else if(event.equals(IdleState.WRITER_IDLE)){
//				System.out.println("写空闲====");
//			}else if(event.equals(IdleState.WRITER_IDLE)){
//				System.out.println("读写空闲====");
//				ctx.channel().writeAndFlush("ping\r\n");
//			}
//
//		}
		
		super.userEventTriggered(ctx, evt);
	}

	
	


	
	
	
	
	
	
	

}
