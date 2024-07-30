$(function () {

    $("#resetData").click(function(){
        $(".error-input").removeClass("error-input");
    });

    loadZoneTemplate("header");
    loadZoneTemplate("footer");

    loadRoles();
    loadUsuarios();
    loadFormEvent();

});

function deleteUser(id) {
    var url = "http://localhost:8080/user/" + id;

    $.ajax({
        url: url,
        type: "DELETE",
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            try {
                alert("Registro eliminado con exito!");
                loadUsuarios();
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

function loadZoneTemplate(zone) {
    var url = "assets/template/" + zone + ".html";
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            try {
                $("#content_" + zone).html(result);
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

function loadFormEvent() {

    console.log("loadFormEvent");

    $("#frm1").on("submit", function (e) {
        e.preventDefault();

        $(".error-input").removeClass("error-input");

        if ($("#nombres").val() === "") {
            $("#nombres").addClass("error-input");
        }

        if ($("#fechaNacimiento").val() === "") {
            $("#fechaNacimiento").addClass("error-input");
        }

        if ($("#color").val() === "") {
            $("#color").addClass("error-input");
        }

        if ($("#correo").val() === "") {
            $("#correo").addClass("error-input");
        }

        if ($("#telefono").val() === "") {
            $("#telefono").addClass("error-input");
        }

        if ($("#avatar").val() === "") {
            $("#avatar").addClass("error-input");
        }

        if ($("#rol").val() === "") {
            $("#rol").addClass("error-input");
        }

        if($(".error-input").length > 0) {
            alert("Verifique los datos ingresados");
            return;
        }

        var objUsuario = {
            "fullName": $("#nombres").val(),
            "bornDate": $("#fechaNacimiento").val(),
            "color": $("#color").val(),
            "email": $("#correo").val(),
            "phone": $("#telefono").val(),
            "avatar": "foto.png",
            "rolId": $("#rol").val()
        };
        
        createUsuario(objUsuario);
    });

}

function createUsuario(data) {
    var url = "http://localhost:8080/user";

    $.ajax({
        url: url,
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(data), 
        success: function (result) {
            try {
                alert("Registro creado");
                $("#resetData").click();
                loadUsuarios();
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

function loadUsuarios() {
    var url = "http://localhost:8080/user";

    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            try {
                renderUsers(result);
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

function loadRoles() {
    var url = "http://localhost:8080/rol";

    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            try {
                renderRoles(result);
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

function renderUsers(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var user = result.data[i];
        html += "<tr>";
        html += "<th scope='row'>"+(i+1)+"</th>"
        html += "<td>"+user.id+"</td>"
        html += "<td>"+user.fullName+"</td>"
        html += "<td>"+user.bornDate+"</td>"
        html += "<td>"+0+"</td>"
        html += "<td>"
        html += "<div class='userColor' style='background-color:"+user.color+"'></div>"
        html += "<label class='detail-color'>"+user.color+"</label>"
        html += "</td>"
        html += "<td>"+user.email+"</td>"
        html += "<td>"+user.phone+"</td>"
        html += "<td>"
        html += "<img src='http://localhost/imagenes/not-found.png' class='avatar' width='50px' height='50px'>"
        html += "</td>"
        html += "<td>"+user.rolName+"</td>"
        html += "<td>"
        html += "<div data-id='"+user.id+"' class='eliminar'>Eliminar</div>"
        html += "<div data-id='"+user.id+"' class='editar'>Editar</div>"
        html += "</td>"
        html += "</tr>"
    }
    $("#bodyListUsers").html(html);
    $(".eliminar").click(function(){
        if(confirm("Desea eliminar el registro?")) {
            var id = $(this).data('id');
            deleteUser(id);
        }
    });
}

function renderRoles(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.name + "</option>";
    }
    $("#rol").html(html);
}

function cbError(error) {
    alert("El llamado al servidor fallo " + error);
}