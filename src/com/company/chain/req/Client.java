package com.company.chain.req;

import java.util.ArrayList;
import java.util.List;

//过滤器接口
interface Filter {
    public void doFilter(Request req,Response res,FilterChain c);
}

//客户端传递的内容到服务器
//模拟javaweb中的request
class Request {  public String requestStr;  }
//服务器反馈的内容到客户端
//模拟javaweb中的response
class Response {  public String responseStr;  }

//HTML的过滤器
class HTMLFilter implements Filter{
    @Override
    public void doFilter(Request req, Response res,FilterChain fc) {
        req.requestStr+="--HTMLFilter";
        fc.doFilter(req, res, fc);
         //在这里它会调用过滤链中的下一个filter
        //等整个过滤链处理完了之后也就是fc.doFilter(req, res, fc);这段
        //处理完了之后就会执行下面的方法了res.responseStr+="--HTMLFilter";
        //然后依次的过滤器都执行这列的这行代码，也就会变成了倒序执行
        res.responseStr+="--HTMLFilter";
    }
}

//敏感词的过滤器
class SensitiveFilter implements Filter{
    @Override
    public void doFilter(Request req, Response res,FilterChain fc) {
        req.requestStr+="--SensitiveFilter";
        fc.doFilter(req, res, fc);
        res.responseStr+="--SensitiveFilter";
    }
}

//过滤器链
class FilterChain implements Filter{
    private List<Filter> list=new ArrayList<Filter>();
    int index=0;
    public FilterChain addfilter(Filter filter){
        list.add(filter);
        return this;
    }
    @Override
    public void doFilter(Request req, Response res,FilterChain fc) {
        if(index==list.size())return;
        Filter f=list.get(index);
        index++;
        //依次执行下一个过滤器，直到整个过滤器链执行完
        f.doFilter(req, res, fc);
    }
}

public class Client {
    /*
     * Request:客户端发送给服务端的信息
     * Response:服务端反馈给客户端的信息
     * 要实现的功能是:Request携带的信息所经过的过滤器
     * 要跟Response所携带的信息所经过的过滤器相反
     */
    public static void main(String[] args) {
        Request req=new Request();
        Response res=new Response();
        req.requestStr="request";
        res.responseStr="response";
        FilterChain  fc=new FilterChain();
        fc.addfilter(new HTMLFilter());
        fc.addfilter(new SensitiveFilter());

//        FilterChain fc1=new FilterChain();
//        fc1.addfilter(new SensitiveFilter());
//        fc.addfilter(fc1);//在一个过滤链上面再加上一个过滤链

        fc.doFilter(req, res,fc);
        System.out.println(req.requestStr);
        System.out.println(res.responseStr);
    }

}