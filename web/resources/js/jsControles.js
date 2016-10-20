//Global variable to track current file name     
var currentFile = "";
var minutos = 0;
var s = 0;

String.prototype.toHHMMSS = function () {
    var sec_num = parseInt(this, 10); // don't forget the second param
    var hours = Math.floor(sec_num / 3600);
    var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
    var seconds = sec_num - (hours * 3600) - (minutes * 60);
    if (hours < 10) {
        hours = "0" + hours;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (seconds < 10) {
        seconds = "0" + seconds;
    }
    return hours + ':' + minutes + ':' + seconds;
}

//display and update progress bar
function progressBar() {
    var oAudio = document.getElementById('myaudio');
    //get current time in seconds
    var elapsedTime = Math.round(oAudio.currentTime);
    var ssec = elapsedTime + "";
    $("#process").html(ssec.toHHMMSS());
    //update the progress bar
    if (canvas.getContext) {
        var ctx = canvas.getContext("2d");
        //clear canvas before painting
        ctx.clearRect(0, 0, canvas.clientWidth, canvas.clientHeight);
        ctx.fillStyle = "rgb(232,232,234)";
        //var fWidth = (elapsedTime / oAudio.duration) * (canvas.clientWidth);
        var fWidth = (oAudio.currentTime / oAudio.duration) * (299);
     
        if (fWidth > 0) {
            ctx.fillRect(0, 0, fWidth, canvas.clientHeight);
        }
    }
}
//Play and pause function 
function playAudio() {
    auxImg = 0;
    $("#contDisco").click();
    try {
        //return objects we need to work with 
        var oAudio = document.getElementById('myaudio');
        var btn = document.getElementById('play');


        var audioURL = document.getElementById('audiofile');

        //Skip loading if current file hasn't changed.
        if (audioURL.value !== currentFile) {
            oAudio.src = audioURL.value;
            currentFile = audioURL.value;
        }

        //Tests the paused attribute and set state. 

        oAudio.play();

    }
    catch (e) {
        // Fail silently but show in F12 developer tools console
        if (window.console && console.error("Error:" + e))
            ;
    }
}
//pause
function pauseAudio() {
    auxImg = 1;
    $("#contDisco").click();
    try {
        //return objects we need to work with 
        var oAudio = document.getElementById('myaudio');
        var btn = document.getElementById('pause');


        var audioURL = document.getElementById('audiofile');

        //Skip loading if current file hasn't changed.
        if (audioURL.value !== currentFile) {
            oAudio.src = audioURL.value;
            currentFile = audioURL.value;
        }

        //Tests the paused attribute and set state. 

        oAudio.pause();

    }
    catch (e) {
        // Fail silently but show in F12 developer tools console
        if (window.console && console.error("Error:" + e))
            ;
    }
}
//Rewinds the audio file by 30 seconds.
function rewindAudio() {
    try {
        var oAudio = document.getElementById('myaudio');
        oAudio.currentTime -= 2.0;
    }
    catch (e) {
        // Fail silently but show in F12 developer tools console
        if (window.console && console.error("Error:" + e))
            ;
    }
}

//Fast forwards the audio file by 30 seconds.
function forwardAudio() {
    try {
        var oAudio = document.getElementById('myaudio');
        oAudio.currentTime += 2.0;
    }
    catch (e) {
        // Fail silently but show in F12 developer tools console
        if (window.console && console.error("Error:" + e))
            ;
    }
}

//Restart the audio file to the beginning.

function restartAudio() {
    try {
        var oAudio = document.getElementById('myaudio');
        oAudio.pause();
        oAudio.currentTime = 0;
    }
    catch (e) {
        // Fail silently but show in F12 developer tools console
        if (window.console && console.error("Error:" + e))
            ;
    }
}

//added events

function initEvents() {
    var canvas = document.getElementById('canvas');
    var oAudio = document.getElementById('myaudio');

    //set up event to toggle play button to pause when playing


    //set up event to toggle play button to play when paused

    //set up event to update the progress bar
    oAudio.addEventListener("timeupdate", progressBar, true);
    //set up mouse click to control position of audio
    canvas.addEventListener("click", function (e) {
        //this might seem redundant, but this these are needed later - make global to remove these
        var oAudio = document.getElementById('myaudio');
        var canvas = document.getElementById('canvas');

        if (!e) {
            e = window.event;
        } //get the latest windows event if it isn't set
        try {
            //calculate the current time based on position of mouse cursor in canvas box
            oAudio.currentTime = oAudio.duration * (e.offsetX / canvas.clientWidth);
        }
        catch (err) {
            // Fail silently but show in F12 developer tools console
            if (window.console && console.error("Error:" + err))
                ;
        }
    }, true);
}
//this event gets fired when a page has loaded
window.addEventListener("DOMContentLoaded", initEvents, false);

