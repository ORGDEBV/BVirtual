$(document).ready(function(){
    var get = window.location.href;
    console.log(get);
    var split1 = get.split("?");
    console.log(split1);
    if(split1.length>1){
      var split2 = split1[1].split("&");
      var splitmes = split2[0].split("=");
      var mes = splitmes[1];
      console.log("mes",mes);
      var splittitulo = split2[1].split("=");
      var titulo = splittitulo[1];
      console.log("titulo",titulo);
      $("#mes-"+mes).click();
      $("#titulo-"+titulo).css({'background':'#cecece'});
    }
})
