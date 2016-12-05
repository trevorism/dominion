$(function(){
    function resizeMainImg(){
        var height = $(window).height() - 180;
        $("#full").height(height);

        var windowWidth = $(window).width();
    }

    $( window ).resize(function() {
        resizeMainImg();
    });

    resizeMainImg();

});