var myInterval;
var radioInterval;
var int = 0;
var intBorder = 0;
var c;
var cxt1;
var cxt2;
var auxImg = 0;
var clPlay = 0;
var clPause = 0;
$(document).ready(function () {
    c = document.getElementById("tutorial");
    cxt2 = c.getContext("2d");
    cxt2.fillStyle = "black";
    cxt2.beginPath();
    cxt2.arc(132, 132, 85, 0, Math.PI * 2, true);
    cxt2.closePath();
    cxt2.fill();
//    $("#contDisco").click(function () {
//        if (auxImg == 0 && clPlay == 0) {
//            clPlay = 1;
//            clPause = 0;
//            document.getElementById('myaudio').play();
//            $("#imgPlay").css({'display': 'none'});
//            myInterval = setInterval(function () {
//                $("#dIzq").css({'transform': 'rotate(' + int + 'deg)'});
//                $("#dDer").css({'transform': 'rotate(' + int + 'deg)'});
//                int++;
//            }, 50);
//            radioInterval = setInterval(function () {
//                if (75 > intBorder) {
//                    c = document.getElementById("tutorial");
//                    cxt1 = c.getContext("2d");
//                    cxt1.fillStyle = "black";
//                    cxt1.beginPath();
//                    cxt1.arc(314, 132, (intBorder / 3) + 50, 0, Math.PI * 2, true);
//                    cxt1.closePath();
//                    cxt1.fill();
//                    intBorder++;
//                }
//            }, 1000);
//        }
//        else if (auxImg == 1 && clPause == 0) {
//            clPlay = 0;
//            clPause = 1;
//            document.getElementById('myaudio').pause();
//            $("#imgPause").css({'display': 'none'});
//            clearInterval(myInterval);
//            clearInterval(radioInterval);
//        }
//    });
    
         $("#btnPlay").click(function () {
          
            document.getElementById('myaudio').play();
            $("#imgPlay").css({'display': 'none'});
            myInterval = setInterval(function () {
                $("#dIzq").css({'transform': 'rotate(' + int + 'deg)'});
                $("#dDer").css({'transform': 'rotate(' + int + 'deg)'});
                int++;
            }, 50);
            radioInterval = setInterval(function () {
                if (75 > intBorder) {
                    c = document.getElementById("tutorial");
                    cxt1 = c.getContext("2d");
                    cxt1.fillStyle = "black";
                    cxt1.beginPath();
                    cxt1.arc(314, 132, (intBorder / 3) + 50, 0, Math.PI * 2, true);
                    cxt1.closePath();
                    cxt1.fill();
                    intBorder++;
                }
            }, 1000);
            
       
    });
    
           $("#btnPause").click(function () {
       
            document.getElementById('myaudio').pause();
            $("#imgPause").css({'display': 'none'});
            clearInterval(myInterval);
            clearInterval(radioInterval);
       
    });
    
     $("#btnStop").click(function () {
            intBorder=0;  
            document.getElementById('myaudio').pause();
            $("#imgPause").css({'display': 'none'});
            clearInterval(myInterval);
            clearInterval(radioInterval);
                      
             
             
       
    });
    
    
    
    
    
});