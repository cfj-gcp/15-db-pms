(function(){//函数的自调用
    //第一步.定义构造函数
    let ajax=function(){}
    //第二步.在构造函数的原型对象上添加函数(这样的函数在基于构造函数构建的js对象中共享)
    ajax.prototype={
        doAjaxGet:function (url,params,callback){
            //1.创建xhr对象(Ajax技术应用的入口)
            let xhr=new XMLHttpRequest();
            //2.设置状态监听(不是必须的,但是假如要获取服务端响应的结果并进行处理就要进行状态监听)
            xhr.onreadystatechange=function(){
                if(xhr.readyState==4&&xhr.status==200){
                    callback(xhr.responseText);
                }
            }
            //3.建立Get连接(get请求传参数,要将参数拼接到url中
            xhr.open("GET",`${url}?${params}`,true);
            //4.发送异步请求
            xhr.send(null);
        },
        doAjaxPost:function (url,params,callback){//封装共性(不变的),提取特性(可能会经常变化的)
            //1.创建xhr对象(Ajax技术应用的入口)
            let xhr=new XMLHttpRequest();
            //2.设置状态监听(不是必须的,但是假如要获取服务端响应的结果并进行处理就要进行状态监听)
            xhr.onreadystatechange=function(){
                if(xhr.readyState==4&&xhr.status==200){
                    callback(xhr.responseText);//处理响应数据
                }
            }
            //3.建立Get连接(get请求传参数,要将参数拼接到url中)
            xhr.open("POST",url,true);
            //post请求假如需要向服务端传递参数,则必须在open之后设置请求头
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            //4.发送异步POST请求(参数需要写到send方法内部)-表单数据或数据量比较大时
            xhr.send(params);
        }
    }
    //3.第三步:基于ajax构造函数构建ajax对象,并将对象赋值给一个全局变量
    window.$$=new ajax();
})()
