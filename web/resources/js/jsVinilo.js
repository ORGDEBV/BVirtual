var rot = 0;
var myInterval;
var auxPlay = 0;
$(document).ready(function () {
//    $(".contenedor").click(function () {
//        if (auxPlay == 0) {
//            myInterval = setInterval(function () {
//                $(".imgDisco").css({'margin-left': '150px'});
//                $(".imgDisco").css({'animation': '3s rotate linear infinite'});
//                console.log(rot);
//                rot++;
//            }, 100);
//            auxPlay = 1;
//        } else if (auxPlay == 1) {
//            clearInterval(myInterval);
//            $(".imgDisco").css({'margin-left': '0px'});
//            $(".imgDisco").css({'animation': '0s rotate linear infinite'});
//            auxPlay = 0;
//        }
//
//    })
    
    
    
        $("#btnPlay").click(function () {
                myInterval = setInterval(function () {
                $(".imgDisco").css({'margin-left': '150px'});
                $(".imgDisco").css({'animation': '3s rotate linear infinite'});
                rot++;
            }, 100);
            
       
    });
  
       $("#btnPause").click(function () {
             clearInterval(myInterval);
//            $(".imgDisco").css({'margin-left': '0px'});
//           $(".imgDisco").css({'animation': '0s rotate linear infinite'});
             
            
       
    });
      $("#btnStop").click(function () {
             clearInterval(myInterval);
            $(".imgDisco").css({'margin-left': '0px'});
            $(".imgDisco").css({'animation': '2s rotate linear infinite'});
             
            
       
    });
    
});
