var client = (function(){
    return{
    getAll:function(callback){
    $.get({url:"/note"}).then((data)=>callback(null,data),()=>callback("err",null));
    },
    add:function(work,description,callback){
        $.post({
            url:"/note",
            data:JSON.stringify({work:work,description:description}),
            contentType:"application/json"
        }).then((data)=>callback(null,data),(err)=>callback(err,null));
    }
    };
})();