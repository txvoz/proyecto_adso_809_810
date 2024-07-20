$(function(){

    loadRoles();
    loadFormEvent();

});

function loadFormEvent(){
    console.log("loadFormEvent");

    $("#frm1").on("submit", function(e) {

        $(".error-input").removeClass("error-input");

       if($("#nombres").val() === "") {
        $("#nombres").addClass("error-input");
       } 

       if($("#fechaNacimiento").val() === "") {
        $("#fechaNacimiento").addClass("error-input");
       }

       if($("#color").val() === "") {
        $("#color").addClass("error-input");
       }

       if($("#correo").val() === "") {
        $("#correo").addClass("error-input");
       }

       if($("#telefono").val() === "") {
        $("#telefono").addClass("error-input");
       }

       if($("#avatar").val() === "") {
        $("#avatar").addClass("error-input");
       }

       if($("#rol").val() === "") {
        $("#rol").addClass("error-input");
       }

        e.preventDefault();
    });

}

function loadRoles() {
    var url = "http://localhost:8080/rol";

    $.ajax({
        url: url, 
        type: "GET",
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            try {
                renderRoles(result);
            } catch (e) {
                console.log("Error en cbSuccess", e);
            }
        }, 
        error: function(xhr, status, error){
            try {
                console.log(error);
                cbError(xhr.status);
            } catch (e) {
                console.log("Error en cbError", e);
            }
        }
    });

}

function renderRoles(data) {
    alert(data.message);
}

function cbError(error) {
    alert("El llamado al servidor fallo " + error);
}