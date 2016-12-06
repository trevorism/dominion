$(function(){
    function resizeMainImg(){
        var height = $(window).height() - 180;

        if(height < 500)
            height = 500;

        $("#full").height(height);

    }

    $( window ).resize(function() {
        resizeMainImg();
    });

    resizeMainImg();

});