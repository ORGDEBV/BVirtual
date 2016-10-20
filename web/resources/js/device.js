$(document).ready(function () {
    var device = navigator.userAgent;
    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE");
    if (device.match(/Iphone/i) || device.match(/Ipod/i) || device.match(/Android/i) || device.match(/J2ME/i) || device.match(/BlackBerry/i) || device.match(/iPhone|iPad|iPod/i) || device.match(/Opera Mini/i) || device.match(/IEMobile/i) || device.match(/Mobile/i) || device.match(/Windows Phone/i) || device.match(/windows mobile/i) || device.match(/windows ce/i) || device.match(/webOS/i) || device.match(/palm/i) || device.match(/bada/i) || device.match(/series60/i) || device.match(/nokia/i) || device.match(/symbian/i) || device.match(/HTC/i))
    {
        if (window.location.pathname != "/Bvirtual/Home-m") {
            window.location = "/Bvirtual/Home-m";
        }

    }
    else
    {
        if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) // If Internet Explorer, return version number
        {
            if (window.location.pathname != "/Bvirtual/Home-e") {
                window.location = "/Bvirtual/Home-e";
            }
        } else {
            if (window.location.pathname != "/Bvirtual/Home") {
                window.location = "/Bvirtual/Home";
            }
        }
    }
});
