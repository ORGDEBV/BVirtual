var auxfiltro = 0;
var widthInicial =  $(window).width();
var heightInicial = $(window).height();
  $(document).ready(function(){
    $("#btnFiltros").click(function(){
      if(auxfiltro == 0){
        $(".container1").css({
          'transform':'translateX(0px)',
          '-webkit-transform':'translateX(0px)'
        });
        $(".filtros-overlay").css({'visibility':'visible'})
        auxfiltro = 1;
      }else{
        $(".container1").css({
          'transform':'translateX(-230px)',
          '-webkit-transform':'translateX(-230px)'
        });
        $(".filtros-overlay").css({'visibility':'hidden'})
        auxfiltro = 0;
      }
    });
    $(".filtros-overlay").click(function(){
      $(".container1").css({
        'transform':'translateX(-230px)',
        '-webkit-transform':'translateX(-230px)'
      });
      $(".filtros-overlay").css({'visibility':'hidden'})
      auxfiltro = 0;
    });
  });
  $(window).resize(function(event){
    $(".filtros-overlay").css({'visibility':'hidden'})
    if(widthInicial != $( window ).width()){
    widthInicial =  $(window).width();
    var width = $( window ).width();
  if(width > 1007){
  $(".container1").css({
    'transform':'translateX(0px)',
    '-webkit-transform':'translateX(0px)'
  });
  auxfiltro = 1;
   }else{
  $(".container1").css({
    'transform':'translateX(-230px)',
    '-webkit-transform':'translateX(-230px)'
  });
  auxfiltro = 0;
     }
  }
  })
