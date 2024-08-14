$(function () { 
    loadTypeZones();
});

function loadTypeZones(){
    var url = "http://localhost:8080/zone/group-by-type";
    callApi(url, "GET", null, function(result){
        var html = "";

        for(var i = 0; i<result.data.length; i++) {
            var type = result.data[i];
            html +="<section class='contenedor-zonas'>";
            html += "<h2>" +type.title+ "</h2>"

            for(var j = 0; j < type.zones.length; j++) {
                var zone = type.zones[j];

                var status = "";
                if(zone.status==="INACTIVO") {
                    status = "disabled";
                } else if(zone.status==="RESERVADO") {
                    status = "reserved";
                }

                html += "<div class='zona " + status + "'>";
                html += "<label class='title'>" +zone.title+ "</label>";
                html += "</div>";
            }

            html += "</section>";
        }

        $("#zones").html(html);
    });
}