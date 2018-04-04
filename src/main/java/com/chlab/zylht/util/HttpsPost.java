package com.chlab.zylht.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;


/**
 * 封装https请求获得access_token等操作
 * @author shenhao
 *
 */
public class HttpsPost {
	
    
	/** 
	* 发起https请求并获取结果 （有提交数据）
	*  
	* @param requestUrl 请求地址 
	* @param requestMethod 请求方式（GET、POST） 
	* @param outputStr 提交的数据 
	* @param charset 字符集
	* @return 字符串
	*/  
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr, String charset) {  
        StringBuffer buffer = new StringBuffer();  
        
        InputStream inputStream = null;  
        InputStreamReader inputStreamReader = null;  
        BufferedReader bufferedReader = null;  
        HttpsURLConnection httpUrlConn = null;
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes(charset));  
                outputStream.close();  
            }  
  
            // 将返回的输入流转换成字符串  
            inputStream = httpUrlConn.getInputStream();  
            inputStreamReader = new InputStreamReader(inputStream, charset);  
            bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
//logger.debug("return :　" + buffer.toString());            
        } catch (ConnectException ce) {  
        
        } catch (Exception e) {  
        	
        } finally {
        	try {
        		if (bufferedReader != null) {
        			bufferedReader.close();
    				inputStreamReader.close();  
    	             // 释放资源  
    	             inputStream.close();
        		}
			} catch (IOException e) {
				
			}  
        	inputStream = null;  
        	httpUrlConn.disconnect();  
        }
        return buffer.toString();  
    }
    
    /**
	 * 发起https请求并获取结果(无提交数据)
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）

	 */
	public static String httpGetRequest(String requestUrl,
			String requestMethod) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url
					.openConnection();
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			// 将inputStream decode为utf-8的形式
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		}  catch (Exception e) {  
	          e.printStackTrace();
	        }  
		return buffer.toString();
	}
    
    /** 
	* 发起https请求,无提交数据也不返回结果
	*  
	* @param requestUrl 请求地址 
	* @param requestMethod 请求方式（GET、POST） 
	*/  
    public static void httpRequest(String requestUrl, String requestMethod) {  
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            httpUrlConn.disconnect();  
        }  catch (Exception e) {  
          e.printStackTrace();
        }  
    }  
    
    /**
     * https文件上传
     * @param requestUrl
     * @param file
     * @return
     */
    public static String httpPostFile(String requestUrl, File file) {  
        
        InputStream inputStream = null;  
        InputStreamReader inputStreamReader = null;  
        BufferedReader bufferedReader = null;  
        HttpsURLConnection con = null;
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            con = (HttpsURLConnection) url.openConnection();  
            con.setSSLSocketFactory(ssf);  
  
            String result =null;  
            con.setDoInput(true);  
              
            con.setDoOutput(true);  
              
            con.setUseCaches(false); // post方式不能使用缓存  
              
            // 设置请求头信息  
              
               con.setRequestProperty("Connection", "Keep-Alive");  
              
            con.setRequestProperty("Charset", "UTF-8");  
            // 设置边界  
              
            String BOUNDARY = "----------" + System.currentTimeMillis();  
              
            con.setRequestProperty("Content-Type",  
                    "multipart/form-data; boundary="  
              
                    + BOUNDARY);  
              
            // 请求正文信息  
              
            // 第一部分：  
              
            StringBuilder sb = new StringBuilder();  
              
            sb.append("--"); // 必须多两道线  
              
            sb.append(BOUNDARY);  
              
            sb.append("\r\n");  
              
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\""+file.length()+"\";filename=\""  
              
                    + file.getName() + "\"\r\n");  
              
            sb.append("Content-Type:application/octet-stream\r\n\r\n");  
              
            byte[] head = sb.toString().getBytes("utf-8");  
              
            // 获得输出流  
              
            OutputStream out = new DataOutputStream(con.getOutputStream());  
              
            // 输出表头  
              
            out.write(head);  
              
            // 文件正文部分  
              
            // 把文件已流文件的方式 推入到url中  
              
            DataInputStream in = new DataInputStream(new FileInputStream(file));  
              
            int bytes = 0;  
              
            byte[] bufferOut = new byte[1024];  
              
            while ((bytes = in.read(bufferOut)) != -1) {  
              
                out.write(bufferOut, 0, bytes);  
              
            }  
              
            in.close();  
              
            // 结尾部分  
              
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
              
            out.write(foot);  
              
            out.flush();  
              
            out.close();  
              
            StringBuffer buffer = new StringBuffer();  
              
            BufferedReader reader = null;  
              
            try {  
              
                // 定义BufferedReader输入流来读取URL的响应  
              
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
              
                String line = null;  
              
                while ((line = reader.readLine()) != null) {  
              
                    buffer.append(line);  
              
                }  
              
                if (result == null) {  
              
                    result = buffer.toString();  
              
                }  
              
            } catch (IOException e) {  
              
                //System.out.println("发送POST请求出现异常！" + e);  
              
                e.printStackTrace();  
              
                throw new IOException("数据读取异常");  
              
            } finally {  
              
                if (reader != null) {  
              
                    reader.close();  
              
                }  
              
            }  
            return result.replaceAll("[\\\\]", "");
//logger.debug("return :　" + buffer.toString());           
        } catch (ConnectException ce) {  
        ce.printStackTrace();
        } catch (Exception e) {  
        	e.printStackTrace();
        } finally {
        	try {
        		if (bufferedReader != null) {
        			bufferedReader.close();
    				inputStreamReader.close();  
    	             // 释放资源  
    	             inputStream.close();
        		}
			} catch (IOException e) {
				e.printStackTrace();
			}  
        	inputStream = null;  
        	con.disconnect();  
        }
		return "fail";
    }
}
