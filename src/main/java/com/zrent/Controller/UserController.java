package com.zrent.Controller;

import com.zrent.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台的登陆
 * @author Zrent
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {


    public Response login(String name,String password){

        /**
         * 登陆逻辑
         *
         *  验证用户密码，如果验证成功。
         *
         *  创建一个随机字符串（UUId） 将  uuid作为ikey 和 用户信息以及 token 存储到redis中  （servletContext）
         *
         *  将 key 返回给客户端。
         *
         */

        return null;
    }
}
