//package wzh.Http;
/*import org.apache.commons.httpclient.HttpClient; 
import org.apache.commons.httpclient.HttpMethod; 
import org.apache.commons.httpclient.HttpStatus; 
import org.apache.commons.httpclient.URIException; 
import org.apache.commons.httpclient.methods.GetMethod; 
import org.apache.commons.httpclient.methods.PostMethod; 
import org.apache.commons.httpclient.params.HttpMethodParams; 
import org.apache.commons.httpclient.util.URIUtil; 
import org.apache.commons.lang.StringUtils; 
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpRequest {

	public static void main(String args[])
	{
		
		String domainURL = "http://www.movoto.com/";
		List<String> url = FileOperation.readFileByLines("E:\test.txt");
		url.forEach(partURL => System.out.println(HttpResponse_Get(domainURL+ partURL));
	}
	
	public static String HttpResponse_Get(String url)
	{
		ArrayList<String> urlPathList = new ArrayList<String>();
		
		//String param = "";
		String response_Status="";
		BufferedReader in = null;
        try {
            String urlNameString = url ;/*+ "?" + param;*/
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
            	if (key==null)
            	{
            		response_Status = map.get(key).toString().split(" ")[1];
            		break;
            	}
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            //while ((line = in.readLine()) != null) {
              //  response_Status += line;
            //}
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		return response_Status;	
	}
	/*
    public static String doGet(String url) { 
    	String queryString =""
        String response = null; 
        HttpClient client = new HttpClient(); 
        HttpMethod method = new GetMethod(url); 
        try { 
                if (StringUtils.isNotBlank(queryString)) 
                        method.setQueryString(URIUtil.encodeQuery(queryString)); 
                client.executeMethod(method); 
                if (method.getStatusCode() == HttpStatus.SC_OK) { 
                        response = method.getResponseBodyAsString(); 
                } 
        } catch (URIException e) { 
                log.error("执行HTTP Get请求时，编码查询字符串“" + queryString + "”发生异常！", e); 
        } catch (IOException e) { 
                log.error("执行HTTP Get请求" + url + "时，发生异常！", e); 
        } finally { 
                method.releaseConnection(); 
        } 
        return response; 
}*/ 
}
