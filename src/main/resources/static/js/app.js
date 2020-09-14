var app =(function(){

    var viewAll=function(err,data){
    $("#showdata").html("");
    var table = $("<table style='width:100%'></table>")
    table.append("<tr><td style='width:49%; background:gray; color:white;'>Work</td><td style='width:49%; background:gray; color:white;'>Description</td></tr>");
    data.forEach((item)=>{
     table.append("<tr><td style='width:49%;'>"+item.work+"</td><td style='width:49%;'>"+item.description+"</td></tr>");
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