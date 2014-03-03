package com.sunshineroad.driverschool;

import java.rmi.RemoteException;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class SendMessageByWebservice {
	
	/*
	 * 短信发送接口
	 */
	public String invokeRemoteFuc( String username ,String mobile, String content, String uuid ) {
		String endpoint = "http://10.1.5.244:8989/smsWebservice/services/smsMsg?wsdl";
		String result = "no result!";
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(endpoint);// 远程调用路径
			call.setOperationName("SendMsg");// 调用的方法名
//
//			// 设置参数名:
//			call.addParameter("username", // 参数名
//					XMLType.XSD_STRING,// 参数类型:String
//					ParameterMode.IN);// 参数模式：'IN' or 'OUT'
//			call.addParameter("mobile", XMLType.XSD_STRING, ParameterMode.IN);
//			call.addParameter("content", XMLType.XSD_STRING, ParameterMode.IN);
//			call.addParameter("uuid", XMLType.XSD_STRING, ParameterMode.IN);
//			// 设置返回值类型：
//			call.setReturnType(XMLType.XSD_STRING);// 返回值类型：String

			result = (String) call.invoke( new Object[]{ username, mobile, content, uuid } );// 远程调用
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*参数 uuid : Sendmsg 输入的 uuid
	 * 查询用户短信状态报告
	 * 返回值说明 ：0：失败，1：成功
	 */
	public int GetRes ( String uuid ) {
		String endpoint = "http://10.1.5.244:8989/smsWebservice/services/smsMsg?wsdl";
		int result = 2;
		Service service = new Service();
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(endpoint);// 远程调用路径
			call.setOperationName("GetRes");// 调用的方法名
			result = (int) call.invoke( new Object[]{ uuid } );// 远程调用
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
}

