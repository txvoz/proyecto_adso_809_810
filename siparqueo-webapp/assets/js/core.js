var validMethods = ["GET", "POST", "PUT", "DELETE"];

function callApi(url, method, data, cbSuccess, cbError) {

    console.log("callApi :: " + method + " :: " + url);


    isPresent = validMethods.find(function(item){
        return item === method;
    });

    if(isPresent === "") {
        alert("Metodo " + method + "No permitido");
        return;
    }

    var jsonData = "";
    if(method === "POST" || method === "PUT") {
        jsonData = JSON.stringify(data);
    }

    $.ajax({
        url: url,
        type: method,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: jsonData, 
        headers: {
            'Authorization':'token123'
        },
        success: function (result) {
            try {
                cbSuccess(result);
            } catch (e) {
                console.log("Error en cbSuccess", e);
            }
        },
        error: function (xhr, status, error) {
            try {
                console.log(error);
                cbError(xhr.status);
            } catch (e) {
                cbErrorBase(xhr.status);
                console.log("Error en cbError", e);
            }
        }
    });
}

function loadZoneTemplate(zone, cbSuccess) {

    var url = "assets/template/" + zone + ".html?o=" + Math.random();
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            try {
                $("#content_" + zone).html(result);

                if(cbSuccess) {
                    cbSuccess();
                }
            } catch (e) {
                console.log("Error en cbSuccess", e);
            }
        },
        error: function (xhr, status, error) {
            try {
                console.log(error);
                cbError(xhr.status);
            } catch (e) {
                console.log("Error en cbError", e);
            }
        }
    });
}

function cbErrorBase(error) {
    alert("El llamado al servidor fallo " + error);
}

function loadZoneMain(main, cbSuccess) {

    var url = "pages/" + main + ".html?o=" + Math.random();
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            try {
                $("#content_main").html(result);

                if(cbSuccess) {
                    cbSuccess();
                }
            } catch (e) {
                console.log("Error en cbSuccess", e);
            }
        },
        error: function (xhr, status, error) {
            try {
                console.log(error);
                cbError(xhr.status);
            } catch (e) {
                console.log("Error en cbError", e);
            }
        }
    });
}