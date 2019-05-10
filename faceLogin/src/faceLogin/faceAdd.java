/**  
 * All rights Reserved, Designed By liufuqiang
 * @Title:  faceAdd.java   
 * @Package faceLogin   
 * @Description:    TODO
 * @author: LiuFuqiang     
 * @date:   2019年5月8日 下午7:20:54   
 * @version V1.0 
 * @Copyright: 2019 liufuqiang All rights reserved. 
 */
package faceLogin;

/**
 * @author Administrator
 *
 */


import java.net.URLEncoder;

import utils.Base64Util;
import utils.FileUtil;
import utils.HttpUtil;

/**
* 人脸注册
*/
public class faceAdd {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String add() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            // 本地文件路径
            String filePath = "C:\\Users\\Administrator\\Desktop\\liu1.png";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            

            String param = "user_id=" + "userid9" + "&user_info=" + "userInfo5" + "&group_id=" + "testFaceLogin" + "&image_type=BASE64" + "&image=" + imgParam ;
            AuthService auth = new AuthService();
            
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = auth.getAuth();

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println("addface:"+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   
}
