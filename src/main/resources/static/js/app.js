var app =(function(){
    var sort = function(li){
        for(var i=0;i<li.length;i++){
            for(var j=i+1;j<li.length;j++){
            if(li[j].date>li[i].date){
                var t1 = li[i];
                var t2 = li[j];
                li[j]=t1;
                li[i]=t2;
            }
          }
        }
        return li;
    };
    var viewAll=function(err,data){
    $("#showdata").html("");
    var cont=0;
    var table = $("<table style='width:100%'></table>")
    table.append("<tr><td style='width:33%; background:gray; color:white;'>Work</td><td style='width:33%; background:gray; color:white;'>Description</td><td style='width:33%; background:gray; color:white;'>Date</td></tr>");
    sort(data).forEach((item)=>{
    if(cont<10){
        cont+=1;
        table.append("<tr><td style='width:33%;'>"+item.work+"</td><td style='width:33%;'>"+item.description+"</td><td style='width:33%;'>"+item.date+"</td></tr>");
     }
    });
    $("#showdata").append(table);
    }

    var show = function(err,data){
        if(err!=null){
        alert("error");
        return;
        }
        app.showAll();
    }

    return {
        showAll:function(){
            client.getAll(viewAll);
        },
        add:function(){
            var work = $("#work").val();
            var description = $("#description").val();
            client.add(work,description,show);
        }
    };
})();