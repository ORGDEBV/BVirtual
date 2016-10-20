var auxfiltro = 0;
var widthInicial = $(window).width();
var heightInicial = $(window).height();
$(document).ready(function () {
    $("#btnFiltros").click(function () {
        console.log(auxfiltro);
        if (auxfiltro == 0) {
            $(".col-1").css({
                'transform': 'translateX(0px)',
                '-webkit-transform': 'translateX(0px)'
            });
            $("#btnFiltros").css({
                'transform': 'translateX(340px)',
                '-webkit-transform': 'translateX(340px)'
            });
            $(".filtros-overlay").css({'visibility': 'visible'})
            auxfiltro = 1;
        } else {
            $(".col-1").css({
                'transform': 'translateX(-340px)',
                '-webkit-transform': 'translateX(-340px)'
            });
            $("#btnFiltros").css({
                'transform': 'translateX(0px)',
                '-webkit-transform': 'translateX(0px)'
            });
            $(".filtros-overlay").css({'visibility': 'hidden'})
            auxfiltro = 0;
        }
    });
    $(".filtros-overlay").click(function () {
        $(".col-1").css({
            'transform': 'translateX(-340px)',
            '-webkit-transform': 'translateX(-340px)'
        });
        $("#btnFiltros").css({
            'transform': 'translateX(0px)',
            '-webkit-transform': 'translateX(0px)'
        });
        $(".filtros-overlay").css({'visibility': 'hidden'})
        auxfiltro = 0;
    });
});
$(window).resize(function (event) {
    $(".filtros-overlay").css({'visibility': 'hidden'})
    if (widthInicial != $(window).width()) {
        widthInicial = $(window).width();
        var width = $(window).width();
        if (width > 1080) {
            $(".col-1").css({
                'transform': 'translateX(0px)',
                '-webkit-transform': 'translateX(0px)'
            });
            $("#btnFiltros").css({
                'transform': 'translateX(0px)',
                '-webkit-transform': 'translateX(0px)'
            });
            auxfiltro = 1;
        } else {
            $(".col-1").css({
                'transform': 'translateX(-340px)',
                '-webkit-transform': 'translateX(-340px)'
            });
            $("#btnFiltros").css({
                'transform': 'translateX(0px)',
                '-webkit-transform': 'translateX(0px)'
            });
            auxfiltro = 0;
        }
    }
})
