function  doAjaxGet(url,params,callback){
//1.创建xhr对象（ajax技术的应用入口）
    let xhr=new XMLHttpRequest();
    //2.设置状态监听（不是必须的，但是假如要获取服务端响应的结果
    // 并进行状态监听）
    xhr.onreadystatechange=function (){
        if(xhr.readyState==4&&xhr.status==200){
         callback(xhr.responseText);
        }
    }
//    3.建立get连接（get请求传参数，要将参数拼接到url中）
    xhr.open("GET",`${url}?${params}`,true);
//    4.发送异步请求
    xhr.send(null);
}
function  doAjaxPost(url,params,callback){
//1.创建xhr对象（ajax技术的应用入口）
    let xhr=new XMLHttpRequest();
    //2.设置状态监听（不是必须的，但是假如要获取服务端响应的结果
    // 并进行状态监听）
    xhr.onreadystatechange=function (){
        if(xhr.readyState==4&&xhr.status==200){
            callback(xhr.responseText);
        }
    }
//    3.建立get连接（get请求传参数，要将参数拼接到url中）
    xhr.open("POST",url,true);
    //post请求假如需要向服务端传递参数,则必须在open之后设置请求头
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    //4.发送异步POST请求(参数需要写到send方法内部)-表单数据或数据量比较大时
    xhr.send(params);

}