$(function(){
    function resizeMainImg(){
        var height = $(window).height() - 280;

        if(height < 500)
            height = 500;

        if($(window).width() < 380)
            height = height - 35;

        $("#full").height(height);

    }

    $( window ).resize(function() {
        resizeMainImg();
    });

    resizeMainImg();

});