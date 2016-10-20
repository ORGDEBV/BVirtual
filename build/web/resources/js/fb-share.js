var urlCompartir = window.location.href;
$(document).ready(function(){
	$(".fb-share-button").attr({'data-href':urlCompartir});
});
(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v2.5";
  fjs.parentNode.insertBefore(js, fjs);
    console.log("fjs",fjs);
}(document, 'script', 'facebook-jssdk'));
