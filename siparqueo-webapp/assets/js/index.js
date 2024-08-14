$(function(){
    loadZoneTemplate("header", loadMain);
    loadZoneTemplate("footer");
});

function loadMain(){
    var searchParams = new URLSearchParams(window.location.search);
    var main = "home";
    if(searchParams.has('option')) {
        main = searchParams.get('option');
    }
    $("#"+main).addClass("active");
    loadZoneMain(main);
}